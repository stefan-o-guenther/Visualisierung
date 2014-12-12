/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.List;

public class PageReplacementAlgorithmFifoSecondChanceImpl extends PageReplacementAlgorithmFifoAbstract implements PageReplacementAlgorithmFifoSecondChance {

	public PageReplacementAlgorithmFifoSecondChanceImpl(List<Integer> sequence, Integer ram, Integer disk) {
		super(sequence, ram, disk);
	}

	@Override
	public EnumPagingStrategy getStrategy() {
		return EnumPagingStrategy.FIFO_SECOND_CHANCE;
	}
	
	@Override
	protected Boolean putOnOldPosition() {
		return false;
	}
}
