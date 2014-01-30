/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import Base.BasePanelModelDraw;
import Base.BasePanelModelScroll;

public class PanelBSBuddySystemeModelScroll extends BasePanelModelScroll {

	public PanelBSBuddySystemeModelScroll(IBuddyMemoryAllocation ibuddy) {
		super();
	    buddy = ibuddy;
	    initComponents();
		initLayout();
	}

	protected IBuddyMemoryAllocation buddy = null;
	protected PanelBSBuddySystemeModelDraw panelModelDraw = null;
	
	@Override
	public void updateModel() {
		panelModelDraw.updateModel();
		scrollPane.getVerticalScrollBar().setValue(0);
	}

	@Override
	protected BasePanelModelDraw getPanelModelDraw() {
		return panelModelDraw;
	}

	@Override
	protected void initComponents() {
		panelModelDraw = new PanelBSBuddySystemeModelDraw(buddy);
	}
}