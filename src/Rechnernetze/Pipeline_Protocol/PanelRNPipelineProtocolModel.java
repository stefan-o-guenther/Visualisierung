/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Pipeline_Protocol;

import java.awt.Graphics;

import Base.BasePanelModelDraw;

public class PanelRNPipelineProtocolModel extends BasePanelModelDraw {

	IPipelineManagement pipeline;
	
	/**
	 * Create the panel.
	 */
	public PanelRNPipelineProtocolModel(IPipelineManagement pipeline) {
		super(pipeline);
		this.pipeline = pipeline;
		putModelToManagement();
		updateModel();
	}
	
	@Override
	public void doDrawing(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateModel() {
		// TODO Auto-generated method stub
		
	}
}
