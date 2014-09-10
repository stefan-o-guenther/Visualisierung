/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Queueing_And_Loss;

import Base.PanelAbstract;
import Base.PanelMainAbstract;

public class PanelRNQueueingAndLossMainImpl extends PanelMainAbstract {

	private static final long serialVersionUID = 1L;

	public PanelRNQueueingAndLossMainImpl(ManagementQueueingAndLoss qal) {
		super(qal);
	}

	@Override
	protected PanelAbstract getNewPanelMenu() {
		ManagementQueueingAndLoss qal = (ManagementQueueingAndLoss) this.getManagement();
		
		PanelAbstract panelLeft = new PanelRNQueueingAndLossMenuImpl(qal);
		
		PanelAbstract panelSpeed = new PanelRNQueueingAndLossControlSpeedImpl(management);
		PanelAbstract panelProcessing = new PanelRNQueueingAndLossControlProcessingImpl(management);
		PanelAbstract panelInterval = new PanelRNQueueingAndLossControlIntervalImpl(management);
		
		PanelAbstract panelCoupleVertical = this.getPanelCoupleVertical(panelSpeed, panelProcessing);
		PanelAbstract panelRight = this.getPanelCoupleVertical(panelCoupleVertical, panelInterval);		
		
		return this.getPanelCoupleHorizontal(panelLeft, panelRight);
	}

	@Override
	protected PanelAbstract getNewPanelModel() {
		ManagementQueueingAndLoss qal = (ManagementQueueingAndLoss) this.getManagement();
		return new PanelRNQueueingAndLossModelImpl(qal);
	}
}
