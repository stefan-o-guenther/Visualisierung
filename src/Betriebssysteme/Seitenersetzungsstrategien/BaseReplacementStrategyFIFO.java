/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.List;

public abstract class BaseReplacementStrategyFIFO extends BaseReplacementStrategy {

	public BaseReplacementStrategyFIFO(List<Integer> sequence, Integer ram, Integer disk) {
		super(sequence, ram, disk);
	}
	
	@Override
	public Boolean useRM() {
		return false;
	}
	
	@Override
	protected void remove(List<ICache> ram, List<ICache> disk) {
		if ((ram != null) && (disk != null)) {
			while (ram.size() > maxRam) {
				Integer l = ram.size() - 1;
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
	protected void useNumber(Integer number) {
		// do nothing
	}
	
	@Override
	protected void initClass() {
		// do nothing		
	}
}
