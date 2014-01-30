/**
 * @author:	Stefan Otto Günther
 * @date:	29.01.2014
 */

package Rechnernetze.Dijkstra;

import Base.BasePanelTitle;

public class PanelRNDijkstraTitle extends BasePanelTitle {

	public PanelRNDijkstraTitle(IDijkstraAlgorithm dijkstra, PanelRNDijkstraModel model) {
		super(dijkstra, model);
	}

	@Override
	protected String getToolTip() {
		String tooltipRNDijkstra = ""
	        + "<html>"
	        + "<p>"
	        + "Der <strong>Algorithmus von Dijkstra</strong> ist ein Algorithmus aus der Klasse der Greedy-Algorithmen<br/>"
	        + "und löst das Problem der kürzesten Pfade für einen gegebenen Startknoten. Er berechnet somit einen<br/>"
	        + "kürzesten Pfad zwischen dem gegebenen Startknoten (in dieser Animation Knoten &quot;U&quot;) und einem<br/>"
	        + "der übrigen Knoten in einem kantengewichtetet Graphen (in dieser Animation Konten &quot;Z&quot;).<br/>"
	        + "Die Kantengewichte dürfen dabei nicht negativ sein.<br/>"
	        + "</p>"
	        + "</html>";
		return tooltipRNDijkstra;
	}

	@Override
	protected String getTitle() {
		return "Dijkstra";
	}	
}