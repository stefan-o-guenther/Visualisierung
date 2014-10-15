/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Pipeline_Protocol;

import Base.PanelAbstract;
import Base.PanelMainAbstract;

public class PanelRNPipelineProtocolMainImpl extends PanelMainAbstract {

	private static final long serialVersionUID = 1L;

	public PanelRNPipelineProtocolMainImpl() {
		super(ManagementARQImpl.getInstance());
		this.createPanel();
	}

	@Override
	protected PanelAbstract getNewPanelMenu() {
		PanelAbstract panelLeft = new PanelRNPipelineProtocolMenuImpl();
		PanelAbstract panelRight = new PanelRNPipelineProtocolLabelImpl();
		PanelAbstract panelMenu = this.getPanelCoupleHorizontal(panelLeft, panelRight);
		PanelAbstract panelSpeed = new PanelRNPipelineProtocolMenuControlSpeedImpl();
		PanelAbstract panelTimeout = new PanelRNPipelineProtocolMenuControlTimeoutImpl();		
		PanelAbstract panelAutomatic = this.getPanelCoupleVertical(panelSpeed, panelTimeout);
		return this.getPanelCoupleHorizontal(panelMenu, panelAutomatic);
	}

	@Override
	protected PanelAbstract getNewPanelModel() {
		return new PanelRNPipelineProtocolModelImpl();
	}
}
