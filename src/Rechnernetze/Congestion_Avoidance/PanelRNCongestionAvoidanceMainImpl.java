/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Congestion_Avoidance;

import Base.PanelAbstract;
import Base.PanelMainAbstract;

public class PanelRNCongestionAvoidanceMainImpl extends PanelMainAbstract {

	private static final long serialVersionUID = 1L;

	public PanelRNCongestionAvoidanceMainImpl(ManagementCongestionAvoidance ca) {
		super(ca);
	}

	@Override
	protected PanelAbstract getNewPanelMenu() {
		ManagementCongestionAvoidance ca = (ManagementCongestionAvoidance) this.getManagement();
		PanelAbstract panelMenu = new PanelRNCongestionAvoidanceMenuImpl(ca);
		return this.getPanelMenuAutomatic(panelMenu, 12);
	}

	@Override
	protected PanelAbstract getNewPanelModel() {
		ManagementCongestionAvoidance ca = (ManagementCongestionAvoidance) this.getManagement();
		return new PanelRNCongestionAvoidanceModelImpl(ca);
	}
}
