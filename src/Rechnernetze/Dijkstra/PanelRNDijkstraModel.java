package Rechnernetze.Dijkstra;

import java.awt.Graphics;

import Base.BasePanelModelDraw;

public class PanelRNDijkstraModel extends BasePanelModelDraw {

	private IDijkstraManagement dijkstra;
	
	/**
	 * Create the panel.
	 */
	public PanelRNDijkstraModel(IDijkstraManagement idijkstra) {
		if (idijkstra == null) {
			idijkstra = new DijkstraManagement();
		}
		dijkstra = idijkstra;
	}

	@Override
	protected void doDrawing(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
