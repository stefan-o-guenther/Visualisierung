/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.util.List;

public class MemoryStrategyFirstFit extends BaseMemoryStrategyFirstNext implements IMemoryStrategyFirstFit {
	
	public MemoryStrategyFirstFit(List<ISpace> example) {
		super(example);
	}

	@Override
	public EnumMemoryStrategy getStrategy() {
		return EnumMemoryStrategy.FIRST_FIT;
	}
	
	protected void inputOK() {		
		start = START;		
		position = start;
		first = true;
	}
	
	protected void finishChoose() {		
		start = START;
		position = start;		
	}

}
