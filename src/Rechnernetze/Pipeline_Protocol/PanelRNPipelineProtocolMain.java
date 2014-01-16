package Rechnernetze.Pipeline_Protocol;

import Base.BasePanelMain;
import Base.PanelTitle;

public class PanelRNPipelineProtocolMain extends BasePanelMain {

	/**
	 * Create the panel.
	 */
	public PanelRNPipelineProtocolMain() {
		super(new PipelineManagement());
		initComponents();
	}

	@Override
	protected void initComponents() {
		IPipelineManagement pipeline = (IPipelineManagement) management;
		
		String tooltip = 
	        	  "<html>"
	        	+ "Mit diesem Geschwindigkeitsregeler k�nnen Sie einstellen,<br>"
	        	+ "wie schnell der Auto-Durchlauf ausgef�hrt werden soll.<br>"
	        	+ "Standardm��ig ist die Geschwindigkeit auf 50% eingestellt.<br>"
	        	+ "</html>";
		
		panelModel = new PanelRNPipelineProtocolModel(pipeline);
		panelMenu = new PanelRNPipelineProtocolMenu(pipeline, panelModel);
		panelTitle = new PanelTitle(pipeline, panelModel, "Pipeline Protocol", tooltip);		
		initLayout(200);
	}

}
