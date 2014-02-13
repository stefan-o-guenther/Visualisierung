/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;


public abstract class BaseManagement implements IManagement {

	public BaseManagement() {
		super();
	}
	
	protected BasePanelModel panelModel;
	protected EnumSurface surface = EnumSurface.COLORED;
	
	protected void update() {
		if (panelModel != null) {
			panelModel.updateModel();
		}		
	}
	
	@Override
	public EnumSurface getSurface() {
		return surface;
	}

	@Override
	public void setSurface(EnumSurface value) {
		if (value != null) {
			surface = value;
			update();
		}
	}

	@Override
	public void setPanelModel(BasePanelModel model) {
		panelModel = model;
	}	
}
