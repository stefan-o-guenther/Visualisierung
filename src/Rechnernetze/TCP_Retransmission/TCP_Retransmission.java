/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Retransmission;

import Base.VisualizationAbstract;

public class TCP_Retransmission extends VisualizationAbstract {

	public TCP_Retransmission() {
		super();
	}
	
	public static void main(String[] args) {
		initialize();
		baseVisualization(new PanelRNTCPRetransmissionMainImpl());	
    }
}
