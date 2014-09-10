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

	private Integer packetWidth;
	private Integer packetHeight;
	private EnumVisualizationStatus status;
	private List<Packet> listPacket;
	private Integer count;
	
	private List<Boolean> listStart;
	private List<Boolean> listTarget;
	
	@Override
	protected void initialize() {		
		this.init();		
		this.initCoordinateSystem();
		this.initLists();
	}
	
	@Override
	protected void create() {
		packetWidth = 20;
		packetHeight = 40;
		count = 0;
	}

	private void init() {		
		status = EnumVisualizationStatus.START;
		listPacket = new ArrayList<Packet>();
		
	}
	
	private void initLists() {
		listStart = new ArrayList<Boolean>();
		listTarget = new ArrayList<Boolean>();
		int max = getXMax();
		for (int i = 0; i < max; i++) {
			listStart.add(false);
		}
	}
	
	private void initCoordinateSystem() {
		
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
		count = width / 40;
		if ((status == EnumVisualizationStatus.START)) {
			
			int widthO = getWidth().intValue();
			int heightO = getHeight().intValue();
			int widthN = width.intValue();
			int heightN = height.intValue();
			if ((widthO != widthN) || (heightO != heightN)) {
				setHeight(height);
				setWidth(width);
			}
		}
		this.updateViews();
	}
	
	@Override
	public Integer getCount() {
		return this.count;
	}

	@Override
	public List<Packet> getListPacket() {
		return new ArrayList(listPacket);
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
		return this.packetHeight;
	}

	@Override
	public Integer getPacketWidth() {
		return this.packetWidth;
	}

	@Override
	public EnumVisualizationStatus getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected EnumAutomaticChecked keepAutomaticChecked() {
		return EnumAutomaticChecked.ALWAYS;
	}

	/*
	pd = new PipelineDrawImpl();
	pd.setHeight(height);
	pd.setWidth(width);
	pd.setGapBetweenX(20);
	pd.setGapBetweenY(1);
	pd.setIntervalX(1);
	pd.setIntervalY(1);
	*/
	
	@Override
	public Integer getGapBetweenX() {
		return 20;
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
		return 0;
	}

	@Override
	protected Integer getGapRight() {
		return 0;
	}

	@Override
	protected Integer getGapTop() {
		return 0;
	}

	@Override
	protected Integer getGapBottom() {
		return 0;
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
}
