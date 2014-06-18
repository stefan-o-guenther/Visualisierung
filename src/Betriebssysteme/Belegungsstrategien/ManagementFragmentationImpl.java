/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Base.ManagementAutomaticAbstract;
import Base.MessageBox;

public class ManagementFragmentationImpl extends ManagementAutomaticAbstract implements ManagementFragmentation {

	public ManagementFragmentationImpl() {
		super();
		init();
		updatePanelMain();
	}	
	
	private MemoryStrategy strategy;	
	
	private void init() {
		strategy = null;		
	}
	
	private List<Space> loadExample() {
		List<Space> listSpaceExample = new ArrayList<Space>();
		listSpaceExample.add(new SpaceEmptyImpl(10));
		listSpaceExample.add(new SpaceFullImpl(1));
		listSpaceExample.add(new SpaceEmptyImpl(4));
		listSpaceExample.add(new SpaceFullImpl(1));
		listSpaceExample.add(new SpaceEmptyImpl(20));
		listSpaceExample.add(new SpaceFullImpl(1));
		listSpaceExample.add(new SpaceEmptyImpl(18));
		listSpaceExample.add(new SpaceFullImpl(1));
		listSpaceExample.add(new SpaceEmptyImpl(7));
		listSpaceExample.add(new SpaceFullImpl(1));
		listSpaceExample.add(new SpaceEmptyImpl(9));
		listSpaceExample.add(new SpaceFullImpl(1));
		listSpaceExample.add(new SpaceEmptyImpl(12));
		listSpaceExample.add(new SpaceFullImpl(1));
		listSpaceExample.add(new SpaceEmptyImpl(15));
		listSpaceExample.add(new SpaceFullImpl(1));
		listSpaceExample.add(new SpaceEmptyImpl(8));
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
		try {
			if (value == null) {
				throw new NullPointerException();
			}
			if (value == EnumMemoryStrategy.NULL) {
				throw new IllegalArgumentException();
			}
			List<Space> example = loadExample();
			strategy = MemoryStrategyFactory.getStrategy(value, example);
			updatePanelMain();		
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@Override
	public void inputNumber(Integer value) {
		try {
			if (value == null) {
				throw new NullPointerException();
			}
			if (value <= 0) {
				throw new IllegalArgumentException();
			}
			if ((strategy != null) && (strategy.getStatus() == EnumMemoryStatus.INPUT)) {
				strategy.inputNumber(value);
				this.setAutomaticChecked(false);
				this.setAutomaticRunning(false);
				isAutomaticChecked = false;
				isAutomaticRunning = false;
				updatePanelMain();
			}
			
		} catch (Exception ex) {
			throw ex;
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
	public List<Space> getListSpace() {
		if (strategy != null) {
			return strategy.getListSpace();
		} else {
			return this.loadExample();
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

	@Override
	public void showErrorMessage() {
		MessageBox.showErrorMessage("Keinen passenden freien Speicher gefunden!");
	}
	
	@Override
	public Boolean isAutomaticEnabled() {
		EnumMemoryStatus status = this.getStatus();
		if (status == EnumMemoryStatus.SEARCH) {
			return true;
		} else if (status == EnumMemoryStatus.CHOOSE) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	protected void updateSize() {
		// TODO Auto-generated method stub
		
	}	
}
