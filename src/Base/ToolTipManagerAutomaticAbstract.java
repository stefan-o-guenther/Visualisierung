/**
 * @author:	Stefan Otto Günther
 * @date:	22.02.2014
 */

package Base;

public abstract class ToolTipManagerAutomaticAbstract implements ToolTipManagerAutomatic {

	public String getToolTipSpeed() {
		String tooltipSpeed = ""
			+ "<html>"
        	+ "Mit diesem Geschwindigkeitsregeler können Sie einstellen,<br>"
        	+ "wie schnell der Auto-Durchlauf ausgef&uuml;hrt werden soll.<br>"
        	+ "Standardm&auml;&szlig;ig ist die Geschwindigkeit auf 50% eingestellt.<br>"
        	+ "</html>";
		return tooltipSpeed;
	}
}