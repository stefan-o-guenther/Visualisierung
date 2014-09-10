/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Base.EnumAutomaticChecked;
import Base.EnumSurface;
import Base.EnumVisualizationStatus;
import Base.ManagementAbstract;

public class ManagementPagingImpl extends ManagementAbstract implements ManagementPaging {	
	
	public ManagementPagingImpl() {
		super();
	}	
	
	private Boolean oldStates; 
	private EnumPagingStrategy strategy;
	private EnumVisualizationStatus status;
	
	private Cache cache;
	
	private Integer errorCount = 0;
	private Integer maxRam = 0;
	private Integer maxDisk = 0;
	private List<CacheBox> listCacheBox;
	private Integer position = -1;
	
	private final Integer maxRM = 4;
	
	@Override
	protected void initialize() {
		status = EnumVisualizationStatus.START;
		strategy = EnumPagingStrategy.NULL;
		oldStates = true;
		listCacheBox = new ArrayList<CacheBox>();
		cache = null;
		position = -1;
		maxRam = 0;
		maxDisk = 0;
		errorCount = 0;
	}
	
	private Boolean putOnOldPosition() {
		switch (strategy) {
			case OPTIMAL: return false;
			case FIFO: return true;
			case FIFO_SECOND_CHANCE: return false;
			case NRU_RNU: return true;
			case NRU_RNU_SECOND_CHANCE: return false;
			default: throw new IllegalArgumentException();
		}		
	}
	
