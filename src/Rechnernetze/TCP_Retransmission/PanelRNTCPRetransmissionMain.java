/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Retransmission;

import Base.BasePanelMain;
import Base.BasePanelMenu;
import Base.BasePanelModel;
import Base.BasePanelTitle;

public class PanelRNTCPRetransmissionMain extends BasePanelMain {

	public PanelRNTCPRetransmissionMain() {
		super();
		initComponents();
		initLayout();
	}
	
	private PanelRNTCPRetransmissionTitle panelTitle;
	private PanelRNTCPRetransmissionMenu panelMenu;
	private PanelRNTCPRetransmissionModel panelModel;

	@Override
	public void initComponents() {
		IRetransmissionManagement retransmission = new RetransmissionManagement();
		panelModel = new PanelRNTCPRetransmissionModel(retransmission);
		panelMenu = new PanelRNTCPRetransmissionMenu(retransmission);
		panelTitle = new PanelRNTCPRetransmissionTitle(retransmission);		
	}

	@Override
	public BasePanelTitle getPanelTitle() {
		return panelTitle;
	}

	@Override
	public BasePanelMenu getPanelMenu() {
		return panelMenu;
	}

	@Override
	public BasePanelModel getPanelModel() {
		return panelModel;
	}
}
