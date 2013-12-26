package Betriebssysteme.Verklemmungen;

import Base.BasePanelModelScroll;

public class PanelBSVerklemmungenModelScroll extends BasePanelModelScroll {

	/**
	 * Create the panel.
	 */
	public PanelBSVerklemmungenModelScroll(IDeadlockManagement ideadlock) {
		if (ideadlock == null) {
			ideadlock = new DeadlockManagement();
		}
		IDeadlockManagement deadlock = ideadlock;
		initComponents(new PanelBSVerklemmungenModelDraw(deadlock));
	}
}
