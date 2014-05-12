/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Retransmission;

import java.awt.Graphics;

import Base.PanelModelDrawAbstract;

public class PanelRNTCPRetransmissionModelImpl extends PanelModelDrawAbstract {

	private ManagementRetransmission retransmission;
	
	/**
	 * Create the panel.
	 */
	public PanelRNTCPRetransmissionModelImpl(ManagementRetransmission retransmission, ToolTipManagerRetransmission tooltip) {
		super(retransmission, tooltip);
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

	@Override
	protected void initComponents() {
		// TODO Auto-generated method stub
		
	}

}
