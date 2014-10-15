package Betriebssysteme.Belegungsstrategien;

import java.util.List;

public abstract class MemoryStrategyAbstract implements MemoryStrategy {

	public MemoryStrategyAbstract() {
		
	}
	
	private final Integer START = 0;
	
	private List<Space> listSpaceWork;
	private List<Space> listSpacePublic;
	private Integer number;
		
	private Integer start;
	private Integer position;
	private Boolean isFirst;
	
	private Boolean executionOK;
	
	private EnumMemoryStrategy strategy;
	
	private EnumMemoryStatus statusMemory;
	
	private Boolean suitable;
	
	private Integer zBestWorst;
	private Integer pBestWorst;
	
	
	protected void initialize() {
		
	}
}
