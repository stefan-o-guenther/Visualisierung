package Rechnernetze.Dijkstra;

import Base.BasePanelMain;
import Base.PanelTitle;

public class PanelRNDijkstraMain extends BasePanelMain {

	/**
	 * Create the panel.
	 */
	public PanelRNDijkstraMain() {
		panelModel = new PanelRNDijkstraModel();
		panelMenu = new PanelRNDijkstraMenu((PanelRNDijkstraModel) panelModel);
		panelTitle = new PanelTitle("Dijkstra", panelModel);		
		initLayout(200);
	}

	@Override
	protected void initComponents() {
		// TODO Auto-generated method stub
		
	}

}
