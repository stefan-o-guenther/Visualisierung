/**
 * @author:	Stefan Otto G�nther
 * @date:	29.01.2014
 */

package Rechnernetze.Queueing_And_Loss;

import Base.BasePanelTitle;

public class PanelRNQueueingAndLossTitle extends BasePanelTitle {

	public PanelRNQueueingAndLossTitle(IQALManagement vManagement, PanelRNQueueingAndLossModel model) {
		super(vManagement, model);
	}

	@Override
	protected String getToolTip() {
		String tooltipRNQueueingAndLoss = ""
	        + "<html>"
	        + "<p>"
	        + "Ein Router hat einen internen endlichen Puffer, in dem Pakete zwischengespeichert werden k�nnen.<br/>"
	        + "Das Zwischenspeichern ist aus dem Grund wichtig, da der Router die Pakete nicht sofort weiterleiten kann.<br/>"
	        + "Der Router muss erst die Empfangsadresse des Paketes ermitteln, um entscheiden zu k�nnen, �ber<br/>"
	        + "welchen Ausgang des Routers das Paket weitergeleitet wird.<br/>"
	        + "Solange die Verarbeitungszeit k�rzer ist als die Rate der ankommenden Pakete, wird es zu keinem Paketverlust<br/>"
	        + "kommen und es gibt keine Probleme. Wenn aber mehr Pakete am Router ankommen, als dieser verarbeiten kann<br/>"
	        + "und der Puffer maximal ausgelastet ist, werden neu ankommende Pakete abgewiesen und das Paket geht verloren.<br/>"
	        + "Erst, wenn ein oder mehrere Pl�tze im Puffer des Router frei geworden sind, k�nnen neue Pakete<br/>"
	        + "aufgenommen und verarbeitet werden. Anderenfalls gehen alle neu ankommenden Pakete verloren.<br/>"
	        + "</p>"
	        + "</html>";
		return tooltipRNQueueingAndLoss;
	}

	@Override
	protected String getTitle() {
		return "Queueing And Loss";
	}
}
