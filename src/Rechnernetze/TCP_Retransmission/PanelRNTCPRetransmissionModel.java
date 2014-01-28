/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Retransmission;

import java.awt.Graphics;

import Base.BasePanelModelDraw;

public class PanelRNTCPRetransmissionModel extends BasePanelModelDraw {

	private IRetransmissionManagement retransmission;
	
	/**
	 * Create the panel.
	 */
	public PanelRNTCPRetransmissionModel(IRetransmissionManagement iretransmission) {
		super();
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
	public void updateData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateModel() {
		// TODO Auto-generated method stub
		
	}

}
