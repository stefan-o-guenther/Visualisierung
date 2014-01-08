package Betriebssysteme.Belegungsstrategien;

import java.util.List;

public class MemoryStrategyFactory {

	public static IMemoryStrategy getStrategy(EnumMemoryStrategy value, List<ISpace> example) {
		IMemoryStrategy strategy = null;
		if ((value != null) && (example != null)) {
			switch (value) {
				case FIRST_FIT: {
					strategy = new MemoryStrategyFirstFit(example);
					break;
				}
				case NEXT_FIT: {
					strategy = new MemoryStrategyNextFit(example);
					break;
				}
				case BEST_FIT: {
					strategy = new MemoryStrategyBestFit(example);
					break;
				}
				case WORST_FIT: {
					strategy = new MemoryStrategyWorstFit(example);	
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
