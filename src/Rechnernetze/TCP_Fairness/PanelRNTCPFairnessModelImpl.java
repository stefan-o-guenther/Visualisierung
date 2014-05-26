/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Fairness;

import Base.PanelModelDrawCoordinateSystemAbstract;

public class PanelRNTCPFairnessModelImpl extends PanelModelDrawCoordinateSystemAbstract {
	
	public PanelRNTCPFairnessModelImpl(ManagementFairness fairness, ToolTipManagerFairness tooltip) {
		super(fairness, tooltip);
		this.initPanel();
	}
	
	private ManagementFairness fairness;
	
	@Override
	protected void doDrawing() {
		if (fairness != null) {
			fairness.setSize(this.getHeight(), this.getWidth());
			
			printCoordinateSystem("Verbindung 1", "Verbindung 2");	
			
			
		}
		
	}

	@Override
	protected void initComponents() {
		this.fairness = (ManagementFairness) this.getManagement();
	}		
}
