package Rechnernetze.Dijkstra;

import Base.BaseFrame;

public class FrameRNDijkstra extends BaseFrame {

	public FrameRNDijkstra() {
		super("Dijkstra");
        initUI(new PanelRNDijkstraMain());
    }

    public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameRNDijkstra());	
    }
}
