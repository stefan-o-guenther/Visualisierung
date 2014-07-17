/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Retransmission;

import Base.FrameAbstract;

public class FrameRNTCPRetransmission extends FrameAbstract {

	public FrameRNTCPRetransmission() {
		super("TCP-Retransmission");
        initUI(new PanelRNTCPRetransmissionMainImpl());
    }
}
