/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Fairness;

import java.awt.Graphics;

import Base.BasePanelModelDraw;

public class PanelRNTCPFairnessModel extends BasePanelModelDraw {

	private IFairnessManagement fairness;
	
	/**
	 * Create the panel.
	 */
	public PanelRNTCPFairnessModel(IFairnessManagement fairness) {
		super(fairness);
		this.fairness = fairness;
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
