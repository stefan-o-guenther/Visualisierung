package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.List;

public class ReplacementStrategy_FIFO_Second_Chance extends BaseReplacementStrategyFIFO implements IReplacementStrategy_FIFO_Second_Chance {

	protected ReplacementStrategy_FIFO_Second_Chance(List<Integer> sequence, Integer ram, Integer disk) {
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
