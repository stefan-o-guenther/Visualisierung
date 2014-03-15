/**
 * @author:	Stefan Otto G�nther
 * @date:	29.01.2014
 */

package Rechnernetze.Pipeline_Protocol;

import Base.BasePanelTitle;

public class PanelRNPipelineProtocolTitle extends BasePanelTitle {

	public PanelRNPipelineProtocolTitle(IPipelineManagement pipeline) {
		super(pipeline);
	}

	@Override
	protected String getToolTip() {
		return ToolTipManager.getToolTipTitle();
	}

	@Override
	protected String getTitle() {
		return "Pipeline Protocol";
	}
}