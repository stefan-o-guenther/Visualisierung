/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Hauptprogramm;

import Base.MainAbstract;

public class Main extends MainAbstract {

	public Main() {
		super();
	}
	
	public static void main(String[] args) {
		initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameMainImpl());	
	}
}
