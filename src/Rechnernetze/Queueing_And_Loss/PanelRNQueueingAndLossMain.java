/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Queueing_And_Loss;

import Base.BasePanelMain;
import Base.BasePanelMenu;
import Base.BasePanelModel;
import Base.BasePanelTitle;

public class PanelRNQueueingAndLossMain extends BasePanelMain {

	public PanelRNQueueingAndLossMain() {
		super();
		initComponents();
		initLayout();
	}

	private PanelRNQueueingAndLossTitle panelTitle;
	private PanelRNQueueingAndLossMenu panelMenu;
	private PanelRNQueueingAndLossModel panelModel;
	
	@Override
	protected void initComponents() {
		IQALManagement qal = new QALManagement();		
		panelModel = new PanelRNQueueingAndLossModel(qal);
		panelMenu = new PanelRNQueueingAndLossMenu(qal, panelModel);
		panelTitle = new PanelRNQueueingAndLossTitle(qal, panelModel);		
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
