/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Congestion_Avoidance;

import Base.BaseMain;

public class Congestion_Avoidance extends BaseMain {

	public Congestion_Avoidance() {
		super();
	}
	
	public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameRNCongestionAvoidance());	
    }
}
