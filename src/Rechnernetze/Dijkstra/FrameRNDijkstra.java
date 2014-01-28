/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

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
