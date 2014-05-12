/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import Base.FrameAbstract;

public class FrameBSBelegungsstrategienImpl extends FrameAbstract {

	public FrameBSBelegungsstrategienImpl() {
		super("Belegungsstrategien");
		initUI(new PanelBSBelegungsstrategienMainImpl());
    }
	
    private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameBSBelegungsstrategienImpl());
    }    
}