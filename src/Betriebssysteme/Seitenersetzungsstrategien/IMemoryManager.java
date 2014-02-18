/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.awt.Color;
import java.util.List;

import Base.EnumSurface;
import Base.IManagement;


public interface IMemoryManager extends IManagement {
	EnumPagingStrategy getStrategy();	
	void setStrategy(EnumPagingStrategy enumStrategy, List<Integer> listSequence, Integer ram, Integer disk);		
	Integer getMaxRam();	
	Integer getMaxDisk();		
	void execute();	
	void reset();	
	void resetRBits();	
	void setMBit();	
	EnumPagingStatus getStatus();	
	List<ICacheBox> getListCache();	
	Boolean useRM();	
	Integer getErrorCount();	
	Color getColor();
}
