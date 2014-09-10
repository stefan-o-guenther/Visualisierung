/**
* @author: Stefan Otto Günther
* @date: 27.01.2014
*/

package Rechnernetze.Queueing_And_Loss;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Base.EnumAutomaticChecked;
import Base.EnumVisualizationStatus;
import Base.ManagementAbstract;

public class ManagementQueueingAndLossImpl extends ManagementAbstract implements ManagementQueueingAndLoss {

	public ManagementQueueingAndLossImpl() {
		super();
	}
	
	private Random random;
	
	private int termSpeed;
	private int termProcessing;
	
	private int interval;	
	
	private Integer error;
	private Integer transfered;
	
	private long timeInput;
	private long timeOutput;
	private long timeError;
	
	private long timeRouter;
	
	private long timeCurrent;
	
	private List<Packet> listRouterWork;
	private List<Packet> listInputWork;
	private List<Packet> listOutputWork;
	private List<Packet> listErrorWork;
	
	private List<Packet> listRouterShow;
	private List<Packet> listInputShow;
	private List<Packet> listOutputShow;
	private List<Packet> listErrorShow;
	
	private int maxRouter;
	private int maxInput;
	private int maxOutput;
	private int maxError;		
	
	private void updateCurrentTime() {
		this.timeCurrent = System.currentTimeMillis();
	}
	
	private Packet getNewPacket() {
		Packet packet = null;
		int i = random.nextInt(8);
		switch (i) {			
			case 0: {
				packet = new PacketBlueImpl();
				break;
			}
			case 1: {
				packet = new PacketCyanImpl();
				break;
			}
			case 2: {
				packet = new PacketGreenImpl();
				break;
			}
			case 3: {
				packet = new PacketMagentaImpl();
				break;
			}
			case 4: {
				packet = new PacketOrangeImpl();
				break;
			}
			case 5: {
				packet = new PacketPinkImpl();
				break;
			}
			case 6: {
				packet = new PacketRedImpl();
				break;
			}
			case 7: {
				packet = new PacketYellowImpl();
				break;
			}
			default: {
				packet = new PacketBlueImpl();
				break;
			}
		}
		return packet;
	}
	
	private Integer getMinPositionOfInput() {
		Integer minPos = null;
		for (Packet packet : listInputWork) {
			int pos = packet.getPosition();
			if ((minPos == null) || (minPos > pos)) {
				minPos = pos;
			}
		}
		return minPos;
	}
	
	private void copyLists() {
		this.listInputShow = this.getCloneOfList(this.listInputWork);
		this.listOutputShow = this.getCloneOfList(this.listOutputWork);
		this.listErrorShow = this.getCloneOfList(this.listErrorWork);
		this.listRouterShow = this.getCloneOfList(this.listRouterWork);
	}
	
	private void executeNewPacket() {
		Integer min = this.getMinPositionOfInput();
		if ((min == null) || (min >= interval)) {			
			if (listInputWork.size() == 0) {
				timeInput = timeCurrent;
			}			
			listInputWork.add(this.getNewPacket());			
		}
	}
	
