package Rechnernetze.Pipeline_Protocol;

import java.util.ArrayList;
import java.util.List;

import Base.Checker;
import Base.EnumVisualizationStatus;
import Base.ManagementFactory;

public abstract class ARQProtocolStrategyAbstract implements ARQProtocolStrategy {

	public ARQProtocolStrategyAbstract(Integer length) {
		super();
		try {
			Checker.checkIfIntegerNotLessZero(length);
			this.length = length;
			this.initialize();
		} catch (Exception ex) {
			throw ex;
		}		
	}
	
	private void initialize() {
		this.pipeline = ManagementFactory.getManagementAutomaticRepeatRequest();
		this.timePacket = System.currentTimeMillis();
		this.baseSender = 0;
		this.baseReceiver = 0;
		this.nextSeqnum = 0;
		this.initializeLists();
	}
	
	private void initializeLists() {
		this.listPacket = new ArrayList<PacketArq>();
		this.listSender = new ArrayList<Sender>();
		this.listReceiver= new ArrayList<Receiver>();
		
		for (int i = 0; i < length; i++) {
			listSender.add(new SenderImpl());
			listReceiver.add(new ReceiverImpl());
		}
	}
	
	protected ManagementAutomaticRepeatRequest pipeline;
	
	private List<PacketArq> listPacket;
	private List<Sender> listSender;
	private List<Receiver> listReceiver;
	
	private Integer length;
	
	private Integer baseSender;
	private Integer baseReceiver;
	private Integer nextSeqnum;
	
	private Long timePacket;
	
	private Integer speed;
	private Integer timeout;
	
	protected abstract void executeTimeout();
	
	protected abstract void executeReceived();
	
	protected abstract void setTimeTimeout(Integer number);
	
	protected abstract void acknowledgePacket(Integer number);
	
	protected Sender getSender(Integer number) {
		Checker.checkIfIntegerNotLessZero(number);
		if (number.intValue() >= this.listSender.size()) {
			throw new IllegalArgumentException();
		}
		return this.listSender.get(number);
	}
	
	protected Receiver getReceiver(Integer number) {
		Checker.checkIfIntegerNotLessZero(number);
		if (number.intValue() >= this.listReceiver.size()) {
			throw new IllegalArgumentException();
		}
		return this.listReceiver.get(number);
	}
	
	protected PacketArq getPacket(Integer number) {
		Checker.checkIfIntegerNotLessZero(number);
		if (number.intValue() >= this.listPacket.size()) {
			throw new IllegalArgumentException();
		}
		return this.listPacket.get(number);
	}
	
	protected Integer getMaxSender() {
		int base = this.getBaseSender();
		int size = this.getWindowSizeSender();
		return (base + size - 1);
	}
	
	protected Integer getMaxReceiver() {
		int base = this.getBaseReceiver();
		int size = this.getWindowSizeReceiver();
		return (base + size - 1);
	}
	
	protected Integer getNextSeqnum() {
		return this.nextSeqnum;
	}
	
	protected void incNextSeqnum() {
		this.nextSeqnum += 1;
	}
	
	protected Integer getSizeListPacket() {
		return this.listPacket.size();
	}
	
	protected Integer getSizeListSender() {
		return this.listSender.size();
	}
	
	protected Integer getSizeListReceiver() {
		return this.listReceiver.size();
	}
	
	protected void addPacket(PacketArq packet) {
		Checker.checkIfNotNull(packet);
		this.listPacket.add(packet);
	}
	
	protected void removerPacket(Integer number) {
		Checker.checkIfIntegerNotLessZero(number);
		if (number.intValue() >= this.listPacket.size()) {
			throw new IllegalArgumentException();
		}
		this.listPacket.remove(number);
	}
	
	protected void removerPacket(PacketArq packet) {
		Checker.checkIfNotNull(packet);
		this.listPacket.remove(packet);
	}
	
	protected void send(Integer number) {
		Checker.checkIfIntegerNotLessZero(number);
		PacketArq packet = new PacketArqDataImpl(number, pipeline.getY0());
		this.listPacket.add(packet);
	}
	
	private Integer getNewBase(Integer base, Integer window, Integer size) {
		Checker.checkIfIntegerNotLessZero(base);
		Checker.checkIfIntegerNotLessZero(window);
		Checker.checkIfIntegerNotLessZero(size);
		int newBase = base;
		int newLast = newBase + window - 1;
		int sizeSender = this.getSizeListSender();
		if (newLast >= sizeSender) {
			newBase = sizeSender - window;
		}
		return newBase;
	}
	
	protected void setBaseSender(Integer base) {
		Checker.checkIfIntegerNotLessZero(base);
		int window = this.getWindowSizeSender();
		int size = this.getSizeListSender();
		this.baseSender = this.getNewBase(base, window, size);
	}
	
	protected void setBaseReceiver(Integer base) {
		Checker.checkIfIntegerNotLessZero(base);
		int window = this.getWindowSizeReceiver();
		int size = this.getSizeListReceiver();
		this.baseReceiver = this.getNewBase(base, window, size);
	}
	
	protected Integer getTimeout() {
		return this.timeout;
	}
	
	private void executePackets() {
		Long timeDif = System.currentTimeMillis() - timePacket;
		if ((timeDif >= speed) && (listPacket.size() > 0)) {
			timePacket = System.currentTimeMillis();
			int size = listPacket.size();
			int i = 0;
			while (i < size) {
				PacketArq packet = listPacket.get(i);
				if (packet.getPacketStatus() == EnumPacketStatus.DELETED) {
					listPacket.remove(i);
				} else {
					packet.doStep();
					i += 1;
				}
				size = listPacket.size();
			}
			
			for (PacketArq packet : listPacket) {
				packet.doStep();
			}
		}		
	}
	
