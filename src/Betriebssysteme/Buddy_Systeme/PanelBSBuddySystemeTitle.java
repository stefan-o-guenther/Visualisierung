/**
 * @author:	Stefan Otto Günther
 * @date:	29.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import Base.BasePanelTitle;

public class PanelBSBuddySystemeTitle extends BasePanelTitle {
	
	public PanelBSBuddySystemeTitle(IBuddyMemoryAllocation buddy) {
		super(buddy);
	}

	@Override
	public String getToolTip() {
		return ToolTipManager.getToolTipTitle();
	}


	@Override
	public String getTitle() {
		return "Buddy Systeme";
	}
}