	private Packet getOutOfListPacket(List<Packet> list, Integer max) {
		try {
			if ((list == null) || (max == null)) {
				throw new NullPointerException();
			}
			if ((list.size() < 0) || (max.intValue() <= 0)) {
				throw new IllegalArgumentException();
			}
			int m = 0;
			Packet packet = null;;
			for (Packet p : list) {
				int x = p.getPosition();
				if ((x > max) && (x > m)) {
					packet = p;
					m = x;
				}
			}
			return packet;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	private void executeInput() {
		long timeDif = timeCurrent - timeInput;
		if ((timeDif >= termSpeed) && (listInputWork.size() > 0)) {
			timeInput = timeCurrent;
			for (Packet packet : listInputWork) {
				packet.incPosition();
			}
			Packet packet = null;
			do {
				packet = this.getOutOfListPacket(listInputWork, maxInput);
				if (packet != null) {
					listInputWork.remove(packet);
					this.putPacketToRouter(packet);
				}
			} while (packet != null);			
		}
	}
	
	private void putPacketToRouter(Packet packet) {
		try {
			if (packet == null) {
				throw new NullPointerException();
			}
			packet.setPosition(0);
			if (this.listRouterWork.size() < this.maxRouter) {
				if (listRouterWork.size() == 0) {
					this.timeRouter = this.timeCurrent;
				}
				this.listRouterWork.add(packet);				
			} else {
				this.listErrorWork.add(packet);
				this.error += 1;
			}
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	private void executeRouter() {
		long timeDif = timeCurrent - timeRouter;
		if ((timeDif >= termProcessing) && (listRouterWork.size() > 0)) {
			timeRouter = timeCurrent;
			Packet packet = listRouterWork.remove(0);
			packet.setPosition(0);
			listOutputWork.add(packet);
			this.transfered += 1;
		}
	}
	
	private void executeError() {
		long timeDif = timeCurrent - timeError;
		if ((timeDif >= termSpeed) && (listErrorWork.size() > 0)) {
			timeError = timeCurrent;
			for (Packet packet : listErrorWork) {
				packet.incPosition();
			}
			Packet packet = null;
			do {
				packet = this.getOutOfListPacket(listErrorWork, maxError);
				if (packet != null) {
					listErrorWork.remove(packet);
				}
			} while (packet != null);			
		}
	}
	
	private void executeOutput() {
		long timeDif = timeCurrent - timeOutput;
		if ((timeDif >= termSpeed) && (listOutputWork.size() > 0)) {
			timeOutput = timeCurrent;
			for (Packet packet : listOutputWork) {
				packet.incPosition();
			}
			Packet packet = null;
			do {
				packet = this.getOutOfListPacket(listOutputWork, maxOutput);
				if (packet != null) {
					listOutputWork.remove(packet);
				}
			} while (packet != null);			
		}
	}
		
	@Override
	protected Boolean execute() {
		updateCurrentTime();
		this.executeOutput();
		this.executeError();
		this.executeRouter();
		this.executeInput();
		this.executeNewPacket();
		copyLists();
		this.updateViews();
		return true;
	}
	
	@Override
	public String getTitle() {
		return "Queueing And Loss";
	}

	@Override
	protected void showErrorMessage() {
		// nothing
	}

	@Override
	protected void updateSize() {
		
	}
	
	private List<Packet> getCloneOfList(List<Packet> list) {
		try {
			List<Packet> result = new ArrayList<Packet>();
			for (Packet packet : list) {
				Packet packetNew = packet.getClone();
				result.add(packetNew);
			}
			return result;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public List<Packet> getListInput() {
		return new ArrayList<Packet>(this.listInputShow);
	}

	@Override
	public List<Packet> getListOutput() {
		return new ArrayList<Packet>(this.listOutputShow);
	}

	@Override
	public List<Packet> getListError() {
		return new ArrayList<Packet>(this.listErrorShow);
	}

	@Override
	public List<Packet> getListRouter() {
		return new ArrayList<Packet>(this.listRouterShow);
	}

	@Override
	public Integer getMaxRouter() {
		return this.maxRouter;
	}

	@Override
	public Integer getCountLoss() {
		return error;
	}

	@Override
	public Integer getCountTransfered() {
		return transfered;
	}

	@Override
	public EnumVisualizationStatus getStatus() {
		return EnumVisualizationStatus.RUN;
	}

	@Override
	protected void initialize() {
		this.random = new Random();
		updateCurrentTime();
		this.interval = 0;
		this.timeInput = timeCurrent;
		this.timeOutput = timeCurrent;
		this.timeRouter = timeCurrent;
		this.timeError = timeCurrent;
		this.error = 0;
		this.transfered = 0;
		maxRouter = 10;
		maxInput = 200;
		maxOutput = 100;
		maxError = 100;
		this.listErrorWork = new ArrayList<Packet>();
		this.listInputWork = new ArrayList<Packet>();
		this.listOutputWork = new ArrayList<Packet>();
		this.listRouterWork = new ArrayList<Packet>();
		this.copyLists();		
	}

	@Override
	protected void create() {
		this.termSpeed = 0;	// 1 - 30
		this.interval = 0;	// 30 - 100
		this.termProcessing = 0;
	}

	@Override
	protected EnumAutomaticChecked keepAutomaticChecked() {
		return EnumAutomaticChecked.ALWAYS;
	}

	@Override
	public Integer getTransferRate() {
		return this.termSpeed;
	}

	@Override
	public void setTransferRate(Integer value) {
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
	public Integer getProcessingTime() {
		return this.termProcessing;
	}

	@Override
	public void setProcessingTime(Integer value) {
		try {
			if (value == null) {
				throw new NullPointerException();
			}
			if (value.intValue() < 0) {
				throw new IllegalArgumentException();
			}
			this.termProcessing = value;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public Integer getPacketInterval() {
		return this.interval;
	}

	@Override
	public void setPacketInterval(Integer value) {
		try {
			if (value == null) {
				throw new NullPointerException();
			}
			if (value.intValue() < 0) {
				throw new IllegalArgumentException();
			}
			this.interval = value;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	protected void createToolTipManager() {
		this.tooltip = new ToolTipManagerQueueingAndLossImpl();
	}
}