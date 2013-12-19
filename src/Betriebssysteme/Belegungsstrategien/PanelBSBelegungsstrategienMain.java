package Betriebssysteme.Belegungsstrategien;

import Base.BasePanelMain;
import Base.PanelTitle;

public class PanelBSBelegungsstrategienMain extends BasePanelMain {
		
	/**
	 * Create the panel.
	 */
	public PanelBSBelegungsstrategienMain() {
		super(new MemoryManagement());
		initComponents();
	}
	
	protected void initComponents() {
		panelModel = new PanelBSBelegungsstrategienModel((IMemoryManagement) management);
		panelMenu = new PanelBSBelegungsstrategienMenu((PanelBSBelegungsstrategienModel) panelModel, (IMemoryManagement) management);
		panelTitle = new PanelTitle("Belegungsstrategien", panelModel);		
		initLayout(160);
	}
}