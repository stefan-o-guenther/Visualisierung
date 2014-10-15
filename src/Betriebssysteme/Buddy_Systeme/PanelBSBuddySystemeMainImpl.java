/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Betriebssysteme.Buddy_Systeme;

import Base.EnumScrollbar;
import Base.PanelAbstract;
import Base.PanelMainAbstract;
import Base.PanelScrollImpl;

public class PanelBSBuddySystemeMainImpl extends PanelMainAbstract {

	private static final long serialVersionUID = 1L;

	public PanelBSBuddySystemeMainImpl() {
		super(ManagementBuddyMemoryAllocationImpl.getInstance());
		this.createPanel();
	}

	@Override
	protected PanelAbstract getNewPanelMenu() {
		PanelAbstract panelLeft = new PanelBSBuddySystemeMenuImpl();
		PanelAbstract panelRightLeft = new PanelBSBuddySystemeTableImpl();
		PanelAbstract panelRightRight = new PanelBSBuddySystemeLabelImpl();
		PanelAbstract panelRight = this.getPanelCoupleHorizontal(panelRightLeft, panelRightRight);
		return this.getPanelCoupleHorizontal(panelLeft, panelRight);
	}

	@Override
	protected PanelAbstract getNewPanelModel() {
		PanelAbstract panel = new PanelBSBuddySystemeModelImpl();
		return new PanelScrollImpl(panel, EnumScrollbar.NEVER, EnumScrollbar.ALWAYS);
	}
}
