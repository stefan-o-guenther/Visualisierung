/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

public interface IManagement {
	EnumSurface getSurface();
	void setSurface(EnumSurface value);
	void setPanelModel(BasePanelModel model);
	Boolean execute();
	void reset();
}
