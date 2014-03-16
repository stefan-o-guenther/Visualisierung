package Base;

public interface IPanelAutomatic {

	public void setManagement(IManagementAutomatic management);
	public void setPanelMenu(BasePanelMenuAutomatic panelMenu);
	
	public void updateAutomatic();
	public void startAutomatic();
	public void stopAutomatic();
	public void switchAutomatic();
	public void error();
	public void setAutomaticEnabled(Boolean enabled);
}
