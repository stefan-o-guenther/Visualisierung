package Betriebssysteme.Buddy_Systeme;

import Base.BasePanelModelScroll;

public class PanelBSBuddySystemeModelScroll extends BasePanelModelScroll {

	/**
	 * Create the panel.
	 */
	public PanelBSBuddySystemeModelScroll(IBuddyManagement ibuddy) {
		if (ibuddy == null) {
			ibuddy = new BuddyManagement();
		}
		IBuddyManagement buddy = ibuddy;
		initComponents(new PanelBSBuddySystemeModelDraw(buddy));
	}
}
