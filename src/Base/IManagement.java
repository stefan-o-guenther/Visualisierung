/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Base;

public interface IManagement {
	public EnumSurface getSurface();
	public void setSurface(EnumSurface value);
	public void setPanelModel(BasePanelModel model);
	public Boolean execute();
	public void reset();
}
