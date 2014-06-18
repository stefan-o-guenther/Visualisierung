package Rechnernetze.Congestion_Avoidance;

import Base.PanelMenuAutomaticControlImpl;

public class PanelRNCongestionAvoidanceMenuAutomaticControlImpl extends PanelMenuAutomaticControlImpl {

	public PanelRNCongestionAvoidanceMenuAutomaticControlImpl(ManagementCongestionAvoidance network, ToolTipManagerCongestionAvoidance tooltip) {
		super(network, tooltip);
		this.initPanel();
	}
}
