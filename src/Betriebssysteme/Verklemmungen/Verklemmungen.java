/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Verklemmungen;

import Base.BaseMain;

public class Verklemmungen extends BaseMain {

	public Verklemmungen() {
		super();
	}
	
	public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameBSVerklemmungen());	
    }
}
