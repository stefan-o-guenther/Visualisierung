package Rechnernetze.Dijkstra;

import Base.BasePanelMain;
import Base.PanelTitle;

public class PanelRNDijkstraMain extends BasePanelMain {

	/**
	 * Create the panel.
	 */
	public PanelRNDijkstraMain() {
		super(null);
		initComponents();
	}

	@Override
	protected void initComponents() {
		panelModel = new PanelRNDijkstraModel();
		panelMenu = new PanelRNDijkstraMenu((PanelRNDijkstraModel) panelModel);
		panelTitle = new PanelTitle("Dijkstra", panelModel);		
		initLayout(200);
	}

}
