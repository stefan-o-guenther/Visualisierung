/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.util.List;

import Base.Management;

public interface ManagementFragmentation extends Management {

	public EnumMemoryStrategy getStrategy();
	public void inputNumber(Integer value);	
	public List<Space> getListSpace();
	public Integer getTotalSpace();
	public Integer getFreeSpace();
	public Integer getUsedSpace();
	public Double getUsedRate();
	public void assume(EnumMemoryStrategy strategy, List<Integer> list);
}
