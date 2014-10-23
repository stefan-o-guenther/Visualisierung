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
			}
			return false;
		} catch (Exception ex) {
			throw ex;
		}
	}
}