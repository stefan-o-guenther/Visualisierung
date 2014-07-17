package Base;

public interface Geometry {

	public Integer getHeight();
	public void setHeight(Integer height);
	
	public Integer getWidth();
	public void setWidth(Integer width);
	
	public Integer getGapBetweenX();
	public void setGapBetweenX(Integer gap);
	
	public Integer getGapBetweenY();
	public void setGapBetweenY(Integer gap);
	
	public Integer getIntervalX();
	public void setIntervalX(Integer interval);
	
	public Integer getIntervalY();
	public void setIntervalY(Integer interval);
	
	public void setGapLeft(Integer gap);	
	public void setGapRight(Integer gap);	
	public void setGapTop(Integer gap);	
	public void setGapBottom(Integer gap);
	
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
	public void enableSameLength(Boolean enable);
}
