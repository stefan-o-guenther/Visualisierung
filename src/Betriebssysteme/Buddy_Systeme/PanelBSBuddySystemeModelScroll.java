package Betriebssysteme.Buddy_Systeme;

import java.awt.Graphics;
import java.awt.Graphics2D;

import Base.BasePanelModelScroll;

public class PanelBSBuddySystemeModelScroll extends BasePanelModelScroll {

	/**
	 * Create the panel.
	 */
	public PanelBSBuddySystemeModelScroll(IBuddyMemoryAllocation ibuddy) {
		if (ibuddy == null) {
			ibuddy = new BuddyMemoryAllocation();
		}
		IBuddyMemoryAllocation buddy = ibuddy;
		initComponents(new PanelBSBuddySystemeModelDraw(buddy));
	}	
}
