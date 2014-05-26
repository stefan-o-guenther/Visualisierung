/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.util.List;

public class MemoryStrategyWorstFitImpl extends MemoryStrategyBestWorstAbstract implements MemoryStrategyWorstFit {
	
	public MemoryStrategyWorstFitImpl(List<Space> example) {
		super(example);
	}

	@Override
	public EnumMemoryStrategy getStrategy() {
		return EnumMemoryStrategy.WORST_FIT;
	}
	
	private void setWorst(Integer value) {
		try {
			if (value == null) {
				throw new NullPointerException();
			}
			if (value < 0) {
				throw new IllegalArgumentException();
			}
			if ((zBestWorst == null) || (value > zBestWorst)) {									
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
				setWorst(value);
			}
			return false;
		} catch (Exception ex) {
			throw ex;
		}		
	}
}