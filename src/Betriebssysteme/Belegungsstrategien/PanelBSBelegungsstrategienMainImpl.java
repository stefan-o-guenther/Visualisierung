/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Betriebssysteme.Belegungsstrategien;

import Base.PanelAbstract;
import Base.PanelMainAbstract;

public class PanelBSBelegungsstrategienMainImpl extends PanelMainAbstract {

	private static final long serialVersionUID = 1L;

	public PanelBSBelegungsstrategienMainImpl(ManagementFragmentation fragmentation) {
		super(fragmentation);
	}

	@Override
	protected PanelAbstract getNewPanelMenu() {
		ManagementFragmentation fragmentation = (ManagementFragmentation) this.management;
		PanelAbstract panelMenu = new PanelBSBelegungsstrategienMenuImpl(fragmentation);
		return this.getPanelMenuAutomatic(panelMenu, 5);	
	}

	@Override
	protected PanelAbstract getNewPanelModel() {
		ManagementFragmentation fragmentation = (ManagementFragmentation) this.management;
		return new PanelBSBelegungsstrategienModelImpl(fragmentation);
	}
}
