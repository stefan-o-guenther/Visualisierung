/**
 * @author:	Stefan Otto Günther
 * @date:	22.02.2014
 */

package Rechnernetze.Dijkstra;

import Base.ToolTipManagerAutomaticAbstract;

public class ToolTipManagerDijkstraAlgorithmImpl extends ToolTipManagerAutomaticAbstract implements ToolTipManagerDijkstraAlgorithm {

	public String getToolTipTitle() {
		String tooltipTitle = ""
	        + "<html>"
	        + "<p>"
	        + "Der <strong>Algorithmus von Dijkstra</strong> ist ein Algorithmus aus der Klasse der Greedy-Algorithmen<br/>"
	        + "und l&ouml;st das Problem der k&uuml;rzesten Pfade f&uuml;r einen gegebenen Startknoten. Er berechnet somit einen<br/>"
	        + "k&uuml;rzesten Pfad zwischen dem gegebenen Startknoten (in dieser Animation Knoten &quot;U&quot;) und einem<br/>"
	        + "der &uuml;brigen Knoten in einem kantengewichtetet Graphen (in dieser Animation Konten &quot;Z&quot;).<br/>"
	        + "Die Kantengewichte d&uuml;rfen dabei nicht negativ sein.<br/>"
	        + "</p>"
	        + "</html>";
		return tooltipTitle;
	}
}
