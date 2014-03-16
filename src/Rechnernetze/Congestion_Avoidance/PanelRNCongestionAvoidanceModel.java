/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Congestion_Avoidance;

import java.awt.Graphics;

import Base.BasePanelModelDraw;

public class PanelRNCongestionAvoidanceModel extends BasePanelModelDraw {

	public PanelRNCongestionAvoidanceModel(INetworkManagement network) {
		super(network);
		if (network == null) {
			network = new NetworkManagement();
		}
		this.network = network;
		putModelToManagement();
		updateModel();
	}

	private INetworkManagement network;
	
	@Override
	public void doDrawing(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateModel() {
		// TODO Auto-generated method stub
		
	}
}