package Betriebssysteme.Belegungsstrategien;

import java.util.List;

public abstract class BaseMemoryStrategyBestWorst extends BaseMemoryStrategy {

	protected BaseMemoryStrategyBestWorst(List<ISpace> example) {
		super(example);
	}

	protected Integer zBestWorst = null;
	protected Integer pBestWorst = START;
	
	protected void inputOK() {
		start = START;		
		position = start;
		first = true;
	}
	
	protected Integer getPos() {
		if (zBestWorst != null) {
			return pBestWorst;
		} else {
			return position;
		}
	}
	
	protected void finishChoose() {
		start = START;
		position = start;	
		zBestWorst = null;
		pBestWorst = START;	
	}	

	protected void finishNotFit() {
		finishFit();
		if (zBestWorst != null) {
			executionOK = true;
		} else {
			executionOK = false;
			status = EnumMemoryStatus.FINISHED;	
		}
	}
	
	protected void initStrategy() {
		zBestWorst = null;
		pBestWorst = START;
	}
}
