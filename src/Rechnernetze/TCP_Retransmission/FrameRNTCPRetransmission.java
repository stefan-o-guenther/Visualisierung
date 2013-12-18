package Rechnernetze.TCP_Retransmission;

import Base.BaseFrame;

public class FrameRNTCPRetransmission extends BaseFrame {

	public FrameRNTCPRetransmission() {
        initUI("Belegungsstrategien", new PanelRNTCPRetransmission());
    }

    public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameRNTCPRetransmission());	
    }
}
