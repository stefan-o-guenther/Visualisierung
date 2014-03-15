/**
 * @author:	Stefan Otto Günther
 * @date:	22.02.2014
 */

package Rechnernetze.Congestion_Avoidance;

public class ToolTipManager {
	
	public static String getToolTipTitle() {
		String tooltipTitle = ""
			+ "<html>"
			+ "<p>"
			+ "Congestion Avoidance (CA) ist ein Verfahren zur Vermeidung von Stausituationen in Routern.<br/>"
			+ "Wenn bei Routern die Warteschlangen gefüllt sind, verwerfen sie normalerweise anstehende Datenpakete.<br/>"
			+ "Dieser Paketverlust führt beim TCP-Protokoll zur Reduzierung der Senderate und zur anschließenden<br/>"
			+ "Erhöhung, sobald keine Datenverluste mehr gemeldet werden.<br/>"
			+ "</p>"
			+ "</html>";
		return tooltipTitle;
	}
}
