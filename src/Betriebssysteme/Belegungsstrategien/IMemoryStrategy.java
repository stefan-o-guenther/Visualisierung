/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.util.List;

public interface IMemoryStrategy {

	EnumMemoryStrategy getStrategy();
	EnumMemoryStatus getStatus();
	List<ISpace> getListSpace();
	void setNumber(Integer value);
	Integer getNumber();
	void init();
	public Boolean execute();
}
