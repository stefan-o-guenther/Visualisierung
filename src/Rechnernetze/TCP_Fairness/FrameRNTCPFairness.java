package Rechnernetze.TCP_Fairness;

import Base.BaseFrame;

public class FrameRNTCPFairness extends BaseFrame {

	public FrameRNTCPFairness() {
		super("TCP-Fairness");
        initUI(new PanelRNTCPFairnessMain());
    }

    public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameRNTCPFairness());	
    }
}
