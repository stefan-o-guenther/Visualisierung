package Rechnernetze.Pipeline_Protocol;

import Base.PanelMenuBoxAbstract;
import Base.PanelMenuControlAbstract;
import Base.PanelMenuMenuAbstract;
import Base.ToolTipManager;

public class PanelRNPipelineProtocolMenuAutomaticBoxImpl extends PanelMenuBoxAbstract {

	public PanelRNPipelineProtocolMenuAutomaticBoxImpl(ManagementPipelineProtocol pipeline, ToolTipManager tooltip) {
		super(pipeline, tooltip);
	}
	
	@Override
	protected PanelMenuMenuAbstract getNewPanelMenuAutomaticMenu() {
		ManagementPipelineProtocol pipeline = (ManagementPipelineProtocol) this.getManagement();
		ToolTipManagerPipelineProtocol tooltip = (ToolTipManagerPipelineProtocol) this.getToolTipManager();
		return new PanelRNPipelineProtocolMenuAutomaticMenuBoxImpl(pipeline, tooltip);
	}

	@Override
	protected PanelMenuControlAbstract getNewPanelAutomaticMenuControler() {
		ManagementPipelineProtocol pipeline = (ManagementPipelineProtocol) this.getManagement();
		ToolTipManagerPipelineProtocol tooltip = (ToolTipManagerPipelineProtocol) this.getToolTipManager();
		return new PanelRNPipelineProtocolMenuAutomaticControlImpl(pipeline, tooltip);
	}
}
