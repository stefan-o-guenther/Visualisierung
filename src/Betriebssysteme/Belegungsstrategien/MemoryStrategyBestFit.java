/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.util.List;

public class MemoryStrategyBestFit extends BaseMemoryStrategyBestWorst implements IMemoryStrategyBestFit {

	public MemoryStrategyBestFit(List<ISpace> example) {
		super(example);
	}
	
	@Override
	public EnumMemoryStrategy getStrategy() {
		return EnumMemoryStrategy.BEST_FIT;
	}
	
	private void setBest(Integer value) {
		if ((value != null) && (value >= 0)) {
			if ((zBestWorst == null) || (value < zBestWorst)) {									
				zBestWorst = value;
				pBestWorst = position;
			}
		}
	}

	protected Boolean isSuitableSpace(Integer number, Integer value) {
		if (value >= number) {			
			setBest(value);
			if (value.equals(number)) {
				return true;									
			} else {
				return false;
			}			
		} else {
			return false;
		}
	}
}
