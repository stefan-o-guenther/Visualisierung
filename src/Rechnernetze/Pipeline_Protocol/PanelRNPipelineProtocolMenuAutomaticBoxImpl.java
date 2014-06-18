package Rechnernetze.Pipeline_Protocol;

import Base.PanelMenuAutomaticBoxAbstract;
import Base.PanelMenuAutomaticMenuAbstract;
import Base.ToolTipManagerAutomatic;

public class PanelRNPipelineProtocolMenuAutomaticBoxImpl extends PanelMenuAutomaticBoxAbstract {

	public PanelRNPipelineProtocolMenuAutomaticBoxImpl(ManagementPipelineProtocol pipeline, ToolTipManagerAutomatic tooltip) {
		super(pipeline, tooltip);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected PanelMenuAutomaticMenuAbstract getNewPanelMenuAutomaticMenu() {
		ManagementPipelineProtocol pipeline = (ManagementPipelineProtocol) this.getManagement();
		ToolTipManagerPipelineProtocol tooltip = (ToolTipManagerPipelineProtocol) this.getToolTipManager();
		return new PanelRNPipelineProtocolMenuAutomaticMenuImpl(pipeline, tooltip);
	}
}
