/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Fairness;

import Base.PanelMainAbstract;
import Base.PanelMenuAbstract;
import Base.PanelModelAbstract;

public class PanelRNTCPFairnessMainImpl extends PanelMainAbstract {

	public PanelRNTCPFairnessMainImpl() {
		super(new ManagementFairnessImpl(), new ToolTipManagerFairnessImpl());
	}
	
	@Override
	public PanelMenuAbstract getNewPanelMenu() {
		ManagementFairness fairness = (ManagementFairness) this.getManagement();
		ToolTipManagerFairness tooltip = (ToolTipManagerFairness) this.getToolTipManager();
		return new PanelRNTCPFairnessMenuAutomaticBoxImpl(fairness, tooltip);
	}

	@Override
	public PanelModelAbstract getNewPanelModel() {
		ManagementFairness fairness = (ManagementFairness) this.getManagement();
		ToolTipManagerFairness tooltip = (ToolTipManagerFairness) this.getToolTipManager();
		return new PanelRNTCPFairnessModelImpl(fairness, tooltip);
	}
}
