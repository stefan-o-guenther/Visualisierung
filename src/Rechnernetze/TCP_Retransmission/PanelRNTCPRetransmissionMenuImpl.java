/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Retransmission;

import Base.PanelMenuAbstract;

public class PanelRNTCPRetransmissionMenuImpl extends PanelMenuAbstract {

	private static final long serialVersionUID = 1L;
	
	public PanelRNTCPRetransmissionMenuImpl() {
		super();
		this.createPanel();
	}

	private ManagementRetransmission retransmission;
	
	@Override
	protected void createMenuComponents() {
		this.retransmission = ManagementRetransmissionImpl.getInstance();
	}
	
	@Override
	protected void createLayout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void createMenuMethods() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getPanelHeight() {
		return 200;
	}

	@Override
	public Integer getPanelWidth() {
		return 200;
	}
}
