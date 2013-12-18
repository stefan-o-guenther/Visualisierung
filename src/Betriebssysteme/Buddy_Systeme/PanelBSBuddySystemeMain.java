package Betriebssysteme.Buddy_Systeme;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;

import Base.BasePanelMain;
import Base.PanelTitle;

public class PanelBSBuddySystemeMain extends BasePanelMain {

	protected void initComponents() {
		panelModel = new PanelBSBuddySystemeModel();
		panelMenu = new PanelBSBuddySystemeMenu( (PanelBSBuddySystemeModel) panelModel);
		panelTitle = new PanelTitle("Buddy Systeme", panelModel);
		initLayout(200);
	}
		
	/**
	 * Create the panel.
	 */
	public PanelBSBuddySystemeMain() {
		initComponents();
	}
}
