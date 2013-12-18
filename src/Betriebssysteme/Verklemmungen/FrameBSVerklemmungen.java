package Betriebssysteme.Verklemmungen;

import Base.BaseFrame;

public class FrameBSVerklemmungen extends BaseFrame {

	public FrameBSVerklemmungen() {
        initUI("Verklemmungen", new PanelBSVerklemmungenMain());
    }

    public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameBSVerklemmungen());	
    }
}
