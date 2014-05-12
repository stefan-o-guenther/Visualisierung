/**
 * @author:	Stefan Otto G�nther
 * @date:	22.02.2014
 */

package Rechnernetze.Pipeline_Protocol;

public class ToolTipManagerPipelineProtocolImpl implements ToolTipManagerPipelineProtocol {
	
	public String getToolTipTitle() {
		String tooltipTitle = ""
			+ "<html>"
	        + "<p>"
	        + "ARQ-Protokolle (Automatic Repeat reQuest, dt. Automatische Wiederholungsanfrage) werden bei<br/>"
	        + "Computernetzen eingesetzt, um eine zuverl�ssige Daten�bertragung durch Sendewiederholungen zu gew�hrleisten.<br/>"
	        + "</p>"
	        + "<p>"
	        + "Durch die M�glichkeit der Fehlererkennung kann ein Empf�nger aufgetretene �bertragungsfehler feststellen.<br/>"
	        + "�ber einen R�ckkanal kann dieser dem Sender der Nachricht das Resultat der Fehlererkennung mitteilen.<br/>"
	        + "Gew�hnlicherweise geschieht dies durch �bertragung so genannter <strong>ACK/NAK</strong> Signale<br/>"
	        + "(Acknowledgement bzw. Negative Acknwoledgement, d. h. korrekter Empfang best�tigt bzw. Wiederholungsanfrage).<br/>"
	        + "Gegebenenfalls wird eine gest�rte Nachricht solange erneut �bertragen, bis sie den Empf�nger ohne Fehler erreicht hat.<br/>"
	        + "</p>"
	        + "<p>"
	        + "In den folgenden Animationen werden die folgenden Protokolle betrachtet:<br/>"
	        + "</p>"
	        + "<ul>"
	        + "<li>Go-Back-N</li>"
	        + "<li>Selective-Repeat</li>"
	        + "</ul>"
	        + "</html>";
		return tooltipTitle;
	}
}
