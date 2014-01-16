package Rechnernetze.TCP_Fairness;

import Base.BasePanelMain;
import Base.PanelTitle;

public class PanelRNTCPFairnessMain extends BasePanelMain {

	/**
	 * Create the panel.
	 */
	public PanelRNTCPFairnessMain() {
		super(new FairnessManagement());
		initComponents();
	}

	@Override
	protected void initComponents() {
		IFairnessManagement fairness = (IFairnessManagement) management;
		
		String tooltip = 
	        	  "<html>"
	        	+ "Mit diesem Geschwindigkeitsregeler k�nnen Sie einstellen,<br>"
	        	+ "wie schnell der Auto-Durchlauf ausgef�hrt werden soll.<br>"
	        	+ "Standardm��ig ist die Geschwindigkeit auf 50% eingestellt.<br>"
	        	+ "</html>";
		
		panelModel = new PanelRNTCPFairnessModel(fairness);
		panelMenu = new PanelRNTCPFairnessMenu(fairness, panelModel);
		panelTitle = new PanelTitle(fairness, panelModel, "TCP-Fairness", tooltip);		
		initLayout(200);
	}

}
