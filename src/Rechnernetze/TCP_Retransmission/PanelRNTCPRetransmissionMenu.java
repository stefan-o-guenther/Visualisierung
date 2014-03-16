/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Retransmission;

import Base.BasePanelMenu;

public class PanelRNTCPRetransmissionMenu extends BasePanelMenu {

	public PanelRNTCPRetransmissionMenu(IRetransmissionManagement retransmission) {
		super(retransmission);
		this.retransmission = retransmission;
	}

	private IRetransmissionManagement retransmission;
	
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

}
