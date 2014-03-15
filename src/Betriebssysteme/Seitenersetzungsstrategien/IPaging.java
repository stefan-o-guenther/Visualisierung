/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.awt.Color;
import java.util.List;

import Base.IManagement;


public interface IPaging extends IManagement {
	public EnumPagingStrategy getStrategy();	
	public void setStrategy(EnumPagingStrategy enumStrategy, List<Integer> listSequence, Integer ram, Integer disk);		
	public Integer getMaxRam();	
	public Integer getMaxDisk();		
	public Boolean resetRBits();	
	public Boolean setMBit();	
	public EnumPagingStatus getStatus();	
	public List<ICacheBox> getListCache();	
	public Boolean useRM();	
	public Integer getErrorCount();	
	public Color getColor();
	public Boolean canViewOldStates();
	public void setViewOldStates(Boolean value);
	public Boolean canUseRM();
}
