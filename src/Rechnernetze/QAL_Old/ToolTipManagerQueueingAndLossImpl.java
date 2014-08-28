/**
 * @author:	Stefan Otto Günther
 * @date:	22.02.2014
 */

package Rechnernetze.QAL_Old;

import Base.ToolTipManagerAbstract;

public class ToolTipManagerQueueingAndLossImpl extends ToolTipManagerAbstract implements ToolTipManagerQueueingAndLoss {
	
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
}
