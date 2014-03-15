/**
 * @author:	Stefan Otto Günther
 * @date:	29.01.2014
 */

package Rechnernetze.Congestion_Avoidance;

import Base.BasePanelTitle;

public class PanelRNCongestionAvoidanceTitle extends BasePanelTitle {

	public PanelRNCongestionAvoidanceTitle(INetworkManagement network) {
		super(network);
	}

	@Override
	protected String getToolTip() {
		return ToolTipManager.getToolTipTitle();
	}

	@Override
	protected String getTitle() {
		return "Congestion Avoidance";
	}
}