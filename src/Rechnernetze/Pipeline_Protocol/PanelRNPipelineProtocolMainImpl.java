/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Pipeline_Protocol;

import Base.PanelAbstract;
import Base.PanelMainAbstract;

public class PanelRNPipelineProtocolMainImpl extends PanelMainAbstract {

	private static final long serialVersionUID = 1L;

	public PanelRNPipelineProtocolMainImpl(ManagementPipelineProtocol pipeline) {
		super(pipeline);
	}

	@Override
	protected PanelAbstract getNewPanelMenu() {
		ManagementPipelineProtocol pipeline = (ManagementPipelineProtocol) this.getManagement();
		PanelAbstract panelLeft = new PanelRNPipelineProtocolMenuAutomaticMenuMenuImpl(pipeline);
		PanelAbstract panelRight = new PanelRNPipelineProtocolMenuAutomaticMenuLabelImpl(pipeline);
		PanelAbstract panelMenu = this.getPanelCoupleHorizontal(panelLeft, panelRight);
		PanelAbstract panelSpeed = new PanelMenuControlSpeedImpl(pipeline);
		PanelAbstract panelTimeout = new PanelMenuControlTimeoutImpl(pipeline);		
		PanelAbstract panelAutomatic = this.getPanelCoupleVertical(panelSpeed, panelTimeout);
		return this.getPanelCoupleHorizontal(panelMenu, panelAutomatic);
	}

	@Override
	protected PanelAbstract getNewPanelModel() {
		ManagementPipelineProtocol pipeline = (ManagementPipelineProtocol) this.getManagement();
		return new PanelRNPipelineProtocolModelImpl(pipeline);
	}
}
