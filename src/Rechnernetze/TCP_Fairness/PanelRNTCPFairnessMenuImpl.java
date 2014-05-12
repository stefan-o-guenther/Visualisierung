/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Fairness;

import Base.PanelMenuAbstract;

public class PanelRNTCPFairnessMenuImpl extends PanelMenuAbstract {
	
	public PanelRNTCPFairnessMenuImpl(ManagementFairness fairness, ToolTipManagerFairness tooltip) {
		super(fairness, tooltip);
		this.fairness = fairness;
	}

	private ManagementFairness fairness;
	
	@Override
	public void initComponents() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void initLayout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getHeightMenu() {
		return 200;
	}

	

}
