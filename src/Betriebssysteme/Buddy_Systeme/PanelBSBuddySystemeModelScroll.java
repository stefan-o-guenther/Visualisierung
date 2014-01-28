/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import Base.BasePanelModelDraw;
import Base.BasePanelModelScroll;

public class PanelBSBuddySystemeModelScroll extends BasePanelModelScroll {

	protected IBuddyMemoryAllocation buddy;
	
	public PanelBSBuddySystemeModelScroll(IBuddyMemoryAllocation ibuddy) {
		super(new PanelBSBuddySystemeModelDraw(ibuddy));
	    initComponents();
	}

	@Override
	public void updateModel() {
		panelModelDraw.updateModel();
		scrollPane.getVerticalScrollBar().setValue(0);
	}

}
