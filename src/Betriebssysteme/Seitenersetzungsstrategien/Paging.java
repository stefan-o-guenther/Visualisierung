package Betriebssysteme.Seitenersetzungsstrategien;

import java.util.ArrayList;
import java.util.List;

public class Paging implements IPaging {

	private EnumPagingStrategy strategy = EnumPagingStrategy.NULL;
	private EnumPagingStatus status = EnumPagingStatus.START;
	private List<ICacheBox> listCache = new ArrayList<ICacheBox>();
	private List<Integer> listSequence = new ArrayList<Integer>();	
	private Integer maxRam = 3;
	private Integer maxDisk = 3;
	
	private void init() {
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
		
		maxRam = 3;
		maxDisk = 3;
	}
	
	
	private void initListCache() {
		listCache = new ArrayList<ICacheBox>();
		if (listSequence != null) {
			for (Integer x : listSequence) {
				listCache.add( new CacheBox(x, maxRam, maxDisk));
			}
		}
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
	
	public Paging() {
		this.initListCache();
		init();
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
