/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import Base.BaseMain;

public class Seitenersetzungsstrategien extends BaseMain {

	public Seitenersetzungsstrategien() {
		super();
	}
	
	public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameBSSeitenersetzungsstrategien());	
    }
}