	private Integer findRM(List<Cache> ram, Integer r, Integer m) {
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
	
	private void remove(List<Cache> ram, List<Cache> disk) {
		if ((ram != null) && (disk != null)) {
			while (ram.size() > maxRam) {
				Integer indexRemove = null;
				if (strategy == EnumPagingStrategy.OPTIMAL) {
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
								if (number.intValue() == number2.intValue()) {
									numberNotFound = false;
									if ((maxPos == null) || (pos > maxPos)) {
										maxNotFound = false;
										maxPos = pos;
										maxIndex = index;
									}
								}							
								pos += 1;
							}
							if (numberNotFound) {
								maxPos = size;
								maxIndex = index;
							}
						}					
					}
					indexRemove = maxIndex;
					if (indexRemove == null) {
						indexRemove = ram.size() - 1;
					}
				} else if ((strategy == EnumPagingStrategy.FIFO) || (strategy == EnumPagingStrategy.FIFO_SECOND_CHANCE)) {
					if (indexRemove == null) {
						indexRemove = ram.size() - 1;
					}
				} else if ((strategy == EnumPagingStrategy.NRU_RNU) || (strategy == EnumPagingStrategy.NRU_RNU_SECOND_CHANCE)) {
					indexRemove = findRM(ram, 0, 0);				
					if (indexRemove == null) {
						indexRemove = findRM(ram, 0, 1);
					}
					if (indexRemove == null) {
						indexRemove = findRM(ram, 1, 0);
					}
					if (indexRemove == null) {
						indexRemove = findRM(ram, 1, 1);
					}
					if (indexRemove == null) {
						indexRemove = ram.size() - 1;
					}
				} else {
					throw new IllegalArgumentException();
				}				
				Cache last = ram.remove(indexRemove.intValue());
				disk.add(0, last);
				error();
			}
			while (disk.size() > maxDisk) {
				Integer l = disk.size() - 1;
				disk.remove(l.intValue());
			}
		}
	}	
	
	private void error() {
		errorCount += 1;
	}
	
	private Integer isAvailable(List<Cache> list, Integer number) {
		Integer result = null;
		if ((number != null) && (list != null)) {
			for (Integer i = 0; i < list.size(); i++) {
				Cache cache = list.get(i);
				Integer x = cache.getNumber();
				if (x.equals(number)) {
					result = i;
					break;
				}
			}
		}	
		return result;
	}
	
	@Override
	public EnumPagingStrategy getStrategy() {
		return strategy;
	}

	@Override
	public void setStrategy(EnumPagingStrategy strategy, List<Integer> listSequence, Integer maxRam, Integer maxDisk) {
		try {
			if ((strategy == null) || (listSequence == null) || (maxRam == null) || (maxDisk == null)) {
				throw new NullPointerException();
			}
			if ((strategy == EnumPagingStrategy.NULL) || (listSequence.size() == 0) || (maxRam.intValue() <= 0) || (maxDisk.intValue() < 0)) {
				throw new IllegalArgumentException();
			}
			this.strategy = strategy;
			this.maxRam = maxRam;
			this.maxDisk = maxDisk;
			this.listCacheBox = new ArrayList<CacheBox>();
			for (Integer i : listSequence) {
				CacheBox cb = new CacheBoxImpl(i);
				listCacheBox.add(cb);			
			}
			status = EnumVisualizationStatus.RUN;
			this.deactivateCacheBoxes();
			this.activateCacheBox();
			this.updateViews();
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	private void deactivateCacheBoxes() {
		for (CacheBox cb : listCacheBox) {
			cb.setActivated(false);
		}
	}
	
	private void activateCacheBox() {
		if (position != null) {
			int pos = position + 1;
			if ((pos >= 0) && (pos < listCacheBox.size())) {
				CacheBox cb = listCacheBox.get(pos);
				cb.setActivated(true);
			}
		}
	}

	@Override
	protected Boolean execute() {
		if (this.status == EnumVisualizationStatus.RUN) {
			if (maxRam > 0) {
				cache = null;
				position += 1;
				if ((position != null) && (position >= 0) && (position < listCacheBox.size())) {
					CacheBox cb = listCacheBox.get(position);
					Integer number = cb.getNumber();				
					List<Cache> ram;
					List<Cache> disk;
					if (position > 0) {
						CacheBox ocb = listCacheBox.get(position-1);
						ram = ocb.getRamCopy();
						disk = ocb.getDiskCopy();
					} else {
						ram = cb.getRam();
						disk = cb.getDisk();			
					}				
					cache = null;
					Integer npos;					
					Integer pos = isAvailable(ram, number);
					if (pos != null) {
						// Number is in RAM
						cache = ram.remove(pos.intValue());
						if (putOnOldPosition()) {
							npos = pos;
						} else {
							npos = 0;
						}
					} else {	
						// Number is not in RAM
						npos = 0;
						pos = isAvailable(disk, number);						
						if (pos != null) {		
							// Number is in DISK
							cache = disk.remove(pos.intValue());
						} else {
							// Number is not in DISK
							cache = new CacheImpl(number, 1, 0);
						}
						if (ram.size() < maxRam) {
							cache.setStatus(EnumCache.NEW);						
						} else {
							cache.setStatus(EnumCache.OVERWRITE);						
						}
					}
					cache.setR(1);
					ram.add(npos.intValue(), cache);
					remove(ram, disk);
					
					cb.setRam(ram);
					cb.setDisk(disk);
					cb.initializeRMDisk();
					cb.initializeRMPrevious();
					if ((position.intValue()+1) == listCacheBox.size()) {
						status = EnumVisualizationStatus.FINISHED;
						this.stopAutomatic();
					}
					this.deactivateCacheBoxes();
					this.activateCacheBox();
				} else {				
					status = EnumVisualizationStatus.FINISHED;
					if (position != null) {
						position -= 1;
					}				
				}
			}			
			this.updateViews();
			return true;
		} else {
			return false;
		}
	}	
	
	@Override
	public EnumVisualizationStatus getStatus() {
		return this.status;	
	}

	@Override
	public List<CacheBox> getListCache() {
		return new ArrayList<CacheBox>(listCacheBox);
	}


	@Override
	public Integer getMaxRam() {
		return maxRam;
	}

	
	@Override
	public Integer getMaxDisk() {
		return maxDisk;
	}	

	@Override
	public Boolean resetRBits() {
		if (this.isRmEnabled()) {
			CacheBox cb = listCacheBox.get(position);
			List<Cache> ram = cb.getRam();
			for (Cache cache : ram) {
				cache.addRPrevious(cache.getR());
				cache.setR(0);
			}
			this.updateViews();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Boolean setMBit() {
		if (this.isRmEnabled()) {
			if (cache != null) {				
				cache.addRPrevious(cache.getR());
				cache.addMPrevious(cache.getM());
				cache.setR(1);
				cache.setM(1);
			}
			this.updateViews();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Boolean isRmVisible() {
		if ((strategy == EnumPagingStrategy.NRU_RNU) || (strategy == EnumPagingStrategy.NRU_RNU_SECOND_CHANCE)) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public Boolean isRmEnabled() {
		if (this.isRmVisible() && (position > -1) && (position < listCacheBox.size())) {
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
	public Integer getErrorCount() {
		return errorCount;
	}

	@Override
	public Color getColor() {		
		if (surface == EnumSurface.COLORED) {
			return Color.RED;
		} else {
			return Color.BLACK;
		}
	}

	@Override
	public Boolean isViewOldStatesEnabled() {
		return oldStates;
	}

	@Override
	public void setViewOldStatesEnabled(Boolean value) {
		if (value != null) {
			oldStates = value;
			this.updateViews();
		}
	}	

	@Override
	public String getTitle() {
		return "Seitenersetzungsstrategien";
	}

	@Override
	protected void showErrorMessage() {
		
	}

	@Override
	protected void updateSize() {
		
	}

	@Override
	protected void create() {
		
	}
	
	@Override
	protected EnumAutomaticChecked keepAutomaticChecked() {
		return EnumAutomaticChecked.CHOICE;
	}

	@Override
	protected void createToolTipManager() {
		this.tooltip = new ToolTipManagerPagingImpl();
	}
}