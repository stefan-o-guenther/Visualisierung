/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Base.ManagementAbstract;
import Base.EnumSurface;

public class ManagementPagingImpl extends ManagementAbstract implements ManagementPaging {	
	
	public ManagementPagingImpl() {
		super();
		init();
		updatePanelMain();
	}	
	
	private ReplacementStrategy strategy;
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
			updatePanelMain();
		}
	}	

	@Override
	public Boolean execute() {		
		if ((strategy != null) && (strategy.getStatus() == EnumPagingStatus.SEARCH)) {
			strategy.execute();
			updatePanelMain();
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
	public List<CacheBox> getListCache() {
		if (strategy != null) {
			return strategy.getListCacheBox();
		} else {
			return new ArrayList<CacheBox>();
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
			updatePanelMain();
			return result;
		} else {
			return false;
		}
	}

	@Override
	public Boolean setMBit() {
		if ((strategy != null) && (strategy.useRM())) {
			Boolean result = strategy.setMBit();
			updatePanelMain();
			return result;
		} else {
			return false;
		}
	}

	@Override
	public void reset() {
		init();
		updatePanelMain();
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
			updatePanelMain();
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

	@Override
	public String getTitle() {
		return "Seitenersetzungsstrategien";
	}

	@Override
	public void showErrorMessage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void updateSize() {
		// TODO Auto-generated method stub
		
	}
}