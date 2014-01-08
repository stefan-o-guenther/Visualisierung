package Betriebssysteme.Belegungsstrategien;

import java.util.List;

public abstract class BaseMemoryStrategyFirstNext extends BaseMemoryStrategy {

	protected BaseMemoryStrategyFirstNext(List<ISpace> example) {
		super(example);
	}

	protected Integer getPos() {
		return position;
	}
	
	protected Boolean isSuitableSpace(Integer number, Integer value) {
		if (value >= number) {		
			return true;
		} else {
			return false;
		}
	}
		
	protected void finishNotFit() {
		executionOK = false;
		finishFit();
		status = EnumMemoryStatus.FINISHED;	
	}
	
	protected void initStrategy() {
		// nothing
	}
}
