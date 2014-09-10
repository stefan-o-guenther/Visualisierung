/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Queueing_And_Loss;

import Base.ToolTipManager;

public interface ToolTipManagerQueueingAndLoss extends ToolTipManager {

	public String getToolTipTransferRate();
	public String getToolTipProcessing();
	public String getToolTipInterval();
}
