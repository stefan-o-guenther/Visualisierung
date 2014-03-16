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
	public PanelRNTCPRetransmissionModel(IRetransmissionManagement retransmission) {
		super(retransmission);
		this.retransmission = retransmission;
		putModelToManagement();
		updateModel();
	}

	@Override
	public void doDrawing(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateModel() {
		// TODO Auto-generated method stub
		
	}

}
