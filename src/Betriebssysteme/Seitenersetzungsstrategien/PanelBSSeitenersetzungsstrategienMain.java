package Betriebssysteme.Seitenersetzungsstrategien;

import Base.BasePanelMain;
import Base.PanelTitle;

public class PanelBSSeitenersetzungsstrategienMain extends BasePanelMain {
	
	/**
	 * Create the panel.
	 */
	public PanelBSSeitenersetzungsstrategienMain() {
		super(new PagingManagement());
		initComponents();
	}	
	
	protected void initComponents() {
		panelModel = new PanelBSSeitenersetzungsstrategienModel((IPagingManagement) management);
		panelMenu = new PanelBSSeitenersetzungsstrategienMenu((PanelBSSeitenersetzungsstrategienModel) panelModel, (IPagingManagement) management);
		panelTitle = new PanelTitle("Seitenersetzungsstrategien", panelModel);
		initLayout(70);
	}
}