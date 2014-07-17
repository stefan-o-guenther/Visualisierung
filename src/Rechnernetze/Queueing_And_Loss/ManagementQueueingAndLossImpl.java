/**
* @author: Stefan Otto Günther
* @date: 27.01.2014
*/

package Rechnernetze.Queueing_And_Loss;

import java.util.ArrayList;
import java.util.List;

import Base.ManagementAutomaticAbstract;

public class ManagementQueueingAndLossImpl extends ManagementAutomaticAbstract implements ManagementQueueingAndLoss {

	public ManagementQueueingAndLossImpl() {
		super();
		init();
	}
	
	private long termSpeed;
	private long termError;
	private long termProcessing;
	private long termInterval;
	
	private List<Packet> listInput;
	private List<Packet> listOutput;
	private List<Packet> listError;
	private List<Packet> listRouter;
	
	private long timeInput;
	private long timeOutput;
	
	private long timeRouter;
	private long timeNewPacket;
	
	private long timeCurrent;
	
	private int numberPacket;
	
	private void init() {
		listInput = new ArrayList<Packet>();
		listOutput = new ArrayList<Packet>();
		listError = new ArrayList<Packet>();
		listRouter = new ArrayList<Packet>();
		numberPacket = 0;
	}
	
	
	private int maxRouter = 10;
	
	public Boolean execute() {
		
		return true;
	}
	
	private void executeNewPacket() {
		long termDif = timeCurrent - timeNewPacket;
		if (termDif >= termInterval) {
			Packet packet = null;
			switch (numberPacket) {
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
			numberPacket = (numberPacket + 1) % 8;
			listInput.add(packet);
			timeNewPacket = timeCurrent;
		}
	}
	
	
	private void executeInput() {
		
	}
	
	
	
	private void executeRouter() {
		int size = listRouter.size();
		long termDif = timeCurrent - timeRouter;
		if ((size > 0) && (termDif >= termProcessing)) {			
			Packet packet = listRouter.remove(size-1);
			packet.setPosition(0);
			listOutput.add(packet);			
			timeRouter = timeCurrent;
		}		
	}
	
	
	
	
	
	@Override
	protected Boolean executeAutomatic() {
		timeCurrent = System.currentTimeMillis();
		
		return true;
	}

	
	
	@Override
	public Boolean isAutomaticEnabled() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showErrorMessage() {
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
		// TODO Auto-generated method stub
		return null;
	}

	
}