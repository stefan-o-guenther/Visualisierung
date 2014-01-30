/**
 * @author:	Stefan Otto G�nther
 * @date:	29.01.2014
 */

package Rechnernetze.TCP_Fairness;

import Base.BasePanelTitle;

public class PanelRNTCPFairnessTitle extends BasePanelTitle {

	public PanelRNTCPFairnessTitle(IFairnessManagement fairness, PanelRNTCPFairnessModel model) {
		super(fairness, model);
	}

	@Override
	protected String getToolTip() {
		String tooltipRNTCPFairness = ""
	        + "<html>"
	        + "<p>"
	        + "Beim TCP-Fairness Verfahren werden zwei Verbindungen betrachtet, welche sich die Leitung und die<br/>"
	        + "Durchflussleistung teilen. Die Durchflussleistung jeder Verbindung wird solange nach dem Congestion<br/>"
	        + "Avoidance Verfahren erh�ht, bis ein Timeout auftritt oder ein Paket verloren geht. Im Falle, dass dies<br/>"
	        + "auftritt, wird die Durchflussleistung beider Verbindungen halbiert.<br/>"
	        + "Das Ziel von TCP-Fairness ist, den Unterschied der Durchflussleistungen so gering wie m�glich zu halten.<br/>"
	        + "TCP-Fairness wird als ein kartesisches Koordinatensystem dargestellt.<br/>"
	        + "Jede TCP-Verbindung wird als eine Koordinatenachse dargestellt, also z. B. Verbindung 1 als x-Achse und<br/>"
	        + "Verbindung 2 als y-Achse. Die Winkelhalbierende stellt TCP-Fairness dar bzw. die gleichm��ig aufgeteilte<br/>"
	        + "Durchflussleistung. Die kreuzende Linie zur TCP-Fairness Linie stellt die maximale Durchflussleistung dar.<br/>"
	        + "</p>"
	        + "</html>";
		return tooltipRNTCPFairness;
	}

	@Override
	protected String getTitle() {
		return "TCP-Fairness";
	}
}