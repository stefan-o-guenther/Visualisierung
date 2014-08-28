/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import javax.swing.ImageIcon;

public abstract class PanelMenuAbstract extends PanelAbstract {

	public PanelMenuAbstract(Management management, ToolTipManager tooltip) {
		super(management, tooltip);
	}
	
	protected ImageIcon getImageIconHelp() {
		return ImageLoader.getImageIconHelp16();
	}
	
	public abstract Integer getHeightMenu();
	
	protected abstract void initComponentsMenu();
	protected abstract void initMethods();
	
	protected void initComponents() {
		this.initComponentsMenu();
		this.initMethods();
	}
}