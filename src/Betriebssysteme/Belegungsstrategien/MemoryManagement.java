package Betriebssysteme.Belegungsstrategien;

import java.util.ArrayList;
import java.util.List;

import Base.BaseManagement;

public class MemoryManagement extends BaseManagement implements IMemoryManagement {

	private EnumMemoryStatus status = EnumMemoryStatus.START;
	private EnumMemoryStrategy strategy = EnumMemoryStrategy.NULL;
	private Integer number = 0;
	private List<ISpace> listSpaceWork = new ArrayList<ISpace>();
	private List<ISpace> listSpacePublic = new ArrayList<ISpace>();
	
	private final Integer START = 0;
	private Integer start = START;
	private Integer position = start;
	private Boolean first = true;
	
	private Integer zBestWorst = null;
	private Integer pBestWorst = START;
	
	private Boolean suitable = false;
	
	
	
	private Boolean executionOK = true;
	
	private void copyListSpace() {
		listSpacePublic = new ArrayList<ISpace>(listSpaceWork);
	}
	
	private void init() {
		status = EnumMemoryStatus.START;
		strategy = EnumMemoryStrategy.NULL;
		number = 0;
		start = START;
		position = start;
		first = true;
		zBestWorst = null;
		pBestWorst = START;
				
		listSpaceWork = new ArrayList<ISpace>();
		listSpaceWork.add(new Space(10, EnumSpace.EMPTY));
		listSpaceWork.add(new Space(1, EnumSpace.FULL));
		listSpaceWork.add(new Space(4, EnumSpace.EMPTY));
		listSpaceWork.add(new Space(1, EnumSpace.FULL));
		listSpaceWork.add(new Space(20, EnumSpace.EMPTY));
		listSpaceWork.add(new Space(1, EnumSpace.FULL));
		listSpaceWork.add(new Space(18, EnumSpace.EMPTY));
		listSpaceWork.add(new Space(1, EnumSpace.FULL));
		listSpaceWork.add(new Space(7, EnumSpace.EMPTY));
		listSpaceWork.add(new Space(1, EnumSpace.FULL));
		listSpaceWork.add(new Space(9, EnumSpace.EMPTY));
		listSpaceWork.add(new Space(1, EnumSpace.FULL));
		listSpaceWork.add(new Space(12, EnumSpace.EMPTY));
		listSpaceWork.add(new Space(1, EnumSpace.FULL));
		listSpaceWork.add(new Space(15, EnumSpace.EMPTY));
		listSpaceWork.add(new Space(1, EnumSpace.FULL));
		listSpaceWork.add(new Space(8, EnumSpace.EMPTY));
		
		copyListSpace();
	}
	
	private ISpace findNextFreeSpace() {
		ISpace space = null;
		if (listSpaceWork != null) {
			Integer size = listSpaceWork.size();
			Boolean notFinished = true;		
			while (notFinished) {
				if (first) {
					first = false;
				} else {
					position = (position + 1) % size;
					if (position == start) {
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
	
	private void deleteNegativeRestValues() {
		if (listSpaceWork != null) {
			for (ISpace sp : listSpaceWork) {
				Integer value = sp.getRestValue();
				if ((value != null) && (value < 0)) {
					sp.setRestValue(null);
				}
			}
		}
	}
	
	private void search() {
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
					if (value >= number) {							
						if (isBestWorst()) {
							setBestWorst(value);
							if ((isBestFit()) && (value.equals(number))) {
								suitable = true;									
							}
						} else {
							//finishFit();
							suitable = true;
						}
					} else {
						status = EnumMemoryStatus.SEARCH;
					}
					executionOK = true;
				} else if ((isBestWorst()) && (zBestWorst != null)) {	
					executionOK = true;
					finishFit();
				} else {
					executionOK = false;
					finishFit();
					status = EnumMemoryStatus.FINISHED;							
				}
			}
		} else {
			executionOK = true;
		}
	}
	
	private void choose() {
		if ((position != null) && (position >= 0) && (listSpaceWork != null)) {			
			for (ISpace sp : listSpaceWork) {		
				sp.setRestValue(null);
			}
			Integer pos = 0;
			if ((isBestWorst()) && (zBestWorst != null)) {
				pos = pBestWorst;
			} else {
				pos = position;
			}
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
			if (isNextFit()) {
				start = position;
			} else {
				start = START;
				position = start;
			}			
			if (isBestWorst()) {
				zBestWorst = null;
				pBestWorst = START;
			}
			executionOK = true;
			status = EnumMemoryStatus.FINISHED;
		}
	}
	
	
	
	private void finishFit() {
		status = EnumMemoryStatus.CHOOSE;
		deleteNegativeRestValues();
	}
	
	private void setBestWorst(Integer value) {
		if ((value != null) && (value >= 0)) {
			if ((zBestWorst == null) || ((isBestFit()) && (value < zBestWorst)) || ((isWorstFit()) && (value > zBestWorst))) {									
				zBestWorst = value;
				pBestWorst = position;
			}
		}
	}
	
	private Boolean isFirstFit() {
		return (strategy == EnumMemoryStrategy.FIRST_FIT);
	}
	
	private Boolean isNextFit() {
		return (strategy == EnumMemoryStrategy.NEXT_FIT);
	}
	
	private Boolean isBestFit() {
		return (strategy == EnumMemoryStrategy.BEST_FIT);
	}
	
	private Boolean isWorstFit() {
		return (strategy == EnumMemoryStrategy.WORST_FIT);
	}
	
	private Boolean isBestWorst() {
		return ((isBestFit()) || (isWorstFit()));
	}
	
	public MemoryManagement() {
		init();
	}
	
	
	@Override
	public EnumMemoryStrategy getStrategy() {
		return strategy;
	}

	@Override
	public void setStrategy(EnumMemoryStrategy value) {		
		if (value != null) {
			strategy = value;
			if (value != EnumMemoryStrategy.NULL) {
				status = EnumMemoryStatus.INPUT;
			} else {
				status = EnumMemoryStatus.START;
			}
		} else {
			status = EnumMemoryStatus.START;
		}		
	}

	@Override
	public Integer getNumber() {
		return number;
	}

	@Override
	public void setNumber(Integer value) {
		if ((value != null) && (value > 0) && (status == EnumMemoryStatus.INPUT)) {
			number = value;
			status = EnumMemoryStatus.SEARCH;
			if (strategy != EnumMemoryStrategy.NEXT_FIT) {
				start = START;
			}
			position = start;
			first = true;
		} else {
			status = EnumMemoryStatus.INPUT;
		}
	}

	@Override
	public EnumMemoryStatus getStatus() {
		return status;
	}
	
	@Override
	public Boolean execute() {
		Boolean ok = false;
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
	
	@Override
	public void reset() {		
		init();
	}

	@Override
	public List<ISpace> getListSpace() {
		return listSpacePublic;
		//return new ArrayList<ISpace>(listSpacePublic); 		
	}
}
