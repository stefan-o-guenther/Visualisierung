/**
 * @author:	Stefan Otto Günther
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
        	+ "Mit diesem Geschwindigkeitsregeler können Sie einstellen,<br>"
        	+ "wie schnell der Auto-Durchlauf ausgeführt werden soll.<br>"
        	+ "Standardmäßig ist die Geschwindigkeit auf 50% eingestellt.<br>"
        	+ "</html>";
		return tooltip;
	}

	@Override
	protected String getTitle() {
		return "Verklemmungen";
	}

	
}
