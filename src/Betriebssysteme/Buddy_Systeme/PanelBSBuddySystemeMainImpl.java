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

	public PanelBSBuddySystemeMainImpl(ManagementBuddyMemoryAllocation buddy) {
		super(buddy);
	}

	@Override
	protected PanelAbstract getNewPanelMenu() {
		ManagementBuddyMemoryAllocation buddy = (ManagementBuddyMemoryAllocation) management;
		PanelAbstract panelLeft = new PanelBSBuddySystemeMenuImpl(buddy);
		PanelAbstract panelRightLeft = new PanelBSBuddySystemeTableImpl(buddy);
		PanelAbstract panelRightRight = new PanelBSBuddySystemeLabelImpl(buddy);
		PanelAbstract panelRight = this.getPanelCoupleHorizontal(panelRightLeft, panelRightRight);
		return this.getPanelCoupleHorizontal(panelLeft, panelRight);
	}

	@Override
	protected PanelAbstract getNewPanelModel() {
		ManagementBuddyMemoryAllocation buddy = (ManagementBuddyMemoryAllocation) management;
		PanelAbstract panel = new PanelBSBuddySystemeModelImpl(buddy);
		return new PanelScrollImpl(buddy, panel, EnumScrollbar.NEVER, EnumScrollbar.ALWAYS);
	}
}
