/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Retransmission;

import Base.PanelMenuAbstract;

public class PanelRNTCPRetransmissionMenuImpl extends PanelMenuAbstract {

	public PanelRNTCPRetransmissionMenuImpl(ManagementRetransmission retransmission, ToolTipManagerRetransmission tooltip) {
		super(retransmission, tooltip);
		this.retransmission = retransmission;
	}

	private ManagementRetransmission retransmission;
	
	@Override
	public void initComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getHeightMenu() {
		return 200;
	}

	@Override
	protected void initLayout() {
		// TODO Auto-generated method stub
		
	}

}
