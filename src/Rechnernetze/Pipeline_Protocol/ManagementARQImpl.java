/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Pipeline_Protocol;

import java.util.ArrayList;
import java.util.List;

import Base.EnumAutomaticChecked;
import Base.EnumVisualizationStatus;
import Base.ManagementGeometryAbstract;
import Base.ToolTipManager;

public class ManagementARQImpl extends ManagementGeometryAbstract implements ManagementARQ {

    private static ManagementARQ instance = new ManagementARQImpl();
    
    private ManagementARQImpl() {
    	super();
    }
 
    public static ManagementARQ getInstance() {
    	return instance;
    }
	
	private long timeCurrent;
	private long timePacket;
	
	private int termTimeout;	
	private int termSpeed;
	
	private List<Packet> listPacket;
	
	private List<Boolean> listSender;
	private List<Boolean> listReceiver;
	
	private EnumARQStrategy strategy;
	
	private Integer n;		// window size;
	private Integer rn;		// request number
	private Integer sn;		// sequence number
	private Integer sb;		// sequence base;
	private Integer sm;		// sequence max
	
	private Integer number;
	
	private Boolean canSend;
	
	@Override
	protected void initialize() {	
		this.updateCurrentTime();
		
		number = 0;
		
		canSend = true;
		
		n = 1;
		rn = 0;
		sn = 0;
		sb = 0;
		sm = n - 1;
		
		this.timePacket = timeCurrent;
		
		this.strategy = EnumARQStrategy.NULL;
		this.listPacket = new ArrayList<Packet>();
		this.listSender = new ArrayList<Boolean>();
		this.listReceiver= new ArrayList<Boolean>();
		this.fillLists();
	}
	
	private void updateCurrentTime() {
		this.timeCurrent = System.currentTimeMillis();
	}
	
	private void fillLists() {
		while (listSender.size() < getXMax()) {
			listSender.add(false);
		}
		while (listReceiver.size() < getXMax()) {
			listReceiver.add(false);
		}
		while (listSender.size() > getXMax()) {
			listSender.remove(listSender.size()-1);
		}
		while (listReceiver.size() > getXMax()) {
			listReceiver.remove(listReceiver.size()-1);
		}
	}
	
	@Override
	protected void create() {
		this.termSpeed = 0;
		
	}

	@Override
	protected Boolean execute() {
		updateCurrentTime();
		this.executePackets();
		this.executeSender();
		this.executeReceiver();
		
		return true;
	}
	
	private void executePackets() {
		long timeDif = timeCurrent - timePacket;
		if ((timeDif >= termSpeed) && (listPacket.size() > 0)) {
			timePacket = timeCurrent;
			for (Packet packet : listPacket) {
				packet.doStep();
			}
		}		
	}
	
	
	
	
	private void executeSender() {
		switch (this.strategy) {
			case STOP_AND_WAIT: {
				this.executeSenderStopAndWait();
				break;
			}
			case GO_BACK_N: {
				this.executeSenderGoBackN();
				break;
			}
			case SELECTIVE_REPEAT: {
				this.executeSenderSelectiveRepeat();
				break;
			}
			default: {
				
				break;
			}
		}
	}
	
	private void executeSenderStopAndWait() {
		if (listPacket != null) {
			int size = listPacket.size();		
			int i = 0;
			while (i < size) {
				Packet packet = listPacket.get(i);
				EnumPacketType packetType = packet.getPacketType();
				if (((packetType == EnumPacketType.ACK) || (packetType == EnumPacketType.NAK)) && (packet.getPosition().intValue() < this.getX0())) {
					if (rn > sb) {
						sm = sm + (rn - sb);
						sb = rn;					
					} else {
						
					}
					listPacket.remove(packet);
					PacketResult result = (PacketResult) packet;
					if (result.isOk()) {
						this.listSender.remove(result.getNumber().intValue());
						this.listSender.add(result.getNumber(), true);
						number += 1;
					} else {
						
					}
					this.canSend = true;
				} else {
					i += 1;
				}
				size = listPacket.size();
			}			
		}
	}
	
