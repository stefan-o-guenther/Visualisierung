/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Rechnernetze.Congestion_Avoidance;

import Base.MainAbstract;

public class Congestion_Avoidance extends MainAbstract {

	public Congestion_Avoidance() {
		super();
	}
	
	public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameRNCongestionAvoidanceImpl());	
    }
}
