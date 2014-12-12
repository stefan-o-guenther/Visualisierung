/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Congestion_Avoidance;

import Base.ManagementFactory;
import Base.PanelAbstract;
import Base.PanelMainAbstract;

public class PanelRNCongestionAvoidanceMainImpl extends PanelMainAbstract {

	private static final long serialVersionUID = 1L;

	public PanelRNCongestionAvoidanceMainImpl() {
		super(ManagementFactory.getManagementCongestionAvoidance());
		this.createPanel();
	}

	@Override
	protected PanelAbstract getNewPanelMenu() {
		PanelAbstract panelMenu = new PanelRNCongestionAvoidanceMenuImpl();
		return this.getPanelMenuAutomatic(panelMenu, 12);
	}

	@Override
	protected PanelAbstract getNewPanelModel() {
		return new PanelRNCongestionAvoidanceModelImpl();
	}
}
