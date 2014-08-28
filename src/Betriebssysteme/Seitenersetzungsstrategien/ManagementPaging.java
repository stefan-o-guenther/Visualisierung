/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.awt.Color;
import java.util.List;

import Base.Management;


public interface ManagementPaging extends Management {
	public EnumPagingStrategy getStrategy();	
	public void setStrategy(EnumPagingStrategy enumStrategy, List<Integer> listSequence, Integer ram, Integer disk);		
	public Integer getMaxRam();	
	public Integer getMaxDisk();		
	public Boolean resetRBits();	
	public Boolean setMBit();	
	public List<CacheBox> getListCache();	
	public Boolean isRmVisible();	
	public Integer getErrorCount();	
	public Color getColor();
	public Boolean isViewOldStatesEnabled();
	public void setViewOldStatesEnabled(Boolean value);
	public Boolean isRmEnabled();
}
