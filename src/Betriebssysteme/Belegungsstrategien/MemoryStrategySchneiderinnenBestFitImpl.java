/**
 * @author:	Stefan Otto Günther
 * @date:	04.06.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.util.List;

public class MemoryStrategySchneiderinnenBestFitImpl extends MemoryStrategyBestWorstAbstract implements MemoryStrategySchneiderinnenBestFit{

	public MemoryStrategySchneiderinnenBestFitImpl(List<Space> example) {
		super(example);
	}

	@Override
	public EnumMemoryStrategy getStrategy() {
		return EnumMemoryStrategy.SCHNEIDERINNEN_BEST_FIT;
	}	

	@Override
	protected Boolean checkSpaceSuitability(Integer number, Integer value) {
		this.checkIfWorst(value);
		if (this.isSuitableSpace(number, value)) {
			this.checkIfBest(value);
			return true;
		} else {
			return false;
		}
	}
}