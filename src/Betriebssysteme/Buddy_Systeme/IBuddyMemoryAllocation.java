/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import java.awt.Color;
import java.util.List;

import Base.IManagement;

public interface IBuddyMemoryAllocation extends IManagement {

	void startProcess(String name, Integer value);
	void stopProcess(String name);
	void setTotalSpace(Integer value);
	void print();
	EnumBuddyMemoryAllocation getStatus();
	List<IBuddyOperation> getNodeList();
	void limitOutput(Integer value);	
	Color getProcessNodeColor(String name);
	Color getRestColor();
	Color getUsedColor();
	Color getBuddyColor();
	List<String> getListProcessNames();
	List<Color> getListUsedColors();	
	Integer getTotalSpace();	
	Integer getProcessCount();	
	Integer getProcessSpace();
	Double getProcessRate();	
	Integer getFreeSpace();
	Double getFreeRate();	
	Integer getRestSpace();
	Double getRestRate();
	List<IProcessNode> getListRunningProcesses();
}
