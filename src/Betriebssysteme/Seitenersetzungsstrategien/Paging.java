/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Base.BaseManagement;
import Base.EnumSurface;

public class Paging extends BaseManagement implements IPaging {	
	
	public Paging() {
		super();
		init();
		update();
	}	
	
	private IReplacementStrategy strategy;
	private Boolean oldStates; 
	
	private void init() {		
		strategy = null;
		oldStates = true;
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
	public Boolean execute() {		
		if ((strategy != null) && (strategy.getStatus() == EnumPagingStatus.SEARCH)) {
			strategy.execute();
			update();
		}
		return true;
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
			return strategy.getListCacheBox();
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
	public Boolean resetRBits() {
		if ((strategy != null) && (strategy.useRM())) {
			Boolean result = strategy.resetRBits();
			update();
			return result;
		} else {
			return false;
		}
	}

	@Override
	public Boolean setMBit() {
		if ((strategy != null) && (strategy.useRM())) {
			Boolean result = strategy.setMBit();
			update();
			return result;
		} else {
			return false;
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

	@Override
	public Boolean canViewOldStates() {
		return oldStates;
	}

	@Override
	public void setViewOldStates(Boolean value) {
		if (value != null) {
			oldStates = value;
			update();
		}
	}

	@Override
	public Boolean canUseRM() {
		if (strategy != null) {
			return strategy.canUseRM();
		} else {
			return false;
		}
	}
}