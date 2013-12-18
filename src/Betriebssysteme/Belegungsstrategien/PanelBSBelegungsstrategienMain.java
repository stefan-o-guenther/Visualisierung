package Betriebssysteme.Belegungsstrategien;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import Base.BasePanelMain;
import Base.PanelTitle;

public class PanelBSBelegungsstrategienMain extends BasePanelMain {
	
	private IMemoryManagement memory;
	
	/**
	 * Create the panel.
	 */
	public PanelBSBelegungsstrategienMain() {
		memory = new MemoryManagement();
		initComponents();
	}
	
	protected void initComponents() {
		panelModel = new PanelBSBelegungsstrategienModel(memory);
		panelMenu = new PanelBSBelegungsstrategienMenu((PanelBSBelegungsstrategienModel) panelModel, memory);
		panelTitle = new PanelTitle("Belegungsstrategien", panelModel);		
		initLayout(160);
	}
}
