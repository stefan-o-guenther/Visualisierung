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

public class ManagementFragmentationImpl extends ManagementAbstract implements ManagementFragmentation {

	public ManagementFragmentationImpl() {
		super();
		
	}		
	
	private final Integer START = 0;
	
	private List<Space> listSpaceWork;
	private List<Space> listSpacePublic;
	private Integer number;
		
	private Integer start;
	private Integer position;
	private Boolean isFirst;
	
	private Boolean executionOK;
	
	private EnumMemoryStrategy strategy;
	
	private EnumMemoryStatus statusMemory;
	private EnumVisualizationStatus status;
	
	private Boolean suitable;
	
	private Integer zBestWorst;
	private Integer pBestWorst;
	
	@Override
	protected void initialize() {
		status = EnumVisualizationStatus.START;
		strategy = EnumMemoryStrategy.NULL;
		number = 0;
		start = START;
		position = start;
		isFirst = true;
		executionOK = true;
		zBestWorst = null;
		pBestWorst = START;
		suitable = false;
		listSpaceWork = new ArrayList<Space>();
		this.copyListSpace();		
	}
		
	private void inputOK() {
		if (strategy != EnumMemoryStrategy.NULL) {
			if (strategy != EnumMemoryStrategy.NEXT_FIT) {
				start = START;
			}
			position = start;
			isFirst = true;
		}
	}
	
	private void finishNotFit() {
		if (strategy != EnumMemoryStrategy.NULL) {
			finishFit();
			if (zBestWorst != null) {
				executionOK = true;
			} else {
				executionOK = false;
				finish();
			}			
		}
	}
	
	private Integer getPos() {
		if (strategy == EnumMemoryStrategy.NULL) {
			throw new NullPointerException();
		}
		if (zBestWorst != null) {
			return pBestWorst;
		} else {
			return position;
		}
	}
		
	private void finishChoose() {
		if (strategy == EnumMemoryStrategy.NULL) {
			throw new NullPointerException();
		}
		if (strategy == EnumMemoryStrategy.NEXT_FIT) {
			start = position;
		} else {
			start = START;
		}
		position = start;
		zBestWorst = null;
		pBestWorst = START;
	}
	
