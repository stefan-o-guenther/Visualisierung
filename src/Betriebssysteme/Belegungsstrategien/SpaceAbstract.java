/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import Base.Checker;

public abstract class SpaceAbstract implements Space {

	public SpaceAbstract(Integer value) {		
		try {
			Checker.checkIfIntegerNotLessZero(value);
			currentValue = value;		
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	protected Integer currentValue;	

	@Override
	public Integer getCurrentValue() {
		return currentValue;
	}

	@Override
	public void setCurrentValue(Integer value) {
		try {
			Checker.checkIfIntegerNotLessZero(value);
			currentValue = value;
		} catch (Exception ex) {
			throw ex;
		}
	}
}