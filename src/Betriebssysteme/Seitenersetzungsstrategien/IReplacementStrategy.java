/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.List;

public interface IReplacementStrategy {
	void execute();	
	Boolean resetRBits();	
	Boolean setMBit();
	EnumPagingStatus getStatus();	
	List<ICacheBox> getListCacheBox();
	EnumPagingStrategy getStrategy();
	Integer getMaxRam();
	Integer getMaxDisk();
	Boolean useRM();
	Integer getErrorCount();
	Integer getMaxRM();
	Boolean canUseRM();
}