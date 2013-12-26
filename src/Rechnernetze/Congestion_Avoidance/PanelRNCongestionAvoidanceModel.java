package Rechnernetze.Congestion_Avoidance;

import java.awt.Graphics;

import Base.BasePanelModelDraw;

public class PanelRNCongestionAvoidanceModel extends BasePanelModelDraw {

	private INetworkManagement network;
	
	/**
	 * Create the panel.
	 */
	public PanelRNCongestionAvoidanceModel(INetworkManagement inetwork) {
		if (inetwork == null) {
			inetwork = new NetworkManagement();
		}
		network = inetwork;
	}

	@Override
	protected void doDrawing(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
