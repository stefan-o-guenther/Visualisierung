package Rechnernetze.Pipeline_Protocol;

import Base.GeometryAbstract;

public class PipelineDrawImpl extends GeometryAbstract implements PipelineDraw {

	@Override
	public Integer getPositionX0() {
		return this.getGapLeft();
	}

	@Override
	public Integer getPositionY0() {
		return this.getGapTop();
	}

	@Override
	public Integer getPositionXMax() {
		return (this.getPositionX0() + this.getAxisXLength());
	}

	@Override
	public Integer getPositionYMax() {
		return (this.getPositionY0() + this.getAxisYLength());
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
			Integer yp = y0 + (y * this.getGapBetweenY());
			return yp;
		} catch (Exception ex) {
			throw ex;
		}	
	}

	@Override
	protected Integer getGapVertical() {
		return 0;
	}

	@Override
	protected Integer getGapHorizontal() {
		return 0;
	}
}
