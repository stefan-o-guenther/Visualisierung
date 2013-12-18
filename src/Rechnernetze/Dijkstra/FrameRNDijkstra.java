package Rechnernetze.Dijkstra;

import Base.BaseFrame;

public class FrameRNDijkstra extends BaseFrame {

	public FrameRNDijkstra() {
        initUI("Belegungsstrategien", new PanelRNDijkstra());
    }

    public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameRNDijkstra());	
    }
}
