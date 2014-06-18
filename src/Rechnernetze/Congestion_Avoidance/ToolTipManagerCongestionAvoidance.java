/**
 * @author:	Stefan Otto Günther
 * @date:	12.05.2014
 */

package Rechnernetze.Congestion_Avoidance;

import Base.ToolTipManagerAutomatic;

public interface ToolTipManagerCongestionAvoidance extends ToolTipManagerAutomatic {

	public String getToolTipTcpTahoe();
	public String getToolTipTcpReno();
	public String getToolTipSsThresh();
	public String getToolTipTimeout();
	public String getToolTipTrippleDuplAck();
}
