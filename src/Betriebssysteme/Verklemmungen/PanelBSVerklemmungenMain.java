package Betriebssysteme.Verklemmungen;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;

import Base.BasePanelMain;
import Base.PanelTitle;

public class PanelBSVerklemmungenMain extends BasePanelMain {

	/**
	 * Create the panel.
	 */
	public PanelBSVerklemmungenMain() {
		super(null);
		initComponents();
	}	
	
	protected void initComponents() {
		panelModel = new PanelBSVerklemmungenModel();
		panelMenu = new PanelBSVerklemmungenMenu((PanelBSVerklemmungenModel) panelModel);
		panelTitle = new PanelTitle("Verklemmungen", panelModel);		
		initLayout(200);
	}
}
