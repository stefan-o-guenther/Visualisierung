/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.TCP_Retransmission;

import Base.ManagementFactory;
import Base.PanelAbstract;
import Base.PanelMainAbstract;

public class PanelRNTCPRetransmissionMainImpl extends PanelMainAbstract {

	private static final long serialVersionUID = 1L;

	public PanelRNTCPRetransmissionMainImpl() {
		super(ManagementFactory.getManagementTCPRetransmission());
		this.createPanel();
	}

	@Override
	protected PanelAbstract getNewPanelMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected PanelAbstract getNewPanelModel() {
		// TODO Auto-generated method stub
		return null;
	}

}
