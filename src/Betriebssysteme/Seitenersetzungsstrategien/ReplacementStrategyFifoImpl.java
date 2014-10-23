/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.List;

public class ReplacementStrategyFifoImpl extends ReplacementStrategyFifoAbstract implements ReplacementStrategyFifo {

	public ReplacementStrategyFifoImpl(List<Integer> sequence, Integer ram, Integer disk) {
		super(sequence, ram, disk);
	}

	@Override
	public EnumPagingStrategy getStrategy() {
		return EnumPagingStrategy.FIFO;
	}

	@Override
	protected Boolean putOnOldPosition() {
		return true;
	}
}
