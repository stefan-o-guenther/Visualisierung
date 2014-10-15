/**
 * @author:	Stefan Otto G&uuml;nther
 * @date:	22.02.2014
 */

package Rechnernetze.Congestion_Avoidance;

import Base.ToolTipManagerAbstract;

public class ToolTipManagerCongestionAvoidanceImpl extends ToolTipManagerAbstract implements ToolTipManagerCongestionAvoidance {
	
	private static ToolTipManagerCongestionAvoidance instance = new ToolTipManagerCongestionAvoidanceImpl();
	
	private ToolTipManagerCongestionAvoidanceImpl() {
		
	}
	
	public static ToolTipManagerCongestionAvoidance getInstance() {
		return instance;
	}	
	
	public String getToolTipTitle() {
		String tooltipTitle = ""
			+ "<html>"
			+ "<p>"
			+ "Congestion Avoidance (CA) ist ein Verfahren zur Vermeidung von Stausituationen in Routern.<br/>"
			+ "Wenn bei Routern die Warteschlangen gef&uuml;llt sind, verwerfen sie normalerweise anstehende Datenpakete.<br/>"
			+ "Dieser Paketverlust f&uuml;hrt beim TCP-Protokoll zur Reduzierung der Senderate und zur anschlie&szlig;enden<br/>"
			+ "Erh&ouml;hung, sobald keine Datenverluste mehr gemeldet werden.<br/>"
			+ "</p>"
			+ "</html>";
		return tooltipTitle;
	}

	@Override
	public String getToolTipTcpTahoe() {
		String tooltipTcpTahoe = ""
			+ "<html>"
			+ "<h3>TCP-Tahoe:</h3>"
			+ "Das inwischen nicht mehr verwendete TCP-Tahoe reduziert, sobald ein Timeout vorliegt, das Congestion Window f&uuml;r die n&auml;chste &uuml;bertragungseinheit auf 1.<br/>"
			+ "Anschlie&szlig;end startet wieder der TCP-Slow-Start-Prozess (mit verringertem Threshold), bis ein neues Timeout- oder DUP-ACKs-Ereignis stattfindet oder<br/>"
			+ "aber der Schwellwert (Threshold) zum &uuml;bergang in die Congestion-Avoidance-Phase erreicht wird.<br/>"
			+ "Dieser Schwellwert wurde nach dem Auftreten des &uuml;berlast-Ereignisses auf die H&auml;lfte der Gr&ouml;&szlig;e des derzeitigen Congestion Window gesetzt.<br/>"
			+ "Der Nachteil dieses Verfahrens ist zum einen, dass ein Paketverlust nur durch einen Timeout festgestellt wird, mitunter also recht lange dauert,<br/>"
			+ "und zum anderen die starke Reduktion des Congestion Window auf 1. "
			+ "</html>";		
		return tooltipTcpTahoe;
	}

	@Override
	public String getToolTipTcpReno() {
		String tooltipTcpReno = ""
			+ "<html>"
			+ "<h3>TCP-Reno:</h3>"
			+ "Die Weiterentwicklung von TCP-Tahoe ist TCP-Reno. Hierbei wird zwischen auftretenden Timeout- und DUP-ACKs-Ereignissen unterschieden.<br/>"
			+ "W&auml;hrend TCP-Reno beim Auftreten eines Timeout genauso verf&auml;hrt wie TCP-Tahoe,<br/>"
			+ "wendet es beim Auftreten von drei doppelten ACKs eine andere Variante f&uuml;r die Festlegung des nachfolgenden Congestion Window an.<br/>"
			+ "Die grundlegenede Idee dabei ist, dass der Verlust eines Segments auf dem Weg zum Empf&auml;nger nicht nur durch einen Timeout erkannt werden kann,<br/>"
			+ "sondern auch dadurch, dass der Empf&auml;nger mehrfach dieselben ACKs f&uuml;r das unmittelbar vor dem verlorengegangenen Segment zur&uuml;ckschickt.<br/>"
			+ "Daher wird das nachfolgende Congestion Window auf die H&auml;lfte des Wertes des Congestion Windows zum Zeitpunkt des &uuml;berlast-Ereignisses gesetzt;<br/>"
			+ "anschlie&szlig;end wird wieder in die Congestion Avoidance Phase &uuml;bergegangen. Dieses Verhalten wid als Fast-Recovery beschrieben."
			+ "</html>";		
		return tooltipTcpReno;
	}

	@Override
	public String getToolTipSSThresh() {
		String tooltipSsThresh = ""
			+ "<html>"
			+ "<p>"
			+ ""
			+ ""
			+ ""
			+ ""
			+ ""
			+ ""
			+ "</p>"
			+ "</html>";		
		return tooltipSsThresh;
	}

	@Override
	public String getToolTipTimeout() {
		String tooltipTimeout = ""
			+ "<html>"
			+ "<p>"
			+ ""
			+ ""
			+ ""
			+ ""
			+ ""
			+ ""
			+ "</p>"
			+ "</html>";		
		return tooltipTimeout;
	}

	@Override
	public String getToolTipTrippleDuplAck() {
		String tooltipTrippleDuplAck = ""
			+ "<html>"
			+ "<p>"
			+ ""
			+ ""
			+ ""
			+ ""
			+ ""
			+ "</p>"
			+ "</html>";		
		return tooltipTrippleDuplAck;
	}

	@Override
	public String getToolTipSSThreshTCPReno() {
		String tooltipSSThresh = ""
			+ "<html>"
			+ "<p>"
			+ ""
			+ ""
			+ ""
			+ ""
			+ ""
			+ "</p>"
			+ "</html>";		
		return tooltipSSThresh;
	}

	@Override
	public String getToolTipSSThreshTCPTahoe() {
		String tooltipSSThresh = ""
			+ "<html>"
			+ "<p>"
			+ ""
			+ ""
			+ ""
			+ ""
			+ ""
			+ "</p>"
			+ "</html>";		
		return tooltipSSThresh;
	}
}
