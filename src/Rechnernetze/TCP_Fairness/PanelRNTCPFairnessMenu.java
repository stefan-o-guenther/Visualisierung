/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Fairness;

import Base.BasePanelMenu;

public class PanelRNTCPFairnessMenu extends BasePanelMenu {

	private IFairnessManagement fairness;
	
	/**
	 * Create the panel.
	 */
	public PanelRNTCPFairnessMenu(IFairnessManagement fairness) {
		super(fairness);
		this.fairness = fairness;
	}

	@Override
	public void initComponents() {
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
