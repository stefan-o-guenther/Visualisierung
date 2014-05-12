/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.util.List;

public interface MemoryStrategy {

	public EnumMemoryStrategy getStrategy();
	public EnumMemoryStatus getStatus();
	public List<Space> getListSpace();
	public void setNumber(Integer value);
	public Integer getNumber();
	public void init();
	public Boolean execute();
}
