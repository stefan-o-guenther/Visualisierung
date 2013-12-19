package Rechnernetze.TCP_Fairness;

import Base.BasePanelMain;
import Base.PanelTitle;

public class PanelRNTCPFairnessMain extends BasePanelMain {

	/**
	 * Create the panel.
	 */
	public PanelRNTCPFairnessMain() {
		super(null);
		initComponents();
	}

	@Override
	protected void initComponents() {
		panelModel = new PanelRNTCPFairnessModel();
		panelMenu = new PanelRNTCPFairnessMenu((PanelRNTCPFairnessModel) panelModel);
		panelTitle = new PanelTitle("TCP-Fairness", panelModel);		
		initLayout(200);
	}

}
