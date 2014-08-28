package Rechnernetze.Queueing_And_Loss;

import Base.PanelMenuBoxAbstract;
import Base.PanelMenuControlAbstract;
import Base.PanelMenuMenuAbstract;

public class PanelRNQueueingAndLossMenuAutomaticBoxImpl extends PanelMenuBoxAbstract {

	public PanelRNQueueingAndLossMenuAutomaticBoxImpl(ManagementQueueingAndLoss qal, ToolTipManagerQueueingAndLoss tooltip) {
		super(qal, tooltip);
	}
	
	private PanelRNQueueingAndLossMenuAutomaticBoxImpl() {
		super(new ManagementQueueingAndLossImpl(), new ToolTipManagerQueueingAndLossImpl());
		this.initComponents();
		this.initLayout();
	}

	@Override
	protected PanelMenuMenuAbstract getNewPanelMenuAutomaticMenu() {
		ManagementQueueingAndLoss qal = (ManagementQueueingAndLoss) this.getManagement();
		ToolTipManagerQueueingAndLoss tooltip = (ToolTipManagerQueueingAndLoss) this.getToolTipManager();
		return new PanelRNQueueingAndLossMenuAutomaticMenuImpl(qal, tooltip);
	}

	@Override
	protected PanelMenuControlAbstract getNewPanelAutomaticMenuControler() {
		ManagementQueueingAndLoss qal = (ManagementQueueingAndLoss) this.getManagement();
		ToolTipManagerQueueingAndLoss tooltip = (ToolTipManagerQueueingAndLoss) this.getToolTipManager();
		return new PanelRNQueueingAndLossMenuAutomaticControlBoxImpl(qal, tooltip);
	}
}