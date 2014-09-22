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

public class ManagementPipelineProtocolImpl extends ManagementGeometryAbstract implements ManagementPipelineProtocol {

	public ManagementPipelineProtocolImpl() {
		super();		
	}
	
	private List<Packet> listPacket;
	
	private List<Boolean> listSender;
	private List<Boolean> listReceiver;
	
	@Override
	protected void initialize() {	
		this.setStatus(EnumVisualizationStatus.START);
		listPacket = new ArrayList<Packet>();
		listSender = new ArrayList<Boolean>();
		listReceiver= new ArrayList<Boolean>();
		listSender.add(true);
		listReceiver.add(true);		
		this.fillLists();
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
		
		
	}

	@Override
	protected Boolean execute() {
		return true;
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
		return new ArrayList<Packet>(listPacket);
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
	protected void createToolTipManager() {
		this.tooltip = new ToolTipManagerPipelineProtocolImpl();
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
	public void assume() {
		listPacket.add(new PacketAckImpl(0, this.getYMax()));
		listPacket.add(new PacketDataImpl(1, this.getY0()));
		this.setStatusRUN();
		this.updateViews();
	}
}
