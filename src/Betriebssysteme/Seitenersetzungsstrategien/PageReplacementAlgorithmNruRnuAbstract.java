/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.List;

public abstract class PageReplacementAlgorithmNruRnuAbstract extends PageReplacementAlgorithmAbstract {

	public PageReplacementAlgorithmNruRnuAbstract(List<Integer> sequence, Integer ram, Integer disk) {
		super(sequence, ram, disk);
	}	
	
	@Override
	public Boolean isRmEnabled() {
		if ((position > -1) && (position < listCacheBox.size())) {
			CacheBox cb = listCacheBox.get(position);
			List<Cache> ram = cb.getRam();
			for (Cache cache : ram) {
				Integer sizeR = cache.getRPreviousSize();
				Integer sizeM = cache.getMPreviousSize();
				if ((sizeR >= maxRM) || (sizeM >= maxRM)) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public Boolean isRmVisible() {
		return true;
	}
	
	protected Integer findRM(List<Cache> ram, Integer r, Integer m) {
		Integer result = null;
		if ((ram != null) && (r != null) && (m != null) && (r.equals(0) || r.equals(1)) && (m.equals(0) || m.equals(1))) {
			Integer size = ram.size();
			for (Integer i = 0; i < size; i++) {
				Cache res = ram.get(i);
				if (res != cache) {
					Integer cr = res.getR();
					Integer cm = res.getM();
					if (cr.equals(r) && cm.equals(m)) {
						result = i;
					}
				}				
			}
		}
		return result;
	}
	
	
	@Override
	protected void remove(List<Cache> ram, List<Cache> disk) {
		if ((ram != null) && (disk != null)) {
			while (ram.size() > maxRam) {
				Integer l = findRM(ram, 0, 0);				
				if (l == null) {
					l = findRM(ram, 0, 1);
				}
				if (l == null) {
					l = findRM(ram, 1, 0);
				}
				if (l == null) {
					l = findRM(ram, 1, 1);
				}
				if (l == null) {
					l = ram.size() - 1;
				}
				Cache last = ram.remove(l.intValue());
				disk.add(0, last);
				error();
			}
			while (disk.size() > maxDisk) {
				Integer l = disk.size() - 1;
				disk.remove(l.intValue());
			}
		}
	}
	
	@Override
	protected void useNumber(Integer number) {
		// do nothing
	}
	
	@Override
	protected void initialize() {
		// do nothing		
	}
}
