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
	protected Boolean isSpaceSuitable(Integer number, Integer value) {
		try {
			if ((number == null) || (value == null)) {
				throw new NullPointerException();
			}
			if ((number.intValue() < 0) || (value.intValue() < 0)) {
				throw new IllegalArgumentException();
			}
			if (number.intValue() <= value.intValue()) {
				this.checkIfWorst(value);
				if (number.intValue() == value.intValue()) {
					this.checkIfBest(value);
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
			
		} catch (Exception ex) {
			throw ex;
		}
	}
}