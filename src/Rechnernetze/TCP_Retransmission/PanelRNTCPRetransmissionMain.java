/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Retransmission;

import Base.BasePanelMain;
import Base.PanelTitle;

public class PanelRNTCPRetransmissionMain extends BasePanelMain {

	/**
	 * Create the panel.
	 */
	public PanelRNTCPRetransmissionMain() {
		super(new RetransmissionManagement());
		initComponents();
	}

	@Override
	protected void initComponents() {
		IRetransmissionManagement retransmission = (IRetransmissionManagement) management;
		
		String tooltip = 
	        	  "<html>"
	        	+ "Mit diesem Geschwindigkeitsregeler k�nnen Sie einstellen,<br>"
	        	+ "wie schnell der Auto-Durchlauf ausgef�hrt werden soll.<br>"
	        	+ "Standardm��ig ist die Geschwindigkeit auf 50% eingestellt.<br>"
	        	+ "</html>";
		
		panelModel = new PanelRNTCPRetransmissionModel(retransmission);
		panelMenu = new PanelRNTCPRetransmissionMenu(retransmission, panelModel);
		panelTitle = new PanelTitle(retransmission, panelModel, "TCP-Retransmission", tooltip);		
		initLayout(200);
	}

}
