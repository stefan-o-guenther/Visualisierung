package Base;

public abstract class ManagementGeometryAbstract extends ManagementAbstract implements
		ManagementGeometry {

	public ManagementGeometryAbstract() {
		
	}
	
	protected abstract Integer getGapLeft();
	protected abstract Integer getGapRight();
	protected abstract Integer getGapTop();
	protected abstract Integer getGapBottom();
	protected abstract Integer getGapHorizontal();
	protected abstract Integer getGapVertical();
	
	protected void initGeometry() {
		
	}
	
	protected Integer calcualteAxisXLength() {
		return (this.getWidth() - this.getGapRight() - this.getGapLeft());
	}
	
	protected Integer calculateAxisYLength() {
		return (this.getHeight() - this.getGapBottom() - this.getGapTop());
	}
	
	protected Integer calculateAxisMinLength() {
		int x = this.calcualteAxisXLength().intValue();
		int y = this.calculateAxisYLength().intValue();
		if (x < y) {
			return x;
		} else {
			return y;
		}
	}
	
	protected Integer getAxisXLength() {
		if (this.isSameLength()) {
			return this.calculateAxisMinLength();
		} else {
			return this.calcualteAxisXLength();
		}
	}
	
	protected Integer getAxisYLength() {
		if (this.isSameLength()) {
			return this.calculateAxisMinLength();
		} else {
			return this.calculateAxisYLength();
		}
	}	
	
	@Override
	public Integer getX0() {
		return 0;
	}

	@Override
	public Integer getY0() {
		return 0;
	}
	
	@Override
	public Integer getXMax() {
		return (this.getAxisXLength() - this.getGapHorizontal()) / this.getGapBetweenX();
	}

	@Override
	public Integer getYMax() {
		return (this.getAxisYLength() - this.getGapVertical()) / this.getGapBetweenY();
	}	
}
