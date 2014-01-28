/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra;

import Base.BasePanelMain;
import Base.PanelTitle;

public class PanelRNDijkstraMain extends BasePanelMain {

	/**
	 * Create the panel.
	 */
	public PanelRNDijkstraMain() {
		super(new DijkstraAlgorithm());
		initComponents();
	}

	@Override
	protected void initComponents() {
		IDijkstraAlgorithm dijkstra = (IDijkstraAlgorithm) management;
		
		String tooltip = 
	        	  "<html>"
	        	+ "Mit diesem Geschwindigkeitsregeler k�nnen Sie einstellen,<br>"
	        	+ "wie schnell der Auto-Durchlauf ausgef�hrt werden soll.<br>"
	        	+ "Standardm��ig ist die Geschwindigkeit auf 50% eingestellt.<br>"
	        	+ "</html>";
		
		panelModel = new PanelRNDijkstraModel(dijkstra);
		panelMenu = new PanelRNDijkstraMenu(dijkstra, panelModel);
		panelTitle = new PanelTitle(dijkstra, panelModel, "Dijkstra", tooltip);		
		initLayout(50);
	}

}
