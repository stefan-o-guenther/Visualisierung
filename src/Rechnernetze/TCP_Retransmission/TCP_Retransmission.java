/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Retransmission;

import Base.FrameMainImpl;
import Base.MainAbstract;

public class TCP_Retransmission extends MainAbstract {

	public TCP_Retransmission() {
		super();
	}
	
	public static void main(String[] args) {
		initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameMainImpl(new ManagementRetransmissionImpl()));	
    }
}
