/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import Base.PanelAbstract;
import Base.PanelMainAbstract;

public class PanelBSSeitenersetzungsstrategienMainImpl extends PanelMainAbstract {

	private static final long serialVersionUID = 1L;

	public PanelBSSeitenersetzungsstrategienMainImpl(ManagementPaging paging) {
		super(paging);
	}

	@Override
	protected PanelAbstract getNewPanelMenu() {
		ManagementPaging paging = (ManagementPaging) this.getManagement();
		PanelAbstract panelMenu = new PanelBSSeitenersetzungsstrategienMenuImpl(paging);
		return this.getPanelMenuAutomatic(panelMenu, 5);
	}

	@Override
	protected PanelAbstract getNewPanelModel() {
		ManagementPaging paging = (ManagementPaging) this.getManagement();
		return new PanelBSSeitenersetzungsstrategienModelImpl(paging);
	}
}
