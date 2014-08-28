package Base;

public interface ManagementGeometry extends Management {

	public Integer getGapBetweenX();	
	public Integer getGapBetweenY();		
	public Integer getIntervalX();	
	public Integer getIntervalY();		
		
	public Integer getX0();
	public Integer getY0();
	public Integer getXMax();
	public Integer getYMax();
	
	public Integer getPositionX0();
	public Integer getPositionY0();
	public Integer getPositionXMax();
	public Integer getPositionYMax();	
	
	public Integer XToPositionX(Integer x);
	public Integer YToPositionY(Integer y);
	
	public Boolean isSameLength();
}
