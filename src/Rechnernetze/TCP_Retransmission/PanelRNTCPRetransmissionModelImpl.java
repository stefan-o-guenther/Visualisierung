/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Retransmission;

import Base.PanelModelDrawAbstract;

public class PanelRNTCPRetransmissionModelImpl extends PanelModelDrawAbstract {

	private static final long serialVersionUID = 1L;

	public PanelRNTCPRetransmissionModelImpl(ManagementRetransmission retransmission) {
		super(retransmission);
	}
	
	private ManagementRetransmission retransmission;

	@Override
	protected void doDrawing() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initComponents() {
		this.retransmission = (ManagementRetransmission) this.getManagement();
	}

}
