/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.util.List;

public class MemoryStrategyFactory {

	public static MemoryStrategy getStrategy(EnumMemoryStrategy value, List<Space> example) {
		try {
			if ((value == null) || (example == null)) {
				throw new NullPointerException();
			} else if (value == EnumMemoryStrategy.FIRST_FIT) {
				return new MemoryStrategyFirstFitImpl(example);
			} else if (value == EnumMemoryStrategy.NEXT_FIT) {
				return new MemoryStrategyNextFitImpl(example);
			} else if (value == EnumMemoryStrategy.BEST_FIT) {
				return new MemoryStrategyBestFitImpl(example);
			} else if (value == EnumMemoryStrategy.WORST_FIT) {
				return new MemoryStrategyWorstFitImpl(example);
			} else {
				throw new IllegalArgumentException();
			}
		} catch (Exception ex) {
			throw ex;
		}
	}
}