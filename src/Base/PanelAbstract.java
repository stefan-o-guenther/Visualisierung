/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Base;

import java.awt.Color;

import javax.swing.JPanel;

public abstract class PanelAbstract extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public PanelAbstract(Management management) {
		try {
			if (management == null) {
				throw new NullPointerException();
			}
			this.management = management;
			setBackground(Color.WHITE);					
		} catch (Exception ex) {
			throw ex;
		}
	}	
	
	public abstract void updatePanel();
	public abstract Integer getPanelHeight();
	public abstract Integer getPanelWidth();
	
	protected abstract void initComponents();
	protected abstract void initLayout();	
	
	protected Management management;
	
	public Management getManagement() {
		return management;
	}
	
	protected void initPanel() {
		this.initComponents();
		this.initLayout();
		this.updatePanel();
	}
}
