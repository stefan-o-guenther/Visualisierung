package Rechnernetze.Pipeline_Protocol;

import Base.BasePanelMain;
import Base.PanelTitle;

public class PanelRNPipelineProtocolMain extends BasePanelMain {

	/**
	 * Create the panel.
	 */
	public PanelRNPipelineProtocolMain() {
		super(null);
		initComponents();
	}

	@Override
	protected void initComponents() {
		panelModel = new PanelRNPipelineProtocolModel();
		panelMenu = new PanelRNPipelineProtocolMenu((PanelRNPipelineProtocolModel) panelModel);
		panelTitle = new PanelTitle("Pipeline Protocol", panelModel);		
		initLayout(200);
	}

}
