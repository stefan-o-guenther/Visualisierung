/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;


public abstract class BasePanelModel extends BasePanel implements IPanelModel {
	
	public BasePanelModel(IManagement management) {
		super();
		this.management = management;
	}
	
	protected IManagement management = null;
	
	public void putModelToManagement() {
		management.setPanelModel(this);
	}
	
	public void setManagement(IManagement management) {
		this.management = management;
	}
}
