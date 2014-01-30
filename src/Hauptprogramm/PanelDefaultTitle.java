/**
 * @author:	Stefan Otto Günther
 * @date:	29.01.2014
 */

package Hauptprogramm;

import Base.BasePanelTitle;

public class PanelDefaultTitle extends BasePanelTitle {

	public PanelDefaultTitle(IDefaultManagement management, PanelDefaultModel model) {
		super(management, model);
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
