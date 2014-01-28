/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Rechnernetze.Queueing_And_Loss;

import Base.BasePanelMain;
import Base.PanelTitle;

public class PanelRNQueueingAndLossMain extends BasePanelMain {

	/**
	 * Create the panel.
	 */
	public PanelRNQueueingAndLossMain() {
		super(new QALManagement());
		initComponents();
	}

	@Override
	protected void initComponents() {
		IQALManagement qal = (IQALManagement) management;
		
		String tooltip = 
	        	  "<html>"
	        	+ "Mit diesem Geschwindigkeitsregeler k�nnen Sie einstellen,<br>"
	        	+ "wie schnell der Auto-Durchlauf ausgef�hrt werden soll.<br>"
	        	+ "Standardm��ig ist die Geschwindigkeit auf 50% eingestellt.<br>"
	        	+ "</html>";
		
		panelModel = new PanelRNQueueingAndLossModel(qal);
		panelMenu = new PanelRNQueueingAndLossMenu(qal, panelModel);
		panelTitle = new PanelTitle(qal, panelModel, "Queueing And Loss", tooltip);		
		initLayout(130);
	}

}
