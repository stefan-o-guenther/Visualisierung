/**
 * @author:	Stefan Otto Günther
 * @date:	22.02.2014
 */

package Rechnernetze.TCP_Fairness;

import Base.ToolTipManagerAutomaticAbstract;

public class ToolTipManagerFairnessImpl extends ToolTipManagerAutomaticAbstract implements ToolTipManagerFairness {
	
	public String getToolTipTitle() {
		String tooltipTitle = ""
			+ "<html>"
	        + "<p>"
	        + "Beim TCP-Fairness Verfahren werden zwei Verbindungen betrachtet, welche sich die Leitung und die<br/>"
	        + "Durchflussleistung teilen. Die Durchflussleistung jeder Verbindung wird solange nach dem Congestion<br/>"
	        + "Avoidance Verfahren erhöht, bis ein Timeout auftritt oder ein Paket verloren geht. Im Falle, dass dies<br/>"
	        + "auftritt, wird die Durchflussleistung beider Verbindungen halbiert.<br/>"
	        + "Das Ziel von TCP-Fairness ist, den Unterschied der Durchflussleistungen so gering wie möglich zu halten.<br/>"
	        + "TCP-Fairness wird als ein kartesisches Koordinatensystem dargestellt.<br/>"
	        + "Jede TCP-Verbindung wird als eine Koordinatenachse dargestellt, also z. B. Verbindung 1 als x-Achse und<br/>"
	        + "Verbindung 2 als y-Achse. Die Winkelhalbierende stellt TCP-Fairness dar bzw. die gleichmäßig aufgeteilte<br/>"
	        + "Durchflussleistung. Die kreuzende Linie zur TCP-Fairness Linie stellt die maximale Durchflussleistung dar.<br/>"
	        + "</p>"
	        + "</html>";
		return tooltipTitle;
	}
}
