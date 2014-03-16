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
	public String getToolTip() {
		return "";
	}

	@Override
	public String getTitle() {
		return "Bachelorarbeit - Visualisierung";
	}

	
}
