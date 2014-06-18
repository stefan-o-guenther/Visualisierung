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
	
	protected Boolean checkSpaceSuitability(Integer number, Integer value) {
		return true;
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
