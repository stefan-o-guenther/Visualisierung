/**
 * @author:	Stefan Otto Günther
 * @date:	01.07.2014
 */

package Base;

public abstract class PanelMenuAutomaticBoxNormalAbstract extends PanelMenuAutomaticBoxAbstract {

	public PanelMenuAutomaticBoxNormalAbstract(ManagementAutomatic management, ToolTipManagerAutomatic tooltip) {
		super(management, tooltip);
	}
	
	@Override
	protected PanelMenuAutomaticControlImpl getNewPanelAutomaticMenuControler() {
		ManagementAutomatic management = (ManagementAutomatic) this.getManagement();
		ToolTipManagerAutomatic tooltip = (ToolTipManagerAutomatic) this.getToolTipManager();
		return new PanelMenuAutomaticControlImpl(management, tooltip);
	}	
}