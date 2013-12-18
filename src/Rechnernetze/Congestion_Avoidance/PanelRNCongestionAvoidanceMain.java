package Rechnernetze.Congestion_Avoidance;

import Base.BasePanelMain;
import Base.PanelTitle;

public class PanelRNCongestionAvoidanceMain extends BasePanelMain {

	/**
	 * Create the panel.
	 */
	public PanelRNCongestionAvoidanceMain() {
		panelModel = new PanelRNCongestionAvoidanceModel();
		panelMenu = new PanelRNCongestionAvoidanceMenu((PanelRNCongestionAvoidanceModel) panelModel);
		panelTitle = new PanelTitle("Congestion Avoidance", panelModel);		
		initLayout(200);
	}

	@Override
	protected void initComponents() {
		// TODO Auto-generated method stub
		
	}

}
