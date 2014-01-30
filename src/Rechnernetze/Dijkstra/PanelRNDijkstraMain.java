/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra;

import Base.BasePanelMain;
import Base.BasePanelMenu;
import Base.BasePanelModel;
import Base.BasePanelTitle;

public class PanelRNDijkstraMain extends BasePanelMain {

	public PanelRNDijkstraMain() {
		super();
		initComponents();
		initLayout();
	}

	private PanelRNDijkstraTitle panelTitle;
	private PanelRNDijkstraMenu panelMenu;
	private PanelRNDijkstraModel panelModel;
	
	@Override
	protected void initComponents() {
		IDijkstraAlgorithm dijkstra = new DijkstraAlgorithm();		
		panelModel = new PanelRNDijkstraModel(dijkstra);
		panelMenu = new PanelRNDijkstraMenu(dijkstra, panelModel);
		panelTitle = new PanelRNDijkstraTitle(dijkstra, panelModel);
	}

	@Override
	protected BasePanelTitle getPanelTitle() {
		return panelTitle;
	}

	@Override
	protected BasePanelMenu getPanelMenu() {
		return panelMenu;
	}

	@Override
	protected BasePanelModel getPanelModel() {
		return panelModel;
	}

}
