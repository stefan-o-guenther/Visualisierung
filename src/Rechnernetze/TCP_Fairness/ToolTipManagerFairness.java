/**
 * @author:	Stefan Otto Günther
 * @date:	12.05.2014
 */

package Rechnernetze.TCP_Fairness;

import Base.ToolTipManager;

public interface ToolTipManagerFairness extends ToolTipManager {

	public String getToolTipConnection1();
	public String getToolTipConnection2();
	public String getToolTipCwnd1();
	public String getToolTipCwnd2();
	public String getToolTipDifference();
	public String getToolTipModus();
	public String getToolTipMaxFlowRate();
}
