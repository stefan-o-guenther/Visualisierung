/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Fairness;

import Base.FrameMainImpl;
import Base.MainAbstract;

public class TCP_Fairness extends MainAbstract {

	public TCP_Fairness() {
		super();
	}
	
	public static void main(String[] args) {
		initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameMainImpl(new ManagementFairnessImpl()));	
    }
}
