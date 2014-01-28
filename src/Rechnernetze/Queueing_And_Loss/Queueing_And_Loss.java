/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Queueing_And_Loss;

import Base.BaseMain;

public class Queueing_And_Loss extends BaseMain {

	public Queueing_And_Loss() {
		super();
	}
	
	public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameRNQueueingAndLoss());	
    }
}
