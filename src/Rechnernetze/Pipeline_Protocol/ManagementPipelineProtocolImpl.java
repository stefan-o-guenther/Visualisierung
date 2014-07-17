/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Pipeline_Protocol;

import java.util.ArrayList;
import java.util.List;

import Base.EnumVisualizationStatus;
import Base.ManagementAutomaticAbstract;

public class ManagementPipelineProtocolImpl extends ManagementAutomaticAbstract implements ManagementPipelineProtocol {

	public ManagementPipelineProtocolImpl() {
		super();
		init();
		initCoordinateSystem();
	}

	private Integer packetWidth = 20;
	private Integer packetHeight = 40;
	private PipelineDraw pd;
	private EnumVisualizationStatus status;
	private List<Packet> listPacket;
	private Integer count = 0;
	
	private List<Boolean> listStart;
	private List<Boolean> listTarget;
	
	private void init() {		
		this.isAutomaticChecked = false;	
		status = EnumVisualizationStatus.START;
		listPacket = new ArrayList<Packet>();
		this.initLists();
	}
	
	private void initLists() {
		listStart = new ArrayList<Boolean>();
		listTarget = new ArrayList<Boolean>();
		int max = pd.getXMax();
		for (int i = 0; i < max; i++) {
			listStart.add(false);
		}
	}
	
	private void initCoordinateSystem() {
		pd = new PipelineDrawImpl();
		pd.setHeight(height);
		pd.setWidth(width);
		pd.setGapBetweenX(20);
		pd.setGapBetweenY(1);
		pd.setIntervalX(1);
		pd.setIntervalY(1);
	}	
	
	@Override
	protected Boolean executeAutomatic() {
		return true;
	}

	@Override
	public void reset() {
		
	}

	@Override
	public String getTitle() {
		return "Pipeline Protocol";
	}

	@Override
	public void showErrorMessage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void updateSize() {
		count = width / 40;
		if ((pd != null) && (status == EnumVisualizationStatus.START)) {
			
			int widthO = pd.getWidth().intValue();
			int heightO = pd.getHeight().intValue();
			int widthN = width.intValue();
			int heightN = height.intValue();
			if ((widthO != widthN) || (heightO != heightN)) {
				pd.setHeight(height);
				pd.setWidth(width);
			}
		}
		this.updatePanelMenu();
	}
	
	@Override
	public Boolean isAutomaticEnabled() {
		return true;
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
}
