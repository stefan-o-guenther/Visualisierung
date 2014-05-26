package Base;

public interface CoordinateSystem {
	
	public void setManagement(Management management);
	
	public void setGapLeft(Integer gap);	
	public void setGapRight(Integer gap);	
	public void setGapTop(Integer gap);	
	public void setGapBottom(Integer gap);
	
	public Integer getArrowLength();
	public void setArrowLength(Integer length);
	
	public Integer getInterval();
	public void setInterval(Integer interval);	

	public Integer getX0();
	public Integer getY0();
	public Integer getXMax();
	public Integer getYMax();
	
	public Integer getPositionX0();
	public Integer getPositionY0();
	public Integer getPositionXMax();
	public Integer getPositionYMax();	
}