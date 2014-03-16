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
	public void initComponents() {
		IPipelineManagement pipeline = new PipelineManagement();		
		panelModel = new PanelRNPipelineProtocolModel(pipeline);
		panelMenu = new PanelRNPipelineProtocolMenu(pipeline);
		panelTitle = new PanelRNPipelineProtocolTitle(pipeline);		
	}

	@Override
	public BasePanelTitle getPanelTitle() {
		return panelTitle;
	}

	@Override
	public BasePanelMenu getPanelMenu() {
		return panelMenu;
	}

	@Override
	public BasePanelModel getPanelModel() {
		return panelModel;
	}
}
