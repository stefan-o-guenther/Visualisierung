/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Congestion_Avoidance;

import Base.BasePanelMain;
import Base.BasePanelMenu;
import Base.BasePanelModel;
import Base.BasePanelTitle;

public class PanelRNCongestionAvoidanceMain extends BasePanelMain {

	public PanelRNCongestionAvoidanceMain() {
		super();
		initComponents();
		initLayout();
	}

	private PanelRNCongestionAvoidanceTitle panelTitle;
	private PanelRNCongestionAvoidanceMenu panelMenu;
	private PanelRNCongestionAvoidanceModel panelModel;
	
	@Override
	public void initComponents() {
		INetworkManagement network = new NetworkManagement();
		panelModel = new PanelRNCongestionAvoidanceModel(network);
		panelMenu = new PanelRNCongestionAvoidanceMenu(network);
		panelTitle = new PanelRNCongestionAvoidanceTitle(network);		
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