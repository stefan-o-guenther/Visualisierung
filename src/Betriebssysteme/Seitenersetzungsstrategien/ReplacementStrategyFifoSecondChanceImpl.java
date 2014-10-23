/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.List;

public class ReplacementStrategyFifoSecondChanceImpl extends ReplacementStrategyFifoAbstract implements ReplacementStrategyFifoSecondChance {

	public ReplacementStrategyFifoSecondChanceImpl(List<Integer> sequence, Integer ram, Integer disk) {
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
