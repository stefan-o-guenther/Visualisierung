/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseReplacementStrategy implements IReplacementStrategy {

	public BaseReplacementStrategy(List<Integer> sequence, Integer ram, Integer disk) {
		init();
		if ((sequence != null) && (disk != null) && (ram != null)) {
			maxRam = ram;
			maxDisk = disk;
			listCacheWork = new ArrayList<ICacheBox>();
			List<Integer> listSequence = sequence;
			for (Integer i : listSequence) {
				ICacheBox cb = new CacheBox(i);
				listCacheWork.add(cb);			
			}
		}
		copyListCache();
	}
	
	protected EnumPagingStatus status;

	protected ICache cache;
	
	protected Integer errorCount = 0;
	protected Integer maxRam = 0;
	protected Integer maxDisk = 0;
	protected List<ICacheBox> listCacheWork;
	protected List<ICacheBox> listCachePublic;
	protected Integer position = -1;
	
	protected abstract void initClass();
	protected abstract void useNumber(Integer number);
	protected abstract Boolean putOnOldPosition();
	protected abstract void remove(List<ICache> ram, List<ICache> disk);	
		
	protected void init() {
		listCacheWork = new ArrayList<ICacheBox>();
		copyListCache();
		cache = null;
		position = -1;
		maxRam = 0;
		maxDisk = 0;
		errorCount = 0;
		status = EnumPagingStatus.SEARCH;
		initClass();
	}
	
	protected void copyListCache() {
		listCachePublic = new ArrayList<ICacheBox>(listCacheWork);
	}
	
	protected void error() {
		errorCount += 1;
	}
	
	protected Integer isAvailable(List<ICache> list, Integer number) {
		Integer result = null;
		if ((number != null) && (list != null)) {
			for (Integer i = 0; i < list.size(); i++) {
				ICache cache = list.get(i);
				Integer x = cache.getNumber();
				if (x.equals(number)) {
					result = i;
					break;
				}
			}
		}	
		return result;
	}
	
	protected void doPaging() {
		if (maxRam > 0) {
			cache = null;
			position += 1;
			if ((position != null) && (position >= 0) && (position < listCacheWork.size())) {
				ICacheBox cb = listCacheWork.get(position);
				Integer number = cb.getNumber();				
				useNumber(number);				
				List<ICache> ram;
				List<ICache> disk;
				if (position == 0) {
					ram = cb.getRam();
					disk = cb.getDisk();					
				} else {
					ICacheBox ocb = listCacheWork.get(position-1);
					ram = ocb.getRamCopy();
					disk = ocb.getDiskCopy();
				}
				cache = null;
				Integer npos;					
				Integer pos = isAvailable(ram, number);
				if (pos != null) {
					// Number is in RAM
					cache = ram.remove(pos.intValue());
					if (putOnOldPosition()) {
						npos = pos;
					} else {
						npos = 0;
					}
				} else {	
					// Number is not in RAM
					npos = 0;
					pos = isAvailable(disk, number);						
					if (pos != null) {		
						// Number is in DISK
						cache = disk.remove(pos.intValue());
					} else {
						// Number is not in DISK
						cache = new Cache(number);						
					}
					if (ram.size() < maxRam) {
						cache.setStatus(EnumCache.NEW);						
					} else {
						cache.setStatus(EnumCache.OVERWRITE);						
					}
				}
				cache.setR(1);
				ram.add(npos.intValue(), cache);
				remove(ram, disk);
				for (ICache c : disk) {
					c.setM(0);
					c.setR(0);
				}
				
				cb.setRam(ram);
				cb.setDisk(disk);
				if ((position+1) == listCacheWork.size()) {
					status = EnumPagingStatus.FINISHED;
				}
			} else {
				status = EnumPagingStatus.FINISHED;
				if (position != null) {
					position -= 1;
				}				
			}
		}
	}
	
	@Override
	public void execute() {
		switch (status) {
			case SEARCH: {
				doPaging();
				break;
			}				
			case FINISHED: {
				
				break;
			}			
			default: {
				break;
			}
		}
		copyListCache();
	}

	@Override
	public void resetRBits() {
		if ((position > -1) && (position < listCacheWork.size())) {
			ICacheBox cb = listCacheWork.get(position);
			List<ICache> ram = cb.getRam();
			for (ICache c : ram) {
				c.setR(0);
			}
		}
	}

	@Override
	public void setMBit() {
		if (cache != null) {
			cache.setM(1);
			cache.setR(1);
			copyListCache();
		}
	}
	
	@Override
	public List<ICacheBox> getListCache() {
		return new ArrayList<ICacheBox>(listCachePublic);
	}
	
	@Override
	public Integer getMaxRam() {
		return maxRam;
	}

	@Override
	public Integer getMaxDisk() {
		return maxDisk;
	}

	@Override
	public EnumPagingStatus getStatus() {		
		return status;
	}
	
	@Override
	public Integer getErrorCount() {
		return errorCount;
	}
}
