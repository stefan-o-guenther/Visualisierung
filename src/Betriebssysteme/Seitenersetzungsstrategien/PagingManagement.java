package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.ArrayList;
import java.util.List;

public class PagingManagement implements IPagingManagement {

	private EnumPagingStrategy strategy = EnumPagingStrategy.NULL;
	private EnumPagingStatus status = EnumPagingStatus.START;
	private List<ICacheBox> listCache = new ArrayList<ICacheBox>();
	private List<Integer> listSequence = new ArrayList<Integer>();	
	private Integer maxRam = 1;
	private Integer maxDisk = 1;
	
	private void init() {
		listSequence = new ArrayList<Integer>();		
		
		listSequence.add(0);
		listSequence.add(1);
		listSequence.add(2);
		listSequence.add(3);
		listSequence.add(4);		
		listSequence.add(5);
		listSequence.add(6);
		listSequence.add(7);
		listSequence.add(3);
		listSequence.add(5);		
		listSequence.add(0);
		listSequence.add(8);
		listSequence.add(1);
		listSequence.add(9);
		listSequence.add(6);		
		listSequence.add(2);
		listSequence.add(4);
		listSequence.add(9);
		listSequence.add(5);
		listSequence.add(3);		
		listSequence.add(0);
		listSequence.add(1);
		listSequence.add(2);
		listSequence.add(8);
		listSequence.add(3);		
		listSequence.add(0);
	}
	
	
	private void initListCache() {
		init();
		listCache = new ArrayList<ICacheBox>();
		
		
		maxRam = 7;
		maxDisk = 0;
		
		Boolean change = true;
		
		for (Integer i : listSequence) {
			Integer cbZahl = i % 10;
			if (cbZahl == 0) {
				change = !change;
			}
			if (change) {
				cbZahl = 9 - cbZahl;
			}			
			ICacheBox cb = new CacheBox(cbZahl);
			listCache.add(cb);			
		}
		fifo();
	}
	
	private void second() {
		Integer count = 0;
		if (maxRam > 0) {
			for (Integer i = 0; i < listCache.size(); i++) {
				ICacheBox cb = listCache.get(i);
				Integer number = cb.getNumber();
				
				List<ICache> ram = null;
				List<ICache> disk = null;
				if (i == 0) {
					ram = cb.getRam();
					ICache cache = new Cache();
					cache.setItem(number);
					ram.add(cache);
				} else {
					ICacheBox ocb = listCache.get(i-1);
					ram = ocb.getRamCopy();
					Integer pos = isAvailable(ram, number);
					if (pos != null) {
						ram.remove(pos.intValue());
					}
					ICache cache = new Cache();
					cache.setItem(number);
					ram.add(0, cache);
					while (ram.size() > maxRam) {
						Integer last = ram.size() - 1;
						ram.remove(last.intValue());
						count += 1;
					}
				}
				cb.setRam(ram);
			}
		}
		System.out.println(count);
	}
	
	
	
	private void fifo() {
		Integer count = 0;
		if (maxRam > 0) {
			for (Integer i = 0; i < listCache.size(); i++) {
				ICacheBox cb = listCache.get(i);
				Integer number = cb.getNumber();
				
				List<ICache> ram = null;
				List<ICache> disk = null;
				if (i == 0) {
					ram = cb.getRam();
					ICache cache = new Cache();
					cache.setItem(number);
					ram.add(cache);
				} else {
					ICacheBox ocb = listCache.get(i-1);
					ram = ocb.getRamCopy();
					if (isAvailable(ram, number) == null) {
						ICache cache = new Cache();
						cache.setItem(number);
						ram.add(0, cache);						
					}
					while (ram.size() > maxRam) {
						Integer last = ram.size() - 1;
						ram.remove(last.intValue());
						count += 1;
					}
				}
				cb.setRam(ram);
			}
		}
		System.out.println(count);
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
	
	
	
	private void doFIFO() {	
		
		for (int i = 0; i < listCache.size(); i++) {
			ICacheBox cb = listCache.get(i);
			Integer number = cb.getNumber();
			
			List<ICache> ram = null;
			List<ICache> disk = null;
			if (i == 0) {
				ram = cb.getRam();
				disk = cb.getDisk();
			} else {
				ICacheBox ocb = listCache.get(i-1);
				ram = ocb.getRamCopy();
				disk = ocb.getDiskCopy();
				cb.setRam(ram);
				cb.setDisk(disk);
			}
			ICache c = null;
			
			for (ICache k : ram) {
				Integer a = k.getItem();
				Integer b = c.getItem();
				if (a.equals(b)) {
					c = k;
				}
			}
			
			if (c == null) {
				int z = 0;
				for (int j = 0; j < disk.size(); j++) {
					ICache k = disk.get(j);
					Integer a = k.getItem();
					Integer b = c.getItem();
					if (a.equals(b)) {
						c = k;
						z = j;
					}
				}
				if (c == null) {
					c = new Cache();
					c.setItem(number);
					c.setStatus(EnumCache.NORMAL);
				} else {
					c = disk.remove(z);
					
					
					//disk.add(new Cache());
				}			
				ram.add(0, c);
				ICache d = ram.remove(ram.size()-1);
				disk.add(0, d);
				disk.remove(disk.size()-1);			
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
	public List<Integer> getSequence() {
		return listSequence;
	}

	@Override
	public void setSequence(List<Integer> value) {
		if (value != null) {
			listSequence = value;
		}
	}

	@Override
	public void execute() {
		doFIFO();
	}

	@Override
	public EnumPagingStatus getStatus() {
		return status;
	}

	@Override
	public List<ICacheBox> getListCache() {
		return listCache;
	}


	@Override
	public Integer getMaxRam() {
		return this.maxRam;
	}


	@Override
	public void setMaxRam(Integer value) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Integer getMaxDisk() {
		return this.maxDisk;
	}


	@Override
	public void setMaxDisk(Integer value) {
		// TODO Auto-generated method stub
		
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
