/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Verklemmungen;

import Base.BaseFrame;

public class FrameBSVerklemmungen extends BaseFrame {

	public FrameBSVerklemmungen() {
		super("Verklemmungen");
		initUI(new PanelBSVerklemmungenMain());
    }

    public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameBSVerklemmungen());	
    }
}
