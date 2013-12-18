package Betriebssysteme.Seitenersetzungsstrategien;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import Base.BasePanelMain;
import Base.PanelTitle;

public class PanelBSSeitenersetzungsstrategienMain extends BasePanelMain {
	
	//private IMemoryManagement memory;
	
	protected void initComponents() {
		panelModel = new PanelBSSeitenersetzungsstrategienModel();
		panelMenu = new PanelBSSeitenersetzungsstrategienMenu((PanelBSSeitenersetzungsstrategienModel) panelModel);
		panelTitle = new PanelTitle("Seitenersetzungsstrategien", panelModel);
		initLayout(70);
	}
	
	
	/**
	 * Create the panel.
	 */
	public PanelBSSeitenersetzungsstrategienMain() {
		//memory = new MemoryManagement();
		initComponents();
	}	
}