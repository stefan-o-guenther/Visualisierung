/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Queueing_And_Loss;

import Base.BaseFrame;

public class FrameRNQueueingAndLoss extends BaseFrame {

	public FrameRNQueueingAndLoss() {
		super("Queueing And Loss");
        initUI(new PanelRNQueueingAndLossMain());
    }

    public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameRNQueueingAndLoss());	
    }
}
