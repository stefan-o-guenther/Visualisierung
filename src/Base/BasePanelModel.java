/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import javax.swing.JPanel;

public abstract class BasePanelModel extends JPanel {
	
	private static final long serialVersionUID = 7806968315363363035L;
	
	public abstract void updateModel();
	
	public BasePanelModel() {
		super();
	}
}
