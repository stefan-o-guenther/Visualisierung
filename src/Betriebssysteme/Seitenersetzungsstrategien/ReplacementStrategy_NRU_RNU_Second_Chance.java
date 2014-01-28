/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.List;

public class ReplacementStrategy_NRU_RNU_Second_Chance extends BaseReplacementStrategyNRU_RNU implements IReplacementStrategy_NRU_RNU_Second_Chance {

	public ReplacementStrategy_NRU_RNU_Second_Chance(List<Integer> sequence, Integer ram, Integer disk) {
		super(sequence, ram, disk);
	}

	@Override
	public EnumPagingStrategy getStrategy() {
		return EnumPagingStrategy.NRU_RNU_SECOND_CHANCE;
	}

	@Override
	protected Boolean putOnOldPosition() {
		return false;
	}
}
