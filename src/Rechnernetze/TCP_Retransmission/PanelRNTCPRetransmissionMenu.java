package Rechnernetze.TCP_Retransmission;

import Base.BasePanelMenu;
import Base.BasePanelModel;

public class PanelRNTCPRetransmissionMenu extends BasePanelMenu {

	private IRetransmissionManagement retransmission;
	
	/**
	 * Create the panel.
	 */
	public PanelRNTCPRetransmissionMenu(IRetransmissionManagement iretransmission, BasePanelModel model) {
		super(model);
		if (iretransmission == null) {
			iretransmission = new RetransmissionManagement();
		}
		retransmission = iretransmission;
	}

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

}
