/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.util.List;

public class MemoryStrategyFirstFitImpl extends MemoryStrategyFirstNextAbstract implements MemoryStrategyFirstFit {
	
	public MemoryStrategyFirstFitImpl(List<Space> example) {
		super(example);
	}

	@Override
	public EnumMemoryStrategy getStrategy() {
		return EnumMemoryStrategy.FIRST_FIT;
	}
	
	protected void inputOK() {		
		start = START;		
		position = start;
		isFirst = true;
	}
	
	protected void finishChoose() {		
		start = START;
		position = start;		
	}
}