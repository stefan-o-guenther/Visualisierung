/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.util.List;

public abstract class MemoryStrategyFirstNextAbstract extends MemoryStrategyAbstract {

	public MemoryStrategyFirstNextAbstract(List<Space> example) {
		super(example);
	}

	protected Integer getPos() {
		return position;
	}
	
	protected Boolean isSuitableSpace(Integer number, Integer value) {
		try {
			if ((number == null) || (value == null)) {
				throw new NullPointerException();
			}
			if ((number < 0) || (value < 0)) {
				throw new IllegalArgumentException();
			}
			if (value >= number) {		
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			throw ex;
		}		
	}
		
	protected void finishNotFit() {
		executionOK = false;
		finishFit();
		status = EnumMemoryStatus.FINISHED;	
	}
	
	protected void initStrategy() {
		// nothing
	}
}
