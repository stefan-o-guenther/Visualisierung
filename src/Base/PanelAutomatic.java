package Base;

public interface PanelAutomatic extends Panel {

	public void setManagement(ManagementAutomatic management);
	public void setPanelMenu(PanelMenuAutomaticAbstract panelMenu);
	
	public void updateAutomatic();
	public void startAutomatic();
	public void stopAutomatic();
	public void switchAutomatic();
	public void error();
	public void setAutomaticEnabled(Boolean enabled);
}
