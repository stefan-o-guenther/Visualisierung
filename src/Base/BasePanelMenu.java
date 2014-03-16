/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import javax.swing.ImageIcon;

public abstract class BasePanelMenu extends BasePanel implements IPanelMenu {

	public BasePanelMenu(IManagement management) {
		super();
		this.management = management;
	}
	
	protected IManagement management = null;
	
	public ImageIcon getImageIconHelp() {
		return ImageLoader.getImageIconHelp16();
	}
	
	public void setManagement(IManagement management) {
		this.management = management;
	}
}