package Betriebssysteme.Belegungsstrategien;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import Base.BasePanelMain;
import Base.PanelTitle;

public class PanelBSBelegungsstrategienMain extends BasePanelMain {
	
	private IMemoryManagement memory;
	
	protected void initComponents() {
		panelModel = new PanelBSBelegungsstrategienModel(memory.getListSpace());
		panelMenu = new PanelBSBelegungsstrategienMenu((PanelBSBelegungsstrategienModel) panelModel);
		panelTitle = new PanelTitle("Belegungsstrategien", panelModel);		
		initLayout(160);
	}
		
	/**
	 * Create the panel.
	 */
	public PanelBSBelegungsstrategienMain() {
		memory = new MemoryManagement();
		initComponents();
	}
}
