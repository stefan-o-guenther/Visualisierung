package Rechnernetze.TCP_Retransmission;

import java.awt.Graphics;

import Base.BasePanelModelDraw;

public class PanelRNTCPRetransmissionModel extends BasePanelModelDraw {

	private IRetransmissionManagement retransmission;
	
	/**
	 * Create the panel.
	 */
	public PanelRNTCPRetransmissionModel(IRetransmissionManagement iretransmission) {
		if (iretransmission == null) {
			iretransmission = new RetransmissionManagement();
		}
		retransmission = iretransmission;
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
