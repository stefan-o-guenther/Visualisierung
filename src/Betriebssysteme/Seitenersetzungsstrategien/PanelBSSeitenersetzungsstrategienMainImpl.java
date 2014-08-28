/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import Base.PanelMainAbstract;
import Base.PanelMenuAbstract;
import Base.PanelModelAbstract;

public class PanelBSSeitenersetzungsstrategienMainImpl extends PanelMainAbstract {
	
	public PanelBSSeitenersetzungsstrategienMainImpl() {
		super(new ManagementPagingImpl(), new ToolTipManagerPagingImpl());
	}
	
	@Override
	protected PanelMenuAbstract getNewPanelMenu() {
		ManagementPaging paging = (ManagementPaging) this.getManagement();
		ToolTipManagerPaging tooltip = (ToolTipManagerPaging) this.getToolTipManager();
		return new PanelBSSeitenersetzungsstrategienMenuAutomaticBoxImpl(paging, tooltip);
	}

	@Override
	protected PanelModelAbstract getNewPanelModel() {
		ManagementPaging paging = (ManagementPaging) this.getManagement();
		ToolTipManagerPaging tooltip = (ToolTipManagerPaging) this.getToolTipManager();
		return new PanelBSSeitenersetzungsstrategienModelImpl(paging, tooltip);
	}
}