/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Fairness;

import Base.ManagementAutomatic;
import Base.ManagementCoordinateSystem;

public interface ManagementFairness extends ManagementAutomatic, ManagementCoordinateSystem {

	public EnumFairnessStatus getFairnessStatus();
	
	public Integer getMaxFlowRate();
	public void setMaxFlowRate(Integer maxFlowRate);
	
	public Integer getConnection1();
	public Integer getConnection2();
	public void setConnections(Integer connection1, Integer connection2);
	
	public Integer getMaxConnnection();
	
	
}
