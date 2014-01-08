package Betriebssysteme.Seitenersetzungsstrategien;

public interface ICache {

	Integer getNumber();	
	
	Integer getR();
	void setR(Integer value);
	
	Integer getM();
	void setM(Integer value);
	
	ICache getCopy();
	
	EnumCache getStatus();
	void setStatus(EnumCache value);
	
	
}
