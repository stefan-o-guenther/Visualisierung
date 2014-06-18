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
		super(new ManagerBuddyMemoryAllocationImpl(), new ToolTipManagerBuddyMemoryAllocationImpl());
		this.initPanel();
	}
	
	@Override
	public PanelMenuAbstract getNewPanelMenu() {
		ManagerBuddyMemoryAllocation buddy =  (ManagerBuddyMemoryAllocation) this.getManagement();
		ToolTipManagerBuddyMemoryAllocation tooltip = (ToolTipManagerBuddyMemoryAllocation) this.getToolTipManager();
		return new PanelBSBuddySystemeMenuBoxImpl(buddy, tooltip);
	}

	@Override
	public PanelModelAbstract getNewPanelModel() {
		ManagerBuddyMemoryAllocation buddy =  (ManagerBuddyMemoryAllocation) this.getManagement();
		ToolTipManagerBuddyMemoryAllocation tooltip = (ToolTipManagerBuddyMemoryAllocation) this.getToolTipManager();
		return new PanelBSBuddySystemeModelImpl(buddy, tooltip);
	}
}