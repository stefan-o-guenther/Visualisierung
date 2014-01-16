package Betriebssysteme.Buddy_Systeme;

import Base.BasePanelModelDraw;
import Base.BasePanelModelScroll;

public class PanelBSBuddySystemeModelScroll extends BasePanelModelScroll {

	protected IBuddyMemoryAllocation buddy;
	
	protected PanelBSBuddySystemeModelScroll(IBuddyMemoryAllocation ibuddy) {
		super(new PanelBSBuddySystemeModelDraw(ibuddy));
	    initComponents();
	}

	@Override
	public void updateModel() {
		panelModelDraw.updateModel();
		scrollPane.getVerticalScrollBar().setValue(0);
	}

}
