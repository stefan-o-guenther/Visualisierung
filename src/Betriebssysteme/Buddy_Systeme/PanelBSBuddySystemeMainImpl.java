/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import Base.PanelMainAbstract;
import Base.PanelMenuAbstract;
import Base.PanelModelAbstract;

public class PanelBSBuddySystemeMainImpl extends PanelMainAbstract {

	public PanelBSBuddySystemeMainImpl() {
		super(new ManagementBuddyMemoryAllocationImpl(), new ToolTipManagerBuddyMemoryAllocationImpl());
	}
	
	@Override
	protected PanelMenuAbstract getNewPanelMenu() {
		ManagementBuddyMemoryAllocation buddy =  (ManagementBuddyMemoryAllocation) this.getManagement();
		ToolTipManagerBuddyMemoryAllocation tooltip = (ToolTipManagerBuddyMemoryAllocation) this.getToolTipManager();
		return new PanelBSBuddySystemeMenuBoxImpl(buddy, tooltip);
	}

	@Override
	protected PanelModelAbstract getNewPanelModel() {
		ManagementBuddyMemoryAllocation buddy =  (ManagementBuddyMemoryAllocation) this.getManagement();
		ToolTipManagerBuddyMemoryAllocation tooltip = (ToolTipManagerBuddyMemoryAllocation) this.getToolTipManager();
		return new PanelBSBuddySystemeModelImpl(buddy, tooltip);
	}
}