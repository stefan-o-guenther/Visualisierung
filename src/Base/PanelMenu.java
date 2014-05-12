package Base;

import javax.swing.ImageIcon;

public interface PanelMenu extends Panel {

	public abstract Integer getHeightMenu();
	
	public ImageIcon getImageIconHelp();
	
	public void setManagement(Management management);
	
	public void updateComponents();
}
