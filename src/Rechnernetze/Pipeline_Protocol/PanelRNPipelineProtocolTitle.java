/**
 * @author:	Stefan Otto Günther
 * @date:	29.01.2014
 */

package Rechnernetze.Pipeline_Protocol;

import Base.BasePanelTitle;

public class PanelRNPipelineProtocolTitle extends BasePanelTitle {

	public PanelRNPipelineProtocolTitle(IPipelineManagement pipeline, PanelRNPipelineProtocolModel model) {
		super(pipeline, model);
	}

	@Override
	protected String getToolTip() {
		String tooltipRNPipelineProtocol = ""
	        + "<html>"
	        + "<p>"
	        + "ARQ-Protokolle (Automatic Repeat reQuest, dt. Automatische Wiederholungsanfrage) werden bei<br/>"
	        + "Computernetzen eingesetzt, um eine zuverlässige Datenübertragung durch Sendewiederholungen zu gewährleisten.<br/>"
	        + "</p>"
	        + "<p>"
	        + "Durch die Möglichkeit der Fehlererkennung kann ein Empfänger aufgetretene Übertragungsfehler feststellen.<br/>"
	        + "Über einen Rückkanal kann dieser dem Sender der Nachricht das Resultat der Fehlererkennung mitteilen.<br/>"
	        + "Gewöhnlicherweise geschieht dies durch Übertragung so genannter <strong>ACK/NAK</strong> Signale<br/>"
	        + "(Acknowledgement bzw. Negative Acknwoledgement, d. h. korrekter Empfang bestätigt bzw. Wiederholungsanfrage).<br/>"
	        + "Gegebenenfalls wird eine gestörte Nachricht solange erneut übertragen, bis sie den Empfänger ohne Fehler erreicht hat.<br/>"
	        + "</p>"
	        + "<p>"
	        + "In den folgenden Animationen werden die folgenden Protokolle betrachtet:<br/>"
	        + "</p>"
	        + "<ul>"
	        + "<li>Go-Back-N</li>"
	        + "<li>Selective-Repeat</li>"
	        + "</ul>"
	        + "</html>";
		return tooltipRNPipelineProtocol;
	}

	@Override
	protected String getTitle() {
		return "Pipeline Protocol";
	}
}