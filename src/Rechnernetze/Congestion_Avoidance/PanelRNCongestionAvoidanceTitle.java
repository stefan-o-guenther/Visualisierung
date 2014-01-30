/**
 * @author:	Stefan Otto Günther
 * @date:	29.01.2014
 */

package Rechnernetze.Congestion_Avoidance;

import Base.BasePanelTitle;

public class PanelRNCongestionAvoidanceTitle extends BasePanelTitle {

	public PanelRNCongestionAvoidanceTitle(INetworkManagement network, PanelRNCongestionAvoidanceModel model) {
		super(network, model);
	}

	@Override
	protected String getToolTip() {
		String tooltipRNCongestionAvoidance = ""
			+ "<html>"
			+ "<p>"
			+ "Congestion Avoidance (CA) ist ein Verfahren zur Vermeidung von Stausituationen in Routern.<br/>"
			+ "Wenn bei Routern die Warteschlangen gefüllt sind, verwerfen sie normalerweise anstehende Datenpakete.<br/>"
			+ "Dieser Paketverlust führt beim TCP-Protokoll zur Reduzierung der Senderate und zur anschließenden<br/>"
			+ "Erhöhung, sobald keine Datenverluste mehr gemeldet werden.<br/>"
			+ "</p>"
			+ "</html>";
		return tooltipRNCongestionAvoidance;
	}

	@Override
	protected String getTitle() {
		return "Congestion Avoidance";
	}
}