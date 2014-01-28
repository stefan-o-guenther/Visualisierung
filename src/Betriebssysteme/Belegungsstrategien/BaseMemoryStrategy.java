/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseMemoryStrategy implements IMemoryStrategy {

	protected final Integer START = 0;
	
	protected List<ISpace> listSpaceWork = new ArrayList<ISpace>();
	protected List<ISpace> listSpacePublic = new ArrayList<ISpace>();
	protected Integer number = 0;
		
	protected Integer start = START;
	protected Integer position = start;
	protected Boolean first = true;
	
	protected Boolean executionOK = true;
	
	protected EnumMemoryStatus status;
	protected Boolean suitable = false;
	
	protected abstract void inputOK();
	
	protected void copyListSpace() {
		listSpacePublic = new ArrayList<ISpace>(listSpaceWork);
	}
	
	protected BaseMemoryStrategy(List<ISpace> example) {
		if (example != null) {
			listSpaceWork = example;
			copyListSpace();
		}
		init();
	}
	
	protected void deleteNegativeRestValues() {
		if (listSpaceWork != null) {
			for (ISpace sp : listSpaceWork) {
				Integer value = sp.getRestValue();
				if ((value != null) && (value < 0)) {
					sp.setRestValue(null);
				}
			}
		}
	}
	
	protected ISpace findNextFreeSpace() {
		ISpace space = null;		
		if (listSpaceWork != null) {
			Integer size = listSpaceWork.size();
			Boolean notFinished = true;		
			while (notFinished) {
				if (first) {
					first = false;
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
		return space;
	}
	
	protected abstract Boolean isSuitableSpace(Integer number, Integer value);
	protected abstract void finishNotFit();
		
	protected void finishFit() {
		status = EnumMemoryStatus.CHOOSE;
		deleteNegativeRestValues();
	}
	
	protected void search() {
		executionOK = false;
		if ((number != null) && (number > 0)) {
			if (suitable) {
				executionOK = true;
				suitable = false;
				finishFit();
			} else {
				ISpace space = this.findNextFreeSpace();
				if (space != null) {
					space.activate(true);
					space.setNewValue(number);
					Integer value = space.getCurrentValue();
					space.setRestValue(value - number);
					suitable = isSuitableSpace(number, value);
					executionOK = true;				
				} else {					
					finishNotFit();										
				}
			}
		} else {
			executionOK = true;
		}
	}

	protected abstract Integer getPos();	
	protected abstract void finishChoose();
	
	protected void choose() {		
		if ((position != null) && (position >= 0) && (listSpaceWork != null)) {			
			for (ISpace sp : listSpaceWork) {		
				sp.setRestValue(null);
			}
			Integer pos = getPos();
			ISpace space = listSpaceWork.get(pos);
			Integer value = space.getCurrentValue();		
			if (space.getType() == EnumSpace.EMPTY) {
				if (value > number) {
					ISpace newSpace = new Space(number, EnumSpace.USED);
					space.setCurrentValue(value - number);
					listSpaceWork.add(pos, newSpace);
				} else if (value.equals(number)) {
					space.setType(EnumSpace.USED);
				}
			}			
			finishChoose();
			executionOK = true;
			status = EnumMemoryStatus.FINISHED;			
		}
	}
	
	protected abstract void initStrategy();
	
	public BaseMemoryStrategy() {
		
	}
	
	@Override
	public void init() {		
		status = EnumMemoryStatus.INPUT;		
		number = 0;
		start = START;
		position = start;
		first = true;
		initStrategy();		
		copyListSpace();
	}
	
	@Override
	public EnumMemoryStatus getStatus() {
		return status;
	}
	
	@Override
	public List<ISpace> getListSpace() {
		return listSpacePublic;
	}
		
	@Override
	public void setNumber(Integer value) {
		if ((value != null) && (value > 0) && (status == EnumMemoryStatus.INPUT)) {
			number = value;
			inputOK();
			status = EnumMemoryStatus.SEARCH;
		} else {
			status = EnumMemoryStatus.INPUT;
		}
	}
	
	@Override
	public Integer getNumber() {
		return number;
	}
		
	@Override
	public Boolean execute() {
		if (listSpaceWork != null) {
			for (ISpace sp : listSpaceWork) {
				sp.activate(false);
				sp.setNewValue(null);				
			}
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
