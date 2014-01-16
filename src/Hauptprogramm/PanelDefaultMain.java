package Hauptprogramm;

import Base.BasePanelMain;
import Base.PanelTitle;

public class PanelDefaultMain extends BasePanelMain {
	
	/**
	 * Create the panel.
	 */
	public PanelDefaultMain() {
		super(new DefaultManagement());
		initComponents();
	}	

	protected void initComponents() {
		IDefaultManagement main = (IDefaultManagement) management;
		
		String tooltip = 
	        	  "<html>"
	        	+ "Mit diesem Geschwindigkeitsregeler k�nnen Sie einstellen,<br>"
	        	+ "wie schnell der Auto-Durchlauf ausgef�hrt werden soll.<br>"
	        	+ "Standardm��ig ist die Geschwindigkeit auf 50% eingestellt.<br>"
	        	+ "</html>";
		
		panelModel = new PanelDefaultModel(main);
		panelMenu = new PanelDefaultMenu(main, panelModel);
		panelTitle = new PanelTitle(main, panelModel, "Bachelorarbeit - Visualisierung", tooltip);		
		initLayout(200);
	}
}
