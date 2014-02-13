/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Congestion_Avoidance;

import java.awt.Graphics;

import Base.BasePanelModelDraw;

public class PanelRNCongestionAvoidanceModel extends BasePanelModelDraw {

	public PanelRNCongestionAvoidanceModel(INetworkManagement inetwork) {
		super();
		if (inetwork == null) {
			inetwork = new NetworkManagement();
		}
		network = inetwork;
		network.setPanelModel(this);
		updateModel();
	}

	private INetworkManagement network;
	
	@Override
	protected void doDrawing(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateModel() {
		// TODO Auto-generated method stub
		
	}
}