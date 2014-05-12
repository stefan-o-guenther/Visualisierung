/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import Base.PanelModelAbstract;

public class PanelBSBuddySystemeModelImpl extends PanelModelAbstract {

	public PanelBSBuddySystemeModelImpl(ManagerBuddyMemoryAllocation buddy, ToolTipManagerBuddyMemoryAllocation tooltip) {
		super(buddy, tooltip);
		this.buddy = buddy;
		this.tooltip = tooltip;		
		initComponents();
		initLayout();
		updateModel();
	}
	
	private ManagerBuddyMemoryAllocation buddy;
	private ToolTipManagerBuddyMemoryAllocation tooltip;
	
	private PanelModelAbstract panelDraw;
	private PanelModelAbstract panelExplanation;
	
	public void initComponents() {
		putModelToManagement();
		panelDraw = new PanelBSBuddySystemeModelScrollImpl(buddy, tooltip);
		panelExplanation = new PanelBSBuddySystemeExplanationScrollImpl(buddy, tooltip);
	}

	@Override
	public void initLayout() {
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
