/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Pipeline_Protocol;

import Base.PanelMainAbstract;
import Base.PanelMenuAbstract;
import Base.PanelModelAbstract;

public class PanelRNPipelineProtocolMainImpl extends PanelMainAbstract {

	public PanelRNPipelineProtocolMainImpl() {
		super(new ManagementPipelineProtocolImpl(), new ToolTipManagerPipelineProtocolImpl());
		initComponents();
		initLayout();
	}
	
	@Override
	public PanelMenuAbstract getNewPanelMenu() {
		ManagementPipelineProtocol pipeline = (ManagementPipelineProtocol) this.getManagement();
		ToolTipManagerPipelineProtocol tooltip = (ToolTipManagerPipelineProtocol) this.getToolTipManager();
		return new PanelRNPipelineProtocolMenuImpl(pipeline, tooltip);
	}

	@Override
	public PanelModelAbstract getNewPanelModel() {
		ManagementPipelineProtocol pipeline = (ManagementPipelineProtocol) this.getManagement();
		ToolTipManagerPipelineProtocol tooltip = (ToolTipManagerPipelineProtocol) this.getToolTipManager();
		return new PanelRNPipelineProtocolModelImpl(pipeline, tooltip);
	}
}
