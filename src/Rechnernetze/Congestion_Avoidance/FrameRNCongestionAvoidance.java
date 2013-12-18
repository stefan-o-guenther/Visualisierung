package Rechnernetze.Congestion_Avoidance;

import Base.BaseFrame;

public class FrameRNCongestionAvoidance extends BaseFrame {
	
	public FrameRNCongestionAvoidance() {
        initUI("Belegungsstrategien", new PanelRNCongestionAvoidance());
    }

    public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameRNCongestionAvoidance());	
    }
}
