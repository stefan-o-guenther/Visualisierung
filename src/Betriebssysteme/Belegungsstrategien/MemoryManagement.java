package Betriebssysteme.Belegungsstrategien;

import java.util.ArrayList;
import java.util.List;

public class MemoryManagement implements IMemoryManagement {

	private EnumMemoryStatus status = EnumMemoryStatus.START;
	private EnumMemoryStrategy strategy = EnumMemoryStrategy.NULL;
	private Integer number = 0;
	private List<ISpace> listSpace = new ArrayList<ISpace>();
	
	private final Integer START = 0;
	private Integer start = START;
	private Integer position = start;
	private Boolean first = true;
	
	private Integer zBestWorst = null;
	private Integer pBestWorst = START;
	
	private Boolean suitable = false;
	
	private void init() {
		status = EnumMemoryStatus.START;
		strategy = EnumMemoryStrategy.NULL;
		number = 0;
		start = START;
		position = start;
		first = true;
		zBestWorst = null;
		pBestWorst = START;
				
		listSpace = new ArrayList<ISpace>();
		listSpace.add(new Space(10, EnumSpace.EMPTY));
		listSpace.add(new Space(1, EnumSpace.FULL));
		listSpace.add(new Space(4, EnumSpace.EMPTY));
		listSpace.add(new Space(1, EnumSpace.FULL));
		listSpace.add(new Space(20, EnumSpace.EMPTY));
		listSpace.add(new Space(1, EnumSpace.FULL));
		listSpace.add(new Space(18, EnumSpace.EMPTY));
		listSpace.add(new Space(1, EnumSpace.FULL));
		listSpace.add(new Space(7, EnumSpace.EMPTY));
		listSpace.add(new Space(1, EnumSpace.FULL));
		listSpace.add(new Space(9, EnumSpace.EMPTY));
		listSpace.add(new Space(1, EnumSpace.FULL));
		listSpace.add(new Space(12, EnumSpace.EMPTY));
		listSpace.add(new Space(1, EnumSpace.FULL));
		listSpace.add(new Space(15, EnumSpace.EMPTY));
		listSpace.add(new Space(1, EnumSpace.FULL));
		listSpace.add(new Space(8, EnumSpace.EMPTY));
	}
	
	private ISpace findNextFreeSpace() {
		ISpace space = null;
		if (listSpace != null) {
			Integer size = listSpace.size();
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
					space = listSpace.get(position);				
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
		if (listSpace != null) {
			for (ISpace sp : listSpace) {
				Integer value = sp.getRestValue();
				if ((value != null) && (value < 0)) {
					sp.setRestValue(null);
				}
			}
		}
	}
	
	private Boolean search() {
		Boolean ok = false;
		if ((number != null) && (number > 0)) {
			if (suitable) {
				ok = true;
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
					ok = true;
				} else if ((isBestWorst()) && (zBestWorst != null)) {	
					ok = true;
					finishFit();
				} else {
					ok = false;
					finishFit();
					status = EnumMemoryStatus.INPUT;							
				}
			}
		} else {
			ok = true;
		}
		return ok;
	}
	
	private void finished() {
		if ((position != null) && (position >= 0) && (listSpace != null)) {			
			for (ISpace sp : listSpace) {		
				sp.setRestValue(null);
			}
			Integer pos = 0;
			if ((isBestWorst()) && (zBestWorst != null)) {
				pos = pBestWorst;
			} else {
				pos = position;
			}
			ISpace space = listSpace.get(pos);
			Integer value = space.getCurrentValue();		
			if (space.getType() == EnumSpace.EMPTY) {
				if (value > number) {
					ISpace newSpace = new Space(number, EnumSpace.USED);
					space.setCurrentValue(value - number);
					listSpace.add(pos, newSpace);
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
			status = EnumMemoryStatus.INPUT;		
		}
	}
	
	
	
	private void finishFit() {
		status = EnumMemoryStatus.FINISHED;
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
		if (listSpace != null) {
			for (ISpace sp : listSpace) {
				sp.activate(false);
				sp.setNewValue(null);				
			}
			if (status == EnumMemoryStatus.SEARCH) {
				ok = search();
			} else if (status == EnumMemoryStatus.FINISHED) {
				ok = true;
				finished();				
			}
		}
		return ok;
	}	

	@Override
	public void reset() {		
		init();
	}

	@Override
	public List<ISpace> getListSpace() {
		return new ArrayList<ISpace>(listSpace); 		
	}
}
