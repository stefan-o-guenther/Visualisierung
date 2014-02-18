/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.awt.Color;

import Base.EnumSurface;

public interface ICache {

	Integer getNumber();	
	
	Integer getR();
	void setR(Integer r);
	
	Integer getM();	
	void setM(Integer m);
	
	ICache getCopy();	
		
	Boolean isRChanged();
	void setRChanged(Boolean value);
	
	Boolean isMChanged();	
	void setMChanged(Boolean value);
	
	Integer getRPrevious();
	void setPreviousR(Integer r);
	
	Integer getMPreviousM();
	void setPreviousM(Integer m);
	
	EnumCache getStatus();
	void setStatus(EnumCache value);
}
