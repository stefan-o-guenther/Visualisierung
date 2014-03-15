/**
 * @author:	Stefan Otto Günther
 * @date:	29.01.2014
 */

package Rechnernetze.TCP_Fairness;

import Base.BasePanelTitle;

public class PanelRNTCPFairnessTitle extends BasePanelTitle {

	public PanelRNTCPFairnessTitle(IFairnessManagement fairness) {
		super(fairness);
	}

	@Override
	protected String getToolTip() {
		return ToolTipManager.getToolTipTitle();
	}

	@Override
	protected String getTitle() {
		return "TCP-Fairness";
	}
}
