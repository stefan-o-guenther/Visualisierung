package Betriebssysteme.Verklemmungen;

import java.awt.Graphics;

import Base.BasePanelModelScroll;

public class PanelBSVerklemmungenModelScroll extends BasePanelModelScroll {
	
	/**
	 * Create the panel.
	 */
	public PanelBSVerklemmungenModelScroll(IDeadlockManagement ideadlock) {
		super(new PanelBSVerklemmungenModelDraw(ideadlock));
		if (ideadlock == null) {
			ideadlock = new DeadlockManagement();
		}		
		initComponents();
	}

	@Override
	public void updateModel() {
		panelModelDraw.updateModel();
	}
}
