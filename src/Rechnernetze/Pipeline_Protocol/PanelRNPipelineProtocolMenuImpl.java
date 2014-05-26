/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Pipeline_Protocol;

import Base.PanelMenuAbstract;

public class PanelRNPipelineProtocolMenuImpl extends PanelMenuAbstract {
	
	public PanelRNPipelineProtocolMenuImpl(ManagementPipelineProtocol pipeline, ToolTipManagerPipelineProtocol tooltip) {
		super(pipeline, tooltip);
		this.initPanel();
	}
	
	private ManagementPipelineProtocol pipeline;

	@Override
	protected void initComponents() {
		this.pipeline = (ManagementPipelineProtocol) this.getManagement();
	}

	@Override
	protected void initLayout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getHeightMenu() {
		return 200;
	}
}
