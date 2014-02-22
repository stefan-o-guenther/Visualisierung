/**
 * @author:	Stefan Otto Günther
 * @date:	29.01.2014
 */

package Rechnernetze.Dijkstra;

import Base.BasePanelTitle;

public class PanelRNDijkstraTitle extends BasePanelTitle {

	public PanelRNDijkstraTitle(IDijkstraAlgorithm dijkstra) {
		super(dijkstra);
	}

	@Override
	protected String getToolTip() {
		return ToolTipManager.getToolTipTitle();
	}

	@Override
	protected String getTitle() {
		return "Dijkstra";
	}	
}