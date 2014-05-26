/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.util.List;

public class MemoryStrategyBestFitImpl extends MemoryStrategyBestWorstAbstract implements MemoryStrategyBestFit {

	public MemoryStrategyBestFitImpl(List<Space> example) {
		super(example);
	}
	
	@Override
	public EnumMemoryStrategy getStrategy() {
		return EnumMemoryStrategy.BEST_FIT;
	}
	
	private void setBest(Integer value) {
		try {
			if (value == null) {
				throw new NullPointerException();
			}
			if (value < 0) {
				throw new IllegalArgumentException();
			}
			if ((zBestWorst == null) || (value < zBestWorst)) {									
				zBestWorst = value;
				pBestWorst = position;
			}
		} catch (Exception ex) {
			throw ex;
		}
	}

	protected Boolean isSuitableSpace(Integer number, Integer value) {
		try {
			if ((number == null) || (value == null)) {
				throw new NullPointerException();
			}
			if ((number < 0) || (value < 0)) {
				throw new IllegalArgumentException();
			}
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
		} catch (Exception ex) {
			throw ex;
		}		
	}
}
