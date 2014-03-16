/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import Base.BasePanelModelDraw;
import Base.BasePanelModelScroll;

public class PanelBSBuddySystemeExplanationScroll extends BasePanelModelScroll {

	public PanelBSBuddySystemeExplanationScroll(IBuddyMemoryAllocation buddy) {
		super(buddy);
		this.buddy = buddy;
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
	public BasePanelModelDraw getPanelModelDraw() {
		return panelModelDraw;
	}

	@Override
	public void initComponents() {
		panelModelDraw = new PanelBSBuddySystemeExplanationDraw(buddy);
	}
}