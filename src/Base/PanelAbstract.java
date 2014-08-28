/**
 * @author:	Stefan Otto Günther
 * @date:	18.02.2014
 */

package Base;

import java.awt.Color;

import javax.swing.JPanel;

public abstract class PanelAbstract extends JPanel {

	public PanelAbstract(Management management, ToolTipManager tooltip) {
		try {
			if ((management == null) || (tooltip == null)) {
				throw new NullPointerException();
			}
			this.management = management;
			this.tooltip = tooltip;
			setBackground(Color.WHITE);			
			this.initPanel();			
		} catch (Exception ex) {
			throw ex;
		}		
	}
	
	public abstract void updatePanel();
	
	protected Management management;
	protected ToolTipManager tooltip;
	
	protected abstract void initComponents();
	protected abstract void initLayout();	
	
	protected void initPanel() {
		this.initComponents();
		this.initLayout();
		this.updatePanel();
	}
	
	
	public Management getManagement() {
		return management;
	}
	
	
	public ToolTipManager getToolTipManager() {
		return tooltip;
	}
}
