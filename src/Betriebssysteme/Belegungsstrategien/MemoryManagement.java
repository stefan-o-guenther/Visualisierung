package Betriebssysteme.Belegungsstrategien;

import java.util.ArrayList;
import java.util.List;

import Base.BaseManagement;

public class MemoryManagement extends BaseManagement implements IMemoryManagement {

	private IMemoryStrategy strategy = null;
	
	private List<ISpace> listSpace = new ArrayList<ISpace>();
	
	private void update() {
		listSpace = strategy.getListSpace();
	}
	
	private void init() {
		strategy = null;
		listSpace = loadExample();
	}
	
	private List<ISpace> loadExample() {
		List<ISpace> listSpaceExample = new ArrayList<ISpace>();
		listSpaceExample.add(new Space(10, EnumSpace.EMPTY));
		listSpaceExample.add(new Space(1, EnumSpace.FULL));
		listSpaceExample.add(new Space(4, EnumSpace.EMPTY));
		listSpaceExample.add(new Space(1, EnumSpace.FULL));
		listSpaceExample.add(new Space(20, EnumSpace.EMPTY));
		listSpaceExample.add(new Space(1, EnumSpace.FULL));
		listSpaceExample.add(new Space(18, EnumSpace.EMPTY));
		listSpaceExample.add(new Space(1, EnumSpace.FULL));
		listSpaceExample.add(new Space(7, EnumSpace.EMPTY));
		listSpaceExample.add(new Space(1, EnumSpace.FULL));
		listSpaceExample.add(new Space(9, EnumSpace.EMPTY));
		listSpaceExample.add(new Space(1, EnumSpace.FULL));
		listSpaceExample.add(new Space(12, EnumSpace.EMPTY));
		listSpaceExample.add(new Space(1, EnumSpace.FULL));
		listSpaceExample.add(new Space(15, EnumSpace.EMPTY));
		listSpaceExample.add(new Space(1, EnumSpace.FULL));
		listSpaceExample.add(new Space(8, EnumSpace.EMPTY));
		return listSpaceExample;
	}
	
	public MemoryManagement() {
		init();
	}	
	
	@Override
	public EnumMemoryStrategy getStrategy() {
		if (strategy != null) {
			return strategy.getStrategy();
		} else {
			return EnumMemoryStrategy.NULL;
		}		
	}

	@Override
	public void setStrategy(EnumMemoryStrategy value) {		
		if (value != null) {
			List<ISpace> example = loadExample();
			strategy = MemoryStrategyFactory.getStrategy(value, example);
			strategy.init();
			update();			
		}		
	}

	@Override
	public Integer getNumber() {
		if (strategy != null) {
			return strategy.getNumber();
		} else {
			return null;
		}		
	}

	@Override
	public void setNumber(Integer value) {
		if ((strategy != null) && (strategy.getStatus() == EnumMemoryStatus.INPUT) && (value != null) && (value > 0)) {
			strategy.setNumber(value);
			update();
		}
	}

	@Override
	public EnumMemoryStatus getStatus() {
		if (strategy != null) {
			return strategy.getStatus();
		} else {
			return EnumMemoryStatus.START;
		}		
	}
	
	@Override
	public Boolean execute() {
		if (strategy != null) {
			Boolean result = strategy.execute();
			update();
			return result;
		} else {
			return false;
		}		
	}
	
	@Override
	public void reset() {		
		init();		
	}

	@Override
	public List<ISpace> getListSpace() {
		return listSpace;
		//return new ArrayList<ISpace>(listSpacePublic); 		
	}
}
