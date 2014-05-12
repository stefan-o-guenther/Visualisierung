/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.ArrayList;
import java.util.List;

public class ReplacementStrategyLruImpl extends ReplacementStrategyAbstract implements ReplacementStrategyLru {

	public ReplacementStrategyLruImpl(List<Integer> sequence, Integer ram, Integer disk) {
		super(sequence, ram, disk);
	}

	private List<Integer> listLRU;
	
	@Override
	public EnumPagingStrategy getStrategy() {
		return EnumPagingStrategy.LRU;
	}

	@Override
	public Boolean useRM() {
		return false;
	}
	
	@Override
	protected void initClass() {
		listLRU = new ArrayList<Integer>();
	}

	@Override
	protected void useNumber(Integer number) {
		if (number != null) {
			Integer size;					
			size = listLRU.size();
			for (Integer i = size; i <= number; i++) {				
				listLRU.add(null);
			}			
			listLRU.set(number, position);						
		}
	}

	@Override
	protected Boolean putOnOldPosition() {
		return false;
	}

	@Override
	protected void remove(List<Cache> ram, List<Cache> disk) {		
		if ((ram != null) && (disk != null)) {
			while (ram.size() > maxRam) {
				Integer minNumber = null;				
				Integer minIndex = null;
				Integer minPos = null;
				Cache res = null;
				for (Integer index = 1; index < ram.size(); index++) {
					res = ram.get(index);
					Integer number = res.getNumber();					
					Integer pos;
					if (listLRU.size() > number) {
						pos = listLRU.get(number);
					} else {
						System.out.println("Fehler");
						pos = 0;
					}					
					if ((res != cache) && (pos != null) && ((minPos == null) || (pos <= minPos))) {
						minNumber = number;
						minPos = pos;
						minIndex = index;
					}			
				}				
				if (minNumber != null) {
					res = ram.remove(minIndex.intValue());
					disk.add(0, res);
					error();
				}				
			}
			while (disk.size() > maxDisk) {
				Integer l = disk.size() - 1;
				disk.remove(l.intValue());
			}
		}		
	}

	@Override
	public Boolean canUseRM() {
		return false;
	}

}
