/**
 * @author:	Stefan Otto Günther
 * @date:	01.07.2014
 */

package Betriebssysteme.Belegungsstrategien;

import Base.PanelMenuBoxStandardAbstract;
import Base.PanelMenuMenuAbstract;

public class PanelBSBelegungsstrategienMenuAutomaticBoxImpl extends PanelMenuBoxStandardAbstract {

	public PanelBSBelegungsstrategienMenuAutomaticBoxImpl(ManagementFragmentation fragmentation, ToolTipManagerFragmentation tooltip) {
		super(fragmentation, tooltip);
	}

	@Override
	protected PanelMenuMenuAbstract getNewPanelMenuAutomaticMenu() {
		ManagementFragmentation fragmentation = (ManagementFragmentation) this.getManagement();
		ToolTipManagerFragmentation tooltip = (ToolTipManagerFragmentation) this.getToolTipManager();
		return new PanelBSBelegungsstrategienMenuAutomaticMenuImpl(fragmentation, tooltip);
	}
}