package Base;

import javax.swing.ImageIcon;

public interface IPanelMenu {

	public void initComponents();
	public void updateComponents();
	
	public abstract Integer getHeightMenu();
	
	public ImageIcon getImageIconHelp();
	
	public void setManagement(IManagement management);
}
