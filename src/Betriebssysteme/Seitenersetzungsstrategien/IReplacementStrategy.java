/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.List;

public interface IReplacementStrategy {
	void execute();	
	void resetRBits();	
	void setMBit();
	EnumPagingStatus getStatus();	
	List<ICacheBox> getListCache();
	EnumPagingStrategy getStrategy();
	Integer getMaxRam();
	Integer getMaxDisk();
	Boolean useRM();
	Integer getErrorCount();
}
