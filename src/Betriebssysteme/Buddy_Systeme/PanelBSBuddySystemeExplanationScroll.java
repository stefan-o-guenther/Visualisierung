package Betriebssysteme.Buddy_Systeme;

import javax.swing.JPanel;

import Base.BasePanelModelDraw;
import Base.BasePanelModelScroll;

public class PanelBSBuddySystemeExplanationScroll extends BasePanelModelScroll {

	/**
	 * Create the panel.
	 */
	protected PanelBSBuddySystemeExplanationScroll(IBuddyMemoryAllocation ibuddy) {
		super(new PanelBSBuddySystemeExplanationDraw(ibuddy));
		initComponents();
	}
	
	@Override
	public void updateModel() {
		panelModelDraw.updateModel();
		scrollPane.getVerticalScrollBar().setValue(0);
	}

}
