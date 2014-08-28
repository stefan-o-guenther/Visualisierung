/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import Base.PanelModelAbstract;

public class PanelBSBuddySystemeModelImpl extends PanelModelAbstract {

	public PanelBSBuddySystemeModelImpl(ManagementBuddyMemoryAllocation buddy, ToolTipManagerBuddyMemoryAllocation tooltip) {
		super(buddy, tooltip);
	}
	
	private PanelBSBuddySystemeModelImpl() {
		super(new ManagementBuddyMemoryAllocationImpl(), new ToolTipManagerBuddyMemoryAllocationImpl());
		this.initComponents();
		this.initLayout();
	}
	
	private PanelModelAbstract panelDraw;
	private PanelModelAbstract panelExplanation;
	
	protected void initComponents() {
		ManagementBuddyMemoryAllocation buddy = (ManagementBuddyMemoryAllocation) this.getManagement();
		ToolTipManagerBuddyMemoryAllocation tooltip = (ToolTipManagerBuddyMemoryAllocation) this.getToolTipManager();		
		panelDraw = new PanelBSBuddySystemeModelScrollImpl(buddy, tooltip);
		panelExplanation = new PanelBSBuddySystemeExplanationScrollImpl(buddy, tooltip);
	}

	@Override
	protected void initLayout() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelDraw, GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
					.addComponent(panelExplanation, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelExplanation, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
				.addComponent(panelDraw, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
		);
		setLayout(groupLayout);		
	}	
	
	@Override
	public void updatePanel() {
		panelDraw.updatePanel();
		panelExplanation.updatePanel();
	}
}