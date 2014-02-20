/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.List;


public interface ICache {

	Integer getNumber();	
	
	Integer getR();
	void setR(Integer r);
	
	Integer getM();	
	void setM(Integer m);
	
	ICache getCopy();	
		
	List<Integer> getRPrevious();
	void setRPrevious(List<Integer> r);
	void addRPrevious(Integer r);
	Integer getRPreviousSize();
	void initializeRPrevious();
	
	List<Integer> getMPrevious();
	void setMPrevious(List<Integer> m);
	void addMPrevious(Integer m);
	Integer getMPreviousSize();
	void initializeMPrevious();
	
	EnumCache getStatus();
	void setStatus(EnumCache value);	
}
