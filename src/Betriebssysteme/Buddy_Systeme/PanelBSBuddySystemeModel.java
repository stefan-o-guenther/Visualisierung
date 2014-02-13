/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import Base.BasePanelModel;

public class PanelBSBuddySystemeModel extends BasePanelModel {

	public PanelBSBuddySystemeModel(IBuddyMemoryAllocation ibuddy) {
		super();
		if (ibuddy == null) {
			ibuddy = new BuddyMemoryAllocation();
		}
		buddy = ibuddy;
		buddy.setPanelModel(this);
		panelDraw = new PanelBSBuddySystemeModelScroll(buddy);
		panelExplanation = new PanelBSBuddySystemeExplanationScroll(buddy);
		initComponents();
		updateModel();
	}

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
	
	@Override
	public void updateModel() {
		panelDraw.updateModel();
		panelExplanation.updateModel();
	}
}
