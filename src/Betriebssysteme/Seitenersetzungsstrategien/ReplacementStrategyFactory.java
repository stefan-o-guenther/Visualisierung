/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.List;

public class ReplacementStrategyFactory {

	public static ReplacementStrategy getStrategy(EnumPagingStrategy enumStrategy, List<Integer> listSequence, Integer ram, Integer disk) {
		ReplacementStrategy strategy = null;
		if ((enumStrategy != null) && (listSequence != null) && (ram != null) && (disk != null)) {			
			switch (enumStrategy) {
				case OPTIMAL: {
					strategy = new ReplacementStrategyOptimalImpl(listSequence, ram, disk);
					break;
				}
				case FIFO: {
					strategy = new ReplacementStrategyFifoImpl(listSequence, ram, disk);
					break;
				}
				case FIFO_SECOND_CHANCE: {
					strategy = new ReplacementStrategyFifoSecondChanceImpl(listSequence, ram, disk);
					break;
				}
				case NRU_RNU: {
					strategy = new ReplacementStrategyNruRnuImpl(listSequence, ram, disk);
					break;
				}
				case NRU_RNU_SECOND_CHANCE: {
					strategy = new ReplacementStrategyNruRnuSecondChanceImpl(listSequence, ram, disk);
					break;
				}
				case LRU: {
					strategy = new ReplacementStrategyLruImpl(listSequence, ram, disk);
					break;
				}
				case NFU_LFU: {
					strategy = new ReplacementStrategyNfuLfuImpl(listSequence, ram, disk);
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
