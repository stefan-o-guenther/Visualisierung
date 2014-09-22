/**
 * @author:	Stefan Otto G�nther
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
		PanelAbstract panelReplacement = new PanelBSSeitenersetzungsstrategienReplacementImpl(paging);
		PanelAbstract panelRM = new PanelBSSeitenersetzungsstrategienRMImpl(paging);
		
		PanelAbstract panelM = this.getPanelCoupleVertical(panelMenu, panelReplacement);
		PanelAbstract panel = this.getPanelCoupleVertical(panelM, panelRM);
		
		return this.getPanelMenuAutomatic(panel, 5);
	}

	@Override
	protected PanelAbstract getNewPanelModel() {
		ManagementPaging paging = (ManagementPaging) this.getManagement();
		return new PanelBSSeitenersetzungsstrategienModelImpl(paging);
	}
}
