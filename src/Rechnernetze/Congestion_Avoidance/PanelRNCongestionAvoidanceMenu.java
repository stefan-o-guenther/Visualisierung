/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Congestion_Avoidance;

import Base.BasePanelMenu;

public class PanelRNCongestionAvoidanceMenu extends BasePanelMenu {

	INetworkManagement network;
	
	/**
	 * Create the panel.
	 */
	public PanelRNCongestionAvoidanceMenu(INetworkManagement inetwork) {
		super();
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

	@Override
	public Integer getHeightMenu() {
		return 200;
	}

}
