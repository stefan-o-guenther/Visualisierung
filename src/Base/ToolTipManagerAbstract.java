/**
 * @author:	Stefan Otto Günther
 * @date:	22.02.2014
 */

package Base;

public abstract class ToolTipManagerAbstract implements ToolTipManager {

	public String getToolTipAutomaticCheckbox() {
		String tooltipSpeed = ""
			+ "<html>"
        	+ "Einstellung, ob die Animation automatisch ablaufen soll..<br>"
        	+ "</html>";
		return tooltipSpeed;
	}
	
	public String getToolTipAutomaticSlider() {
		String tooltipSpeed = ""
			+ "<html>"
        	+ "Mit diesem Geschwindigkeitsregeler können Sie einstellen,<br>"
        	+ "wie schnell der Auto-Durchlauf ausgef&uuml;hrt werden soll.<br>"
        	+ "Standardm&auml;&szlig;ig ist die Geschwindigkeit auf 50% eingestellt.<br>"
        	+ "</html>";
		return tooltipSpeed;
	}
}