package Betriebssysteme.Seitenersetzungsstrategien;

import Base.BasePanelMain;
import Base.PanelTitle;

public class PanelBSSeitenersetzungsstrategienMain extends BasePanelMain {
	
	/**
	 * Create the panel.
	 */
	public PanelBSSeitenersetzungsstrategienMain() {
		initComponents();
	}	
	
	protected void initComponents() {
		panelModel = new PanelBSSeitenersetzungsstrategienModel();
		panelMenu = new PanelBSSeitenersetzungsstrategienMenu((PanelBSSeitenersetzungsstrategienModel) panelModel);
		panelTitle = new PanelTitle("Seitenersetzungsstrategien", panelModel);
		initLayout(70);
	}
	
	
	
}