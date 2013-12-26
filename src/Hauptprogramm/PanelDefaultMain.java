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
	        	+ "Mit diesem Geschwindigkeitsregeler können Sie einstellen,<br>"
	        	+ "wie schnell der Auto-Durchlauf ausgeführt werden soll.<br>"
	        	+ "Standardmäßig ist die Geschwindigkeit auf 50% eingestellt.<br>"
	        	+ "</html>";
		
		panelModel = new PanelDefaultModel(main);
		panelMenu = new PanelDefaultMenu(main);
		panelTitle = new PanelTitle("Bachelorarbeit - Visualisierung", tooltip, main);		
		initLayout(200);
	}
}
