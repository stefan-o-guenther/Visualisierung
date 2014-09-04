/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Retransmission;

import Base.PanelMenuAbstract;

public class PanelRNTCPRetransmissionMenuImpl extends PanelMenuAbstract {

	private static final long serialVersionUID = 1L;
	
	public PanelRNTCPRetransmissionMenuImpl(ManagementRetransmission retransmission) {
		super(retransmission);
	}

	private ManagementRetransmission retransmission;
	
	@Override
	protected void initComponentsMenu() {
		this.retransmission = (ManagementRetransmission) this.getManagement();
	}
	
	@Override
	protected void initLayout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initMethods() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getPanelHeight() {
		return 200;
	}

	@Override
	public Integer getPanelWidth() {
		// TODO Auto-generated method stub
		return null;
	}
}
