/**
 * @author:	Stefan Otto Günther
 * @date:	29.01.2014
 */

package Rechnernetze.Pipeline_Protocol;

import Base.BasePanelTitle;

public class PanelRNPipelineProtocolTitle extends BasePanelTitle {

	public PanelRNPipelineProtocolTitle(IPipelineManagement pipeline) {
		super(pipeline);
	}

	@Override
	public String getToolTip() {
		return ToolTipManager.getToolTipTitle();
	}

	@Override
	public String getTitle() {
		return "Pipeline Protocol";
	}
}