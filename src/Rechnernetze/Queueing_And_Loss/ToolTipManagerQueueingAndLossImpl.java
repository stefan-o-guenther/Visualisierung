/**
 * @author:	Stefan Otto Günther
 * @date:	22.02.2014
 */

package Rechnernetze.Queueing_And_Loss;

import Base.ToolTipManagerAbstract;

public class ToolTipManagerQueueingAndLossImpl extends ToolTipManagerAbstract implements ToolTipManagerQueueingAndLoss {
	
	private static ToolTipManagerQueueingAndLoss instance = new ToolTipManagerQueueingAndLossImpl();
	
	private ToolTipManagerQueueingAndLossImpl() {
		
	}
	
	public static ToolTipManagerQueueingAndLoss getInstance() {
		return instance;
	}	
	
	public String getToolTipTitle() {
		String tooltipTitle = ""
	        + "<html>"
	        + "<p>"
	        + "Ein Router hat einen internen endlichen Puffer, in dem Pakete zwischengespeichert werden k&ouml;nnen.<br/>"
	        + "Das Zwischenspeichern ist aus dem Grund wichtig, da der Router die Pakete nicht sofort weiterleiten kann.<br/>"
	        + "Der Router muss erst die Empfangsadresse des Paketes ermitteln, um entscheiden zu k&ouml;nnen, &uuml;ber<br/>"
	        + "welchen Ausgang des Routers das Paket weitergeleitet wird.<br/>"
	        + "Solange die Verarbeitungszeit k&uuml;rzer ist als die Rate der ankommenden Pakete, wird es zu keinem Paketverlust<br/>"
	        + "kommen und es gibt keine Probleme. Wenn aber mehr Pakete am Router ankommen, als dieser verarbeiten kann<br/>"
	        + "und der Puffer maximal ausgelastet ist, werden neu ankommende Pakete abgewiesen und das Paket geht verloren.<br/>"
	        + "Erst, wenn ein oder mehrere Pl&auml;tze im Puffer des Router frei geworden sind, k&ouml;nnen neue Pakete<br/>"
	        + "aufgenommen und verarbeitet werden. Anderenfalls gehen alle neu ankommenden Pakete verloren.<br/>"
	        + "</p>"
	        + "</html>";
		return tooltipTitle;
	}	
	
	@Override
	public String getToolTipTransferRate() {
		String tooltipTransferRate = ""
		        + "<html>"
		        + "<p>"
		        + "Mit diesen Geschwindigkeitsregelern können Sie einstellen,<br/>"
		        + "mit welcher Geschwindigkeit sich die Pakete bewegen sollen.<br/>"
		        + "</p>"
		        + "</html>";
			return tooltipTransferRate;
	}

	@Override
	public String getToolTipProcessing() {
		String tooltipProcessing = ""
				+ "<html>"
		        + "<p>"
		        + "Mit diesen Geschwindigkeitsregelern können Sie einstellen,<br/>"
		        + "wie lange ein einzelnes Paket im Speicher bleiben soll.<br/>"
		        + "</p>"
		        + "</html>";
			return tooltipProcessing;
	}

	@Override
	public String getToolTipInterval() {
		String tooltipInterval = ""
				+ "<html>"
		        + "<p>"
		        + "Mit diesen Geschwindigkeitsregelern können Sie einstellen,<br/>"
		        + "in welchen Abständen die Pakete ankommen sollen.<br/>"
		        + "</p>"
		        + "</html>";
			return tooltipInterval;
	}
}
