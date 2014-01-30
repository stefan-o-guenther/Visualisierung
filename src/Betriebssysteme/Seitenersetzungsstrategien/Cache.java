/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

public class Cache implements ICache {

	public Cache(Integer value) {
		if (value != null) {
			number = value;
		} else {
			number = 0;
		}
		status = EnumCache.NORMAL;
		r = 0;
		m = 0;
	}
	
	private Integer number = null;
	private Integer r = null;
	private Integer m = null;
	private EnumCache status;
	
	@Override
	public Integer getNumber() {
		return number;
	}
	
	@Override
	public Integer getR() {
		return r;
	}

	@Override
	public void setR(Integer value) {
		if (value != null) {
			r = value;	
		}			
	}

	@Override
	public Integer getM() {
		return m;
	}

	@Override
	public void setM(Integer value) {
		if (value != null) {
			m = value;
		}		
	}

	@Override
	public ICache getCopy() {
		ICache cache = new Cache(number);
		cache.setM(m);
		cache.setR(r);
		cache.setStatus(EnumCache.NORMAL);
		return cache;
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

}
