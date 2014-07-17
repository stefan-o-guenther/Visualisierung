package Rechnernetze.Congestion_Avoidance;

import Base.PanelMenuAutomaticBoxNormalAbstract;
import Base.PanelMenuAutomaticControlImpl;
import Base.PanelMenuAutomaticMenuAbstract;

public class PanelRNCongestionAvoidanceMenuAutomaticBoxImpl extends PanelMenuAutomaticBoxNormalAbstract {

	public PanelRNCongestionAvoidanceMenuAutomaticBoxImpl(ManagementCongestionAvoidance network, ToolTipManagerCongestionAvoidance tooltip) {
		super(network, tooltip);
		this.initPanel();
	}

	@Override
	protected PanelMenuAutomaticMenuAbstract getNewPanelMenuAutomaticMenu() {
		ManagementCongestionAvoidance network = (ManagementCongestionAvoidance) this.getManagement();
		ToolTipManagerCongestionAvoidance tooltip = (ToolTipManagerCongestionAvoidance) this.getToolTipManager();
		return new PanelRNCongestionAvoidanceMenuAutomaticMenuImpl(network, tooltip);
	}
}
