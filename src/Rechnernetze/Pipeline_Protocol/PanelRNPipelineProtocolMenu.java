/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Pipeline_Protocol;

import Base.BasePanelMenu;

public class PanelRNPipelineProtocolMenu extends BasePanelMenu {

	IPipelineManagement pipeline;
	
	/**
	 * Create the panel.
	 */
	public PanelRNPipelineProtocolMenu(IPipelineManagement ipipeline) {
		super();
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
	public Integer getHeightMenu() {
		return 200;
	}

}
