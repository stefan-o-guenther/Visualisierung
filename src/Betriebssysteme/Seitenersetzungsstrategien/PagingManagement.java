package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.ArrayList;
import java.util.List;

import Base.BaseManagement;

public class PagingManagement extends BaseManagement implements IPagingManagement {

	private EnumPagingStrategy strategy = EnumPagingStrategy.NULL;
	private EnumPagingStatus status = EnumPagingStatus.START;
	private List<ICacheBox> listCache = new ArrayList<ICacheBox>();
	
	private Integer maxRam = 0;
	private Integer maxDisk = 0;
	
	private Integer position = 0;
	
	private void init() {
		
	}
	
	
	private void initListCache() {
		//init();
		listCache = new ArrayList<ICacheBox>();
		
		
		//maxRam = 3;
		//maxDisk = 4;
		
		//Boolean change = true;
		
		
		//doFIFO(false);
		//fifo();
		//second();
		//optimal();
	}
	
	private Integer removeOptimal(List<ICache> ram, List<ICache> disk, Integer number, Integer index) {
		Integer result = 0;
		if ((ram != null) && (disk != null)) {
			while (ram.size() > maxRam) {				
				List<Integer> listNumber = new ArrayList<Integer>();
				List<Integer> listIndex = new ArrayList<Integer>();
				for (Integer i = 0; i < ram.size(); i++) {
					ICache cache = ram.get(i);
					Integer item = cache.getItem();
					if (!(item.equals(number))) {
						listNumber.add(item);
						listIndex.add(i);
					}					
				}
				Integer minNumber = null;
				Integer minCount = null;
				Integer minIndex = null;
				for (Integer j = 0; j < listNumber.size(); j++) {
					Integer z = listNumber.get(j);
					Integer count = 0;
					for (Integer i = (index+1); i < listCache.size(); i++) {
						ICacheBox cb = listCache.get(i);
						if (cb.getNumber().equals(z)) {
							count += 1;
						}
					}
					if ((minNumber == null) || (count < minCount)) {
						minNumber = z;
						minCount = count;
						minIndex = listIndex.get(j);
					}
				}
				if (minNumber != null) {
					ICache last = ram.remove(minIndex.intValue());
					disk.add(0, last);
					result += 1;
				}				
			}
			while (disk.size() > maxDisk) {
				Integer l = disk.size() - 1;
				disk.remove(l.intValue());
			}
		}
		return result;
	}
	
	private Integer removeFIFO(List<ICache> ram, List<ICache> disk) {
		Integer result = 0;
		if ((ram != null) && (disk != null)) {
			while (ram.size() > maxRam) {
				Integer l = ram.size() - 1;
				ICache last = ram.remove(l.intValue());
				disk.add(0, last);
				result += 1;
			}
			while (disk.size() > maxDisk) {
				Integer l = disk.size() - 1;
				disk.remove(l.intValue());
			}
		}
		return result;
	}
	
	private Integer isAvailable(List<ICache> list, Integer number) {
		Integer result = null;
		if ((number != null) && (list != null)) {
			for (Integer i = 0; i < list.size(); i++) {
				ICache cache = list.get(i);
				Integer x = cache.getItem();
				if (x.equals(number)) {
					result = i;
					break;
				}
			}
		}	
		return result;
	}
	
	
	
	
	
	private void second() {
		Integer count = 0;
		if (maxRam > 0) {
			for (Integer i = 0; i < listCache.size(); i++) {
				ICacheBox cb = listCache.get(i);
				Integer number = cb.getNumber();
				
				List<ICache> ram = new ArrayList<ICache>();
				List<ICache> disk = new ArrayList<ICache>();
				if (i == 0) {
					ram = cb.getRam();
					disk = cb.getDisk();
					ICache cache = new Cache();
					cache.setItem(number);
					ram.add(cache);
				} else {
					ICacheBox ocb = listCache.get(i-1);
					ram = ocb.getRamCopy();
					disk = ocb.getDiskCopy();
					Integer pos = isAvailable(ram, number);
					ICache cache = null;
					if (pos == null) {						
						pos = isAvailable(disk, number);
						if (pos != null) {
							cache = disk.remove(pos.intValue());
						} else {
							
						}
					} else {
						cache = ram.remove(pos.intValue());
					}
					cache = new Cache();
					cache.setItem(number);
					ram.add(0, cache);
					count += removeFIFO(ram, disk);
				}
				cb.setRam(ram);
				cb.setDisk(disk);
			}
		}
	}
	
	private void fifo() {
		Integer count = 0;
		//System.out.println(maxRam);
		if (maxRam > 0) {
			for (Integer i = 0; i < listCache.size(); i++) {
				ICacheBox cb = listCache.get(i);
				Integer number = cb.getNumber();
				
				List<ICache> ram = new ArrayList<ICache>();
				List<ICache> disk = new ArrayList<ICache>();
				if (i == 0) {
					ram = cb.getRam();
					disk = cb.getDisk();
					ICache cache = new Cache();
					cache.setItem(number);
					ram.add(cache);
				} else {
					ICacheBox ocb = listCache.get(i-1);
					ram = ocb.getRamCopy();
					disk = ocb.getDiskCopy();
					Integer pos = isAvailable(ram, number);
					if (pos == null) {
						pos = isAvailable(disk, number);
						if (pos != null) {
							disk.remove(pos.intValue());
						}
						ICache cache = new Cache();
						cache.setItem(number);
						ram.add(0, cache);						
					}
					count += removeFIFO(ram, disk);
				}
				cb.setRam(ram);
				cb.setDisk(disk);
			}
		}
	}
	
