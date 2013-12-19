package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.List;

import Base.IBaseManagement;


public interface IPagingManagement extends IBaseManagement {
	EnumPagingStrategy getStrategy();
	void setStrategy(EnumPagingStrategy value);
	
	List<Integer> getSequence();
	void setSequence(List<Integer> value);
	
	Integer getMaxRam();
	void setMaxRam(Integer value);
	
	Integer getMaxDisk();
	void setMaxDisk(Integer value);
	
	void execute();
	
	void resetRBits();
	
	void setMBit();
	
	EnumPagingStatus getStatus();
	
	List<ICacheBox> getListCache();
	
}
