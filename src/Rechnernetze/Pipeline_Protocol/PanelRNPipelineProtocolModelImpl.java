/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Pipeline_Protocol;

import java.awt.Graphics;

import Base.PanelModelDrawAbstract;

public class PanelRNPipelineProtocolModelImpl extends PanelModelDrawAbstract {

	ManagementPipelineProtocol pipeline;
	
	/**
	 * Create the panel.
	 */
	public PanelRNPipelineProtocolModelImpl(ManagementPipelineProtocol pipeline, ToolTipManagerPipelineProtocol tooltip) {
		super(pipeline, tooltip);
		this.pipeline = pipeline;
		putModelToManagement();
		updateModel();
	}
	
	@Override
	public void doDrawing(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initComponents() {
		// TODO Auto-generated method stub
		
	}
}
