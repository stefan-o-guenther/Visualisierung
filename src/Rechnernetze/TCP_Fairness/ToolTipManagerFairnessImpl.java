/**
 * @author:	Stefan Otto Günther
 * @date:	22.02.2014
 */

package Rechnernetze.TCP_Fairness;

import Base.ToolTipManagerAbstract;

public class ToolTipManagerFairnessImpl extends ToolTipManagerAbstract implements ToolTipManagerFairness {
	
	private static ToolTipManagerFairness instance = new ToolTipManagerFairnessImpl();
	
	private ToolTipManagerFairnessImpl() {
		
	}
	
	public static ToolTipManagerFairness getInstance() {
		return instance;
	}	
	
	public String getToolTipTitle() {
		String tooltipTitle = ""
			+ "<html>"
	        + "<p>"
	        + "Bei der TCP-Fairness Betrachtung werden zwei Verbindungen untersucht, welche sich die Gesamtduchflussleistung<br/>"
	        + "teilen. Die Durchflussleistung jeder Verbindung wird solange nach dem Congestion Avoidance<br/>"
	        + "Verfahren erhöht, bis Pakete verloren gehen und Timeouts auftreten. Im Falle, dass dies<br/>"
	        + "eintritt, wird die Durchflussleistung beider Verbindungen halbiert.<br/>"
	        + "Das Ziel von TCP-Fairness ist, den Unterschied der Durchflussleistungen so gering wie möglich zu halten.<br/>"
	        + "TCP-Fairness wird als ein kartesisches Koordinatensystem dargestellt.<br/>"
	        + "Jede TCP-Verbindung wird als eine Koordinatenachse dargestellt, also z. B. Verbindung 1 als x-Achse und<br/>"
	        + "Verbindung 2 als y-Achse. Die Winkelhalbierende stellt TCP-Fairness dar bzw. die gleichmäßig aufgeteilte<br/>"
	        + "Durchflussleistung. Die kreuzende gestrichelte Linie zur TCP-Fairness Linie stellt die maximale Durchflussleistung dar.<br/>"
	        + "</p>"
	        + "</html>";
		return tooltipTitle;
	}

	@Override
	public String getToolTipConnection1() {
		String tooltipConnection1 = ""
			+ "<html>"
	        + "<p>"
	        + "Congestion Window Size (cwnd) ist die Durchflussleistung von Verbindung 1.<br/>"
	        + "</p>"
	        + "</html>";
		return tooltipConnection1;
	}

	@Override
	public String getToolTipConnection2() {
		String tooltipConnection2 = ""
			+ "<html>"
	        + "<p>"
	        + "Congestion Window Size (cwnd) ist die Durchflussleistung von Verbindung 2.<br/>"
	        + "</p>"
	        + "</html>";
		return tooltipConnection2;
	}

	@Override
	public String getToolTipCwnd1() {
		String tooltipCwnd1 = ""
			+ "<html>"
	        + "<p>"
	        + "Die Congestion Window Size (cwnd) ist die Durchflussleistung von Verbindung 1 w&auml;hrend des Programmablaufs.<br/>"
	        + "</p>"
	        + "</html>";
		return tooltipCwnd1;
	}

	@Override
	public String getToolTipCwnd2() {
		String tooltipCwnd2 = ""
			+ "<html>"
	        + "<p>"
	        + "Die Congestion Window Size (cwnd) ist die Durchflussleistung von Verbindung 2 w&auml;hrend des Programmablaufs.<br/>"
	        + "</p>"
	        + "</html>";
		return tooltipCwnd2;
	}

	@Override
	public String getToolTipDifference() {
		String tooltipDifference = ""
			+ "<html>"
	        + "<p>"
	        + "Die Differenz zwischen cwnd von Verbindung 1 und cwnd von Verbindung 2. Dass Ziel ist, dass die Differenz 0 ist.<br/>"
	        + "</p>"
	        + "</html>";
		return tooltipDifference;
	}

	@Override
	public String getToolTipModus() {
		String tooltipModus = ""
			+ "<html>"
	        + "<p>"
	        + "Der Modus ist standardm&auml;&szlig;ig auf Congestion Avoidance eingestellt.<br/>"
	        + "</p>"
	        + "</html>";
		return tooltipModus;
	}

	@Override
	public String getToolTipMaxFlowRate() {
		String tooltipMax = ""
			+ "<html>"
	        + "<p>"
	        + "maximale Summe der Durchflussleistungen von Verbindung 1 und 2<br/>"
	        + "</p>"
	        + "</html>";
		return tooltipMax;
	}
}