	private void executeSenderGoBackN() {
		if (listPacket != null) {
			int size = listPacket.size();		
			int i = 0;
			while (i < size) {
				Packet packet = listPacket.get(i);
				EnumPacketType packetType = packet.getPacketType();
				if (((packetType == EnumPacketType.ACK) || (packetType == EnumPacketType.NAK)) && (packet.getPosition().intValue() < this.getX0())) {
					if (rn > sb) {
						sm = sm + (rn - sb);
						sb = rn;					
					} else {
						
					}
					listPacket.remove(packet);
					PacketResult result = (PacketResult) packet;
					if (result.isOk()) {
						this.listSender.remove(result.getNumber().intValue());
						this.listSender.add(result.getNumber(), true);
					} else {
						
					}
				} else {
					i += 1;
				}
				size = listPacket.size();
			}			
		}
	}
	
	private void executeSenderSelectiveRepeat() {
		
	}
	
	private void executeReceiver() {
		switch (this.strategy) {
			case STOP_AND_WAIT: {
				this.executeReceiverStopAndWait();
				break;
			}
			case GO_BACK_N: {
				this.executeReceiverGoBackN();
				break;
			}
			case SELECTIVE_REPEAT: {
				this.executeReceiverSelectiveRepeat();
				break;
			}
			default: {
				
				break;
			}
		}
	}
	
	private void executeReceiverStopAndWait() {
		if (listPacket != null) {
			int size = listPacket.size();		
			int i = 0;
			while (i < size) {
				Packet packet = listPacket.get(i);
				if ((packet.getPacketType() == EnumPacketType.DATA) && (packet.getPosition().intValue() >  this.getYMax())) {
					listPacket.remove(packet);
					PacketData data = (PacketData) packet;
					if (data.getNumber().intValue() == rn.intValue()) {
						rn += 1;
					}
					PacketResult result;
					if (data.isOk()) {
						result  = new PacketAckImpl(data.getNumber(), this.getYMax());
						this.listReceiver.remove(data.getNumber().intValue());
						this.listReceiver.add(data.getNumber(), true);
					} else {
						result  = new PacketNakImpl(data.getNumber(), this.getYMax());
					}
					listPacket.add(result);
				} else {
					i += 1;
				}
				size = listPacket.size();
			}			
		}
	}
	
	private void executeReceiverGoBackN() {
		if (listPacket != null) {
			int size = listPacket.size();		
			int i = 0;
			while (i < size) {
				Packet packet = listPacket.get(i);
				if ((packet.getPacketType() == EnumPacketType.DATA) && (packet.getPosition().intValue() >  this.getYMax())) {
					listPacket.remove(packet);
					PacketData data = (PacketData) packet;
					if (data.getNumber().intValue() == rn.intValue()) {
						rn += 1;
					}
					PacketResult result;
					if (data.isOk()) {
						result  = new PacketAckImpl(data.getNumber(), this.getYMax());
						this.listReceiver.remove(data.getNumber().intValue());
						this.listReceiver.add(data.getNumber(), true);
					} else {
						result  = new PacketNakImpl(data.getNumber(), this.getYMax());
					}
					listPacket.add(result);
				} else {
					i += 1;
				}
				size = listPacket.size();
			}			
		}
	}
	
	private void executeReceiverSelectiveRepeat() {
		
	}

	@Override
	public String getTitle() {
		return "Pipeline Protocol";
	}

	@Override
	protected void showErrorMessage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void updateSize() {	
		if (this.getStatus() == EnumVisualizationStatus.START) {
			this.fillLists();
		}
	}
	
	@Override
	public List<Packet> getListPacket() {
		List<Packet> list = new ArrayList<Packet>(listPacket);
		List<Packet> listPacketCopy = new ArrayList<Packet>();
		for (Packet packet : list) {
			listPacketCopy.add(packet.getCopy());
		}
		return listPacketCopy;
	}

	@Override
	public Integer getPositionStart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getPositionTarget() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getPacketHeight() {
		return 40;
	}

	@Override
	public Integer getPacketWidth() {
		return 20;
	}

