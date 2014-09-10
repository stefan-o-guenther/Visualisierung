/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Congestion_Avoidance;

import Base.MainAbstract;

public class Congestion_Avoidance extends MainAbstract {

	public Congestion_Avoidance() {
		super();
	}
	
	public static void main(String[] args) {
		ManagementCongestionAvoidance ca = new ManagementCongestionAvoidanceImpl();
		initialize();
		panelMain = new PanelRNCongestionAvoidanceMainImpl(ca);
		baseMain();	
    }
}