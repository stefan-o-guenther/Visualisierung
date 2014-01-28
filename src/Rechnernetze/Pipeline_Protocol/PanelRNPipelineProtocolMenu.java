/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Pipeline_Protocol;

import javax.swing.JPanel;

import Base.BasePanelMenu;
import Base.BasePanelModel;

public class PanelRNPipelineProtocolMenu extends BasePanelMenu {

	IPipelineManagement pipeline;
	
	/**
	 * Create the panel.
	 */
	public PanelRNPipelineProtocolMenu(IPipelineManagement ipipeline, BasePanelModel model) {
		super(model);
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
