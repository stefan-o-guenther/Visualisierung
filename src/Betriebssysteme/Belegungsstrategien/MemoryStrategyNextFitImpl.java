/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.util.List;

import Base.EnumVisualizationStatus;
import Base.ManagementFactory;

public class MemoryStrategyNextFitImpl extends MemoryStrategyFirstNextAbstract implements MemoryStrategyNextFit {
	
	public MemoryStrategyNextFitImpl(List<Space> example) {
		super(example);
	}

	@Override
	public EnumMemoryStrategy getStrategy() {
		return EnumMemoryStrategy.NEXT_FIT;
	}
	
	@Override
	protected void initialize() {
		ManagementFragmentation fragmentation = ManagementFactory.getManagementFragmentation();
		fragmentation.setStatus(EnumVisualizationStatus.INPUT);
		this.setStart(this.getPosition());
		this.setNumber(1);
		resetIsFirst();
		copyListSpace();
	}
}
