/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public abstract class BasePanelMenu extends BasePanel {

	public BasePanelMenu() {
		super();
	}
	
	private static final long serialVersionUID = 1L;
	
	protected abstract void initComponents();
	protected abstract void updateComponents();
	protected abstract void initToolTips();
	
	public abstract Integer getHeightMenu();
	
	public ImageIcon getImageIconHelp() {
		return ImageLoader.getImageIconHelp16();
	}	
}