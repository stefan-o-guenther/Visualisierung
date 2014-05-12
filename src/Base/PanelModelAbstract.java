/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;


public abstract class PanelModelAbstract extends PanelAbstract implements PanelModel {
	
	public PanelModelAbstract(Management management, ToolTipManager tooltip) {
		super(management, tooltip);
	}
	
	protected void putModelToManagement() {
		management.setPanelModel(this);
	}
}
