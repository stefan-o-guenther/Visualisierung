/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

public class SpaceImpl implements Space {

	public SpaceImpl() {
		isActivated = false;
		spaceType = EnumSpace.FULL;
		newValue = null;
		currentValue = 1;
		restValue = null;
	}
	
	public SpaceImpl(Integer value, EnumSpace type) {
		this();
		if (value != null) {
			currentValue = value;
		}
		if (type != null) {
			spaceType = type;
		}	
	}
	
	private Boolean isActivated;
	private EnumSpace spaceType;
	private Integer newValue;
	private Integer currentValue;
	private Integer restValue;		
	
	@Override
	public Boolean isActivated() {
		return isActivated;
	}

	@Override
	public void activate(Boolean value) {
		isActivated = value;
	}
	
	@Override
	public Integer getNewValue() {
		return newValue;
	}

	@Override
	public void setNewValue(Integer value) {
		newValue = value;
	}

	@Override
	public Integer getCurrentValue() {
		return currentValue;
	}

	@Override
	public void setCurrentValue(Integer value) {
		currentValue = value;
	}

	@Override
	public Integer getRestValue() {
		return restValue;
	}

	@Override
	public void setRestValue(Integer value) {
		restValue = value;
	}

	@Override
	public EnumSpace getType() {
		return spaceType;
	}

	@Override
	public void setType(EnumSpace value) {
		spaceType = value;
	}
}
