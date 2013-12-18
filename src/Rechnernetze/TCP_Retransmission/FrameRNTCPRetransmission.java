package Rechnernetze.TCP_Retransmission;

import Base.BaseFrame;

public class FrameRNTCPRetransmission extends BaseFrame {

	public FrameRNTCPRetransmission() {
		super("TCP-Retransmission");
        initUI(new PanelRNTCPRetransmissionMain());
    }

    public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameRNTCPRetransmission());	
    }
}
