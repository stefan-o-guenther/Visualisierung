package Hauptprogramm;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;

import Base.BasePanelMain;
import Base.PanelTitle;

public class PanelDefaultMain extends BasePanelMain {
	
	/**
	 * Create the panel.
	 */
	public PanelDefaultMain() {
		super(null);
		initComponents();
	}	

	protected void initComponents() {
		panelModel = new PanelDefaultModel();
		panelMenu = new PanelDefaultMenu((PanelDefaultModel) panelModel);
		panelTitle = new PanelTitle("Bachelorarbeit - Visualisierung", panelModel);		
		initLayout(200);
	}
}
