package Betriebssysteme.Buddy_Systeme;

import Base.EnumScrollbar;
import Base.PanelAbstract;
import Base.PanelBuilderAbstract;
import Base.PanelScrollImpl;

public class PanelBuilderBuddyMemoryAllocationImpl extends PanelBuilderAbstract	implements PanelBuilderBuddyMemoryAllocation {

	public PanelBuilderBuddyMemoryAllocationImpl(ManagementBuddyMemoryAllocation buddy) {
		super(buddy);
	}

	@Override
	protected void createPanelMenu() {
		ManagementBuddyMemoryAllocation buddy = (ManagementBuddyMemoryAllocation) management;
		PanelAbstract panelLeft = new PanelBSBuddySystemeMenuImpl(buddy);
		PanelAbstract panelRightLeft = new PanelBSBuddySystemeTableImpl(buddy);
		PanelAbstract panelRightRight = new PanelBSBuddySystemeLabelImpl(buddy);
		PanelAbstract panelRight = this.getPanelCouple(panelRightLeft, panelRightRight);
		panelMenu = this.getPanelCouple(panelLeft, panelRight);
	}

	@Override
	protected void createPanelModel() {
		ManagementBuddyMemoryAllocation buddy = (ManagementBuddyMemoryAllocation) management;
		PanelAbstract panel = new PanelBSBuddySystemeModelImpl(buddy);
		this.panelModel = new PanelScrollImpl(buddy, panel, EnumScrollbar.NEVER, EnumScrollbar.ALWAYS);
	}
}
