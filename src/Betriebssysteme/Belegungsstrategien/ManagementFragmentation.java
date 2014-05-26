/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.awt.Color;
import java.util.List;

import Base.ManagementAutomatic;


public interface ManagementFragmentation extends ManagementAutomatic {

	public EnumMemoryStrategy getStrategy();
	public void setStrategy(EnumMemoryStrategy value);
	public void inputNumber(Integer value);	
	public EnumMemoryStatus getStatus();	
	public List<Space> getListSpace();
	public Integer getTotalSpace();
	public Integer getFreeSpace();
	public Integer getUsedSpace();
	public Double getUsedRate();	
}
