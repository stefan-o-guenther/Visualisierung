/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.util.List;

import Base.EnumVisualizationStatus;

public abstract class MemoryStrategyBestWorstAbstract extends MemoryStrategyAbstract {

	public MemoryStrategyBestWorstAbstract(List<Space> example) {
		super(example);
	}

	protected Integer zBestWorst = null;
	protected Integer pBestWorst = START;

	@Override
	protected void initialize() {
		ManagementFragmentation fragmentation = ManagementFragmentationImpl.getInstance();
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
			if (value == null) {
				throw new NullPointerException();
			}
			int ival = value.intValue();
			if (ival < 0) {
				throw new IllegalArgumentException();
			}
			if ((zBestWorst == null) || (ival < zBestWorst.intValue())) {
				zBestWorst = value;
				pBestWorst = this.getPosition();
				
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
				pBestWorst = this.getPosition();
			}
		} catch (Exception ex) {
			throw ex;
		}
	}
}
