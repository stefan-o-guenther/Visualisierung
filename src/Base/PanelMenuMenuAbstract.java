/**
 * @author:	Stefan Otto G�nther
 * @date:	01.06.2014
 */

package Base;


public abstract class PanelMenuMenuAbstract extends PanelMenuAbstract {

	public PanelMenuMenuAbstract(Management management, ToolTipManager tooltip) {
		super(management, tooltip);
	}
	
	public abstract Integer getLengthMenu();
}
