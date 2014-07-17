/**
 * @author:	Stefan Otto Günther
 * @date:	01.06.2014
 */

package Base;

public class CoordinateSystemImpl extends GeometryAbstract implements CoordinateSystem {

	public CoordinateSystemImpl(Boolean sameSize, EnumCoordinateSystem position) {
		try {
			if ((sameSize == null) && (position == null)) {
				throw new NullPointerException();
			}
			this.enableSameLength(sameSize);
			this.position = position;
			init();
		} catch (Exception ex) {
			throw ex;
		}
	}	
	
	private Integer arrowLength;	
	private EnumCoordinateSystem position;
	
	
	
	private void init() {
		this.setGapLeft(35);
		this.setGapRight(10);
		this.setGapTop(20);
		this.setIntervalX(1);
		this.setIntervalY(1);
		this.setGapBetweenX(1);
		this.setGapBetweenY(1);
		this.setHeight(0);
		this.setWidth(0);
		arrowLength = 10;
		switch (position) {
			case BOTTOM: {
				this.setGapBottom(50);
				break;
			}
			case RIGHT: {
				this.setGapBottom(30);
				break;
			}
			default: {
				this.setGapBottom(50);
				break;
			}
		}
	}	
	
	@Override
	public Integer getArrowLength() {
		return this.arrowLength;
	}

	@Override
	public void setArrowLength(Integer length) {
		if (length != null) {
			this.arrowLength = length;
		}
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
	public EnumCoordinateSystem getPosition() {
		return this.position;
	}

	@Override
	public void setPostion(EnumCoordinateSystem position) {
		try {
			if (position == null) {
				throw new NullPointerException();
			}
			this.position = position;
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