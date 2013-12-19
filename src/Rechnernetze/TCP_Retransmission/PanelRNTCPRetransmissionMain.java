package Rechnernetze.TCP_Retransmission;

import Base.BasePanelMain;
import Base.PanelTitle;

public class PanelRNTCPRetransmissionMain extends BasePanelMain {

	/**
	 * Create the panel.
	 */
	public PanelRNTCPRetransmissionMain() {
		super(null);
		initComponents();
	}

	@Override
	protected void initComponents() {
		panelModel = new PanelRNTCPRetransmissionModel();
		panelMenu = new PanelRNTCPRetransmissionMenu((PanelRNTCPRetransmissionModel) panelModel);
		panelTitle = new PanelTitle("TCP-Retransmission", panelModel);		
		initLayout(200);
	}

}
