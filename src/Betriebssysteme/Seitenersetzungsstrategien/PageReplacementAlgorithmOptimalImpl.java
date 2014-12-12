/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.List;

public class PageReplacementAlgorithmOptimalImpl extends PageReplacementAlgorithmAbstract implements PageReplacementAlgorithmOptimal {
	
	public PageReplacementAlgorithmOptimalImpl(List<Integer> sequence, Integer ram, Integer disk) {
		super(sequence, ram, disk);
	}

	@Override
	public EnumPagingStrategy getStrategy() {
		return EnumPagingStrategy.OPTIMAL;
	}

	@Override
	public Boolean isRmVisible() {
		return false;
	}

	@Override
	public Boolean isRmEnabled() {
		return false;
	}
	
	@Override
	protected void initialize() {
		// do nothing
	}

	@Override
	protected void useNumber(Integer number) {
		// do nothing
	}

	@Override
	protected Boolean putOnOldPosition() {
		return false;
	}
	
	@Override
	protected void remove(List<Cache> ram, List<Cache> disk) {
		if ((ram != null) && (disk != null)) {
			while (ram.size() > maxRam) {
				Integer maxNumber = null;				
				Integer maxIndex = null;
				Integer maxPos = null;
				Cache res = null;
				for (Integer index = 0; index < ram.size(); index++) {
					res = ram.get(index);
					Integer number = res.getNumber();
					if (res != cache) {
						Integer pos = position + 1;
						Boolean maxNotFound = true;
						Boolean numberNotFound = true;
						Integer size = listCacheBox.size();
						while ((pos < size) && maxNotFound) {
							CacheBox cb = listCacheBox.get(pos);
							Integer number2 = cb.getNumber();
							if (number.equals(number2)) {
								numberNotFound = false;
								if ((maxPos == null) || (pos > maxPos)) {
									maxNotFound = false;
									maxPos = pos;
									maxNumber = number;							
									maxIndex = index;
								}
							}							
							pos += 1;
						}
						if (numberNotFound) {
							maxPos = size;
							maxNumber = number;
							maxIndex = index;
						}
					}					
				}
				Integer l = null;
				if (maxNumber != null) {
					l = maxIndex;
				} else {
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
}
