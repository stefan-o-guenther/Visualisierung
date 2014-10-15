/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Fairness;

import Base.VisualizationAbstract;

public class TCP_Fairness extends VisualizationAbstract {

	public TCP_Fairness() {
		super();
	}
	
	public static void main(String[] args) {
		initialize();
		baseVisualization(new PanelRNTCPFairnessMainImpl());	
    }
}
