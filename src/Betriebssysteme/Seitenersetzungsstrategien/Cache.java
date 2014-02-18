/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.awt.Color;

import Base.EnumSurface;

public class Cache implements ICache {

	public Cache(Integer number, Integer r, Integer m) {
		status = EnumCache.NORMAL;
		
		if (number == null) {
			number = 0;
		}
		this.number = number;
		
		if (r == null) {
			r = 0;
		}
		this.r = r;
		
		if (m == null) {
			m = 0;
		}
		this.m = m;
		
		previousR = r;
		previousM = m;
		
		rChanged = false;
		mChanged = false;
	}
	
	private Integer number;
	private Integer r;
	private Integer m;
	private EnumCache status;
	private Boolean rChanged;
	private Boolean mChanged;
	private Integer previousR;
	private Integer previousM;
	
	@Override
	public Integer getNumber() {
		return number;
	}
	
	@Override
	public Integer getR() {
		return r;
	}

	@Override
	public void setR(Integer r) {
		if (r != null) {
			this.r = r;
		}
	}

	@Override
	public Integer getM() {
		return m;
	}
	
	@Override
	public void setM(Integer m) {
		if (m != null) {
			this.m = m;
		}
	}

	@Override
	public ICache getCopy() {
		return new Cache(number, r, m);
	}

	@Override
	public EnumCache getStatus() {
		return status;
	}

	@Override
	public void setStatus(EnumCache value) {
		if (value != null) {
			status = value;
		}
	}

	@Override
	public Boolean isRChanged() {
		return rChanged;
	}
	
	@Override
	public void setRChanged(Boolean value) {
		if (value != null) {
			rChanged = value;
		}		
	}

	@Override
	public Boolean isMChanged() {
		return mChanged;
	}
	
	@Override
	public void setMChanged(Boolean value) {
		if (value != null) {
			mChanged = value;
		}	
	}
	
	@Override
	public Integer getRPrevious() {
		return previousR;
	}

	@Override
	public void setPreviousR(Integer r) {
		if (r != null) {
			previousR = r;
		}
	}

	@Override
	public Integer getMPreviousM() {
		return previousM;
	}

	@Override
	public void setPreviousM(Integer m) {
		if (m != null) {
			previousM = m;
		}
	}
}
