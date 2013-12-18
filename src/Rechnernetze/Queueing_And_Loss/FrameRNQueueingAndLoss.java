package Rechnernetze.Queueing_And_Loss;

import Base.BaseFrame;

public class FrameRNQueueingAndLoss extends BaseFrame {

	public FrameRNQueueingAndLoss() {
        initUI("Belegungsstrategien", new PanelRNQueueingAndLoss());
    }

    public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameRNQueueingAndLoss());	
    }
}
