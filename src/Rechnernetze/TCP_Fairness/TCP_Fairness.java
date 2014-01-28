/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Fairness;

import Base.BaseMain;

public class TCP_Fairness extends BaseMain {

	public TCP_Fairness() {
		super();
	}
	
	public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameRNTCPFairness());	
    }
}
