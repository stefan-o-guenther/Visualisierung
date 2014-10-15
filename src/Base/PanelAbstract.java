/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Base;

import java.awt.Color;

import javax.swing.JPanel;

public abstract class PanelAbstract extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public PanelAbstract() {
		setBackground(Color.WHITE);
	}	
	
	public abstract void updatePanel();
	
	public abstract Integer getPanelHeight();
	public abstract Integer getPanelWidth();
	
	protected abstract void createPanel();
}
