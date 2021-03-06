/**
 * @author:	Stefan Otto Günther
 * @date:	22.02.2014
 */

package Rechnernetze.Pipeline_Protocol;

import Base.ToolTipManagerSpeedPacketAbstract;

public class ToolTipManagerARQImpl extends ToolTipManagerSpeedPacketAbstract implements ToolTipManagerARQ {
	
	private static ToolTipManagerARQ instance = new ToolTipManagerARQImpl();
	
	private ToolTipManagerARQImpl() {
		
	}
	
	public static ToolTipManagerARQ getInstance() {
		return instance;
	}	
	
	public String getToolTipTitle() {
		String tooltipTitle = ""
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
		return tooltipTitle;
	}

	@Override
	public String getToolTipTimeout() {
		String tooltipTransferRate = ""
	        + "<html>"
	        + "<p>"
	        + "Mit diesen Regelern können Sie einstellen,<br/>"
	        + "nach welcher Zeit die Pakete erneut gesendet werden sollen.<br/>"
	        + "</p>"
	        + "</html>";
		return tooltipTransferRate;
	}
}
