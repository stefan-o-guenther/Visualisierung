/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Congestion_Avoidance;

import Base.PanelMainAbstract;
import Base.PanelMenuAbstract;
import Base.PanelModelAbstract;

public class PanelRNCongestionAvoidanceMainImpl extends PanelMainAbstract {

	public PanelRNCongestionAvoidanceMainImpl() {
		super(new ManagementCongestionAvoidanceImpl(), new ToolTipManagerCongestionAvoidanceImpl());
		this.initPanel();
	}

	@Override
	protected PanelMenuAbstract getNewPanelMenu() {
		ManagementCongestionAvoidance network = (ManagementCongestionAvoidance) this.getManagement();
		ToolTipManagerCongestionAvoidance tooltip = (ToolTipManagerCongestionAvoidance) this.getToolTipManager();
		return new PanelRNCongestionAvoidanceMenuImpl(network, tooltip);
	}

	@Override
	protected PanelModelAbstract getNewPanelModel() {
		ManagementCongestionAvoidance network = (ManagementCongestionAvoidance) this.getManagement();
		ToolTipManagerCongestionAvoidance tooltip = (ToolTipManagerCongestionAvoidance) this.getToolTipManager();
		return new PanelRNCongestionAvoidanceModelImpl(network, tooltip);
	}
}