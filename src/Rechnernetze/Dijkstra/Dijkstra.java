/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra;

import Base.MainAbstract;

public class Dijkstra extends MainAbstract {

	public Dijkstra() {
		super();
	}
	
	public static void main(String[] args) {
		ManagementDijkstraAlgorithm dijkstra = new ManagementDijkstraAlgorithmImpl();
		initialize();
		panelMain = new PanelRNDijkstraAlgorithmMainImpl(dijkstra);
    	baseMain();	
    }
}
