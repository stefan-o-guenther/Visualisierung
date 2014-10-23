/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.util.List;

public abstract class MemoryStrategyFirstNextAbstract extends MemoryStrategyAbstract {

	public MemoryStrategyFirstNextAbstract(List<Space> example) {
		super(example);
	}

	protected Integer getChosenPosition() {
		return this.getPosition();
	}
	
	protected Boolean isSpaceSuitable(Integer number, Integer value) {
		try {
			if ((number == null) || (value == null)) {
				throw new NullPointerException();
			}
			if ((number.intValue() < 0) || (value.intValue() < 0)) {
				throw new IllegalArgumentException();
			}
			return (number.intValue() <= value.intValue());
		} catch (Exception ex) {
			throw ex;
		}
	}
		
	protected Boolean finishNotFit() {
		finishFit();
		finish();
		return false;
	}
}
