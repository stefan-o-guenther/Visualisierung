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
		PanelAbstract panelLeft = new PanelRNPipelineProtocolMenuImpl();
		PanelAbstract panelRight = new PanelRNPipelineProtocolTableExplanationImpl();
		PanelAbstract panelMenu = this.getPanelCoupleHorizontal(panelLeft, panelRight);
		
		PanelAbstract panelSpeed = new PanelControlSpeedPacketImpl(ManagementFactory.getManagementAutomaticRepeatRequest(), "Geschwindigkeit:");
		PanelAbstract panelTimeout = new PanelRNPipelineProtocolControlTimeoutImpl();		
		PanelAbstract panelAutomatic = this.getPanelCoupleVertical(panelSpeed, panelTimeout);
		return this.getPanelCoupleHorizontal(panelMenu, panelAutomatic);
	}

	@Override
	protected PanelAbstract getNewPanelModel() {
		return new PanelRNPipelineProtocolModelImpl();
	}
}
