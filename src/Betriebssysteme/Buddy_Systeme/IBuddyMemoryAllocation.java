package Betriebssysteme.Buddy_Systeme;

import java.util.List;

import Base.IManagement;

public interface IBuddyMemoryAllocation extends IManagement {

	void startProcess(String name, Integer value);
	void stopProcess(String name);
	void setTotalSpace(Integer value);
	void print();
	void reset();
	EnumBuddyMemoryAllocation getStatus();
	List<IBuddyOperation> getNodeList();
	void limitOutput(Integer value);
	Integer getTotalSpace();
}
