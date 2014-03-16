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
	public PanelRNCongestionAvoidanceMenu(INetworkManagement network) {
		super(network);
		this.network = network;
	}

	@Override
	public void initComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getHeightMenu() {
		return 200;
	}

}
