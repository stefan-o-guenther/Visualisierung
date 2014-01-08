package Betriebssysteme.Belegungsstrategien;

import java.util.List;

public interface IMemoryStrategy {

	EnumMemoryStrategy getStrategy();
	EnumMemoryStatus getStatus();
	List<ISpace> getListSpace();
	void setNumber(Integer value);
	Integer getNumber();
	void init();
	public Boolean execute();
}
