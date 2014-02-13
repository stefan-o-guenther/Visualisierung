/**
 * @author:	Stefan Otto Günther
 * @date:	29.01.2014
 */

package Hauptprogramm;

import Base.BasePanelTitle;

public class PanelDefaultTitle extends BasePanelTitle {

	public PanelDefaultTitle(IDefaultManagement management) {
		super(management);
	}

	@Override
	protected String getToolTip() {
		return "";
	}

	@Override
	protected String getTitle() {
		return "Bachelorarbeit - Visualisierung";
	}

	
}
