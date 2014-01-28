/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Pipeline_Protocol;

import Base.BaseMain;

public class Pipeline_Protocol extends BaseMain {

	public Pipeline_Protocol() {
		super();
	}
	
	public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameRNPipelineProtocol());	
    }
}
