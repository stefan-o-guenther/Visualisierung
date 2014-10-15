/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Queueing_And_Loss;

import Base.PanelAbstract;
import Base.PanelMainAbstract;

public class PanelRNQueueingAndLossMainImpl extends PanelMainAbstract {

	private static final long serialVersionUID = 1L;

	public PanelRNQueueingAndLossMainImpl() {
		super(ManagementQALImpl.getInstance());
		this.createPanel();
	}

	@Override
	protected PanelAbstract getNewPanelMenu() {
		PanelAbstract panelLeft = new PanelRNQueueingAndLossMenuImpl();
		
		PanelAbstract panelSpeed = new PanelRNQueueingAndLossControlSpeedImpl();
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
