/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.util.List;

import Base.EnumVisualizationStatus;
import Base.ManagementFactory;

public class MemoryStrategyFirstFitImpl extends MemoryStrategyFirstNextAbstract implements MemoryStrategyFirstFit {
	
	public MemoryStrategyFirstFitImpl(List<Space> example) {
		super(example);
	}

	@Override
	public EnumMemoryStrategy getStrategy() {
		return EnumMemoryStrategy.FIRST_FIT;
	}
	
	@Override
	protected void initialize() {
		ManagementFragmentation fragmentation = ManagementFactory.getManagementFragmentation();
		fragmentation.setStatus(EnumVisualizationStatus.INPUT);
		this.setStart(START);
		this.setPosition(START);		
		this.setNumber(1);
		resetIsFirst();
		copyListSpace();
	}
}