/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra;

import Base.FrameAbstract;

public class FrameRNDijkstra extends FrameAbstract {

	public FrameRNDijkstra() {
		super("Dijkstra");
        initUI(new PanelRNDijkstraAlgorithmMainImpl());
    }

    public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameRNDijkstra());	
    }
}
