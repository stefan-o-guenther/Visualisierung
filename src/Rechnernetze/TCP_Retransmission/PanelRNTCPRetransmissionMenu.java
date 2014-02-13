/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Retransmission;

import Base.BasePanelMenu;

public class PanelRNTCPRetransmissionMenu extends BasePanelMenu {

	public PanelRNTCPRetransmissionMenu(IRetransmissionManagement iretransmission) {
		super();
		if (iretransmission == null) {
			iretransmission = new RetransmissionManagement();
		}
		retransmission = iretransmission;
	}

	private IRetransmissionManagement retransmission;
	
	@Override
	protected void initComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void updateComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initToolTips() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getHeightMenu() {
		return 200;
	}

}
