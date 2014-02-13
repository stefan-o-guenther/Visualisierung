/**
 * @author:	Stefan Otto G�nther
 * @date:	29.01.2014
 */

package Betriebssysteme.Verklemmungen;

import Base.BasePanelTitle;

public class PanelBSVerklemmungenTitle extends BasePanelTitle {

	public PanelBSVerklemmungenTitle(IDeadlockManagement deadlock) {
		super(deadlock);
	}

	@Override
	protected String getToolTip() {
		String tooltip = ""
			+ "<html>"
        	+ "Mit diesem Geschwindigkeitsregeler k�nnen Sie einstellen,<br>"
        	+ "wie schnell der Auto-Durchlauf ausgef�hrt werden soll.<br>"
        	+ "Standardm��ig ist die Geschwindigkeit auf 50% eingestellt.<br>"
        	+ "</html>";
		return tooltip;
	}

	@Override
	protected String getTitle() {
		return "Verklemmungen";
	}

	
}
