package Rechnernetze.TCP_Fairness;

import Base.PanelMenuBoxStandardAbstract;
import Base.PanelMenuMenuAbstract;

public class PanelRNTCPFairnessMenuAutomaticBoxImpl extends PanelMenuBoxStandardAbstract {

	public PanelRNTCPFairnessMenuAutomaticBoxImpl(ManagementFairness fairness, ToolTipManagerFairness tooltip) {
		super(fairness, tooltip);
	}

	private PanelRNTCPFairnessMenuAutomaticBoxImpl() {
		super(new ManagementFairnessImpl(), new ToolTipManagerFairnessImpl());
		this.initComponents();
		this.initLayout();
		this.updatePanel();
	}
	
	@Override
	protected PanelMenuMenuAbstract getNewPanelMenuAutomaticMenu() {
		ManagementFairness fairness = (ManagementFairness) this.getManagement();
		ToolTipManagerFairness tooltip = (ToolTipManagerFairness) this.getToolTipManager();
		return new PanelRNTCPFairnessMenuAutomaticMenuImpl(fairness, tooltip);
	}
}
