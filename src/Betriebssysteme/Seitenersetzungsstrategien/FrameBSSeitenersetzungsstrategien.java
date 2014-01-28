/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import Base.BaseFrame;

public class FrameBSSeitenersetzungsstrategien extends BaseFrame {

	public FrameBSSeitenersetzungsstrategien() {
		super("Seitenersetzungsstrategien");
		initUI(new PanelBSSeitenersetzungsstrategienMain());
    }

    public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameBSSeitenersetzungsstrategien());	
    }
}
