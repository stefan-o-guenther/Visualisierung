/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.awt.Color;
import java.util.List;

import Base.IManagementAutomatic;


public interface IFragmentation extends IManagementAutomatic {

	public EnumMemoryStrategy getStrategy();
	public void setStrategy(EnumMemoryStrategy value);	
	public Integer getNumber();
	public void setNumber(Integer value);	
	public EnumMemoryStatus getStatus();	
	public List<ISpace> getListSpace();
	public Color getColor(EnumSpace type);
	public Integer getTotalSpace();
	public Integer getFreeSpace();
	public Integer getUsedSpace();
	public Double getUsedRate();	
}
