package Betriebssysteme.Belegungsstrategien;

import Base.PanelMenuAutomaticBoxAbstract;
import Base.PanelMenuAutomaticMenuAbstract;

public class PanelBSBelegungsstrategienMenuAutomaticBoxImpl extends PanelMenuAutomaticBoxAbstract {

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
