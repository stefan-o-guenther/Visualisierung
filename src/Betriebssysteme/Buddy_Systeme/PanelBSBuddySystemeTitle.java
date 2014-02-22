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
	protected String getToolTip() {
		return ToolTipManager.getToolTipTitle();
	}


	@Override
	protected String getTitle() {
		return "Buddy Systeme";
	}
}
