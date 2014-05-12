/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Base;

import javax.swing.ImageIcon;

public abstract class PanelMenuAbstract extends PanelAbstract implements PanelMenu {

	public PanelMenuAbstract(Management management, ToolTipManager tooltip) {
		super(management, tooltip);
	}
	
	public ImageIcon getImageIconHelp() {
		return ImageLoader.getImageIconHelp16();
	}
}