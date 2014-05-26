package Base;


public abstract class PanelMenuAutomaticAbstract extends PanelMenuAbstract implements PanelMenuAutomatic{

	public PanelMenuAutomaticAbstract(Management management, ToolTipManager tooltip) {
		super(management, tooltip);
	}
	
	protected PanelAutomaticAbstract panelAutomatic;
	
	protected Boolean executeManualAutomatic() {
		Boolean result = true;
		try {
			ManagementAutomatic automatic = (ManagementAutomatic) this.getManagement();
			if (automatic.isAutomaticChecked()) {
				panelAutomatic.switchAutomatic();
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
