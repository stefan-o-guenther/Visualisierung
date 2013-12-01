package Betriebssysteme.Belegungsstrategien;

import java.util.ArrayList;
import java.util.List;

public class MemoryManagement implements IMemoryManagement {

	private EnumStatus status = EnumStatus.START;
	private EnumStrategy strategy = EnumStrategy.NULL;
	private Integer number = 0;
	private List<ISpace> listSpace = new ArrayList<ISpace>();
	
	private final Integer START = 0;
	private Integer start = START;
	private Integer position = start;
	private Boolean first = true;
	
	private Integer zBestWorst = null;
	private Integer pBestWorst = START;
	
	private Boolean auto = false;
	
	private void init() {
		status = EnumStatus.START;
		strategy = EnumStrategy.NULL;
		number = 0;
		start = START;
		position = start;
		first = true;
		zBestWorst = null;
		pBestWorst = START;
		auto = false;
				
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
	
	
	public MemoryManagement() {
		init();
	}
	
	
	@Override
	public EnumStrategy getStrategy() {
		return strategy;
	}

	@Override
	public void setStrategy(EnumStrategy value) {		
		if (value != null) {
			strategy = value;
			if (value != EnumStrategy.NULL) {
				status = EnumStatus.INPUT;
			} else {
				status = EnumStatus.START;
			}
		} else {
			status = EnumStatus.START;
		}		
	}

	@Override
	public Integer getNumber() {
		return number;
	}

	@Override
	public void setNumber(Integer value) {
		if ((value != null) && (value > 0) && (status == EnumStatus.INPUT)) {
			number = value;
			status = EnumStatus.SEARCH;
			if (strategy != EnumStrategy.NEXT_FIT) {
				start = START;
			}
			position = start;
			first = true;
		} else {
			status = EnumStatus.INPUT;
		}
	}

	@Override
	public EnumStatus getStatus() {
		return status;
	}
	
	
	private void executeFirstFitNextFit() {
		if (listSpace != null) {
			for (ISpace sp : listSpace) {				
				sp.setRestValue(null);
			}
			if (status == EnumStatus.SEARCH) {
				if (number != null) {
					ISpace space = this.findNextFreeSpace();
					if (space != null) {
						space.setActivated(true);
						space.setNewValue(number);
						Integer value = space.getCurrentValue();
						if (value >= number) {
							space.setRestValue(value - number);
							status = EnumStatus.FINISHED;
						} else {
							status = EnumStatus.SEARCH;
						}
					} else {
						status = EnumStatus.INPUT;
					}
				}
			} else if (status == EnumStatus.FINISHED) {
				ISpace space = listSpace.get(position);
				Integer value = space.getCurrentValue();
				if (space.getType() == EnumSpace.EMPTY) {
					if (value > number) {
						ISpace newSpace = new Space(number, EnumSpace.USED);
						space.setCurrentValue(value - number);
						listSpace.add(position, newSpace);
					} else if (value.equals(number)) {
						space.setType(EnumSpace.USED);
					}
				}
				if (strategy == EnumStrategy.FIRST_FIT) {
					start = START;
				} else {
					start = position;
				}
				position = start;
				status = EnumStatus.INPUT;
			}
		}
	}
	
	
	private void executeBestFitWorstFit() {
		if (listSpace != null) {			
			if (status == EnumStatus.SEARCH) {
				if (number != null) {
					ISpace space = this.findNextFreeSpace();
					if (space != null) {
						space.setActivated(true);
						space.setNewValue(number);
						Integer value = space.getCurrentValue();
						if (value >= number) {
							space.setRestValue(value - number);
							if ((zBestWorst == null) || 
								((strategy == EnumStrategy.BEST_FIT) && (value < zBestWorst)) || 
								((strategy == EnumStrategy.WORST_FIT) && (value > zBestWorst))) {									
								zBestWorst = value;
								pBestWorst = position;
							}
							if ((strategy == EnumStrategy.BEST_FIT) && (value.equals(number))) {
								status = EnumStatus.FINISHED;
							}
						} else {
							status = EnumStatus.SEARCH;
						}
					} else if (zBestWorst != null) {
						status = EnumStatus.FINISHED;
					} else {					
						status = EnumStatus.INPUT;					
					}					
				}
			} else if (status == EnumStatus.FINISHED) {
				for (ISpace sp : listSpace) {				
					sp.setRestValue(null);
				}
				ISpace space = listSpace.get(pBestWorst);
				Integer value = space.getCurrentValue();
				if (space.getType() == EnumSpace.EMPTY) {
					if (value > number) {
						ISpace newSpace = new Space(number, EnumSpace.USED);
						space.setCurrentValue(value - number);
						listSpace.add(pBestWorst, newSpace);
					} else if (value.equals(number)) {
						space.setType(EnumSpace.USED);
					}
				}		
				start = START;				
				position = start;
				status = EnumStatus.INPUT;
				zBestWorst = null;
				pBestWorst = START;
			}
		}
	}
	
	
	@Override
	public void execute() {
		if (listSpace != null) {
			for (ISpace sp : listSpace) {
				sp.setActivated(false);
				sp.setNewValue(null);				
			}
			
			if ((strategy == EnumStrategy.FIRST_FIT) || (strategy == EnumStrategy.NEXT_FIT)) {
				executeFirstFitNextFit();
			} else if ((strategy == EnumStrategy.BEST_FIT) || (strategy == EnumStrategy.WORST_FIT)) {
				executeBestFitWorstFit();
			}
		}	
	}

	

	@Override
	public void reset() {		
		init();
	}

	@Override
	public List<ISpace> getListSpace() {
		return listSpace;		
	}

	@Override
	public Boolean isAuto() {
		return auto;
	}

	@Override
	public void setAuto(Boolean value) {
		if (value != null) {
			auto = value;
		}
	}

}
