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
	protected void initComponents() {
		IFairnessManagement fairness = new FairnessManagement();
		panelModel = new PanelRNTCPFairnessModel(fairness);
		panelMenu = new PanelRNTCPFairnessMenu(fairness);
		panelTitle = new PanelRNTCPFairnessTitle(fairness);		
	}

	@Override
	protected BasePanelTitle getPanelTitle() {
		return panelTitle;
	}

	@Override
	protected BasePanelMenu getPanelMenu() {
		return panelMenu;
	}

	@Override
	protected BasePanelModel getPanelModel() {
		return panelModel;
	}
}
