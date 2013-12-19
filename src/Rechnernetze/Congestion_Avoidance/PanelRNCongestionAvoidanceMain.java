package Rechnernetze.Congestion_Avoidance;

import Base.BasePanelMain;
import Base.PanelTitle;

public class PanelRNCongestionAvoidanceMain extends BasePanelMain {

	/**
	 * Create the panel.
	 */
	public PanelRNCongestionAvoidanceMain() {
		super(null);
		initComponents();
	}

	@Override
	protected void initComponents() {
		panelModel = new PanelRNCongestionAvoidanceModel();
		panelMenu = new PanelRNCongestionAvoidanceMenu((PanelRNCongestionAvoidanceModel) panelModel);
		panelTitle = new PanelTitle("Congestion Avoidance", panelModel);		
		initLayout(200);
	}
}
