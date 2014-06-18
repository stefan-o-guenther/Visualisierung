package Rechnernetze.TCP_Fairness;

import Base.PanelMenuAutomaticControlImpl;

public class PanelRNTCPFairnessMenuAutomaticControlImpl extends PanelMenuAutomaticControlImpl {

	public PanelRNTCPFairnessMenuAutomaticControlImpl(ManagementFairness fairness, ToolTipManagerFairness tooltip) {
		super(fairness, tooltip);
		this.initPanel();
	}

	private PanelRNTCPFairnessMenuAutomaticControlImpl() {
		super(new ManagementFairnessImpl(), new ToolTipManagerFairnessImpl());
		this.initComponents();
		this.initLayout();
		this.updatePanel();
	}	
}
