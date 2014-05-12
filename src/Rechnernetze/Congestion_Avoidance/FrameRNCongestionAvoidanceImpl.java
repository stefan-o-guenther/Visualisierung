/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Congestion_Avoidance;

import Base.FrameAbstract;

public class FrameRNCongestionAvoidanceImpl extends FrameAbstract {
	
	public FrameRNCongestionAvoidanceImpl() {
		super("Congestion Avoidance");
        initUI(new PanelRNCongestionAvoidanceMainImpl());
    }

    public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameRNCongestionAvoidanceImpl());	
    }
}
