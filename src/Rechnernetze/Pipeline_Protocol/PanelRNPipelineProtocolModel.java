package Rechnernetze.Pipeline_Protocol;

import java.awt.Graphics;

import Base.BasePanelModelDraw;

public class PanelRNPipelineProtocolModel extends BasePanelModelDraw {

	IPipelineManagement pipeline;
	
	/**
	 * Create the panel.
	 */
	public PanelRNPipelineProtocolModel(IPipelineManagement ipipeline) {
		if (ipipeline == null) {
			ipipeline = new PipelineManagement();
		}
		pipeline = ipipeline;
	}

	@Override
	protected void doDrawing(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
