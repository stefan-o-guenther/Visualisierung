package Betriebssysteme.Seitenersetzungsstrategien;

import Base.BaseFrame;

public class FrameBSSeitenersetzungsstrategien extends BaseFrame {

	public FrameBSSeitenersetzungsstrategien() {
        initUI("Seitenersetzungsstrategien", new PanelBSSeitenersetzungsstrategienMain());
    }

    public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameBSSeitenersetzungsstrategien());	
    }
}
