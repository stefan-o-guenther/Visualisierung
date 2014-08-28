package Rechnernetze.Congestion_Avoidance;

import Base.PanelMenuBoxStandardAbstract;
import Base.PanelMenuMenuAbstract;

public class PanelRNCongestionAvoidanceMenuAutomaticBoxImpl extends PanelMenuBoxStandardAbstract {

	public PanelRNCongestionAvoidanceMenuAutomaticBoxImpl(ManagementCongestionAvoidance network, ToolTipManagerCongestionAvoidance tooltip) {
		super(network, tooltip);
	}

	@Override
	protected PanelMenuMenuAbstract getNewPanelMenuAutomaticMenu() {
		ManagementCongestionAvoidance network = (ManagementCongestionAvoidance) this.getManagement();
		ToolTipManagerCongestionAvoidance tooltip = (ToolTipManagerCongestionAvoidance) this.getToolTipManager();
		return new PanelRNCongestionAvoidanceMenuAutomaticMenuImpl(network, tooltip);
	}
}
