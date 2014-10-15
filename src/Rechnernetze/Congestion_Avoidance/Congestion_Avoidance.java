/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Congestion_Avoidance;

import Base.VisualizationAbstract;

public class Congestion_Avoidance extends VisualizationAbstract {

	public Congestion_Avoidance() {
		super();
	}
	
	public static void main(String[] args) {
		initialize();
		baseVisualization(new PanelRNCongestionAvoidanceMainImpl());	
    }
}