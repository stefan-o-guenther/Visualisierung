/**
 * @author:	Stefan Otto Günther
 * @date:	29.01.2014
 */

package Rechnernetze.TCP_Retransmission;

import Base.BasePanelTitle;

public class PanelRNTCPRetransmissionTitle extends BasePanelTitle {

	public PanelRNTCPRetransmissionTitle(IRetransmissionManagement retransmission) {
		super(retransmission);
	}

	@Override
	public String getToolTip() {
		return ToolTipManager.getToolTipTitle();
	}

	@Override
	public String getTitle() {
		return "TCP-Retransmission";
	}
}
