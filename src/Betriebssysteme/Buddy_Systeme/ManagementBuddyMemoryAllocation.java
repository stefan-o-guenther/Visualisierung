/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import java.awt.Color;
import java.util.List;

import Base.Management;

public interface ManagementBuddyMemoryAllocation extends Management {

	public void setTotalSpace(Integer value);
	public void print();
	public List<BuddyOperation> getNodeList();
	public void limitOutput(Integer value);	
	public Color getProcessNodeColor(String name);
	public Color getRestColor();
	public Color getUsedColor();
	public Color getBuddyColor();
	public List<String> getListProcessNames();
	public List<Color> getListUsedColors();	
	public Integer getTotalSpace();	
	public Integer getProcessCount();	
	public Integer getProcessSpace();
	public Double getProcessRate();	
	public Integer getFreeSpace();
	public Double getFreeRate();	
	public Integer getRestSpace();
	public Double getRestRate();
	public List<ProcessNode> getListRunningProcesses();
	public EnumProcess getProcessOperation();
	public void setProcessOperation(EnumProcess type);
	public void setProcessName(String name);
	public void setProcessSize(Integer value);
}
