package Betriebssysteme.Buddy_Systeme;

import java.awt.Graphics;
import java.awt.Graphics2D;

import Base.BasePanelModelDraw;
import Base.EnumSurface;

public class PanelBSBuddySystemeModelDraw extends BasePanelModelDraw {

	private IBuddyManagement buddy;
	
	/**
	 * Create the panel.
	 */
	public PanelBSBuddySystemeModelDraw(IBuddyManagement ibuddy) {
		if (ibuddy == null) {
			ibuddy = new BuddyManagement();
		}
		buddy = ibuddy;
	}

	@Override
	protected void doDrawing(Graphics g) {
		// update();
		Graphics2D g2d = (Graphics2D) g;
        g2d.drawString("Java 2D", 50, 50);
	}

	@Override
	protected void update() {
		EnumSurface surface = buddy.getSurface();		
	}

}
