/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import javax.swing.JPanel;

public abstract class BasePanelUseModel extends JPanel {

	public BasePanelUseModel(BasePanelModel model) {
		super();
		if (model != null) {
			panelModel = model;
		}
	}
	
	private static final long serialVersionUID = 1L;
	protected BasePanelModel panelModel;
	
	protected void updateModel() {
		if (panelModel != null) {
			panelModel.updateModel();
		}
	}	
}
