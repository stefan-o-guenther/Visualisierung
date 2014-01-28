/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import javax.swing.JPanel;

import Base.BasePanelModelDraw;
import Base.BasePanelModelScroll;

public class PanelBSBuddySystemeExplanationScroll extends BasePanelModelScroll {

	/**
	 * Create the panel.
	 */
	public PanelBSBuddySystemeExplanationScroll(IBuddyMemoryAllocation ibuddy) {
		super(new PanelBSBuddySystemeExplanationDraw(ibuddy));
		initComponents();
	}
	
	@Override
	public void updateModel() {
		panelModelDraw.updateModel();
		scrollPane.getVerticalScrollBar().setValue(0);
	}

}
