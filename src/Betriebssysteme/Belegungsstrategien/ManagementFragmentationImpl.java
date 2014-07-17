/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

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
	
	private MemoryStrategy memStrategy;
		
	private void init() {
		memStrategy = null;
	}	
	
	@Override
	public EnumMemoryStrategy getStrategy() {
		if (memStrategy != null) {
			return memStrategy.getStrategy();
		} else {
			return EnumMemoryStrategy.NULL;
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
			if ((memStrategy != null) && (memStrategy.getStatus() == EnumMemoryStatus.INPUT)) {
				memStrategy.inputNumber(value);
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
		if (memStrategy != null) {
			return memStrategy.getStatus();
		} else {
			return EnumMemoryStatus.START;
		}		
	}
	
	@Override
	protected Boolean executeAutomatic() {
		if (memStrategy != null) {
			Boolean result = memStrategy.execute();
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
		if (memStrategy != null) {
			return memStrategy.getListSpace();
		} else {
			return new ArrayList<Space>();
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
		Integer total = getTotalSpace();
		int t = total.intValue();
		if (t <= 0) {
			return 0.0;
		} else {
			Integer used = getUsedSpace();
			Double rate = (((double) used) * 100.0) / ((double) total); 
			return rate;		
		}		
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
		// nothing
	}

	private List<Space> getGeneralStorage(List<Integer> list) {
		List<Space> listSpace = new ArrayList<Space>();
		try {
			// teste Zahlen
			for (Integer number : list) {
				int x = number.intValue();
				if (x <= 0) {
					throw new IllegalArgumentException();
				}
			}
			for (Integer i = 0; i < list.size(); i++) {
				int j = i.intValue();
				Space space;
				if (j > 0) {
					space = new SpaceFullImpl(1);
					listSpace.add(space);					
				}
				Integer number = list.get(i);
				space = new SpaceEmptyImpl(number);
				listSpace.add(space);
			}
		} catch (Exception ex) {
			throw ex;
		}		
		return listSpace;
	}

	@Override
	public void assume(EnumMemoryStrategy strategy, List<Integer> list) {
		if ((strategy == null) || (list == null)) {
			throw new NullPointerException();
		}
		if ((strategy == EnumMemoryStrategy.NULL) || (list.size() <= 0)) {
			throw new IllegalArgumentException();
		}
		List<Space> listSpace = this.getGeneralStorage(list);		
		memStrategy = MemoryStrategyFactory.getStrategy(strategy, listSpace);
		updatePanelMain();
	}		
}
