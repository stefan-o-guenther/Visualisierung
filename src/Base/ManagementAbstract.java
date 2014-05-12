/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;


public abstract class ManagementAbstract implements Management {

	public ManagementAbstract() {
		super();
		surface = EnumSurface.COLORED;
	}
	
	protected PanelModelAbstract panelModel;
	protected EnumSurface surface;
	
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
	public void setPanelModel(PanelModelAbstract model) {
		panelModel = model;
	}	
}
