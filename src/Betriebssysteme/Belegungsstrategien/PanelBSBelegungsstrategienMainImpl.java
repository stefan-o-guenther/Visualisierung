/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Betriebssysteme.Belegungsstrategien;

import Base.PanelAbstract;
import Base.PanelMainAbstract;

public class PanelBSBelegungsstrategienMainImpl extends PanelMainAbstract {

	private static final long serialVersionUID = 1L;

	public PanelBSBelegungsstrategienMainImpl() {
		super(ManagementFragmentationImpl.getInstance());
		this.createPanel();
	}

	@Override
	protected PanelAbstract getNewPanelMenu() {
		PanelAbstract panelTop = new PanelBSBelegungsstrategienMenuImpl();
		PanelAbstract panelBottom = new PanelBSBelegungsstrategienLabelImpl();
		PanelAbstract panelMenu = this.getPanelCoupleVertical(panelTop, panelBottom);
		return this.getPanelMenuAutomatic(panelMenu, 5);	
	}

	@Override
	protected PanelAbstract getNewPanelModel() {
		return new PanelBSBelegungsstrategienModelImpl();
	}
}