	private void executeSender() {		
		int i = 0;
		while (i < this.getSizeListPacket()) {
			PacketArq packet = this.getPacket(i);
			EnumPacketType packetType = packet.getPacketType();
			int packetNumber = packet.getNumber();
			int base = this.getBaseSender().intValue();
			int y0 = pipeline.getY0();
			if (((packetType == EnumPacketType.ACK) || (packetType == EnumPacketType.NAK)) && (packet.getPosition().intValue() < y0)) {
				this.removerPacket(packet);				
				PacketArqResult result = (PacketArqResult) packet;
				if ((result.getPacketStatus() == EnumPacketStatus.OK) && (packetType == EnumPacketType.ACK)) {
					this.acknowledgePacket(packetNumber);
					if (packetNumber >= base) {
						Integer lastAck = null;
						Boolean ok = true;
						int j = base;
						while ((j <= this.getMaxSender().intValue()) && ok) {
							Sender s = this.getSender(j);
							if (s.getType() == EnumARQSender.ACK) {
								lastAck = j;
								j += 1;
							} else {
								ok = false;
							}
						}
						if (lastAck != null) {
							this.setBaseSender(lastAck + 1);
						}
					}								
				} else if (packetNumber >= base) {
					for (int j = base; j <= packetNumber; j++) {
						Sender sender = this.getSender(j);
						if (sender.getType() == EnumARQSender.SENT) {
							this.send(j);
							this.setTimeTimeout(j);
						}							
					}
				}
			} else {
				i += 1;
			}
		}		
	}
	
	private void executeReceiver() {		
		int i = 0;
		while (i < this.getSizeListPacket().intValue()) {
			PacketArq packet = this.getPacket(i);
			EnumPacketType packetType = packet.getPacketType();
			int base = this.getBaseReceiver().intValue();
			int max = this.getMaxReceiver().intValue();
			int packetNumber = packet.getNumber().intValue();
			int position = packet.getPosition().intValue();
			int yMax = pipeline.getYMax();
			if ((packetType == EnumPacketType.DATA) && (position > yMax)) {
				this.removerPacket(packet);
				if (packetNumber <= max) {
					Receiver receiver = this.listReceiver.get(packetNumber);
					PacketArqData data = (PacketArqData) packet;
					PacketArqResult result;					
					if (data.getPacketStatus() == EnumPacketStatus.OK) {
						receiver.setType(EnumARQReceiver.RECEIVED);
						this.executeReceived();
					}
					if (receiver.getType() == EnumARQReceiver.RECEIVED) {
						result = new PacketArqAckImpl(packetNumber, yMax);
						if (packetNumber >= base) {
							Integer lastReceived = null;
							Boolean ok = true;
							int j = base;
							while ((j <= max) && ok) {
								Receiver r = this.getReceiver(j);
								if (r.getType() == EnumARQReceiver.RECEIVED) {
									lastReceived = j;
									j += 1;
								} else {
									ok = false;
								}
							}
							if (lastReceived != null) {
								this.setBaseReceiver(lastReceived + 1);
							}
						}
					} else {
						result = new PacketArqNakImpl(packetNumber, yMax);
					}
					this.addPacket(result);
				}
			} else {
				i += 1;
			}
		}		
	}
	
	private void executeFinish() {
		int sizePacket = this.listPacket.size();
		int sizeSender = 0;
		for (Sender sender : this.listSender) {
			if (sender.getType() != EnumARQSender.ACK) {
				sizeSender += 1;
			}
		}
		if ((sizePacket == 0) && (sizeSender == 0)) {
			this.pipeline.setStatus(EnumVisualizationStatus.FINISHED);
		}
	}

	@Override
	public void execute() {
		this.executePackets();
		this.executeReceiver();
		this.executeSender();
		this.executeTimeout();
		this.executeFinish();
	}
	
	@Override
	public List<PacketArq> getListPacket() {
		return new ArrayList<PacketArq>(this.listPacket);
	}

	@Override
	public List<Sender> getListSender() {
		return new ArrayList<Sender>(this.listSender);
	}

	@Override
	public List<Receiver> getListReceiver() {
		return new ArrayList<Receiver>(this.listReceiver);
	}
	
	@Override
	public void deletePacket(PacketArq packet) {
		try {
			Checker.checkIfNotNull(packet);
			packet.setPacketStatus(EnumPacketStatus.DELETED);
			if (pipeline.isAutomaticRunning() == false) {
				listPacket.remove(packet);
			}			
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public void disablePacket(PacketArq packet) {
		try {
			Checker.checkIfNotNull(packet);
			packet.setPacketStatus(EnumPacketStatus.BROKEN);
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public void setSpeedPacket(Integer speed) {
		Checker.checkIfIntegerNotLessZero(speed);
		this.speed = speed;
	}

	@Override
	public void setTimeout(Integer timeout) {
		Checker.checkIfIntegerNotLessZero(timeout);
		this.timeout = timeout;
	}
	
	@Override
	public Boolean canSendPacket() {
		int last = this.baseSender + this.getWindowSizeSender() - 1;
		return (this.nextSeqnum.intValue() <= last);
	}	
	
	@Override
	public Integer getBaseSender() {
		return this.baseSender;
	}

	@Override
	public Integer getBaseReceiver() {
		return this.baseReceiver;
	}
}
