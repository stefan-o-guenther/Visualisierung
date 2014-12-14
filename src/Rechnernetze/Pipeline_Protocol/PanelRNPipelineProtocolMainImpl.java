/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Pipeline_Protocol;

import Base.ManagementFactory;
import Base.PanelAbstract;
import Base.PanelControlSpeedPacketImpl;
import Base.PanelMainAbstract;

public class PanelRNPipelineProtocolMainImpl extends PanelMainAbstract {

	private static final long serialVersionUID = 1L;

	public PanelRNPipelineProtocolMainImpl() {
		super(ManagementFactory.getManagementAutomaticRepeatRequest());
		this.createPanel();
	}

	@Override
	protected PanelAbstract getNewPanelMenu() {
		PanelAbstract panelMenu = new PanelRNPipelineProtocolMenuImpl();
		PanelAbstract panelLabel = new PanelRNPipelineProtocolTableExplanationImpl();
		PanelAbstract panelLeft = this.getPanelCoupleHorizontal(panelMenu, panelLabel);
		
		PanelAbstract panelSpeed = new PanelControlSpeedPacketImpl(ManagementFactory.getManagementAutomaticRepeatRequest(), "Geschwindigkeit:");
		PanelAbstract panelTimeout = new PanelRNPipelineProtocolControlTimeoutImpl();		
		PanelAbstract panelAutomatic = this.getPanelCoupleVertical(panelSpeed, panelTimeout);
		
		PanelAbstract panelMessage = new PanelRNPipelineProtocolMessageImpl();
		PanelAbstract panelRight = this.getPanelCoupleVertical(panelAutomatic, panelMessage);
		
		return this.getPanelCoupleHorizontal(panelLeft, panelRight);
	}

	@Override
	protected PanelAbstract getNewPanelModel() {
		return new PanelRNPipelineProtocolModelImpl();
	}
}
