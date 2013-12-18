package Rechnernetze.Queueing_And_Loss;

import Base.BasePanelMain;
import Base.PanelTitle;

public class PanelRNQueueingAndLossMain extends BasePanelMain {

	/**
	 * Create the panel.
	 */
	public PanelRNQueueingAndLossMain() {
		panelModel = new PanelRNQueueingAndLossModel();
		panelMenu = new PanelRNQueueingAndLossMenu((PanelRNQueueingAndLossModel) panelModel);
		panelTitle = new PanelTitle("Queueing And Loss", panelModel);		
		initLayout(200);
	}

	@Override
	protected void initComponents() {
		// TODO Auto-generated method stub
		
	}

}
