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
	
	public void initComponents() {
		IBuddyMemoryAllocation buddy =  new BuddyMemoryAllocation();
		panelModel = new PanelBSBuddySystemeModel(buddy);
		panelMenu = new PanelBSBuddySystemeMenu(buddy);
		panelTitle = new PanelBSBuddySystemeTitle(buddy);
	}

	@Override
	public BasePanelTitle getPanelTitle() {
		return panelTitle;
	}

	@Override
	public BasePanelMenu getPanelMenu() {
		return panelMenu;
	}

	@Override
	public BasePanelModel getPanelModel() {
		return panelModel;
	}	
}