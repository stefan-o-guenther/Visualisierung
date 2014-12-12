/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.util.ArrayList;
import java.util.List;

import Base.Checker;
import Base.EnumVisualizationStatus;
import Base.ManagementFactory;

public abstract class MemoryStrategyAbstract implements MemoryStrategy {

	public MemoryStrategyAbstract(List<Space> example) {
		try {
			Checker.checkIfNotNull(example);
			listSpaceWork = example;
			start = START;
			position = START;
			copyListSpace();			
			initialize();
		} catch (Exception ex) {
			throw ex;
		}		
	}	
	
	protected final Integer START = 0;
	
	private Integer position;
	private EnumMemoryStatus status;
	private Integer start;
	private Integer number;	
	
	protected List<Space> listSpaceWork;
	protected List<Space> listSpacePublic;
	
	
	protected Integer getNumber() {
		return number;
	}
	
	protected void setNumber(Integer number) {
		try {
			Checker.checkIfIntegerNotLessZero(number);
			this.number = number;
		} catch (Exception ex) {
			throw ex;
		}
	}	
	
	protected Integer getStart() {
		return start;
	}
	
	protected void setStart(Integer start) {
		try {
			Checker.checkIfNotNull(start);
			this.start = start;
		} catch (Exception ex) {
			throw ex;
		}
	}		
	
	protected Integer getPosition() {
		return position;
	}
	
	protected void setPosition(Integer position) {
		try {
			Checker.checkIfNotNull(position);
			this.position = position;
		} catch (Exception ex) {
			throw ex;
		}
	}	
	
	private Boolean isFirst;
	
	protected void resetIsFirst() {
		this.isFirst = true;
	}
	
	protected abstract Boolean finishNotFit();
	protected abstract Integer getChosenPosition();	
	
	protected abstract Boolean isSpaceSuitable(Integer number, Integer value);
	
	protected abstract void initialize();
	
	protected void copyListSpace() {
		listSpacePublic = new ArrayList<Space>(listSpaceWork);
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
	
	private void setNewValue(Integer newValue) {
		try {
			Checker.checkIfNotNull(newValue);
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
	
	protected SpaceEmpty findNextFreeSpace() {
		Space space = null;		
		if (listSpaceWork != null) {
			Integer size = listSpaceWork.size();
			Boolean notFinished = true;		
			while (notFinished) {
				if (isFirst) {
					isFirst = false;
				} else {
					Integer pos = (this.getPosition() + 1) % size;
					this.setPosition(pos);
					if (pos.intValue() == start.intValue()) {
						notFinished = false;
					}
				}
				if (notFinished) {
					space = listSpaceWork.get(this.getPosition());				
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
		
	protected void finishFit() {
		status = EnumMemoryStatus.CHOOSE;
		hideNegativeRestValues();
	}
	
	private Boolean search() {		
		this.hideNewValues();
		if ((number != null) && (number > 0)) {
			SpaceEmpty spaceE = this.findNextFreeSpace();
			if (spaceE != null) {
				spaceE.activate(true);
				spaceE.showNewValue(true);
				Integer value = spaceE.getCurrentValue();
				spaceE.showRestValue(true);
				if (isSpaceSuitable(number, value)) {
					this.status = EnumMemoryStatus.ADJUST;
				}
				return true;				
			} else {					
				return finishNotFit();
			}
		} else {
			return true;
		}
	}
	
	private Boolean adjust() {
		this.hideNewValues();
		finishFit();
		return true;
	}
	
	private Boolean choose() {		
		this.hideRestValues();
		Integer position = this.getPosition();
		if ((position != null) && (position >= 0) && (listSpaceWork != null)) {				
			Integer pos = getChosenPosition();
			Integer size = listSpaceWork.size();
			if (pos.intValue() < size.intValue()) {
				Space space = listSpaceWork.get(pos);
				Integer value = space.getCurrentValue();		
				if (space.getType() == EnumSpace.EMPTY) {
					Space newSpace = new SpaceUsedImpl(number);
					listSpaceWork.add(pos, newSpace);
					if (value.intValue() > number.intValue()) {					
						space.setCurrentValue(value - number);						
					} else if (value.intValue() == number.intValue()) {
						listSpaceWork.remove(space);
					}
				}				
				initialize();				
				finish();
				return true;
			}					
		}
		return false;
	}	
	
	protected Boolean hasEmptySpace() {
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
	
	protected void finish() {
		ManagementFragmentation fragmentation = ManagementFactory.getManagementFragmentation();
		if (hasEmptySpace()) {
			fragmentation.setStatus(EnumVisualizationStatus.NEXT);
		} else {
			fragmentation.setStatus(EnumVisualizationStatus.FINISHED);
		}		
		fragmentation.setAutomaticPlay(false);
	}
	
	@Override
	public EnumMemoryStatus getStatus() {
		return status;
	}
	
	protected void setStatus(EnumMemoryStatus status) {
		try {
			if (status == null) {
				throw new NullPointerException();
			}
			this.status = status;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@Override
	public List<Space> getListSpace() {
		if (listSpacePublic == null) {
			return new ArrayList<Space>();
		} else {
			return new ArrayList<Space>(listSpacePublic);
		}		
	}
		
	@Override
	public void inputNumber(Integer value) {
		try {
			ManagementFragmentation fragmentation = ManagementFactory.getManagementFragmentation();
			if (fragmentation.getStatus() == EnumVisualizationStatus.INPUT) {
				this.setNumber(value);
				this.setNewValue(value);
				fragmentation.setStatus(EnumVisualizationStatus.RUN);
				status = EnumMemoryStatus.SEARCH;				
			}
		} catch (Exception ex) {
			throw ex;
		}
	}	
	
	@Override
	public Boolean execute() {
		Boolean result = false;
		ManagementFragmentation fragmentation = ManagementFactory.getManagementFragmentation();
		if (listSpaceWork != null) {
			this.deactivateValues();
			if (fragmentation.getStatus() == EnumVisualizationStatus.RUN) {
				if (status == EnumMemoryStatus.SEARCH) {				
					result = search();
				} else if (status == EnumMemoryStatus.CHOOSE) {
					result = choose();
				} else if (status == EnumMemoryStatus.ADJUST) {
					result = adjust();
				}
			} else if (fragmentation.getStatus() == EnumVisualizationStatus.NEXT) {				
				fragmentation.setStatus(EnumVisualizationStatus.INPUT);
				result = true;
			} else if (fragmentation.getStatus() == EnumVisualizationStatus.FINISHED) {				
				result = true;
			}
		}
		copyListSpace();
		return result;
	}
}
