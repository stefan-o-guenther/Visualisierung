/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.util.List;

import Base.Checker;

public class MemoryStrategyBestFitImpl extends MemoryStrategyBestWorstAbstract implements MemoryStrategyBestFit {

	public MemoryStrategyBestFitImpl(List<Space> example) {
		super(example);
	}
	
	@Override
	public EnumMemoryStrategy getStrategy() {
		return EnumMemoryStrategy.BEST_FIT;
	}
	
	@Override
	protected Boolean isSpaceSuitable(Integer number, Integer value) {
		try {
			Checker.checkIfIntegerNotLessZero(number);
			Checker.checkIfIntegerNotLessZero(value);
			if (number.intValue() <= value.intValue()) {
				this.checkIfBest(value);
				if (number.intValue() == value.intValue()) {
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