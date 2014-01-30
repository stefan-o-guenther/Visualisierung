/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import javax.swing.ImageIcon;

public abstract class BasePanelMenu extends BasePanelUseModel {

	public BasePanelMenu(BasePanelModel model) {
		super(model);
	}
	
	private static final long serialVersionUID = 1L;
	
	protected abstract void initComponents();
	protected abstract void updateComponents();
	protected abstract void initToolTips();
	
	protected void updateView() {
		updateComponents();
		updateModel();
	}
	
	public abstract Integer getHeightMenu();
	
	public ImageIcon getImageIconHelp() {
		return ImageLoader.getImageIconHelp16();
	}	
}