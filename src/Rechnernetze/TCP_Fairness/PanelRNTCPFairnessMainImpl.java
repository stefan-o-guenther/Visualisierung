/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.TCP_Fairness;

import Base.PanelAbstract;
import Base.PanelMainAbstract;

public class PanelRNTCPFairnessMainImpl extends PanelMainAbstract {

	private static final long serialVersionUID = 1L;

	public PanelRNTCPFairnessMainImpl(ManagementFairness fairness) {
		super(fairness);
	}

	@Override
	protected PanelAbstract getNewPanelMenu() {
		ManagementFairness fairness = (ManagementFairness) this.getManagement();
		PanelAbstract panelMenu = new PanelRNTCPFairnessMenuImpl(fairness);
		return this.getPanelMenuAutomatic(panelMenu, 5);
	}

	@Override
	protected PanelAbstract getNewPanelModel() {
		ManagementFairness fairness = (ManagementFairness) this.getManagement();
		return new PanelRNTCPFairnessModelImpl(fairness);
	}
}
