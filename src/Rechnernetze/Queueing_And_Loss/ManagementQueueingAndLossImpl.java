/**
* @author: Stefan Otto G�nther
* @date: 27.01.2014
*/

package Rechnernetze.Queueing_And_Loss;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Base.EnumAutomaticChecked;
import Base.EnumVisualizationStatus;
import Base.ManagementAbstract;
import Base.ToolTipManager;

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
	
	private List<PacketQal> listRouterWork;
	private List<PacketQal> listInputWork;
	private List<PacketQal> listOutputWork;
	private List<PacketQal> listErrorWork;
	
	private List<PacketQal> listRouterShow;
	private List<PacketQal> listInputShow;
	private List<PacketQal> listOutputShow;
	private List<PacketQal> listErrorShow;
	
	private int maxRouter;
	private int maxInput;
	private int maxOutput;
	private int maxError;		
	
	private PacketQal getNewPacket() {
		PacketQal packet = null;
		int i = random.nextInt(8);
		switch (i) {			
			case 0: {
				packet = new PacketQalBlueImpl();
				break;
			}
			case 1: {
				packet = new PacketQalCyanImpl();
				break;
			}
			case 2: {
				packet = new PacketQalGreenImpl();
				break;
			}
			case 3: {
				packet = new PacketQalMagentaImpl();
				break;
			}
			case 4: {
				packet = new PacketQalOrangeImpl();
				break;
			}
			case 5: {
				packet = new PacketQalPinkImpl();
				break;
			}
			case 6: {
				packet = new PacketQalRedImpl();
				break;
			}
			case 7: {
				packet = new PacketQalYellowImpl();
				break;
			}
			default: {
				packet = new PacketQalBlueImpl();
				break;
			}
		}
		return packet;
	}
	
	private Integer getMinPositionOfInput() {
		Integer minPos = null;
		for (PacketQal packet : listInputWork) {
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
				timeInput = System.currentTimeMillis();
			}			
			listInputWork.add(this.getNewPacket());			
		}
	}
	
	private PacketQal getOutOfListPacket(List<PacketQal> list, Integer max) {
		try {
			if ((list == null) || (max == null)) {
				throw new NullPointerException();
			}
			if ((list.size() < 0) || (max.intValue() <= 0)) {
				throw new IllegalArgumentException();
			}
			int m = 0;
			PacketQal packet = null;;
			for (PacketQal p : list) {
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
		long timeDif = System.currentTimeMillis() - timeInput;
		if ((timeDif >= termSpeed) && (listInputWork.size() > 0)) {
			timeInput = System.currentTimeMillis();
			for (PacketQal packet : listInputWork) {
				packet.doStep();
			}
			PacketQal packet = null;
			do {
				packet = this.getOutOfListPacket(listInputWork, maxInput);
				if (packet != null) {
					listInputWork.remove(packet);
					this.putPacketToRouter(packet);
				}
			} while (packet != null);			
		}
	}
	
	private void putPacketToRouter(PacketQal packet) {
		try {
			if (packet == null) {
				throw new NullPointerException();
			}
			packet.setPosition(0);
			if (this.listRouterWork.size() < this.maxRouter) {
				if (listRouterWork.size() == 0) {
					this.timeRouter = System.currentTimeMillis();
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
		long timeDif = System.currentTimeMillis() - timeRouter;
		if ((timeDif >= termProcessing) && (listRouterWork.size() > 0)) {
			timeRouter = System.currentTimeMillis();
			PacketQal packet = listRouterWork.remove(0);
			packet.setPosition(0);
			listOutputWork.add(packet);
			this.transfered += 1;
		}
	}
	
	private void executeError() {
		long timeDif = System.currentTimeMillis() - timeError;
		if ((timeDif >= termSpeed) && (listErrorWork.size() > 0)) {
			timeError = System.currentTimeMillis();
			for (PacketQal packet : listErrorWork) {
				packet.doStep();
			}
			PacketQal packet = null;
			do {
				packet = this.getOutOfListPacket(listErrorWork, maxError);
				if (packet != null) {
					listErrorWork.remove(packet);
				}
			} while (packet != null);			
		}
	}
	
	private void executeOutput() {
		long timeDif = System.currentTimeMillis() - timeOutput;
		if ((timeDif >= termSpeed) && (listOutputWork.size() > 0)) {
			timeOutput = System.currentTimeMillis();
			for (PacketQal packet : listOutputWork) {
				packet.doStep();
			}
			PacketQal packet = null;
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
	
	private List<PacketQal> getCloneOfList(List<PacketQal> list) {
		try {
			List<PacketQal> result = new ArrayList<PacketQal>();
			for (PacketQal packet : list) {
				PacketQal packetNew = (PacketQal) packet.getClone();
				result.add(packetNew);
			}
			return result;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public List<PacketQal> getListInput() {
		return new ArrayList<PacketQal>(this.listInputShow);
	}

	@Override
	public List<PacketQal> getListOutput() {
		return new ArrayList<PacketQal>(this.listOutputShow);
	}

	@Override
	public List<PacketQal> getListError() {
		return new ArrayList<PacketQal>(this.listErrorShow);
	}

	@Override
	public List<PacketQal> getListRouter() {
		return new ArrayList<PacketQal>(this.listRouterShow);
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
	protected void initialize() {
		this.setStatus(EnumVisualizationStatus.RUN);
		this.random = new Random();
		this.timeInput = System.currentTimeMillis();
		this.timeOutput = System.currentTimeMillis();
		this.timeRouter = System.currentTimeMillis();
		this.timeError = System.currentTimeMillis();
		this.error = 0;
		this.transfered = 0;
		maxRouter = 10;
		maxInput = 200;
		maxOutput = 100;
		maxError = 100;
		this.listErrorWork = new ArrayList<PacketQal>();
		this.listInputWork = new ArrayList<PacketQal>();
		this.listOutputWork = new ArrayList<PacketQal>();
		this.listRouterWork = new ArrayList<PacketQal>();
		this.copyLists();		
	}

	@Override
	protected void create() {
		this.setStatus(EnumVisualizationStatus.RUN);
		this.termSpeed = 0;	// 1 - 30
		this.interval = 0;	// 30 - 100
		this.termProcessing = 0;
	}

	@Override
	protected EnumAutomaticChecked keepAutomaticChecked() {
		return EnumAutomaticChecked.ALWAYS;
	}

	@Override
	public Integer getSpeedPacket() {
		return this.termSpeed;
	}

	@Override
	public void setSpeedPacket(Integer value) {
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
	public Integer getIntervalPacket() {
		return this.interval;
	}

	@Override
	public void setIntervalPacket(Integer value) {
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
	public ToolTipManager getToolTipManager() {
		return ToolTipManagerQueueingAndLossImpl.getInstance();
	}
}