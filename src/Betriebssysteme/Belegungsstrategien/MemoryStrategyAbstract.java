/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.util.ArrayList;
import java.util.List;

public abstract class MemoryStrategyAbstract implements MemoryStrategy {

	public MemoryStrategyAbstract(List<Space> example) {
		try {
			if (example == null) {
				throw new NullPointerException();
			}
			listSpaceWork = example;
			copyListSpace();
			init();
		} catch (Exception ex) {
			throw ex;
		}		
	}	
	
	protected final Integer START = 0;
	
	protected List<Space> listSpaceWork = new ArrayList<Space>();
	protected List<Space> listSpacePublic = new ArrayList<Space>();
	protected Integer number = 0;
		
	protected Integer start = START;
	protected Integer position = start;
	protected Boolean isFirst = true;
	
	protected Boolean executionOK = true;
	
	protected EnumMemoryStatus status;
	protected Boolean suitable = false;
	
	protected abstract void inputOK();	
	protected abstract void finishNotFit();
	protected abstract Integer getPos();	
	protected abstract void finishChoose();
	protected abstract void initStrategy();
	protected abstract Boolean checkSpaceSuitability(Integer number, Integer value);
	
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
	
	protected SpaceEmpty findNextFreeSpace() {
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
		
	protected void finishFit() {
		status = EnumMemoryStatus.CHOOSE;
		hideNegativeRestValues();
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
	
	protected void search() {		
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
	
	protected void choose() {		
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
				status = EnumMemoryStatus.FINISHED;	
			}					
		}
	}	
	
	protected void init() {		
		status = EnumMemoryStatus.INPUT;		
		number = 0;
		start = START;
		position = start;
		isFirst = true;
		initStrategy();		
		copyListSpace();
	}
	
	@Override
	public EnumMemoryStatus getStatus() {
		return status;
	}
	
	@Override
	public List<Space> getListSpace() {
		return new ArrayList<Space>(listSpacePublic);
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
			if (status == EnumMemoryStatus.INPUT) {
				number = value;
				inputOK();
				this.setNewValue(value);
				status = EnumMemoryStatus.SEARCH;
			} else {
				//status = EnumMemoryStatus.INPUT;
			}
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	
	
	@Override
	public Boolean execute() {
		if (listSpaceWork != null) {
			this.deactivateValues();
			if (status == EnumMemoryStatus.SEARCH) {				
				search();
			} else if (status == EnumMemoryStatus.CHOOSE) {
				choose();				
			} else if (status == EnumMemoryStatus.FINISHED) {				
				status = EnumMemoryStatus.INPUT;
				executionOK = true;
			}
		}
		copyListSpace();
		return executionOK;
	}
}
