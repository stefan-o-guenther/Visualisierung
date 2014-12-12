/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Retransmission;

import Base.ManagementFactory;
import Base.PanelDrawingAbstract;

public class PanelRNTCPRetransmissionModelImpl extends PanelDrawingAbstract {

	private static final long serialVersionUID = 1L;

	public PanelRNTCPRetransmissionModelImpl() {
		super();
		this.createPanel();
	}
	
	private ManagementTCPRetransmission retransmission;

	@Override
	protected void doDrawing() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void createDrawing() {
		this.retransmission = ManagementFactory.getManagementTCPRetransmission();
	}

	@Override
	public Integer getPanelHeight() {
		return 100;
	}

	@Override
	public Integer getPanelWidth() {
		return 100;
	}
}
