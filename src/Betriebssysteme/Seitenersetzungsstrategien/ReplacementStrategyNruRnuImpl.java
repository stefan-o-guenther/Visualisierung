/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.List;

public class ReplacementStrategyNruRnuImpl extends ReplacementStrategyNruRnuAbstract implements ReplacementStrategyNruRnu {

	public ReplacementStrategyNruRnuImpl(List<Integer> sequence, Integer ram, Integer disk) {
		super(sequence, ram, disk);
	}

	@Override
	public EnumPagingStrategy getStrategy() {
		return EnumPagingStrategy.NRU_RNU;
	}

	@Override
	protected Boolean putOnOldPosition() {
		return true;
	}
}
