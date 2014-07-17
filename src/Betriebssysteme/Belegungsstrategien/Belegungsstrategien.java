/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import Base.MainAbstract;

public class Belegungsstrategien extends MainAbstract {
	
	public Belegungsstrategien() {
		super();
	}
	
	public static void main(String[] args) {
		initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameBSBelegungsstrategienImpl());
    }
}