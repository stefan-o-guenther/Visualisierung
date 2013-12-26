package Rechnernetze.Pipeline_Protocol;

import javax.swing.JPanel;

import Base.BasePanelMenu;

public class PanelRNPipelineProtocolMenu extends BasePanelMenu {

	IPipelineManagement pipeline;
	
	/**
	 * Create the panel.
	 */
	public PanelRNPipelineProtocolMenu(IPipelineManagement ipipeline) {
		if (ipipeline == null) {
			ipipeline = new PipelineManagement();
		}
		pipeline = ipipeline;
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
