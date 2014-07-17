/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Queueing_And_Loss;

import Base.PanelMainAbstract;
import Base.PanelMenuAbstract;
import Base.PanelModelAbstract;

public class PanelRNQueueingAndLossMainImpl extends PanelMainAbstract {

	public PanelRNQueueingAndLossMainImpl() {
		super(new ManagementQueueingAndLossImpl(), new ToolTipManagerQueueingAndLossImpl());
		this.initPanel();
	}

	@Override
	public PanelMenuAbstract getNewPanelMenu() {
		ManagementQueueingAndLoss qal = (ManagementQueueingAndLoss) this.getManagement();
		ToolTipManagerQueueingAndLoss tooltip = (ToolTipManagerQueueingAndLoss) this.getToolTipManager();
		return new PanelRNQueueingAndLossMenuAutomaticBoxImpl(qal, tooltip);
	}

	@Override
	public PanelModelAbstract getNewPanelModel() {
		ManagementQueueingAndLoss qal = (ManagementQueueingAndLoss) this.getManagement();
		ToolTipManagerQueueingAndLoss tooltip = (ToolTipManagerQueueingAndLoss) this.getToolTipManager();
		return new PanelRNQueueingAndLossModelImpl(qal, tooltip);
	}
}
