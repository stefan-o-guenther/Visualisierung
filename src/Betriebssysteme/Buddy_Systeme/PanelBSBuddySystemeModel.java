package Betriebssysteme.Buddy_Systeme;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;

import Base.BasePanelModel;

public class PanelBSBuddySystemeModel extends BasePanelModel {

	private IBuddyMemoryAllocation buddy;
	
	private BasePanelModel panelDraw;
	private BasePanelModel panelExplanation;
	
	private void initComponents() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(panelDraw, GroupLayout.DEFAULT_SIZE, 800, GroupLayout.PREFERRED_SIZE)
					.addComponent(panelExplanation, GroupLayout.PREFERRED_SIZE, 100, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelExplanation, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
				.addComponent(panelDraw, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
		);
		setLayout(groupLayout);
	}
	
	
	/**
	 * Create the panel.
	 */
	public PanelBSBuddySystemeModel(IBuddyMemoryAllocation ibuddy) {
		if (ibuddy == null) {
			ibuddy = new BuddyMemoryAllocation();
		}
		buddy = ibuddy;
		panelDraw = new PanelBSBuddySystemeModelScroll(buddy);
		panelExplanation = new PanelBSBuddySystemeExplanationScroll(buddy);
		initComponents();
	}

	@Override
	public void updateModel() {
		panelDraw.updateModel();
		panelExplanation.updateModel();
	}
}
