package Base;

public abstract class GeometryAbstract implements Geometry {

	public GeometryAbstract() {
		super();
	}
	
	private Integer height;
	private Integer width;
	private Integer gapBetweenX;
	private Integer gapBetweenY;
	private Integer intervalX;
	private Integer intervalY;
	
	private Integer gapLeft;
	private Integer gapRight;
	private Integer gapTop;
	private Integer gapBottom;	
	private Boolean sameSize;
	
	protected abstract Integer getGapVertical();
	protected abstract Integer getGapHorizontal();
	
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
		if (this.sameSize) {
			return this.calculateAxisMinLength();
		} else {
			return this.calcualteAxisXLength();
		}
	}
	
	protected Integer getAxisYLength() {
		if (this.sameSize) {
			return this.calculateAxisMinLength();
		} else {
			return this.calculateAxisYLength();
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
	public Integer getGapBetweenX() {
		return this.gapBetweenX;
	}

	@Override
	public void setGapBetweenX(Integer gapBetween) {
		try {
			if (gapBetween == null) {
				throw new NullPointerException();
			}
			if (gapBetween.intValue() <= 0) {
				throw new IllegalArgumentException();
			}
			this.gapBetweenX = gapBetween;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public Integer getGapBetweenY() {
		return this.gapBetweenY;
	}

	@Override
	public void setGapBetweenY(Integer gapBetween) {
		try {
			if (gapBetween == null) {
				throw new NullPointerException();
			}
			if (gapBetween.intValue() <= 0) {
				throw new IllegalArgumentException();
			}
			this.gapBetweenY = gapBetween;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@Override
	public Integer getIntervalX() {
		return this.intervalX;
	}

	@Override
	public void setIntervalX(Integer interval) {
		try {
			if (interval == null) {
				throw new NullPointerException();
			}
			if (interval.intValue() <= 0) {
				throw new IllegalArgumentException();
			}
			this.intervalX = interval;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@Override
	public Integer getIntervalY() {
		return this.intervalY;
	}

	@Override
	public void setIntervalY(Integer interval) {
		try {
			if (interval == null) {
				throw new NullPointerException();
			}
			if (interval.intValue() <= 0) {
				throw new IllegalArgumentException();
			}
			this.intervalY = interval;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	protected Integer getGapLeft() {
		return this.gapLeft;
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
	
	protected Integer getGapRight() {
		return this.gapRight;
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
	
	protected Integer getGapTop() {
		return this.gapTop;
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
	
	protected Integer getGapBottom() {
		return this.gapBottom;
	}

	@Override
	public void setGapBottom(Integer gap) {
		try {
			if (gap == null) {
				throw new NullPointerException();
			}
			this.gapBottom = gap;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@Override
	public Boolean isSameLength() {
		return this.sameSize;
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
