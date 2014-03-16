/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Fairness;

import Base.BasePanelMain;
import Base.BasePanelMenu;
import Base.BasePanelModel;
import Base.BasePanelTitle;

public class PanelRNTCPFairnessMain extends BasePanelMain {

	public PanelRNTCPFairnessMain() {
		super();
		initComponents();
		initLayout();
	}
	
	private PanelRNTCPFairnessTitle panelTitle;
	private PanelRNTCPFairnessMenu panelMenu;
	private PanelRNTCPFairnessModel panelModel;

	@Override
	public void initComponents() {
		IFairnessManagement fairness = new FairnessManagement();
		panelModel = new PanelRNTCPFairnessModel(fairness);
		panelMenu = new PanelRNTCPFairnessMenu(fairness);
		panelTitle = new PanelRNTCPFairnessTitle(fairness);		
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
