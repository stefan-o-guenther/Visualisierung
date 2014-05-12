/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

public interface Management {
	public EnumSurface getSurface();
	public void setSurface(EnumSurface value);
	public void setPanelModel(PanelModelAbstract model);
	public Boolean execute();
	public void reset();
	public String getTitle();
}
