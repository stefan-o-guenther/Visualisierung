/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Verklemmungen;

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
