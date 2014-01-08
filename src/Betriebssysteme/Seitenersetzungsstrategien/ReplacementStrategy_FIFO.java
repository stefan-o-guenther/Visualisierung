package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.List;

public class ReplacementStrategy_FIFO extends BaseReplacementStrategyFIFO implements IReplacementStrategy_FIFO {

	protected ReplacementStrategy_FIFO(List<Integer> sequence, Integer ram, Integer disk) {
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
