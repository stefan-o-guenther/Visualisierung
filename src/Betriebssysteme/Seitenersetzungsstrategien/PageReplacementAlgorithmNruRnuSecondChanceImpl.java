/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.List;

public class PageReplacementAlgorithmNruRnuSecondChanceImpl extends PageReplacementAlgorithmNruRnuAbstract implements PageReplacementAlgorithmNruRnuSecondChance {

	public PageReplacementAlgorithmNruRnuSecondChanceImpl(List<Integer> sequence, Integer ram, Integer disk) {
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
