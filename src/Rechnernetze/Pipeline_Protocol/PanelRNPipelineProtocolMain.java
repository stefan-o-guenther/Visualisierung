/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Pipeline_Protocol;

import Base.BasePanelMain;
import Base.BasePanelMenu;
import Base.BasePanelModel;
import Base.BasePanelTitle;

public class PanelRNPipelineProtocolMain extends BasePanelMain {

	public PanelRNPipelineProtocolMain() {
		super();
		initComponents();
		initLayout();
	}
	
	private PanelRNPipelineProtocolTitle panelTitle;
	private PanelRNPipelineProtocolMenu panelMenu;
	private PanelRNPipelineProtocolModel panelModel;

	@Override
	protected void initComponents() {
		IPipelineManagement pipeline = new PipelineManagement();		
		panelModel = new PanelRNPipelineProtocolModel(pipeline);
		panelMenu = new PanelRNPipelineProtocolMenu(pipeline);
		panelTitle = new PanelRNPipelineProtocolTitle(pipeline);		
	}

	@Override
	protected BasePanelTitle getPanelTitle() {
		return panelTitle;
	}

	@Override
	protected BasePanelMenu getPanelMenu() {
		return panelMenu;
	}

	@Override
	protected BasePanelModel getPanelModel() {
		return panelModel;
	}
}
