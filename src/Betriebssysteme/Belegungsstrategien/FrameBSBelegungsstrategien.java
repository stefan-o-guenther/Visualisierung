/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import Base.BaseFrame;

public class FrameBSBelegungsstrategien extends BaseFrame {

	public FrameBSBelegungsstrategien() {
		super("Belegungsstrategien");
		initUI(new PanelBSBelegungsstrategienMain());
    }
	
    private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameBSBelegungsstrategien());
    }    
}