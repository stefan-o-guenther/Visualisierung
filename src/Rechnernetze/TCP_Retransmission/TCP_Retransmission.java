/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Retransmission;

import Base.BaseMain;

public class TCP_Retransmission extends BaseMain {

	public TCP_Retransmission() {
		super();
	}
	
	public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameRNTCPRetransmission());	
    }
}
