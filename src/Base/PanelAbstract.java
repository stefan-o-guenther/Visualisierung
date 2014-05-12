/**
 * @author:	Stefan Otto Günther
 * @date:	18.02.2014
 */

package Base;

import java.awt.Color;

import javax.swing.JPanel;

public abstract class PanelAbstract extends JPanel implements Panel {

	public PanelAbstract(Management management, ToolTipManager tooltip) {
		this.management = management;
		this.tooltip = tooltip;
		setBackground(Color.WHITE);
	}
	
	protected Management management;
	protected ToolTipManager tooltip;
	
	protected abstract void initLayout();
	protected abstract void initComponents();
	
	@Override
	public Management getManagement() {
		return management;
	}
	
	@Override
	public void setManagement(Management management) {
		this.management = management;
	}
	
	@Override
	public ToolTipManager getToolTipManager() {
		return tooltip;
	}
}
