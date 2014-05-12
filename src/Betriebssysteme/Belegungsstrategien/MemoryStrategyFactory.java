/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.util.List;

public class MemoryStrategyFactory {

	public static MemoryStrategy getStrategy(EnumMemoryStrategy value, List<Space> example) {
		MemoryStrategy strategy = null;
		if ((value != null) && (example != null)) {
			switch (value) {
				case FIRST_FIT: {
					strategy = new MemoryStrategyFirstFitImpl(example);
					break;
				}
				case NEXT_FIT: {
					strategy = new MemoryStrategyNextFitImpl(example);
					break;
				}
				case BEST_FIT: {
					strategy = new MemoryStrategyBestFitImpl(example);
					break;
				}
				case WORST_FIT: {
					strategy = new MemoryStrategyWorstFitImpl(example);	
					break;
				}
				case NULL: {
					strategy = null;
					break;
				}
				default: {
					strategy = null;
					break;
				}					
			}
		}
		return strategy;
	}
}
