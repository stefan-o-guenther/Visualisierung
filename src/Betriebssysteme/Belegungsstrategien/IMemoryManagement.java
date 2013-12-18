package Betriebssysteme.Belegungsstrategien;

import java.util.List;

public interface IMemoryManagement {
	
	EnumMemoryStrategy getStrategy();
	void setStrategy(EnumMemoryStrategy value);
	
	Integer getNumber();
	void setNumber(Integer value);
	
	EnumMemoryStatus getStatus();
	
	Boolean execute();	
	
	void reset();
	
	List<ISpace> getListSpace();
}
