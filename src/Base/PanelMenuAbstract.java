/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import javax.swing.ImageIcon;

public abstract class PanelMenuAbstract extends PanelAbstract implements PanelMenu {

	public PanelMenuAbstract(Management management, ToolTipManager tooltip) {
		super(management, tooltip);
	}
	
	protected ImageIcon getImageIconHelp() {
		return ImageLoader.getImageIconHelp16();
	}
}