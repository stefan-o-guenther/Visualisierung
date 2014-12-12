package Base;

public abstract class ToolTipManagerSpeedPacketAbstract extends	ToolTipManagerAbstract implements ToolTipManagerSpeedPacket {

	@Override
	public String getToolTipSpeedPacket() {
		String tooltipTransferRate = ""
	        + "<html>"
	        + "<p>"
	        + "Mit diesen Geschwindigkeitsregelern können Sie einstellen,<br/>"
	        + "mit welcher Geschwindigkeit sich die Pakete bewegen sollen.<br/>"
	        + "</p>"
	        + "</html>";
		return tooltipTransferRate;
	}
}
