package Betriebssysteme.Belegungsstrategien;

import java.util.List;

import Base.IManagement;

public interface IMemoryManagement extends IManagement {
	
	EnumMemoryStrategy getStrategy();
	void setStrategy(EnumMemoryStrategy value);
	
	Integer getNumber();
	void setNumber(Integer value);
	
	EnumMemoryStatus getStatus();
	
	Boolean execute();
	
	void reset();
	
	List<ISpace> getListSpace();
}
