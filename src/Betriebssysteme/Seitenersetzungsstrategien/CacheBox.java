/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.List;

public interface CacheBox {
	
	public Integer getNumber();
	public void setNumber(Integer value);
	
	public List<Cache> getRam();
	public void setRam(List<Cache> value);
	
	public List<Cache> getDisk();
	public void setDisk(List<Cache> value);
	
	public List<Cache> getRamCopy();
	public List<Cache> getDiskCopy();
	
	public Boolean isActivated();
	public void setActivated(Boolean value);
	
	public void initializeRMPrevious();
	public void initializeRMDisk();
}
