/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

public abstract class SpaceAbstract implements Space {

	public SpaceAbstract(Integer value) {		
		try {			
			if (value == null) {
				throw new NullPointerException();
			}
			if (value <= 0) {
				throw new IllegalArgumentException();
			}			
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
			if (value == null) {
				throw new NullPointerException();
			}
			if (value < 0) {
				throw new IllegalArgumentException();
			}
			currentValue = value;
		} catch (Exception ex) {
			throw ex;
		}
	}
}