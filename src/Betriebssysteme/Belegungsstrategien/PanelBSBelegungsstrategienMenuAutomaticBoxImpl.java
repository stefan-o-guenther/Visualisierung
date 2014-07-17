/**
 * @author:	Stefan Otto Günther
 * @date:	01.07.2014
 */

package Betriebssysteme.Belegungsstrategien;

import Base.PanelMenuAutomaticBoxNormalAbstract;
import Base.PanelMenuAutomaticMenuAbstract;

public class PanelBSBelegungsstrategienMenuAutomaticBoxImpl extends PanelMenuAutomaticBoxNormalAbstract {

	public PanelBSBelegungsstrategienMenuAutomaticBoxImpl(ManagementFragmentation fragmentation, ToolTipManagerFragmentation tooltip) {
		super(fragmentation, tooltip);
		this.initPanel();
	}

	@Override
	protected PanelMenuAutomaticMenuAbstract getNewPanelMenuAutomaticMenu() {
		ManagementFragmentation fragmentation = (ManagementFragmentation) this.getManagement();
		ToolTipManagerFragmentation tooltip = (ToolTipManagerFragmentation) this.getToolTipManager();
		return new PanelBSBelegungsstrategienMenuAutomaticMenuImpl(fragmentation, tooltip);
	}
}
