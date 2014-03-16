/**
 * @author:	Stefan Otto Günther
 * @date:	29.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import Base.BasePanelTitle;

public class PanelBSSeitenersetzungsstrategienTitle extends BasePanelTitle {

	public PanelBSSeitenersetzungsstrategienTitle(IPaging paging) {
		super(paging);
	}

	@Override
	public String getToolTip() {
		return ToolTipManager.getToolTipTitle();
	}

	@Override
	public String getTitle() {
		return "Seitenersetzungsstrategien";
	}

}
