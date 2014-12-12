/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.List;

public abstract class PageReplacementAlgorithmFifoAbstract extends PageReplacementAlgorithmAbstract {

	public PageReplacementAlgorithmFifoAbstract(List<Integer> sequence, Integer ram, Integer disk) {
		super(sequence, ram, disk);
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
	protected void remove(List<Cache> ram, List<Cache> disk) {
		if ((ram != null) && (disk != null)) {
			while (ram.size() > maxRam) {
				Integer l = ram.size() - 1;
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
