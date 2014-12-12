/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.util.List;

import Base.Checker;

public class MemoryStrategyFactory {

	public static MemoryStrategy getStrategy(EnumMemoryStrategy enumStrategy, List<Space> listExample) {
		try {
			Checker.checkIfNotNull(enumStrategy);
			Checker.checkIfNotNull(listExample);
			MemoryStrategy strategy = null;
			switch (enumStrategy) {
				case FIRST_FIT: {
					strategy = new MemoryStrategyFirstFitImpl(listExample);
					break;
				}
				case NEXT_FIT: {
					strategy = new MemoryStrategyNextFitImpl(listExample);
					break;
				}
				case BEST_FIT: {
					strategy = new MemoryStrategyBestFitImpl(listExample);
					break;
				}
				case WORST_FIT: {
					strategy = new MemoryStrategyWorstFitImpl(listExample);
					break;
				}
				case SCHNEIDERINNEN_BEST_FIT: {
					strategy = new MemoryStrategySchneiderinnenBestFitImpl(listExample);
					break;
				}
				default: {
					throw new IllegalArgumentException();
				}
			}
			return strategy;
		} catch (Exception ex) {
			throw ex;
		}
	}
}