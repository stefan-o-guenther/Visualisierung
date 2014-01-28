/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra;

import Base.BaseMain;

public class Dijkstra extends BaseMain {

	public Dijkstra() {
		super();
	}
	
	public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameRNDijkstra());	
    }
}
