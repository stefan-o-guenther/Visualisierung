/**
 * @author:	Stefan Otto Günther
 * @date:	12.05.2014
 */

package Rechnernetze.Congestion_Avoidance;

import Base.ToolTipManager;

public interface ToolTipManagerCongestionAvoidance extends ToolTipManager {

	public String getToolTipTcpTahoe();
	public String getToolTipTcpReno();
	public String getToolTipSsTresh();
	public String getToolTipTimeout();
	public String getToolTipTrippleDuplAck();
}
