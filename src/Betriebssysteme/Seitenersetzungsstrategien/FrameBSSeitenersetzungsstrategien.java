/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import Base.FrameAbstract;

public class FrameBSSeitenersetzungsstrategien extends FrameAbstract {

	public FrameBSSeitenersetzungsstrategien() {
		super("Seitenersetzungsstrategien");
		initUI(new PanelBSSeitenersetzungsstrategienMainImpl());
    }

    public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameBSSeitenersetzungsstrategien());	
    }
}
