/**
 * @author:	Stefan Otto Günther
 * @date:	29.01.2014
 */

package Rechnernetze.Queueing_And_Loss;

import Base.BasePanelTitle;

public class PanelRNQueueingAndLossTitle extends BasePanelTitle {

	public PanelRNQueueingAndLossTitle(IQALManagement vManagement) {
		super(vManagement);
	}

	@Override
	public String getToolTip() {
		return ToolTipManager.getToolTipTitle();
	}

	@Override
	public String getTitle() {
		return "Queueing And Loss";
	}
}
