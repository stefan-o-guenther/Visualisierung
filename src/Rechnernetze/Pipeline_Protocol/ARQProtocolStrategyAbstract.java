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
		this.message = "";
		this.oldTime = 0;
		this.initializeLists();
	}
	
	private void initializeLists() {
		this.listPacket = new ArrayList<PacketArq>();
		this.arraySender = new Sender[length.intValue()];
		this.arrayReceiver= new Receiver[length.intValue()];
		int l = this.length.intValue();		
		for (int i = 0; i < l; i++) {
			arraySender[i] = new SenderImpl();
			arrayReceiver[i] = new ReceiverImpl();
		}
	}
	
	protected ManagementAutomaticRepeatRequest pipeline;
	
	private List<PacketArq> listPacket;
	private Sender[] arraySender;
	private Receiver[] arrayReceiver;
	
	private Integer length;
	
	private Integer baseSender;
	private Integer baseReceiver;
	private Integer nextSeqnum;
	
	private Long timePacket;
	
	private Integer speed;
	private Integer timeout;
	private String message;
	
	private long oldTime;
	
	protected abstract void executeTimeout();
	protected abstract void executeTimer();
	
	protected abstract void resetTimer(Integer number);
	
	protected abstract void receiveAck(Integer number);
	protected abstract void receiveNak(Integer number);	
	
	protected void setMessage(String message) {
		Checker.checkIfString(message);
		this.message = message;
	}
	
	protected Sender getSender(Integer number) {
		Checker.checkIfIntegerNotLessZero(number);
		if (number.intValue() >= this.arraySender.length) {
			throw new IllegalArgumentException();
		}
		return this.arraySender[number];
	}
	
	protected Boolean isAnySent() {
		int base = this.getBaseSender();
		int max = this.getMaxSender();
		Boolean result = false;
		for (int i = base; i <= max; i++) {
			Sender sender = this.arraySender[i];
			if (sender.getType() == EnumARQSender.SENT) {
				result = true;
			}
		}
		return result;
	}
	
	protected Receiver getReceiver(Integer number) {
		Checker.checkIfIntegerNotLessZero(number);
		if (number.intValue() >= this.arrayReceiver.length) {
			throw new IllegalArgumentException();
		}
		return this.arrayReceiver[number];
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
	
	protected Integer getSizeArraySender() {
		return this.arraySender.length;
	}
	
	protected Integer getSizeArrayReceiver() {
		return this.arrayReceiver.length;
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
		int sizeSender = this.getSizeArraySender();
		if (newLast >= sizeSender) {
			newBase = sizeSender - window;
		}
		return newBase;
	}
	
	protected void setBaseSender(Integer base) {
		Checker.checkIfIntegerNotLessZero(base);
		int window = this.getWindowSizeSender();
		int size = this.getSizeArraySender();
		this.baseSender = this.getNewBase(base, window, size);
	}
	
	protected void setBaseReceiver(Integer base) {
		Checker.checkIfIntegerNotLessZero(base);
		int window = this.getWindowSizeReceiver();
		int size = this.getSizeArrayReceiver();
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
	
	private Integer findNewBase(Actor[] arrayActor) {
		Checker.checkIfNotNull(arrayActor);
		Integer lastReceived = null;
		Boolean ok = true;
		int i = 0;
		while ((i < arrayActor.length) && ok) {
			Actor actor = arrayActor[i];
			if (actor.hasReceived()) {
				lastReceived = i;
				i += 1;
			} else {
				ok = false;
			}
		}
		if (lastReceived != null) {
			return (lastReceived + 1);
		} else {
			return 0;
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
					this.receiveAck(packetNumber);													
				} else if (packetNumber >= base) {
					this.receiveNak(packetNumber);					
				}
				int newBase = this.findNewBase(this.arraySender);
				this.setBaseSender(newBase);
				this.resetTimer(packetNumber);
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
			int packetNumber = packet.getNumber().intValue();
			int max = this.getMaxReceiver();
			int position = packet.getPosition().intValue();
			int yMax = pipeline.getYMax();
			if ((packetType == EnumPacketType.DATA) && (position > yMax)) {
				this.removerPacket(packet);
				Receiver receiver = this.arrayReceiver[packetNumber];
				PacketArqData data = (PacketArqData) packet;
				PacketArqResult result;
				if (packetNumber <= max) {
					if (data.getPacketStatus() == EnumPacketStatus.OK) {
						receiver.setReceived();
					}
					if (receiver.getType() == EnumARQReceiver.RECEIVED) {
						result = new PacketArqAckImpl(packetNumber, yMax);
						int newBase = this.findNewBase(arrayReceiver);
						this.setBaseReceiver(newBase);
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
		for (Sender sender : this.arraySender) {
			if (sender.getType() != EnumARQSender.ACK) {
				sizeSender += 1;
			}
		}
		if ((sizePacket == 0) && (sizeSender == 0)) {
			this.pipeline.setStatus(EnumVisualizationStatus.FINISHED);
		} else if (!pipeline.isAutomaticRunning()) {
			this.oldTime = 0;
		}
	}

	@Override
	public void execute() {
		this.executePackets();
		this.executeReceiver();
		this.executeSender();
		long time = System.currentTimeMillis();
		if (this.oldTime == 0) {
			this.oldTime = time;
		}
		long dif = time - oldTime;
		if (dif >= 1) {
			this.executeTimer();
			this.oldTime = time;
		}
		this.executeTimeout();
		this.executeFinish();
		
	}
	
	@Override
	public List<PacketArq> getListPacket() {
		return new ArrayList<PacketArq>(this.listPacket);
	}

	@Override
	public Sender[] getArraySender() {
		return arraySender.clone();
	}

	@Override
	public Receiver[] getArrayReceiver() {
		return arrayReceiver.clone();
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
	
	@Override
	public String getMessage() {
		return this.message;
	}
}
