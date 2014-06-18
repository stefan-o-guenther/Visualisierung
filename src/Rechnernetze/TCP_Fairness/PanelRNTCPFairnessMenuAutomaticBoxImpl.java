package Rechnernetze.TCP_Fairness;

import Base.PanelMenuAutomaticBoxAbstract;
import Base.PanelMenuAutomaticMenuAbstract;

public class PanelRNTCPFairnessMenuAutomaticBoxImpl extends PanelMenuAutomaticBoxAbstract {

	public PanelRNTCPFairnessMenuAutomaticBoxImpl(ManagementFairness fairness, ToolTipManagerFairness tooltip) {
		super(fairness, tooltip);
		this.initPanel();
	}

	private PanelRNTCPFairnessMenuAutomaticBoxImpl() {
		super(new ManagementFairnessImpl(), new ToolTipManagerFairnessImpl());
		this.initComponents();
		this.initLayout();
		this.updatePanel();
	}
	
	@Override
	protected PanelMenuAutomaticMenuAbstract getNewPanelMenuAutomaticMenu() {
		ManagementFairness fairness = (ManagementFairness) this.getManagement();
		ToolTipManagerFairness tooltip = (ToolTipManagerFairness) this.getToolTipManager();
		return new PanelRNTCPFairnessMenuAutomaticMenuImpl(fairness, tooltip);
	}
}
