/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Congestion_Avoidance;

import Base.BaseFrame;

public class FrameRNCongestionAvoidance extends BaseFrame {
	
	public FrameRNCongestionAvoidance() {
		super("Congestion Avoidance");
        initUI(new PanelRNCongestionAvoidanceMain());
    }

    public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameRNCongestionAvoidance());	
    }
}
