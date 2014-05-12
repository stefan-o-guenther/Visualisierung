/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Retransmission;

import Base.PanelMainAbstract;
import Base.PanelMenuAbstract;
import Base.PanelModelAbstract;
import Base.PanelTitleImpl;

public class PanelRNTCPRetransmissionMainImpl extends PanelMainAbstract {

	public PanelRNTCPRetransmissionMainImpl() {
		super(new ManagementRetransmissionImpl(), new ToolTipManagerRetransmissionImpl());
		initComponents();
		initLayout();
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
