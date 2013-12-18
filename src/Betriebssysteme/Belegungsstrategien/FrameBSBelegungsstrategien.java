package Betriebssysteme.Belegungsstrategien;

import Base.BaseFrame;

public class FrameBSBelegungsstrategien extends BaseFrame {

	public FrameBSBelegungsstrategien() {
        initUI("Belegungsstrategien", new PanelBSBelegungsstrategienMain());
    }

    public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameBSBelegungsstrategien());	
    }
}