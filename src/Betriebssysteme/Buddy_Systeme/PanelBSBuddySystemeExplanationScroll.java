/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import Base.BasePanelModelDraw;
import Base.BasePanelModelScroll;

public class PanelBSBuddySystemeExplanationScroll extends BasePanelModelScroll {

	public PanelBSBuddySystemeExplanationScroll(IBuddyMemoryAllocation ibuddy) {
		super();
		buddy = ibuddy;
		initComponents();
		initLayout();
	}
	
	IBuddyMemoryAllocation buddy = null;
	PanelBSBuddySystemeExplanationDraw panelModelDraw = null;
	
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
		panelModelDraw = new PanelBSBuddySystemeExplanationDraw(buddy);
	}
}