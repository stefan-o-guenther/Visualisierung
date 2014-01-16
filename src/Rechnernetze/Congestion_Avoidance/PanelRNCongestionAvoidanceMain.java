package Rechnernetze.Congestion_Avoidance;

import Base.BasePanelMain;
import Base.PanelTitle;

public class PanelRNCongestionAvoidanceMain extends BasePanelMain {

	/**
	 * Create the panel.
	 */
	public PanelRNCongestionAvoidanceMain() {
		super(new NetworkManagement());
		initComponents();
	}

	@Override
	protected void initComponents() {
		INetworkManagement network = (INetworkManagement) management;
		
		String tooltip = 
	        	  "<html>"
	        	+ "Mit diesem Geschwindigkeitsregeler können Sie einstellen,<br>"
	        	+ "wie schnell der Auto-Durchlauf ausgeführt werden soll.<br>"
	        	+ "Standardmäßig ist die Geschwindigkeit auf 50% eingestellt.<br>"
	        	+ "</html>";
		
		panelModel = new PanelRNCongestionAvoidanceModel(network);
		panelMenu = new PanelRNCongestionAvoidanceMenu(network, panelModel);
		panelTitle = new PanelTitle(network, panelModel, "Congestion Avoidance", tooltip);		
		initLayout(200);
	}
}
