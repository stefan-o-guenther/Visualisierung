package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.List;

public interface ICacheBox {
	
	Integer getNumber();
	void setNumber(Integer value);
	
	List<ICache> getRam();
	void setRam(List<ICache> value);
	
	List<ICache> getDisk();
	void setDisk(List<ICache> value);
	
	List<ICache> getRamCopy();
	List<ICache> getDiskCopy();
	
	Boolean isActivate();
	void activate(Boolean value);
}
