/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Fairness;

import java.awt.Graphics;

import Base.PanelModelDrawAbstract;

public class PanelRNTCPFairnessModelImpl extends PanelModelDrawAbstract {
	
	public PanelRNTCPFairnessModelImpl(ManagementFairness fairness, ToolTipManagerFairness tooltip) {
		super(fairness, tooltip);
		this.fairness = fairness;
		putModelToManagement();
		updateModel();
	}
	
	private ManagementFairness fairness;

	@Override
	public void doDrawing(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initComponents() {
		// TODO Auto-generated method stub
		
	}

}
