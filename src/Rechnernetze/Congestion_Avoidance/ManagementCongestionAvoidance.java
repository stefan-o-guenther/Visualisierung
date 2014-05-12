/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Congestion_Avoidance;

import java.util.List;

import Base.ManagementAutomatic;

public interface ManagementCongestionAvoidance extends ManagementAutomatic {

	EnumNetworkType getNetworkType();
	void setNetworkType(EnumNetworkType type);
	
	EnumNetworkStrategy getNetworkStrategy();
	void setNetworkStrategy(EnumNetworkStrategy strategy);
	
	EnumNetworkStatus getNetworkStatus();
	void setNetworkStatus(EnumNetworkStatus status);
	
	Integer getMaxTimeout();
	void setMaxTimeout(Integer max);
	
	Integer getMaxTrippleDuplACK();
	void setMaxTrippleDuplACK(Integer max);
	
	List<Point> getListPoints();
	
	void setSsTresh(Integer value);
	
	Integer getMaxTransmissionRound();
	void setMaxTransmissionRound(Integer tr);
	
	Integer getMaxCwnd();
	void setMaxCwnd(Integer cwnd);
}
