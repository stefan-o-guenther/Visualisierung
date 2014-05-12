/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Base.ManagementAutomaticAbstract;

public class ManagementFragmentationImpl extends ManagementAutomaticAbstract implements ManagementFragmentation {

	public ManagementFragmentationImpl() {
		super();
		init();
		update();
	}	
	
	private MemoryStrategy strategy;
	
	
	private void init() {
		strategy = null;		
	}
	
	private List<Space> loadExample() {
		List<Space> listSpaceExample = new ArrayList<Space>();
		listSpaceExample.add(new SpaceImpl(10, EnumSpace.EMPTY));
		listSpaceExample.add(new SpaceImpl(1, EnumSpace.FULL));
		listSpaceExample.add(new SpaceImpl(4, EnumSpace.EMPTY));
		listSpaceExample.add(new SpaceImpl(1, EnumSpace.FULL));
		listSpaceExample.add(new SpaceImpl(20, EnumSpace.EMPTY));
		listSpaceExample.add(new SpaceImpl(1, EnumSpace.FULL));
		listSpaceExample.add(new SpaceImpl(18, EnumSpace.EMPTY));
		listSpaceExample.add(new SpaceImpl(1, EnumSpace.FULL));
		listSpaceExample.add(new SpaceImpl(7, EnumSpace.EMPTY));
		listSpaceExample.add(new SpaceImpl(1, EnumSpace.FULL));
		listSpaceExample.add(new SpaceImpl(9, EnumSpace.EMPTY));
		listSpaceExample.add(new SpaceImpl(1, EnumSpace.FULL));
		listSpaceExample.add(new SpaceImpl(12, EnumSpace.EMPTY));
		listSpaceExample.add(new SpaceImpl(1, EnumSpace.FULL));
		listSpaceExample.add(new SpaceImpl(15, EnumSpace.EMPTY));
		listSpaceExample.add(new SpaceImpl(1, EnumSpace.FULL));
		listSpaceExample.add(new SpaceImpl(8, EnumSpace.EMPTY));
		return listSpaceExample;
	}
	
	@Override
	public EnumMemoryStrategy getStrategy() {
		if (strategy != null) {
			return strategy.getStrategy();
		} else {
			return EnumMemoryStrategy.NULL;
		}		
	}

	@Override
	public void setStrategy(EnumMemoryStrategy value) {		
		if (value != null) {
			List<Space> example = loadExample();
			strategy = MemoryStrategyFactory.getStrategy(value, example);
			strategy.init();
			update();			
		}		
	}

	@Override
	public Integer getNumber() {
		if (strategy != null) {
			return strategy.getNumber();
		} else {
			return null;
		}		
	}

	@Override
	public void setNumber(Integer value) {
		if ((strategy != null) && (strategy.getStatus() == EnumMemoryStatus.INPUT) && (value != null) && (value > 0)) {
			strategy.setNumber(value);
			isAutomaticChecked = false;
			isAutomaticRunning = false;
			update();
		}
	}

	@Override
	public EnumMemoryStatus getStatus() {
		if (strategy != null) {
			return strategy.getStatus();
		} else {
			return EnumMemoryStatus.START;
		}		
	}
	
	@Override
	public Boolean execute() {
		if (strategy != null) {
			Boolean result = strategy.execute();
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
	public List<Space> getListSpace() {
		if (strategy != null) {
			return strategy.getListSpace();
		} else {
			return this.loadExample();
		}
	}

	private Color getColorEmpty() {
		return Color.WHITE;		
	}

	private Color getColorUsed() {
		switch (surface) {
			case COLORED: return new Color(135,206,250);			
			case GRAY: return Color.LIGHT_GRAY;
			default: return null;						
		}
	}

	private Color getColorFull() {
		return Color.BLACK;
	}

	@Override
	public Color getColor(EnumSpace type) {
		switch (type) {
			case EMPTY: return getColorEmpty();
			case USED: return getColorUsed();
			case FULL: return getColorFull();
			default: return null;
		}
	}
	
	@Override
	public Integer getTotalSpace() {
		Integer total = 0;
		List<Space> listSpace = this.getListSpace();
    	for (Space space : listSpace) {
    		Integer value = space.getCurrentValue();
    		total += value;    		   		
    	}
		return total;
	}

	@Override
	public Integer getFreeSpace() {		
    	Integer free = 0;
    	List<Space> listSpace = this.getListSpace();
    	for (Space space : listSpace) {    		 		
    		EnumSpace type = space.getType();
    		if (type == EnumSpace.EMPTY) {
    			Integer value = space.getCurrentValue();   
    			free += value;
    		}    		
    	}
		return free;
	}

	@Override
	public Integer getUsedSpace() {		
    	Integer used = 0;
    	List<Space> listSpace = this.getListSpace();
    	for (Space space : listSpace) {    		
    		EnumSpace type = space.getType();
    		if ((type == EnumSpace.FULL) || (type == EnumSpace.USED)) {
    			Integer value = space.getCurrentValue();
    			used += value;
    		}
    	}
		return used;
	}

	@Override
	public Double getUsedRate() {
		Integer used = getUsedSpace();
		Integer total = getTotalSpace();
		Double rate = (((double) used) * 100.0) / ((double) total); 
		return rate;
	}

	@Override
	public String getTitle() {
		return "Belegungsstrategien";
	}
}
