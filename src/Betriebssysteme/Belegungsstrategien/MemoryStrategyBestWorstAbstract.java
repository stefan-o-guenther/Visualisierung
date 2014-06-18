/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.util.List;

public abstract class MemoryStrategyBestWorstAbstract extends MemoryStrategyAbstract {

	public MemoryStrategyBestWorstAbstract(List<Space> example) {
		super(example);
	}

	protected Integer zBestWorst = null;
	protected Integer pBestWorst = START;
	
	protected void inputOK() {
		start = START;		
		position = start;
		isFirst = true;
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
	
	protected Boolean isSuitableSpace(Integer number, Integer value) {
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
	
	protected void checkIfBest(Integer value) {
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
	
	protected void checkIfWorst(Integer value) {
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
}
