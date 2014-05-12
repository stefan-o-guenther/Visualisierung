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
		super(new ManagementQueueingAndLossImpl(1E-4), new ToolTipManagerQueueingAndLossImpl());
		initComponents();
		initLayout();
	}

	@Override
	public PanelMenuAbstract getNewPanelMenu() {
		ManagementQueueingAndLoss qal = (ManagementQueueingAndLoss) this.getManagement();
		ToolTipManagerQueueingAndLoss tooltip = (ToolTipManagerQueueingAndLoss) this.getToolTipManager();
		return new PanelRNQueueingAndLossMenuImpl(qal, tooltip);
	}

	@Override
	public PanelModelAbstract getNewPanelModel() {
		ManagementQueueingAndLoss qal = (ManagementQueueingAndLoss) this.getManagement();
		ToolTipManagerQueueingAndLoss tooltip = (ToolTipManagerQueueingAndLoss) this.getToolTipManager();
		return new PanelRNQueueingAndLossModelImpl(qal, tooltip);
	}
}
