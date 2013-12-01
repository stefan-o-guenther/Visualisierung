package Betriebssysteme.Belegungsstrategien;

import java.util.List;

public interface IMemoryManagement {
	
	EnumStrategy getStrategy();
	void setStrategy(EnumStrategy value);
	
	Integer getNumber();
	void setNumber(Integer value);
	
	EnumStatus getStatus();
	
	void execute();	
	
	void reset();
	
	List<ISpace> getListSpace();
	
	Boolean isAuto();
	void setAuto(Boolean value);
}
