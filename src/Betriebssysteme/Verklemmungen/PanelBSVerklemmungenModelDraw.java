/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Verklemmungen;

import java.awt.Graphics;
import java.awt.Graphics2D;

import Base.BasePanelModelDraw;
import Base.EnumSurface;

public class PanelBSVerklemmungenModelDraw extends BasePanelModelDraw {

	public PanelBSVerklemmungenModelDraw(IDeadlockManagement ideadlock) {
		super();
		if (ideadlock == null) {
			ideadlock = new DeadlockManagement();
		}
		deadlock = ideadlock;
	}

	private IDeadlockManagement deadlock;
	
	@Override
	protected void doDrawing(Graphics g) {
		// update();
		Graphics2D g2d = (Graphics2D) g;
        g2d.drawString("Java 2D", 50, 50);
	}

	@Override
	protected void updateData() {
		EnumSurface surface = deadlock.getSurface();
	}

	@Override
	public void updateModel() {
		// TODO Auto-generated method stub
		
	}

}
