/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.util.List;

public class MemoryStrategyNextFitImpl extends MemoryStrategyFirstNextAbstract implements MemoryStrategyNextFit {
	
	public MemoryStrategyNextFitImpl(List<Space> example) {
		super(example);
	}

	@Override
	public EnumMemoryStrategy getStrategy() {
		return EnumMemoryStrategy.NEXT_FIT;
	}
	
	protected void inputOK() {
		position = start;
		first = true;
	}
	
	protected void finishChoose() {		
		start = position;		
	}

}
