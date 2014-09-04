/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import javax.swing.ImageIcon;

public abstract class PanelMenuAbstract extends PanelInitAbstract {

	private static final long serialVersionUID = 1L;
	
	public PanelMenuAbstract(Management management) {
		super(management);
	}
	
	protected ImageIcon getImageIconHelp() {
		return ImageLoader.getImageIconHelp16();
	}
	
	protected abstract void initComponentsMenu();
	protected abstract void initMethods();
	
	protected void initComponents() {
		this.initComponentsMenu();
		this.initMethods();
	}
}