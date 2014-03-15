/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.List;

public interface ICacheBox {
	
	public Integer getNumber();
	public void setNumber(Integer value);
	
	public List<ICache> getRam();
	public void setRam(List<ICache> value);
	
	public List<ICache> getDisk();
	public void setDisk(List<ICache> value);
	
	public List<ICache> getRamCopy();
	public List<ICache> getDiskCopy();
	
	public Boolean isActivate();
	public void activate(Boolean value);
	
	public void initializeRMPrevious();
	public void initializeRMDisk();
}
