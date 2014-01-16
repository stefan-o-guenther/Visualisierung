package Base;

import javax.swing.JPanel;

public abstract class BasePanelUseModel extends JPanel {

	protected BasePanelModel panelModel;
	
	protected void updateModel() {
		if (panelModel != null) {
			panelModel.updateModel();
		}
	}
	
	/**
	 * Create the panel.
	 */
	protected BasePanelUseModel(BasePanelModel model) {
		if (model != null) {
			panelModel = model;
		}
	}
}
