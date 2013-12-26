package Betriebssysteme.Verklemmungen;

import java.awt.Graphics;
import java.awt.Graphics2D;

import Base.BasePanelModelDraw;
import Base.EnumSurface;

public class PanelBSVerklemmungenModelDraw extends BasePanelModelDraw {

	private IDeadlockManagement deadlock;
	
	/**
	 * Create the panel.
	 */
	public PanelBSVerklemmungenModelDraw(IDeadlockManagement ideadlock) {
		if (ideadlock == null) {
			ideadlock = new DeadlockManagement();
		}
		deadlock = ideadlock;
	}

	@Override
	protected void doDrawing(Graphics g) {
		// update();
		Graphics2D g2d = (Graphics2D) g;
        g2d.drawString("Java 2D", 50, 50);
	}

	@Override
	protected void update() {
		EnumSurface surface = deadlock.getSurface();
	}

}
