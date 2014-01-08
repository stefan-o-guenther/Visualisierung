package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.List;

public class ReplacementStrategyFactory {

	public static IReplacementStrategy getStrategy(EnumPagingStrategy enumStrategy, List<Integer> listSequence, Integer ram, Integer disk) {
		IReplacementStrategy strategy = null;
		if ((enumStrategy != null) && (listSequence != null) && (ram != null) && (disk != null)) {			
			switch (enumStrategy) {
				case OPTIMAL: {
					strategy = new ReplacementStrategy_Optimal(listSequence, ram, disk);
					break;
				}
				case FIFO: {
					strategy = new ReplacementStrategy_FIFO(listSequence, ram, disk);
					break;
				}
				case FIFO_SECOND_CHANCE: {
					strategy = new ReplacementStrategy_FIFO_Second_Chance(listSequence, ram, disk);
					break;
				}
				case NRU_RNU: {
					strategy = new ReplacementStrategy_NRU_RNU(listSequence, ram, disk);
					break;
				}
				case NRU_RNU_SECOND_CHANCE: {
					strategy = new ReplacementStrategy_NRU_RNU_Second_Chance(listSequence, ram, disk);
					break;
				}
				case LRU: {
					strategy = new ReplacementStrategy_LRU(listSequence, ram, disk);
					break;
				}
				case NFU_LFU: {
					strategy = new ReplacementStrategy_NFU_LFU(listSequence, ram, disk);
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
