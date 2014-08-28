/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Retransmission;

import Base.PanelMenuAbstract;

public class PanelRNTCPRetransmissionMenuImpl extends PanelMenuAbstract {

	public PanelRNTCPRetransmissionMenuImpl(ManagementRetransmission retransmission, ToolTipManagerRetransmission tooltip) {
		super(retransmission, tooltip);
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
	public Integer getHeightMenu() {
		return 200;
	}
}
