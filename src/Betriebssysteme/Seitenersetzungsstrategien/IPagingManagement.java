package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.List;

import Base.IManagement;


public interface IPagingManagement extends IManagement {
	EnumPagingStrategy getStrategy();
	void setStrategy(EnumPagingStrategy value);
	
	void setSequence(List<Integer> value);
	
	void loadExample();
	
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
