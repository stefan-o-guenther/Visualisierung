package Base;

public abstract class ManagementCoordinateSystemAbstract extends
		ManagementGeometryAbstract implements ManagementCoordinateSystem {

	public ManagementCoordinateSystemAbstract() {
		super();
	}
	
	protected void initCoordinateSystem() {
		this.initGeometry();
	}
	
	@Override
	public Integer getPositionX0() {
		return this.getGapLeft();
	}
	
	@Override
	public Integer getPositionY0() {
		return (this.getPositionYMax() + this.getAxisYLength());
	}

	@Override
	public Integer getPositionXMax() {
		return (this.getPositionX0() + this.getAxisXLength());
	}

	@Override
	public Integer getPositionYMax() {
		return this.getGapTop();
	}

	@Override
	public Integer XToPositionX(Integer x) {
		try {
			if (x == null) {
				throw new NullPointerException();
			}
			Integer x0 = this.getPositionX0();
			Integer xp = x0 + (x * this.getGapBetweenX());
			return xp;
		} catch (Exception ex) {
			throw ex;
		}		
	}

	@Override
	public Integer YToPositionY(Integer y) {
		try {
			if (y == null) {
				throw new NullPointerException();
			}
			Integer y0 = this.getPositionY0();
			Integer yp = y0 - (y * this.getGapBetweenY());
			return yp;
		} catch (Exception ex) {
			throw ex;
		}	
	}

	@Override
	protected Integer getGapVertical() {
		return this.getArrowLength();
	}

	@Override
	protected Integer getGapHorizontal() {
		return this.getArrowLength();
	}
}
