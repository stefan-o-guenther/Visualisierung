package Rechnernetze.Dijkstra;

import Base.BasePanelMain;
import Base.PanelTitle;

public class PanelRNDijkstraMain extends BasePanelMain {

	/**
	 * Create the panel.
	 */
	public PanelRNDijkstraMain() {
		super(new DijkstraManagement());
		initComponents();
	}

	@Override
	protected void initComponents() {
		IDijkstraManagement dijkstra = (IDijkstraManagement) management;
		
		String tooltip = 
	        	  "<html>"
	        	+ "Mit diesem Geschwindigkeitsregeler können Sie einstellen,<br>"
	        	+ "wie schnell der Auto-Durchlauf ausgeführt werden soll.<br>"
	        	+ "Standardmäßig ist die Geschwindigkeit auf 50% eingestellt.<br>"
	        	+ "</html>";
		
		panelModel = new PanelRNDijkstraModel(dijkstra );
		panelMenu = new PanelRNDijkstraMenu(dijkstra );
		panelTitle = new PanelTitle("Dijkstra", tooltip, dijkstra );		
		initLayout(200);
	}

}
