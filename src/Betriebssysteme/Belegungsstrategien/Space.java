package Betriebssysteme.Belegungsstrategien;

public class Space implements ISpace {

	private Boolean isActivated = false;
	private EnumSpace spaceType = EnumSpace.FULL;
	private Integer newValue = null;
	private Integer currentValue = 1;
	private Integer restValue = null;
	
	public Space() {
		
	}
	
	public Space(Integer value, EnumSpace type) {
		currentValue = value;
		spaceType = type;
	}
	
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
