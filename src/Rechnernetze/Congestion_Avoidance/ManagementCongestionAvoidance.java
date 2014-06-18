/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Congestion_Avoidance;

import java.awt.Color;
import java.util.List;

import Base.EnumVisualizationStatus;
import Base.ManagementAutomatic;
import Base.ManagementCoordinateSystem;

public interface ManagementCongestionAvoidance extends ManagementAutomatic, ManagementCoordinateSystem {

	public Boolean isTcpReno();
	public void setTcpReno(Boolean reno);
	
	public Boolean isTcpTahoe();
	public void setTcpTahoe(Boolean tahoe);
	
	public EnumNetworkStrategy getNetworkStrategy();
	public void setNetworkStrategy(EnumNetworkStrategy strategy);
	
	public EnumVisualizationStatus getStatus();
	
	public Integer getTimeout();
	public void setTimeout(Integer max);
	
	public Integer getTrippleDuplACK();
	public void setTrippleDuplACK(Integer max);
	
	public List<Point> getListPoints();
	
	public void setSsTresh(Integer value);
		
	public Integer getCurrentTransmissionRound();
	public Integer getMaxTransmissionRound();		
	public Integer getMaxCwnd();		
	
	public Color getColorTcpTahoe();
	public Color getColorTcpReno();
	public Color getColorSsTreshTcpTahoe();
	public Color getColorSsTreshTcpReno();
}
