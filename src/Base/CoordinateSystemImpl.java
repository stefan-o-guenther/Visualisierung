package Base;

public class CoordinateSystemImpl implements CoordinateSystem {

	public CoordinateSystemImpl(Management management) {
		try {
			if (management == null) {
				throw new NullPointerException();
			}
			this.management = management;
		} catch (Exception ex) {
			throw ex;
		}
	}	
	
	private Management management;	
	private Integer gapLeft = 0;
	private Integer gapRight = 0;
	private Integer gapTop = 0;
	private Integer gapBotton = 0;	
	private Integer interval = 1;
	private Integer arrowLength = 2;	
	
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
	public Integer getInterval() {
		return this.interval;
	}

	@Override
	public void setInterval(Integer interval) {
		try {
			if (interval == null) {
				throw new NullPointerException();
			}
			if (interval <= 0) {
				throw new IllegalArgumentException();
			}
			this.interval = interval;
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
		Integer x0 = this.getPositionX0();
		Integer xMax = this.getPositionXMax();		
		Integer x = (xMax - x0 - this.arrowLength) / this.interval;
		return x;
	}

	@Override
	public Integer getYMax() {
		Integer y0 = this.getPositionY0();
		Integer yMax = this.getPositionYMax();
		Integer y = (y0 - yMax - this.arrowLength) / this.interval;		
		return y;
	}

	@Override
	public Integer getPositionX0() {
		return this.gapLeft;
	}

	@Override
	public Integer getPositionY0() {
		return (management.getHeight() - this.gapBotton);
	}

	@Override
	public Integer getPositionXMax() {
		return (management.getWidth() - this.gapRight);
	}

	@Override
	public Integer getPositionYMax() {
		return this.gapTop;
	}

	@Override
	public void setManagement(Management management) {
		try {
			if (management == null) {
				throw new NullPointerException();
			}
			this.management = management;
		} catch (Exception ex) {
			throw ex;
		}
	}	
}
