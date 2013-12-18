package Betriebssysteme.Buddy_Systeme;

import Base.BaseFrame;

public class FrameBSBuddySysteme extends BaseFrame {

	public FrameBSBuddySysteme() {
        initUI("Buddy Systeme", new PanelBSBuddySystemeMain());
    }

    public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameBSBuddySysteme());	
    }
}
