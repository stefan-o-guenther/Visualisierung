/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import Base.PanelModelDrawAbstract;
import Base.PanelModelScrollAbstract;
import Base.EnumScrollbar;

public class PanelBSBuddySystemeExplanationScrollImpl extends PanelModelScrollAbstract {

	public PanelBSBuddySystemeExplanationScrollImpl(ManagementBuddyMemoryAllocation buddy, ToolTipManagerBuddyMemoryAllocation tooltip) {
		super(buddy, tooltip);
	}
	
	@Override
	public PanelModelDrawAbstract getNewPanelModelDraw() {
		ManagementBuddyMemoryAllocation buddy = (ManagementBuddyMemoryAllocation) this.getManagement();
		ToolTipManagerBuddyMemoryAllocation tooltip = (ToolTipManagerBuddyMemoryAllocation) this.getToolTipManager();
		return new PanelBSBuddySystemeExplanationDrawImpl(buddy, tooltip);
	}

	@Override
	public EnumScrollbar getScrollbarHorizontal() {
		return EnumScrollbar.NEVER;
	}

	@Override
	public EnumScrollbar getScrollbarVertical() {
		return EnumScrollbar.ALWAYS;
	}	
}