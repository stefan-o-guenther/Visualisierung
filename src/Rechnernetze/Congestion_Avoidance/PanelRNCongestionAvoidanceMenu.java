package Rechnernetze.Congestion_Avoidance;

import Base.BasePanelMenu;
import Base.BasePanelModel;

public class PanelRNCongestionAvoidanceMenu extends BasePanelMenu {

	INetworkManagement network;
	
	/**
	 * Create the panel.
	 */
	public PanelRNCongestionAvoidanceMenu(INetworkManagement inetwork, BasePanelModel model) {
		super(model);
		if (inetwork == null) {
			inetwork = new NetworkManagement();
		}
		network = inetwork;
	}

	@Override
	protected void initComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void updateComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initToolTips() {
		// TODO Auto-generated method stub
		
	}

}
