/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.ArrayList;
import java.util.List;

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
		
		this.initializeRPrevious();
		this.initializeMPrevious();
	}
	
	private Integer number;
	private Integer r;
	private Integer m;
	private EnumCache status;
	private List<Integer> rPrevious;
	private List<Integer> mPrevious;
	
	@Override
	public Integer getNumber() {
		return number;
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
	public Integer getR() {
		return r;
	}

	@Override
	public void setR(Integer r) {
		if ((r != null) && (r.equals(0) || r.equals(1))) {
			this.r = r;
		}
	}

	@Override
	public Integer getM() {
		return m;
	}
	
	@Override
	public void setM(Integer m) {
		if ((m != null) && (m.equals(0) || m.equals(1))) {
			this.m = m;
		}
	}

	@Override
	public List<Integer> getRPrevious() {
		return rPrevious;
	}

	@Override
	public void setRPrevious(List<Integer> r) {
		if (r != null) {
			rPrevious = r;
		}
	}

	@Override
	public void addRPrevious(Integer r) {
		if ((r != null) && (r.equals(0) || r.equals(1)) && (rPrevious != null)) {
			rPrevious.add(r);
		}
	}

	@Override
	public Integer getRPreviousSize() {
		if (rPrevious != null) {
			return rPrevious.size();
		} else {
			return null;
		}
	}

	@Override
	public void initializeRPrevious() {
		rPrevious = new ArrayList<Integer>();
	}

	@Override
	public List<Integer> getMPrevious() {
		return mPrevious;
	}

	@Override
	public void setMPrevious(List<Integer> m) {
		if (m != null) {
			mPrevious = m;
		}
	}

	@Override
	public void addMPrevious(Integer m) {
		if ((m != null) && (m.equals(0) || m.equals(1)) && (mPrevious != null)) {
			mPrevious.add(m);
		}
	}

	@Override
	public Integer getMPreviousSize() {
		if (mPrevious != null) {
			return mPrevious.size();
		} else {
			return null;
		}
	}

	@Override
	public void initializeMPrevious() {
		mPrevious = new ArrayList<Integer>();
	}
}
