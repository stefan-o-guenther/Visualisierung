/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Queueing_And_Loss;

import Base.VisualizationAbstract;

public class Queueing_And_Loss extends VisualizationAbstract {

	public Queueing_And_Loss() {
		super();
	}
	
	public static void main(String[] args) {
		initialize();
		baseVisualization(new PanelRNQueueingAndLossMainImpl());	
    }
}
