/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.util.List;

public class MemoryStrategyWorstFitImpl extends MemoryStrategyBestWorstAbstract implements MemoryStrategyWorstFit {
	
	public MemoryStrategyWorstFitImpl(List<Space> example) {
		super(example);
	}

	@Override
	public EnumMemoryStrategy getStrategy() {
		return EnumMemoryStrategy.WORST_FIT;
	}
	
	@Override
	protected Boolean checkSpaceSuitability(Integer number, Integer value) {
		this.checkIfWorst(value);
		return false;
	}
}