	private void checkIfBest(Integer value) {
		try {
			if (value == null) {
				throw new NullPointerException();
			}
			int ival = value.intValue();
			if (ival < 0) {
				throw new IllegalArgumentException();
			}
			if ((zBestWorst == null) || (ival < zBestWorst.intValue())) {
				zBestWorst = value;
				pBestWorst = position;
				
			}
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	private void checkIfWorst(Integer value) {
		try {
			if (value == null) {
				throw new NullPointerException();
			}
			if (value < 0) {
				throw new IllegalArgumentException();
			}
			if ((zBestWorst == null) || (value > zBestWorst)) {									
				zBestWorst = value;
				pBestWorst = position;
			}
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	private Boolean isSuitableSpace(Integer number, Integer value) {
		try {
			if ((number == null) || (value == null)) {
				throw new NullPointerException();
			}
			int inumber = number.intValue();
			int ivalue = value.intValue();
			if ((inumber < 0) || (ivalue < 0)) {
				throw new IllegalArgumentException();
			}
			if (ivalue >= inumber) {
				if (ivalue == inumber) {
					return true;									
				} else {
					return false;
				}			
			} else {
				return false;
			}
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	private Boolean checkSpaceSuitability(Integer number, Integer value) {
		if (strategy == EnumMemoryStrategy.NULL) {
			throw new NullPointerException();
		} else if (strategy == EnumMemoryStrategy.BEST_FIT) {
			this.checkIfBest(value);
			return this.isSuitableSpace(number, value);
		} else if (strategy == EnumMemoryStrategy.WORST_FIT) {
			this.checkIfWorst(value);
			return false;
		} else if (strategy == EnumMemoryStrategy.SCHNEIDERINNEN_BEST_FIT) {		
			this.checkIfWorst(value);
			if (this.isSuitableSpace(number, value)) {
				this.checkIfBest(value);
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}
	
	@Override
	public EnumMemoryStrategy getStrategy() {
		return strategy;
	}
	
	private void hideNegativeRestValues() {
		if (listSpaceWork != null) {
			for (Space space : listSpaceWork) {
				if (space.getType() == EnumSpace.EMPTY) {
					SpaceEmpty spaceE = (SpaceEmpty) space;
					if (spaceE.getRestValue() < 0) {
						spaceE.showRestValue(false);
					}
				}
			}
		}
	}
	
	private void deactivateValues() {
		if (listSpaceWork != null) {
			for (Space space : listSpaceWork) {
				if (space.getType() == EnumSpace.EMPTY) {
					SpaceEmpty spaceE = (SpaceEmpty) space;
					spaceE.activate(false);
				}
			}
		}
	}
	
	private void hideNewValues() {
		if (listSpaceWork != null) {
			for (Space space : listSpaceWork) {
				if (space.getType() == EnumSpace.EMPTY) {
					SpaceEmpty spaceE = (SpaceEmpty) space;
					spaceE.showNewValue(false);
				}				
			}
		}
	}
	
	private void hideRestValues() {
		if (listSpaceWork != null) {
			for (Space space : listSpaceWork) {	
				if (space.getType() == EnumSpace.EMPTY) {
					SpaceEmpty spaceE = (SpaceEmpty) space;
					spaceE.showRestValue(false);
				}				
			}
		}
	}
	
	private void search() {		
		executionOK = false;
		this.hideNewValues();
		if ((number != null) && (number > 0)) {
			if (suitable) {
				executionOK = true;
				suitable = false;
				finishFit();
			} else {
				SpaceEmpty spaceE = this.findNextFreeSpace();
				if (spaceE != null) {
					spaceE.activate(true);
					spaceE.showNewValue(true);
					Integer value = spaceE.getCurrentValue();
					spaceE.showRestValue(true);
					suitable = checkSpace(number, value);
					executionOK = true;				
				} else {					
					finishNotFit();										
				}
			}
		} else {
			executionOK = true;
		}
	}
	
	private Boolean checkSpace(Integer number, Integer value) {
		try {
			if ((number == null) || (value == null)) {
				throw new NullPointerException();
			}
			int inumber = number.intValue();
			int ivalue = value.intValue();
			if ((inumber < 0) || (ivalue < 0)) {
				throw new IllegalArgumentException();
			}
			if (inumber <= ivalue) {
				return suitable = checkSpaceSuitability(number, value);
			} else {
				return false;
			}
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	private SpaceEmpty findNextFreeSpace() {
		Space space = null;		
		if (listSpaceWork != null) {
			Integer size = listSpaceWork.size();
			Boolean notFinished = true;		
			while (notFinished) {
				if (isFirst) {
					isFirst = false;
				} else {
					position = (position + 1) % size;
					if (position.equals(start)) {
						notFinished = false;
					}
				}
				if (notFinished) {
					space = listSpaceWork.get(position);				
					if (space.getType() != EnumSpace.EMPTY) {
						space = null;
					} else {
						notFinished = false;
					}
				}				
			}
		}		
		return (SpaceEmpty) space;
	}
	
	private Boolean hasEmptySpace() {
		if (listSpaceWork != null) {
			for (Space space : listSpaceWork) {
				if (space.getType() == EnumSpace.EMPTY) {
					return true;
				}
			}
			return false;			
		} else {
			return false;
		}
	}
	
	private void finish() {
		if (hasEmptySpace()) {
			status = EnumVisualizationStatus.NEXT;
		} else {
			status = EnumVisualizationStatus.FINISHED;	
		}
		this.stopAutomatic();
	}
	
	private void finishFit() {
		status = EnumVisualizationStatus.RUN;
		statusMemory = EnumMemoryStatus.CHOOSE;
		hideNegativeRestValues();
	}
	
	private void choose() {		
		this.hideRestValues();
		if ((position != null) && (position >= 0) && (listSpaceWork != null)) {				
			Integer pos = getPos();
			Integer size = listSpaceWork.size();
			if (pos < size) {
				Space space = listSpaceWork.get(pos);
				Integer value = space.getCurrentValue();		
				if (space.getType() == EnumSpace.EMPTY) {
					Space newSpace = new SpaceUsedImpl(number);
					listSpaceWork.add(pos, newSpace);
					if (value > number) {					
						space.setCurrentValue(value - number);						
					} else if (value.equals(number)) {
						listSpaceWork.remove(space);
					}
				}			
				finishChoose();
				executionOK = true;
				finish();
			}					
		}
	}
	
	private void setNewValue(Integer newValue) {
		try {
			if (newValue == null) {
				throw new NullPointerException();
			}
			if (listSpaceWork != null) {
				for (Space space : listSpaceWork) {
					if (space.getType() == EnumSpace.EMPTY) {
						SpaceEmpty spaceE = (SpaceEmpty) space;
						spaceE.setNewValue(newValue);
						spaceE.showNewValue(false);
						spaceE.showRestValue(false);
					}		
				}
			}
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
			if ((strategy != EnumMemoryStrategy.NULL) && (status == EnumVisualizationStatus.INPUT)) {
				number = value;
				inputOK();
				this.setNewValue(value);
				status = EnumVisualizationStatus.RUN;
				statusMemory = EnumMemoryStatus.SEARCH;
				this.updateViews();
			}			
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public EnumVisualizationStatus getStatus() {
		return status;	
	}
	
	@Override
	protected Boolean execute() {
		if (strategy != EnumMemoryStrategy.NULL) {
			if (listSpaceWork != null) {
				this.deactivateValues();
				if (status == EnumVisualizationStatus.RUN) {
					if (statusMemory == EnumMemoryStatus.SEARCH) {				
						search();
					} else if (statusMemory == EnumMemoryStatus.CHOOSE) {
						choose();
					}
				} else if (status == EnumVisualizationStatus.NEXT) {				
					status = EnumVisualizationStatus.INPUT;
					executionOK = true;
				} else if (status == EnumVisualizationStatus.FINISHED) {
					executionOK = true;
				}
			}
			copyListSpace();
			this.updateViews();
			return executionOK;			
		} else {
			return false;
		}		
	}
	
	@Override
	public List<Space> getListSpace() {
		return new ArrayList<Space>(listSpacePublic);
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
	
	private void copyListSpace() {
		listSpacePublic = new ArrayList<Space>(listSpaceWork);
	}
	
	@Override
	public void assume(EnumMemoryStrategy strategy, List<Integer> list) {
		try {
			if ((strategy == null) || (list == null)) {
				throw new NullPointerException();
			}
			if ((strategy == EnumMemoryStrategy.NULL) || (list.size() <= 0)) {
				throw new IllegalArgumentException();
			}
			this.strategy = strategy;
			this.listSpaceWork = this.getGeneralStorage(list);		
			copyListSpace();
			status = EnumVisualizationStatus.INPUT;			
			this.updateViews();		
		} catch (Exception ex) {
			throw ex;
		}
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
		tooltip = new ToolTipManagerFragmentationImpl();
	}
}
