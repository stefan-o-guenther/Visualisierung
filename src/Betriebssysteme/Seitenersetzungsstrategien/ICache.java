/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

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
