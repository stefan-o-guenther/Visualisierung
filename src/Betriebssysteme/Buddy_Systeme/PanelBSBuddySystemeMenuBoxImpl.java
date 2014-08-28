/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelBSBuddySystemeMenuBoxImpl extends PanelBSBuddySystemeMenuAbstract {

	public PanelBSBuddySystemeMenuBoxImpl(ManagementBuddyMemoryAllocation buddy, ToolTipManagerBuddyMemoryAllocation tooltip) {
		super(buddy, tooltip);
	}
	
	private PanelBSBuddySystemeMenuAbstract panelControl;
	private PanelBSBuddySystemeMenuAbstract panelLabel;
	
	private ManagementBuddyMemoryAllocation buddy;
	private ToolTipManagerBuddyMemoryAllocation tooltip;
	
	private PanelBSBuddySystemeMenuBoxImpl() {
		super(new ManagementBuddyMemoryAllocationImpl(), new ToolTipManagerBuddyMemoryAllocationImpl());
		this.initComponents();
		this.initLayout();
	}	

	@Override
	public Integer getHeightMenu() {
		return 110;
	}

	@Override
	public void updatePanel() {
		if (panelControl != null) {
			panelControl.updatePanel();
		}
		if (panelLabel != null) {
			panelLabel.updatePanel();
		}
	}

	@Override
	protected void initComponentsMenu() {
		buddy = (ManagementBuddyMemoryAllocation) this.getManagement();
		tooltip = (ToolTipManagerBuddyMemoryAllocation) this.getToolTipManager();		
		this.panelControl = new PanelBSBuddySystemeMenuControlImpl(buddy, tooltip);
		this.panelLabel = new PanelBSBuddySystemeMenuLabelImpl(buddy, tooltip);
	}

	@Override
	protected void initLayout() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(panelControl, GroupLayout.PREFERRED_SIZE, 591, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelLabel, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
				.addComponent(panelControl, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
		);
		setLayout(groupLayout);
	}

	@Override
	protected void initMethods() {
		// nothing
	}	
}
