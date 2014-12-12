/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.util.List;

import Base.Checker;
import Base.EnumVisualizationStatus;
import Base.ManagementFactory;

public abstract class MemoryStrategyBestWorstAbstract extends MemoryStrategyAbstract {

	public MemoryStrategyBestWorstAbstract(List<Space> example) {
		super(example);
	}

	protected Integer zBestWorst = null;
	protected Integer pBestWorst = START;

	@Override
	protected void initialize() {
		ManagementFragmentation fragmentation = ManagementFactory.getManagementFragmentation();
		fragmentation.setStatus(EnumVisualizationStatus.INPUT);
		this.setStart(START);
		this.setPosition(START);		
		this.setNumber(1);
		zBestWorst = null;
		pBestWorst = START;	
		resetIsFirst();
		copyListSpace();
	}
	
	@Override
	protected Integer getChosenPosition() {
		if (zBestWorst != null) {
			return pBestWorst;
		} else {
			return this.getPosition();
		}
	}
	
	@Override
	protected Boolean finishNotFit() {
		finishFit();
		if (zBestWorst != null) {
			return true;
		} else {
			finish();
			return false;
		}
	}
	
	protected void checkIfBest(Integer value) {
		try {
			Checker.checkIfIntegerNotLessZero(value);
			if ((zBestWorst == null) || (value.intValue() < zBestWorst.intValue())) {
				zBestWorst = value;
				pBestWorst = this.getPosition();
				
			}
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	protected void checkIfWorst(Integer value) {
		try {
			Checker.checkIfIntegerNotLessZero(value);
			if ((zBestWorst == null) || (value.intValue() > zBestWorst)) {									
				zBestWorst = value;
				pBestWorst = this.getPosition();
			}
		} catch (Exception ex) {
			throw ex;
		}
	}
}
