/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import Base.BasePanelMain;
import Base.BasePanelMenu;
import Base.BasePanelModel;
import Base.BasePanelTitle;

public class PanelBSBuddySystemeMain extends BasePanelMain {

	public PanelBSBuddySystemeMain() {
		super();
		initComponents();
		initLayout();
	}
	
	private PanelBSBuddySystemeTitle panelTitle;
	private PanelBSBuddySystemeMenu panelMenu;
	private PanelBSBuddySystemeModel panelModel;
	
	protected void initComponents() {
		IBuddyMemoryAllocation buddy =  new BuddyMemoryAllocation();
		panelModel = new PanelBSBuddySystemeModel(buddy);
		panelMenu = new PanelBSBuddySystemeMenu(buddy, panelModel);
		panelTitle = new PanelBSBuddySystemeTitle(buddy, panelModel);
	}

	@Override
	protected BasePanelTitle getPanelTitle() {
		return panelTitle;
	}

	@Override
	protected BasePanelMenu getPanelMenu() {
		return panelMenu;
	}

	@Override
	protected BasePanelModel getPanelModel() {
		return panelModel;
	}	
}