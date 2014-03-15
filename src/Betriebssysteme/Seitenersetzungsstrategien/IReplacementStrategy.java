/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.List;

public interface IReplacementStrategy {
	public void execute();	
	public Boolean resetRBits();	
	public Boolean setMBit();
	public EnumPagingStatus getStatus();	
	public List<ICacheBox> getListCacheBox();
	public EnumPagingStrategy getStrategy();
	public Integer getMaxRam();
	public Integer getMaxDisk();
	public Boolean useRM();
	public Integer getErrorCount();
	public Integer getMaxRM();
	public Boolean canUseRM();
}