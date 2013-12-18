package Rechnernetze.TCP_Fairness;

import Base.BaseFrame;

public class FrameRNTCPFairness extends BaseFrame {

	public FrameRNTCPFairness() {
        initUI("Belegungsstrategien", new PanelRNTCPFairness());
    }

    public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameRNTCPFairness());	
    }
}
