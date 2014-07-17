package Rechnernetze.Queueing_And_Loss;

import Base.PanelMenuAutomaticBoxAbstract;
import Base.PanelMenuAutomaticControlAbstract;
import Base.PanelMenuAutomaticMenuAbstract;

public class PanelRNQueueingAndLossMenuAutomaticBoxImpl extends PanelMenuAutomaticBoxAbstract {

	public PanelRNQueueingAndLossMenuAutomaticBoxImpl(ManagementQueueingAndLoss qal, ToolTipManagerQueueingAndLoss tooltip) {
		super(qal, tooltip);
		this.initPanel();
	}
	
	private PanelRNQueueingAndLossMenuAutomaticBoxImpl() {
		super(new ManagementQueueingAndLossImpl(), new ToolTipManagerQueueingAndLossImpl());
		this.initComponents();
		this.initLayout();
	}

	@Override
	protected PanelMenuAutomaticMenuAbstract getNewPanelMenuAutomaticMenu() {
		ManagementQueueingAndLoss qal = (ManagementQueueingAndLoss) this.getManagement();
		ToolTipManagerQueueingAndLoss tooltip = (ToolTipManagerQueueingAndLoss) this.getToolTipManager();
		return new PanelRNQueueingAndLossMenuAutomaticMenuImpl(qal, tooltip);
	}

	@Override
	protected PanelMenuAutomaticControlAbstract getNewPanelAutomaticMenuControler() {
		ManagementQueueingAndLoss qal = (ManagementQueueingAndLoss) this.getManagement();
		ToolTipManagerQueueingAndLoss tooltip = (ToolTipManagerQueueingAndLoss) this.getToolTipManager();
		return new PanelRNQueueingAndLossMenuAutomaticControlImpl(qal, tooltip);
	}
}