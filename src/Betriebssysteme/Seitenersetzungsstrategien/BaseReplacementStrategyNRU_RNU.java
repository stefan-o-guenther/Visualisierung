/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.List;

public abstract class BaseReplacementStrategyNRU_RNU extends BaseReplacementStrategy {

	public BaseReplacementStrategyNRU_RNU(List<Integer> sequence, Integer ram, Integer disk) {
		super(sequence, ram, disk);
	}	
	
	@Override
	public Boolean canUseRM() {
		if ((position > -1) && (position < listCacheBox.size())) {
			ICacheBox cb = listCacheBox.get(position);
			List<ICache> ram = cb.getRam();
			for (ICache cache : ram) {
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
	
	protected Integer findRM(List<ICache> ram, Integer r, Integer m) {
		Integer result = null;
		if ((ram != null) && (r != null) && (m != null) && (r.equals(0) || r.equals(1)) && (m.equals(0) || m.equals(1))) {
			Integer size = ram.size();
			for (Integer i = 0; i < size; i++) {
				ICache res = ram.get(i);
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
	protected void remove(List<ICache> ram, List<ICache> disk) {
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
				ICache last = ram.remove(l.intValue());
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
	public Boolean useRM() {
		return true;
	}
	
	@Override
	protected void useNumber(Integer number) {
		// do nothing
	}
	
	@Override
	protected void initClass() {
		// do nothing		
	}
}
