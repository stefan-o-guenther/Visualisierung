/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.TCP_Fairness;

import Base.ManagementFactory;
import Base.PanelAbstract;
import Base.PanelMainAbstract;

public class PanelRNTCPFairnessMainImpl extends PanelMainAbstract {

	private static final long serialVersionUID = 1L;

	public PanelRNTCPFairnessMainImpl() {
		super(ManagementFactory.getManagementTCPFairness());
		this.createPanel();
	}

	@Override
	protected PanelAbstract getNewPanelMenu() {
		PanelAbstract panelMenu = new PanelRNTCPFairnessMenuImpl();
		return this.getPanelMenuAutomatic(panelMenu, 5);
	}

	@Override
	protected PanelAbstract getNewPanelModel() {
		return new PanelRNTCPFairnessModelImpl();
	}
}
