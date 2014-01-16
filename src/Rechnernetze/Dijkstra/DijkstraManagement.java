package Rechnernetze.Dijkstra;

import Base.BaseManagement;

public class DijkstraManagement extends BaseManagement implements IDijkstraManagement {

	private void initDijkstra() {
		INode nodeU = new Node("U");
		nodeU.setType(EnumNodeType.START);
		
	}
	
	public DijkstraManagement() {
		
	}
	
}
