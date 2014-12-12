/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.util.List;

import Base.Checker;

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
			Checker.checkIfIntegerNotLessZero(number);
			Checker.checkIfIntegerNotLessZero(value);
			if (number.intValue() <= value.intValue()) {
				this.checkIfWorst(value);
			}
			return false;
		} catch (Exception ex) {
			throw ex;
		}
	}
}