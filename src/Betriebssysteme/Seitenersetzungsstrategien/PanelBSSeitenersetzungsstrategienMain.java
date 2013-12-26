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
		IPagingManagement paging = (IPagingManagement) management;
		
		String tooltip = 
	        	  "<html>"
	        	+ "Mit diesem Geschwindigkeitsregeler können Sie einstellen,<br>"
	        	+ "wie schnell der Auto-Durchlauf ausgeführt werden soll.<br>"
	        	+ "Standardmäßig ist die Geschwindigkeit auf 50% eingestellt.<br>"
	        	+ "</html>";
		
		panelModel = new PanelBSSeitenersetzungsstrategienModel(paging);
		panelMenu = new PanelBSSeitenersetzungsstrategienMenu(paging);
		panelTitle = new PanelTitle("Seitenersetzungsstrategien", tooltip, paging);
		initLayout(70);
	}
}