package Rechnernetze.TCP_Fairness;

import java.awt.Graphics;

import Base.BasePanelModelDraw;

public class PanelRNTCPFairnessModel extends BasePanelModelDraw {

	private IFairnessManagement fairness;
	
	/**
	 * Create the panel.
	 */
	public PanelRNTCPFairnessModel(IFairnessManagement ifairness) {
		if (ifairness == null) {
			ifairness = new FairnessManagement();
		}
		fairness = ifairness;
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
