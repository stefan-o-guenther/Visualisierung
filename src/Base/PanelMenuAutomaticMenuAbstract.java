/**
 * @author:	Stefan Otto Günther
 * @date:	01.06.2014
 */

package Base;


public abstract class PanelMenuAutomaticMenuAbstract extends PanelMenuAutomaticAbstract implements PanelMenuAutomaticMenu {

	public PanelMenuAutomaticMenuAbstract(ManagementAutomatic management, ToolTipManager tooltip) {
		super(management, tooltip);
	}
	
	protected Boolean executeManualAutomatic() {
		Boolean result = true;
		try {
			ManagementAutomatic automatic = (ManagementAutomatic) this.getManagement();
			if (automatic.isAutomaticChecked()) {
				automatic.switchAutomatic();
				result = true;
			} else {
				result = automatic.execute();
			}
			updatePanel();
		} catch (Exception ex) {
			throw ex;
		}		
		return result;
	}
	
	protected void reset() {
		
	}
}
