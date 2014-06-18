/**
 * @author:	Stefan Otto Günther
 * @date:	01.06.2014
 */

package Base;

public class CoordinateSystemImpl implements CoordinateSystem {

	public CoordinateSystemImpl(Boolean sameSize, EnumCoordinateSystem position) {
		try {
			if ((sameSize == null) && (position == null)) {
				throw new NullPointerException();
			}
			this.sameSize = sameSize;
			this.position = position;
			init();
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	private Integer gapLeft;
	private Integer gapRight;
	private Integer gapTop;
	private Integer gapBotton;	
	private Integer interval;
	private Integer arrowLength;
	private Integer gapBetween;
	private Integer height;
	private Integer width;
	private Boolean sameSize;
	
	private EnumCoordinateSystem position;
	
	private void init() {
		gapLeft = 35;
		gapRight = 10;
		gapTop = 20;			
		interval = 1;
		arrowLength = 10;
		gapBetween = 1;
		height = 0;
		width = 0;
		switch (position) {
			case BOTTOM: {
				gapBotton = 50;
				break;
			}
			case RIGHT: {
				gapBotton = 30;
				break;
			}
			default: {
				gapBotton = 50;
				break;
			}
		}
	}
	
	private Integer calcualteAxisXLength() {
		return (this.width - this.gapRight - this.gapLeft);
	}
	
	private Integer calculateAxisYLength() {
		return (this.height - this.gapBotton - this.gapTop);
	}
	
	private Integer calculateAxisMinLength() {
		int x = this.calcualteAxisXLength().intValue();
		int y = this.calculateAxisYLength().intValue();
		if (x < y) {
			return x;
		} else {
			return y;
		}
	}
	
	private Integer getAxisXLength() {
		if (this.sameSize) {
			return this.calculateAxisMinLength();
		} else {
			return this.calcualteAxisXLength();
		}
	}
	
	private Integer getAxisYLength() {
		if (this.sameSize) {
			return this.calculateAxisMinLength();
		} else {
			return this.calculateAxisYLength();
		}
	}
	
	@Override
	public void setGapLeft(Integer gap) {
		try {
			if (gap == null) {
				throw new NullPointerException();
			}
			this.gapLeft = gap;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public void setGapRight(Integer gap) {
		try {
			if (gap == null) {
				throw new NullPointerException();
			}
			this.gapRight = gap;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public void setGapTop(Integer gap) {
		try {
			if (gap == null) {
				throw new NullPointerException();
			}
			this.gapTop = gap;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public void setGapBottom(Integer gap) {
		try {
			if (gap == null) {
				throw new NullPointerException();
			}
			this.gapBotton = gap;
		} catch (Exception ex) {
			throw ex;
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
	public Integer getX0() {
		return 0;
	}

	@Override
	public Integer getY0() {
		return 0;
	}
	
	@Override
	public Integer getXMax() {
		return (this.getAxisXLength() - this.arrowLength) / this.gapBetween;
	}

	@Override
	public Integer getYMax() {
		return (this.getAxisYLength() - this.arrowLength) / this.gapBetween;
	}

	@Override
	public Integer getPositionX0() {
		return this.gapLeft;
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
		return this.gapTop;
	}

	@Override
	public Integer XToPositionX(Integer x) {
		try {
			if (x == null) {
				throw new NullPointerException();
			}
			Integer x0 = this.getPositionX0();
			Integer xp = x0 + (x * this.gapBetween);
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
			Integer yp = y0 - (y * this.gapBetween);
			return yp;
		} catch (Exception ex) {
			throw ex;
		}	
	}
	
	@Override
	public Integer getInterval() {
		return this.interval;
	}

	@Override
	public void setInterval(Integer interval) {
		try {
			if (interval == null) {
				throw new NullPointerException();
			}
			if (interval.intValue() <= 0) {
				throw new IllegalArgumentException();
			}
			this.interval = interval;
		} catch (Exception ex) {
			throw ex;
		}
	}	
	
	@Override
	public Integer getGapBetweenNumbers() {
		return this.gapBetween;
	}

	@Override
	public void setGapBetweenNumbers(Integer gapBetween) {
		try {
			if (gapBetween == null) {
				throw new NullPointerException();
			}
			if (gapBetween.intValue() <= 0) {
				throw new IllegalArgumentException();
			}
			this.gapBetween = gapBetween;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public Integer getHeight() {
		return this.height;
	}

	@Override
	public void setHeight(Integer height) {
		try {
			if (height == null) {
				throw new NullPointerException();
			}
			this.height = height;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public Integer getWidth() {
		return this.width;
	}
	
	@Override
	public void setWidth(Integer width) {
		try {
			if (width == null) {
				throw new NullPointerException();
			}
			this.width = width;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public void enableSameLength(Boolean enable) {
		try {
			if (enable == null) {
				throw new NullPointerException();
			}
			this.sameSize = enable;
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
}