/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.QAL_Old;

import Base.MainAbstract;

public class Queueing_And_Loss extends MainAbstract {

	public Queueing_And_Loss() {
		super();
	}
	
	public static void main(String[] args) {
		initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameRNQueueingAndLoss());	
    }
}
