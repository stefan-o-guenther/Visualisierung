package Rechnernetze.TCP_Retransmission;

import Base.BasePanelMain;
import Base.PanelTitle;

public class PanelRNTCPRetransmissionMain extends BasePanelMain {

	/**
	 * Create the panel.
	 */
	public PanelRNTCPRetransmissionMain() {
		panelModel = new PanelRNTCPRetransmissionModel();
		panelMenu = new PanelRNTCPRetransmissionMenu((PanelRNTCPRetransmissionModel) panelModel);
		panelTitle = new PanelTitle("TCP-Retransmission", panelModel);		
		initLayout(200);
	}

	@Override
	protected void initComponents() {
		// TODO Auto-generated method stub
		
	}

}
