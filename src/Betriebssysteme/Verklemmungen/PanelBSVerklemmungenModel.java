/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Verklemmungen;

import Base.BasePanelModelDraw;
import Base.BasePanelModelScroll;

public class PanelBSVerklemmungenModel extends BasePanelModelScroll {
	
	public PanelBSVerklemmungenModel(IDeadlockManagement ideadlock) {
		super();
		if (ideadlock == null) {
			ideadlock = new DeadlockManagement();
		}		
		initLayout();
	}
	
	protected IDeadlockManagement deadlock = null;
	protected PanelBSVerklemmungenModelDraw panelModelDraw = null;

	@Override
	public void updateModel() {
		panelModelDraw.updateModel();
	}

	@Override
	protected BasePanelModelDraw getPanelModelDraw() {
		return panelModelDraw;
	}

	@Override
	protected void initComponents() {
		panelModelDraw = new PanelBSVerklemmungenModelDraw(deadlock);
	}
}
