package Rechnernetze.Dijkstra;

import Base.BasePanelMenu;

public class PanelRNDijkstraMenu extends BasePanelMenu {

	private IDijkstraManagement dijkstra;
	
	/**
	 * Create the panel.
	 */
	public PanelRNDijkstraMenu(IDijkstraManagement idijkstra) {
		if (idijkstra == null) {
			idijkstra = new DijkstraManagement();
		}
		dijkstra = idijkstra;
	}

	@Override
	protected void initComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void updateComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initToolTips() {
		// TODO Auto-generated method stub
		
	}

}
