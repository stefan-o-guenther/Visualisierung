/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.ArrayList;
import java.util.List;

import Base.EnumVisualizationStatus;

public abstract class ReplacementStrategyAbstract implements ReplacementStrategy {

	public ReplacementStrategyAbstract(List<Integer> sequence, Integer ram, Integer disk) {
		initialize();
		if ((sequence != null) && (disk != null) && (ram != null)) {
			maxRam = ram;
			maxDisk = disk;
			listCacheBox = new ArrayList<CacheBox>();
			List<Integer> listSequence = sequence;
			for (Integer i : listSequence) {
				CacheBox cb = new CacheBoxImpl(i);
				listCacheBox.add(cb);			
			}
		}
	}
	
	protected Cache cache;
	
	protected Integer errorCount = 0;
	protected Integer maxRam = 0;
	protected Integer maxDisk = 0;
	protected List<CacheBox> listCacheBox;
	protected Integer position = -1;
	
	protected final Integer maxRM = 4;
	
	protected abstract void initClass();
	protected abstract void useNumber(Integer number);
	protected abstract Boolean putOnOldPosition();
	protected abstract void remove(List<Cache> ram, List<Cache> disk);	
		
	protected void initialize() {
		ManagementPaging paging = ManagementPagingImpl.getInstance();
		paging.setStatus(EnumVisualizationStatus.RUN);
		listCacheBox = new ArrayList<CacheBox>();
		cache = null;
		position = -1;
		maxRam = 0;
		maxDisk = 0;
		errorCount = 0;		
		initClass();
	}
	
	protected void error() {
		errorCount += 1;
	}
	
	protected Integer isAvailable(List<Cache> list, Integer number) {
		Integer result = null;
		if ((number != null) && (list != null)) {
			for (Integer i = 0; i < list.size(); i++) {
				Cache cache = list.get(i);
				Integer x = cache.getNumber();
				if (x.equals(number)) {
					result = i;
					break;
				}
			}
		}	
		return result;
	}
	
	@Override
	public void execute() {
		ManagementPaging paging = ManagementPagingImpl.getInstance();
		if (maxRam > 0) {
			cache = null;
			position += 1;
			if ((position != null) && (position >= 0) && (position < listCacheBox.size())) {
				CacheBox cb = listCacheBox.get(position);
				Integer number = cb.getNumber();				
				useNumber(number);				
				List<Cache> ram;
				List<Cache> disk;
				if (position > 0) {
					CacheBox ocb = listCacheBox.get(position-1);
					ram = ocb.getRamCopy();
					disk = ocb.getDiskCopy();
				} else {
					ram = cb.getRam();
					disk = cb.getDisk();			
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
						cache = new CacheImpl(number, 1, 0);
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
				
				cb.setRam(ram);
				cb.setDisk(disk);
				cb.initializeRMDisk();
				cb.initializeRMPrevious();
				if ((position+1) == listCacheBox.size()) {					
					paging.setStatus(EnumVisualizationStatus.FINISHED);
				}
			} else {
				paging.setStatus(EnumVisualizationStatus.FINISHED);
				if (position != null) {
					position -= 1;
				}				
			}
		}
	}
	
	@Override
	public Boolean resetRBits() {
		if ((position > -1) && (position < listCacheBox.size()) && (isRmEnabled())) {			
			CacheBox cb = listCacheBox.get(position);
			List<Cache> ram = cb.getRam();
			for (Cache cache : ram) {
				cache.addRPrevious(cache.getR());
				cache.setR(0);
			}
			return isRmEnabled();			
		} else {
			return false;
		}		
	}

	@Override
	public Boolean setMBit() {
		if ((position > -1) && (position < listCacheBox.size()) && (cache != null) && (isRmEnabled())) {			
			if (cache != null) {
				cache.addRPrevious(cache.getR());
				cache.addMPrevious(cache.getM());
				cache.setR(1);
				cache.setM(1);
			}
			return isRmEnabled();			
		} else {
			return true;
		}		
	}
	
	@Override
	public List<CacheBox> getListCacheBox() {
		return new ArrayList<CacheBox>(listCacheBox);
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
	public Integer getErrorCount() {
		return errorCount;
	}
	
	@Override
	public Integer getMaxRM() {
		return maxRM;
	}	
}
