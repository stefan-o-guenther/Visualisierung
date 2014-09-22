/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

public interface Management {
	public EnumSurface getSurface();
	public void setSurface(EnumSurface value);
	public void executeNormal();
	public void reset();
	public String getTitle();
	public void updateViews();
	
	public Integer getHeight();
	public void setHeight(Integer height);
	
	public Integer getWidth();
	public void setWidth(Integer width);
	
	public void setSize(Integer height, Integer width);
	
	public EnumVisualizationStatus getStatus();
	
	// automatic
	public Boolean isAutomaticChecked();
	public void setAutomaticChecked(Boolean value);
	public Boolean isAutomaticRunning();
	public void setAutomaticRunning(Boolean value);
	public Boolean isAutomaticPlay();
	public void setAutomaticPlay(Boolean value);
	public Boolean isAutomaticEnabled();
	public Integer getSpeed();
	public void setSpeed(Integer value);
	public void switchAutomatic();
	public void endThread();
	public void executeThread();
	
	public ToolTipManager getToolTipManager();
}
