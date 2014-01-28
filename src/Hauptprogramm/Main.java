/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Hauptprogramm;

import Base.BaseMain;

public class Main extends BaseMain {

	public Main() {
		super();
	}
	
	public static void main(String[] args) {
		initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameMain());	
	}
}
