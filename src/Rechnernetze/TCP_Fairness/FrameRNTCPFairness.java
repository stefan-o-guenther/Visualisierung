/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Fairness;

import Base.FrameAbstract;

public class FrameRNTCPFairness extends FrameAbstract {

	public FrameRNTCPFairness() {
		super("TCP-Fairness");
        initUI(new PanelRNTCPFairnessMainImpl());
    }

    public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameRNTCPFairness());	
    }
}
