/**
 * @author:	Stefan Otto G�nther
 * @date:	22.02.2014
 */

package Rechnernetze.TCP_Retransmission;

import Base.ToolTipManagerAbstract;

public class ToolTipManagerRetransmissionImpl extends ToolTipManagerAbstract implements ToolTipManagerRetransmission {
	
	public String getToolTipTitle() {
		String tooltipTitle = ""
			+ "<html>"
	        + "<p>"
	        + "Wenn Sender A dem Empf�nger B ein TCP-Paket sendet, wartet der Sender A auf ein ACK von der Gegenseite,<br/>"
	        + "das best�tigt, dass das Paket fehlerfrei angekommen ist. Um festzustellen, ob und wann ein Paket w�hrend<br/>"
	        + "der �bertragung verloren gegangen ist, verwendet der Sender einen Timeout. Dabei k�nnen verschiedene<br/>"
	        + "Szenarien auftreten. Wenn z. B. der Timeout zu niedrig eingestellt ist, bewirkt dies, dass Pakete,<br/>"
	        + "die eigentlich korrekt beim Empf�nger angekommen sind, wiederholt werden. Bei einem zu hohen Timeout<br/>"
	        + "bewirkt dies, dass ein verloren gegangenes Paket unn�tig sp�t wiederholt gesendet wird.<br/>"
	        + "</p>"
	        + "<p>"
	        + "In der folgenden Animation werden diese drei verschiedene Szenarien behandelt und veranschaulicht:<br/>"
	        + "</p>"
	        + "<ul>"
	        + "<li>Lost ACK (Verlorenes Paket)</li>"
	        + "<li>Premature Timeout (Fr�hzeitiges Timeout-Ende)</li>"
	        + "<li>Cumulative ACK (Kumulative bzw. Gesamte Best�tigung)</li>"
	        + "</ul>"
	        + "</html>";
		return tooltipTitle;
	}
}
