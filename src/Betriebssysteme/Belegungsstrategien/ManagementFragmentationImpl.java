/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.util.ArrayList;
import java.util.List;

import Base.EnumAutomaticChecked;
import Base.EnumVisualizationStatus;
import Base.ManagementAbstract;
import Base.MessageBox;
import Base.ToolTipManager;

public class ManagementFragmentationImpl extends ManagementAbstract implements ManagementFragmentation {

    private static ManagementFragmentation instance = new ManagementFragmentationImpl();
    
    private ManagementFragmentationImpl() {
    	super();
    }
 
    public static ManagementFragmentation getInstance() {
    	return instance;
    }
    
    private MemoryStrategy memStrategy;
    
    @Override
	protected void initialize() {
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
			if ((memStrategy != null) && (this.getStatus() == EnumVisualizationStatus.INPUT)) {
				memStrategy.inputNumber(value);
				this.updateViews();
			}			
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	protected Boolean execute() {
		if (memStrategy != null) {
			Boolean result = memStrategy.execute();
			this.updateViews();
			return result;
		} else {
			return false;
		}
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
	public Double getFreeSpaceRate() {
		Integer total = getTotalSpace();
		int t = total.intValue();
		if (t <= 0) {
			return 0.0;
		} else {
			Integer free = getFreeSpace();
			Double rate = (((double) free) * 100.0) / ((double) total); 
			return rate;		
		}		
	}
	
	@Override
	public Double getUsedSpaceRate() {
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
	protected void showErrorMessage() {
		MessageBox.showErrorMessage("Keinen passenden freien Speicher gefunden!");
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
				if (i.intValue() > 0) {
					listSpace.add(SpaceFactory.getSpaceFullOne());					
				}
				Integer number = list.get(i);
				listSpace.add(SpaceFactory.getSpaceEmpty(number));
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
		this.updateViews();
	}

	@Override
	protected void create() {
		
	}

	@Override
	protected EnumAutomaticChecked keepAutomaticChecked() {
		return EnumAutomaticChecked.CHOICE;
	}
	
	@Override
	public ToolTipManager getToolTipManager() {
		return ToolTipManagerFragmentationImpl.getInstance();
	}
}