	@Override
	protected EnumAutomaticChecked keepAutomaticChecked() {
		return EnumAutomaticChecked.ALWAYS;
	}
	
	@Override
	public Integer getGapBetweenX() {
		return this.getPacketWidth() + this.getGapBetweenPackets();
	}

	@Override
	public Integer getGapBetweenY() {
		return 1;
	}

	@Override
	public Integer getIntervalX() {
		return 1;
	}

	@Override
	public Integer getIntervalY() {
		return 1;
	}

	@Override
	public Integer getPositionX0() {
		return this.getGapLeft();
	}

	@Override
	public Integer getPositionY0() {
		return this.getGapTop();
	}

	@Override
	public Integer getPositionXMax() {
		return (this.getPositionX0() + this.getAxisXLength());
	}

	@Override
	public Integer getPositionYMax() {
		return (this.getPositionY0() + this.getAxisYLength());
	}

	@Override
	public Integer XToPositionX(Integer x) {
		try {
			if (x == null) {
				throw new NullPointerException();
			}
			Integer x0 = this.getPositionX0();
			Integer xp = x0 + (x * this.getGapBetweenX());
			return xp;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public Integer YToPositionY(Integer y) {
		try {
			if (y == null) {
				throw new NullPointerException();
			}
			Integer y0 = this.getPositionY0();
			Integer yp = y0 + (y * this.getGapBetweenY());
			return yp;
		} catch (Exception ex) {
			throw ex;
		}	
	}

	@Override
	public Boolean isSameLength() {
		return false;
	}

	@Override
	protected Integer getGapLeft() {
		return 10;
	}

	@Override
	protected Integer getGapRight() {
		return 0;
	}

	@Override
	protected Integer getGapTop() {
		return 10 + this.getPacketHeight();
	}

	@Override
	protected Integer getGapBottom() {
		return 10 + (2 * this.getPacketHeight());
	}

	@Override
	protected Integer getGapHorizontal() {
		return 0;
	}

	@Override
	protected Integer getGapVertical() {
		return 0;
	}

	@Override
	public Integer getGapBetweenPackets() {
		return 10;
	}

	@Override
	public List<Boolean> getListSender() {
		return new ArrayList<Boolean>(this.listSender);
	}

	@Override
	public List<Boolean> getListReceiver() {
		return new ArrayList<Boolean>(this.listReceiver);
	}

	@Override
	public void assume(EnumARQStrategy strategy) {
		try {
			if (strategy == null) {
				throw new NullPointerException();
			}
			if (strategy == EnumARQStrategy.NULL) {
				throw new IllegalArgumentException();
			}
			this.strategy = strategy;
			this.setStatusRUN();
			this.updateViews();
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public Boolean canSendPacket() {
		return (this.isAutomaticRunning() && (canSend));		
	}

	@Override
	public void sendPacket() {
		if (this.canSendPacket()) {
			Packet packet = new PacketDataImpl(number, this.getY0());
			this.listPacket.add(packet);
			this.canSend = false;			
		}
	}

	@Override
	public void setPacketSpeed(Integer value) {
		try {
			if (value == null) {
				throw new NullPointerException();
			}
			if (value.intValue() < 0) {
				throw new IllegalArgumentException();
			}
			this.termSpeed = value;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public void setTimeout(Integer value) {
		try {
			if (value == null) {
				throw new NullPointerException();
			}
			if (value.intValue() < 0) {
				throw new IllegalArgumentException();
			}
			this.termTimeout = value;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public Integer getWindowSizeSender() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void setWindowSizeSender(Integer n) {
		try {
			if (n == null) {
				throw new NullPointerException();
			}
			if (n.intValue() < 1) {
				throw new IllegalArgumentException();
			}
			
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public Integer getWindowSizeReceiver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePacket(Packet packet) {
		try {
			if (packet == null) {
				throw new NullPointerException();
			}
			listPacket.remove(packet);
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public void disablePacket(Packet packet) {
		try {
			if (packet == null) {
				throw new NullPointerException();
			}
			packet.setOk(false);
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public ToolTipManager getToolTipManager() {
		return ToolTipManagerARQImpl.getInstance();
	}
}
