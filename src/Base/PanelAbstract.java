/**
 * @author:	Stefan Otto Günther
 * @date:	18.02.2014
 */

package Base;

import java.awt.Color;

import javax.swing.JPanel;

public abstract class PanelAbstract extends JPanel implements Panel {

	public PanelAbstract(Management management, ToolTipManager tooltip) {
		try {
			if ((management == null) || (tooltip == null)) {
				throw new NullPointerException();
			}
			this.management = management;
			this.tooltip = tooltip;
			setBackground(Color.WHITE);
		} catch (Exception ex) {
			throw ex;
		}		
	}
	
	protected Management management;
	protected ToolTipManager tooltip;
	
	protected abstract void initComponents();
	protected abstract void initLayout();
	
	protected void initPanel() {
		this.initComponents();
		this.initLayout();
		this.updatePanel();
	}
	
	@Override
	public Management getManagement() {
		return management;
	}
	
	@Override
	public ToolTipManager getToolTipManager() {
		return tooltip;
	}
}
