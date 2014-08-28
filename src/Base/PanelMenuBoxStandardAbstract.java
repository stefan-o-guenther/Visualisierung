/**
 * @author:	Stefan Otto Günther
 * @date:	01.07.2014
 */

package Base;

public abstract class PanelMenuBoxStandardAbstract extends PanelMenuBoxAbstract {

	public PanelMenuBoxStandardAbstract(Management management, ToolTipManager tooltip) {
		super(management, tooltip);
	}
	
	@Override
	protected PanelMenuControlBoxImpl getNewPanelAutomaticMenuControler() {
		return new PanelMenuControlBoxImpl(this.management, this.tooltip);
	}	
}