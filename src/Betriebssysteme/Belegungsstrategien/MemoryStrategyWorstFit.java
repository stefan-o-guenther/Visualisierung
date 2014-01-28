/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.util.List;

public class MemoryStrategyWorstFit extends BaseMemoryStrategyBestWorst implements IMemoryStrategyWorstFit {
	
	public MemoryStrategyWorstFit(List<ISpace> example) {
		super(example);
	}

	@Override
	public EnumMemoryStrategy getStrategy() {
		return EnumMemoryStrategy.WORST_FIT;
	}
	
	private void setWorst(Integer value) {
		if ((value != null) && (value >= 0)) {
			if ((zBestWorst == null) || (value > zBestWorst)) {									
				zBestWorst = value;
				pBestWorst = position;
			}
		}
	}

	protected Boolean isSuitableSpace(Integer number, Integer value) {
		if (value >= number) {			
			setWorst(value);
			return false;		
		} else {
			return false;
		}
	}
}
