/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Fairness;

import java.awt.Color;
import java.util.List;

import Base.EnumVisualizationStatus;
import Base.ManagementAutomatic;
import Base.ManagementCoordinateSystem;

public interface ManagementFairness extends ManagementAutomatic, ManagementCoordinateSystem {

	public EnumVisualizationStatus getStatus();
	
	public Integer getMaxFlowRate();
	
	public void setConnections(Integer connection1, Integer connection2);
	public Integer getConnection1();
	public Integer getConnection2();
	public Integer getDifference();
	
	public Integer getMaxConnnection();
	
	public String getModus();
	
	public List<Point> getListPoints();
	
	public Color getColorFairness();
	public Color getColorMaxFlowRate();
}
