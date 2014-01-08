package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.List;

public class ReplacementStrategy_Optimal extends BaseReplacementStrategy implements IReplacementStrategy_Optimal {
	
	protected ReplacementStrategy_Optimal(List<Integer> sequence, Integer ram, Integer disk) {
		super(sequence, ram, disk);
	}

	@Override
	public EnumPagingStrategy getStrategy() {
		return EnumPagingStrategy.OPTIMAL;
	}

	@Override
	public Boolean useRM() {
		return false;
	}
	
	@Override
	protected void initClass() {
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
	protected void remove(List<ICache> ram, List<ICache> disk) {
		if ((ram != null) && (disk != null)) {
			while (ram.size() > maxRam) {
				Integer maxNumber = null;				
				Integer maxIndex = null;
				Integer maxPos = null;
				ICache res = null;
				for (Integer index = 0; index < ram.size(); index++) {
					res = ram.get(index);
					Integer number = res.getNumber();
					if (res != cache) {
						Integer pos = position + 1;
						Boolean maxNotFound = true;
						Boolean numberNotFound = true;
						Integer size = listCacheWork.size();
						while ((pos < size) && maxNotFound) {
							ICacheBox cb = listCacheWork.get(pos);
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
}
