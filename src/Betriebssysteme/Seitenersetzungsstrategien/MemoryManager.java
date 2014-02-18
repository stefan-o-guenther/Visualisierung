/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Base.BaseManagement;
import Base.EnumSurface;

public class MemoryManager extends BaseManagement implements IMemoryManager {	
	
	public MemoryManager() {
		super();
		init();
		update();
	}	
	
	private IReplacementStrategy strategy;	
	
	private void init() {		
		strategy = null;
	}	
	
	@Override
	public EnumPagingStrategy getStrategy() {
		if (strategy != null) {
			return strategy.getStrategy();
		} else {
			return EnumPagingStrategy.NULL;
		}		
	}

	@Override
	public void setStrategy(EnumPagingStrategy enumStrategy, List<Integer> listSequence, Integer ram, Integer disk) {
		init();
		if ((enumStrategy != null) && (listSequence != null) && (ram != null) && (disk != null)) {
			strategy = ReplacementStrategyFactory.getStrategy(enumStrategy, listSequence, ram, disk);
			update();
		}
	}	

	@Override
	public void execute() {		
		if ((strategy != null) && (strategy.getStatus() == EnumPagingStatus.SEARCH)) {
			strategy.execute();
			update();
		}		
	}	
	
	@Override
	public EnumPagingStatus getStatus() {
		if (strategy != null) {
			return strategy.getStatus();
		} else {
			return EnumPagingStatus.START;
		}		
	}

	@Override
	public List<ICacheBox> getListCache() {
		if (strategy != null) {
			return strategy.getListCache();
		} else {
			return new ArrayList<ICacheBox>();
		}
	}


	@Override
	public Integer getMaxRam() {
		if (strategy != null) {
			return strategy.getMaxRam();
		} else {
			return 0;
		}
	}

	
	@Override
	public Integer getMaxDisk() {
		if (strategy != null) {
			return strategy.getMaxDisk();
		} else {
			return 0;
		}
	}	

	@Override
	public void resetRBits() {
		if ((strategy != null) && (strategy.useRM())) {
			strategy.resetRBits();
			update();
		}		
	}

	@Override
	public void setMBit() {
		if ((strategy != null) && (strategy.useRM())) {
			strategy.setMBit();
			update();
		}		
	}

	@Override
	public void reset() {
		init();
		update();
	}

	@Override
	public Boolean useRM() {
		if (strategy != null) {
			return strategy.useRM();
		} else {
			return false;
		}
	}

	@Override
	public Integer getErrorCount() {
		if (strategy != null) {
			return strategy.getErrorCount();
		} else {
			return 0;
		}
	}

	@Override
	public Color getColor() {		
		if (surface == EnumSurface.COLORED) {
			return Color.RED;
		} else {
			return Color.BLACK;
		}
	}
}