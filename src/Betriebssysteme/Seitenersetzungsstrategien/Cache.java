package Betriebssysteme.Seitenersetzungsstrategien;

public class Cache implements ICache {

	private Integer item = null;
	private Integer r = null;
	private Integer m = null;
	private EnumCache status = EnumCache.EMPTY;
	
	@Override
	public Integer getItem() {
		return item;
	}

	@Override
	public void setItem(Integer value) {
		item = value;		
	}

	@Override
	public Integer getR() {
		return r;
	}

	@Override
	public void setR(Integer value) {
		r = value;		
	}

	@Override
	public Integer getM() {
		return m;
	}

	@Override
	public void setM(Integer value) {		
		m = value;
	}

	@Override
	public ICache getCopy() {
		ICache cache = new Cache();
		cache.setItem(item);
		cache.setM(m);
		cache.setR(r);
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
