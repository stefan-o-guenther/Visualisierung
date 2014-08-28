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
	
	private long termSpeed;
	private long termError;
	private long termProcessing;
	
	private int interval;
	
	private Integer error = 0;
	private Integer transfered = 0;
	
	private long timeInput;
	private long timeOutput;
	private long timeError;
	
	private long timeRouter;
	
	private long timeCurrent;
	
	private List<Packet> listRouter;
	private List<Packet> listInput;
	private List<Packet> listOutput;
	private List<Packet> listError;
	
	private int maxRouter = 10;
	private int maxInput = 100;
	private int maxOutput = 100;
	private int maxError = 100;
	
	private void executeNewPacket() {
		long termDif = timeCurrent;// - timeNewPacket;
		if (termDif >= interval) {
			Packet packet = null;
			switch (random.nextInt(8)) {
				case 0: {
					packet = new PacketBlueImpl();
				}
				case 1: {
					packet = new PacketCyanImpl();
				}
				case 2: {
					packet = new PacketGreenImpl();
				}
				case 3: {
					packet = new PacketMagentaImpl();
				}
				case 4: {
					packet = new PacketOrangeImpl();
				}
				case 5: {
					packet = new PacketPinkImpl();
				}
				case 6: {
					packet = new PacketRedImpl();
				}
				case 7: {
					packet = new PacketYellowImpl();
				}
				default: {
					packet = new PacketBlueImpl();
				}
			}
			listInput.add(packet);
			//timeNewPacket = timeCurrent;
			timeInput = timeCurrent;
		}
	}	
	
	private void executeInput() {
		long timeDif = timeCurrent - timeInput;
		if (timeDif >= termSpeed) {
			timeInput = timeCurrent;
			Packet packet = new PacketEmptyImpl();
			listInput.add(0, packet);
			while (this.listInput.size() > this.maxInput) {
				
			}
		}
	}
	
	private void executeRouter() {
		
	}
	
	private void executeError() {
		
	}
	
	private void executeOutput() {
		
	}
		
	@Override
	protected Boolean execute() {
		timeCurrent = System.currentTimeMillis();
		this.executeOutput();
		this.executeError();
		this.executeRouter();
		this.executeInput();
		this.executeNewPacket();
		
		
		
		
		
		error += 1;
		this.updatePanelMain();
		return true;
	}
	
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void showErrorMessage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void updateSize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Packet> getListInput() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Packet> getListOutput() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Packet> getListError() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Packet> getListRouter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getMaxRouter() {
		return 9;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void initialize() {
		this.random = new Random();
		this.timeCurrent = System.currentTimeMillis();
		this.interval = 0;
		this.timeInput = timeCurrent;
		this.timeOutput = timeCurrent;
		this.timeRouter = timeCurrent;
		this.timeError = timeCurrent;		
	}

	@Override
	protected void create() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected EnumAutomaticChecked keepAutomaticChecked() {
		return EnumAutomaticChecked.ALWAYS;
	}

	@Override
	public Integer getAutomaticSpace() {
		return 0;
	}

	@Override
	public Integer getTransferRate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTransferRate(Integer value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getProcessingTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProcessingTime(Integer value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getPacketInterval() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPacketInterval(Integer value) {
		// TODO Auto-generated method stub
		
	}
}