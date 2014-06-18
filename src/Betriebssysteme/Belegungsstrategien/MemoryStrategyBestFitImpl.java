/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.util.List;

public class MemoryStrategyBestFitImpl extends MemoryStrategyBestWorstAbstract implements MemoryStrategyBestFit {

	public MemoryStrategyBestFitImpl(List<Space> example) {
		super(example);
	}
	
	@Override
	public EnumMemoryStrategy getStrategy() {
		return EnumMemoryStrategy.BEST_FIT;
	}
	
	@Override
	protected Boolean checkSpaceSuitability(Integer number, Integer value) {
		this.checkIfBest(value);
		return this.isSuitableSpace(number, value);
	}
}