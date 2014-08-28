/**
 * @author:	Stefan Otto Günther
 * @date:	01.07.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import Base.PanelMenuBoxStandardAbstract;
import Base.PanelMenuMenuAbstract;

public class PanelBSSeitenersetzungsstrategienMenuAutomaticBoxImpl extends PanelMenuBoxStandardAbstract {

	public PanelBSSeitenersetzungsstrategienMenuAutomaticBoxImpl(ManagementPaging paging, ToolTipManagerPaging tooltip) {
		super(paging, tooltip);
	}
	
	private PanelBSSeitenersetzungsstrategienMenuAutomaticBoxImpl() {
		super(new ManagementPagingImpl(), new ToolTipManagerPagingImpl());
		this.initComponents();
		this.initLayout();
	}	

	@Override
	protected PanelMenuMenuAbstract getNewPanelMenuAutomaticMenu() {
		ManagementPaging paging = (ManagementPaging) this.getManagement();
		ToolTipManagerPaging tooltip = (ToolTipManagerPaging) this.getToolTipManager();
		return new PanelBSSeitenersetzungsstrategienMenuAutomaticMenuImpl(paging, tooltip);
	}
}