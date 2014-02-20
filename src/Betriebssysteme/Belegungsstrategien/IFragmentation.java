/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.awt.Color;
import java.util.List;

import Base.IManagement;

public interface IFragmentation extends IManagement {

	EnumMemoryStrategy getStrategy();
	void setStrategy(EnumMemoryStrategy value);	
	Integer getNumber();
	void setNumber(Integer value);	
	EnumMemoryStatus getStatus();	
	Boolean execute();	
	void reset();	
	List<ISpace> getListSpace();
	Color getColor(EnumSpace type);
	Integer getTotalSpace();
	Integer getFreeSpace();
	Integer getUsedSpace();
	Double getUsedRate();
	Boolean isAutomaticChecked();
	void setAutomaticChecked(Boolean value);
	Boolean isAutomaticRunning();
	void setAutomaticRunning(Boolean value);
	Integer getSpeed();
	void setSpeed(Integer value);
}
