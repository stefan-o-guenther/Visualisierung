/**
 * @author:	Stefan Otto Günther
 * @date:	29.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import Base.BasePanelTitle;

public class PanelBSBelegungsstrategienTitle extends BasePanelTitle {

	public PanelBSBelegungsstrategienTitle(IFragmentation memory) {
		super(memory);
	}
	
	@Override
	public String getToolTip() {
		return ToolTipManager.getToolTipTitle();
	}

	@Override
	public String getTitle() {
		return "Belegungsstrategien";
	}
}
