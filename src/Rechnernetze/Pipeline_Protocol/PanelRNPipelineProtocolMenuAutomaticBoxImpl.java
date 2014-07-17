package Rechnernetze.Pipeline_Protocol;

import Base.PanelMenuAutomaticBoxAbstract;
import Base.PanelMenuAutomaticControlAbstract;
import Base.PanelMenuAutomaticMenuAbstract;
import Base.ToolTipManagerAutomatic;

public class PanelRNPipelineProtocolMenuAutomaticBoxImpl extends PanelMenuAutomaticBoxAbstract {

	public PanelRNPipelineProtocolMenuAutomaticBoxImpl(ManagementPipelineProtocol pipeline, ToolTipManagerAutomatic tooltip) {
		super(pipeline, tooltip);
		this.initPanel();
	}
	
	@Override
	protected PanelMenuAutomaticMenuAbstract getNewPanelMenuAutomaticMenu() {
		ManagementPipelineProtocol pipeline = (ManagementPipelineProtocol) this.getManagement();
		ToolTipManagerPipelineProtocol tooltip = (ToolTipManagerPipelineProtocol) this.getToolTipManager();
		return new PanelRNPipelineProtocolMenuAutomaticMenuBoxImpl(pipeline, tooltip);
	}

	@Override
	protected PanelMenuAutomaticControlAbstract getNewPanelAutomaticMenuControler() {
		ManagementPipelineProtocol pipeline = (ManagementPipelineProtocol) this.getManagement();
		ToolTipManagerPipelineProtocol tooltip = (ToolTipManagerPipelineProtocol) this.getToolTipManager();
		return new PanelRNPipelineProtocolMenuAutomaticControlImpl(pipeline, tooltip);
	}
}