	private void optimal() {
		Integer count = 0;
		if (maxRam > 0) {
			for (Integer i = 0; i < listCache.size(); i++) {
				ICacheBox cb = listCache.get(i);
				Integer number = cb.getNumber();
				
				List<ICache> ram = new ArrayList<ICache>();
				List<ICache> disk = new ArrayList<ICache>();
				if (i == 0) {
					ram = cb.getRam();
					disk = cb.getDisk();
					ICache cache = new Cache();
					cache.setItem(number);
					ram.add(cache);
				} else {
					ICacheBox ocb = listCache.get(i-1);
					ram = ocb.getRamCopy();
					disk = ocb.getDiskCopy();
					Integer pos = isAvailable(ram, number);
					if (pos != null) {
						ram.remove(pos.intValue());
					} else {
						pos = isAvailable(disk, number);
						if (pos != null) {
							disk.remove(pos.intValue());
						}
					}
					ICache cache = new Cache();
					cache.setItem(number);
					ram.add(0, cache);
					count += removeOptimal(ram, disk, number, i);
				}
				cb.setRam(ram);
				cb.setDisk(disk);
			}
		}
	}
	
	
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	
	
	private void doStrategy() {	
		Integer count = 0;
		if (maxRam > 0) {
			for (Integer i = 0; i < listCache.size(); i++) {
				ICacheBox cb = listCache.get(i);
				Integer number = cb.getNumber();
				
				List<ICache> ram = new ArrayList<ICache>();
				List<ICache> disk = new ArrayList<ICache>();
				if (i == 0) {
					ram = cb.getRam();
					disk = cb.getDisk();
					ICache cache = new Cache();
					cache.setItem(number);
					ram.add(cache);
				} else {
					ICacheBox ocb = listCache.get(i-1);
					ram = ocb.getRamCopy();
					disk = ocb.getDiskCopy();
					if (isAvailable(ram, number) == null) {
						Integer pos = isAvailable(disk, number);
						if (pos != null) {
							disk.remove(pos.intValue());
						}
						ICache cache = new Cache();
						cache.setItem(number);
						ram.add(0, cache);						
					}
					count += removeFIFO(ram, disk);
				}
				cb.setRam(ram);
				cb.setDisk(disk);
			}
		}
		
		
		if (maxRam > 0) {
			for (Integer i = 0; i < listCache.size(); i++) {
				ICacheBox cb = listCache.get(i);
				Integer number = cb.getNumber();
				
				List<ICache> ram = new ArrayList<ICache>();
				List<ICache> disk = new ArrayList<ICache>();
				if (i == 0) {
					ram = cb.getRam();
					disk = cb.getDisk();
					ICache cache = new Cache();
					cache.setItem(number);
					ram.add(cache);
				} else {
					ICacheBox ocb = listCache.get(i-1);
					ram = ocb.getRamCopy();
					disk = ocb.getDiskCopy();
					Integer pos = isAvailable(ram, number);
					if (pos != null) {
						ram.remove(pos.intValue());
					} else {
						pos = isAvailable(disk, number);
						if (pos != null) {
							disk.remove(pos.intValue());
						}
					}
					ICache cache = new Cache();
					cache.setItem(number);
					ram.add(0, cache);
					count += removeFIFO(ram, disk);
				}
				cb.setRam(ram);
				cb.setDisk(disk);
			}
		}
		
		
	}
	
	private void doSecondChance() {
		listCache = new ArrayList<ICacheBox>();
		
	}
	
	private void doOptimal() {
		listCache = new ArrayList<ICacheBox>();
		
	}
	
	public PagingManagement() {
		initListCache();
		//init();
	}
	
	
	@Override
	public EnumPagingStrategy getStrategy() {
		return strategy;
	}

	@Override
	public void setStrategy(EnumPagingStrategy value) {
		if (value != null) {
			strategy = value;
		}		
	}

	@Override
	public void setSequence(List<Integer> value) {
		listCache = new ArrayList<ICacheBox>();
		if (value != null) {
			List<Integer> listSequence = value;
			for (Integer i : listSequence) {
				ICacheBox cb = new CacheBox(i);
				listCache.add(cb);			
			}
		}
	}
	
	@Override
	public void loadExample() {		
		// 012340156012356
		List<Integer> listSequence = new ArrayList<Integer>();	
		listSequence.add(0);
		listSequence.add(1);
		listSequence.add(2);
		listSequence.add(3);
		listSequence.add(4);		
		listSequence.add(0);
		listSequence.add(1);
		listSequence.add(5);
		listSequence.add(6);
		listSequence.add(0);		
		listSequence.add(1);
		listSequence.add(2);
		listSequence.add(3);
		listSequence.add(5);
		listSequence.add(6);
		
		setSequence(listSequence);
		
		setMaxRam(3);
		setMaxDisk(4);
		
		position = 0;
	}

	@Override
	public void execute() {
		fifo();
	}

	@Override
	public EnumPagingStatus getStatus() {
		return status;
	}

	@Override
	public List<ICacheBox> getListCache() {
		//return listCache;
		return new ArrayList<ICacheBox>(listCache); 
	}


	@Override
	public Integer getMaxRam() {
		return maxRam;
	}


	@Override
	public void setMaxRam(Integer value) {
		if (value != null) {
			System.out.println("");
			maxRam = value;
		}
	}


	@Override
	public Integer getMaxDisk() {
		return maxDisk;
	}


	@Override
	public void setMaxDisk(Integer value) {
		if (value != null) {
			maxDisk = value;
		}
	}


	@Override
	public void resetRBits() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setMBit() {
		// TODO Auto-generated method stub
		
	}


	
}
