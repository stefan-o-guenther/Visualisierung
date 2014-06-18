/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

public interface Management {
	public EnumSurface getSurface();
	public void setSurface(EnumSurface value);
	public void setPanelMain(PanelMainAbstract panelMain);
	public Boolean execute();
	public void reset();
	public String getTitle();
	public void updateAllPanels();
	
	public Integer getHeight();
	public void setHeight(Integer height);
	
	public Integer getWidth();
	public void setWidth(Integer width);
	
	public void setSize(Integer height, Integer width);
	public void showErrorMessage();
}
