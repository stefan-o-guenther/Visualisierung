package Rechnernetze.TCP_Fairness;

import Base.BasePanelMain;
import Base.PanelTitle;

public class PanelRNTCPFairnessMain extends BasePanelMain {

	/**
	 * Create the panel.
	 */
	public PanelRNTCPFairnessMain() {
		panelModel = new PanelRNTCPFairnessModel();
		panelMenu = new PanelRNTCPFairnessMenu((PanelRNTCPFairnessModel) panelModel);
		panelTitle = new PanelTitle("TCP-Fairness", panelModel);		
		initLayout(200);
	}

	@Override
	protected void initComponents() {
		// TODO Auto-generated method stub
		
	}

}
