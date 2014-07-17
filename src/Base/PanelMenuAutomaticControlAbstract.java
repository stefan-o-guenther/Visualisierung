/**
 * @author:	Stefan Otto Günther
 * @date:	01.07.2014
 */

package Base;

import java.awt.Color;


public abstract class PanelMenuAutomaticControlAbstract extends PanelMenuAutomaticAbstract implements PanelMenuAutomaticControl {

	public PanelMenuAutomaticControlAbstract(Management management,	ToolTipManager tooltip) {
		super(management, tooltip);
		background = this.getBackground();
	}
	
	protected ManagementAutomatic management;
	protected ToolTipManagerAutomatic tooltip;
	
	protected Color background;
	protected abstract Boolean isAutomaticChecked();
}