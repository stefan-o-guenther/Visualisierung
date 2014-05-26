/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Retransmission;

import Base.PanelMainAbstract;
import Base.PanelMenuAbstract;
import Base.PanelModelAbstract;

public class PanelRNTCPRetransmissionMainImpl extends PanelMainAbstract {

	public PanelRNTCPRetransmissionMainImpl() {
		super(new ManagementRetransmissionImpl(), new ToolTipManagerRetransmissionImpl());
		this.initPanel();
	}
	
	@Override
	public PanelMenuAbstract getNewPanelMenu() {
		ManagementRetransmission retransmission = (ManagementRetransmission) this.getManagement();
		ToolTipManagerRetransmission tooltip = (ToolTipManagerRetransmission) this.getToolTipManager();
		return new PanelRNTCPRetransmissionMenuImpl(retransmission, tooltip);
	}

	@Override
	public PanelModelAbstract getNewPanelModel() {
		ManagementRetransmission retransmission = (ManagementRetransmission) this.getManagement();
		ToolTipManagerRetransmission tooltip = (ToolTipManagerRetransmission) this.getToolTipManager();
		return new PanelRNTCPRetransmissionModelImpl(retransmission, tooltip);
	}
}
