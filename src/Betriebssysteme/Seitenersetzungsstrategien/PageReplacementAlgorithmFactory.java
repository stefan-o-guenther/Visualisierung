/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.List;

import Base.Checker;

public class PageReplacementAlgorithmFactory {

	public static PageReplacementAlgorithm getStrategy(EnumPagingStrategy enumStrategy, List<Integer> listSequence, Integer ram, Integer disk) {
		try {
			Checker.checkIfNotNull(enumStrategy);
			Checker.checkIfNotNull(listSequence);
			Checker.checkIfNotNull(ram);
			Checker.checkIfNotNull(disk);
			PageReplacementAlgorithm strategy = null;
			switch (enumStrategy) {
				case OPTIMAL: {
					strategy = new PageReplacementAlgorithmOptimalImpl(listSequence, ram, disk);
					break;
				}
				case FIFO: {
					strategy = new PageReplacementAlgorithmFifoImpl(listSequence, ram, disk);
					break;
				}
				case FIFO_SECOND_CHANCE: {
					strategy = new PageReplacementAlgorithmFifoSecondChanceImpl(listSequence, ram, disk);
					break;
				}
				case NRU_RNU: {
					strategy = new PageReplacementAlgorithmNruRnuImpl(listSequence, ram, disk);
					break;
				}
				case NRU_RNU_SECOND_CHANCE: {
					strategy = new PageReplacementAlgorithmNruRnuSecondChanceImpl(listSequence, ram, disk);
					break;
				}
				case LRU: {
					strategy = new PageReplacementAlgorithmLruImpl(listSequence, ram, disk);
					break;
				}
				case NFU_LFU: {
					strategy = new PageReplacementAlgorithmNfuLfuImpl(listSequence, ram, disk);
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
			return strategy;
		} catch (Exception ex) {
			throw ex;
		}		
	}	
}
