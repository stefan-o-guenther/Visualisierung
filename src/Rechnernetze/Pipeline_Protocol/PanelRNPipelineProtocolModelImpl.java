/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Pipeline_Protocol;

import Base.PanelModelDrawAbstract;

public class PanelRNPipelineProtocolModelImpl extends PanelModelDrawAbstract {

	public PanelRNPipelineProtocolModelImpl(ManagementPipelineProtocol pipeline, ToolTipManagerPipelineProtocol tooltip) {
		super(pipeline, tooltip);
		this.initPanel();
	}
	
	private ManagementPipelineProtocol pipeline;
	
	@Override
	protected void doDrawing() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initComponents() {
		this.pipeline = (ManagementPipelineProtocol) this.getManagement();
	}
}
