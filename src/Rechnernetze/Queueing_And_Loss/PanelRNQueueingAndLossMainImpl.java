/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Queueing_And_Loss;

import Base.ManagementFactory;
import Base.PanelAbstract;
import Base.PanelControlSpeedPacketImpl;
import Base.PanelMainAbstract;

public class PanelRNQueueingAndLossMainImpl extends PanelMainAbstract {

	private static final long serialVersionUID = 1L;

	public PanelRNQueueingAndLossMainImpl() {
		super(ManagementFactory.getManagementQueueingAndLoss());
		this.createPanel();
	}

	@Override
	protected PanelAbstract getNewPanelMenu() {
		PanelAbstract panelLeft = new PanelRNQueueingAndLossMenuImpl();
		
		PanelAbstract panelSpeed = new PanelControlSpeedPacketImpl(ManagementFactory.getManagementQueueingAndLoss(), "Übertragungsrate Eingang:");
		
		PanelAbstract panelProcessing = new PanelRNQueueingAndLossControlProcessingImpl();
		PanelAbstract panelInterval = new PanelRNQueueingAndLossControlIntervalImpl();
		
		PanelAbstract panelCoupleVertical = this.getPanelCoupleVertical(panelSpeed, panelProcessing);
		PanelAbstract panelRight = this.getPanelCoupleVertical(panelCoupleVertical, panelInterval);		
		
		return this.getPanelCoupleHorizontal(panelLeft, panelRight);
	}

	@Override
	protected PanelAbstract getNewPanelModel() {
		return new PanelRNQueueingAndLossModelImpl();
	}
}
