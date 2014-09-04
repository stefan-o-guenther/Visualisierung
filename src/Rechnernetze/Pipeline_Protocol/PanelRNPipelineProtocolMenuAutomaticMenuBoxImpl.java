package Rechnernetze.Pipeline_Protocol;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import Base.PanelMenuAbstract;
import Base.PanelMenuAbstract;

public class PanelRNPipelineProtocolMenuAutomaticMenuBoxImpl extends PanelMenuAbstract {

	public PanelRNPipelineProtocolMenuAutomaticMenuBoxImpl(ManagementPipelineProtocol pipeline) {
		super(pipeline);
	}
	
	private PanelRNPipelineProtocolMenuAutomaticMenuBoxImpl() {
		super(new ManagementPipelineProtocolImpl());		
		this.initComponents();
		this.initLayout();
	}
	
	private PanelMenuAbstract panelMenu;		
	private PanelMenuAbstract panelLabel;
	
	@Override
	public Integer getPanelWidth() {
		Integer length = 150;
		if (panelMenu != null) {
			length += panelMenu.getPanelWidth();
		}
		return length;
	}

	@Override
	public Integer getPanelHeight() {
		Integer heightMenu = 0;
		int h1 = 0;
		if (panelMenu != null) {
			h1 = panelMenu.getPanelHeight();
		}
		int h2 = 0;
		if (panelLabel != null) {
			h2 = panelLabel.getPanelHeight();
		}
		if (h2 > h1) {
			heightMenu = h2;
		} else {
			heightMenu = h1;
		}
		return heightMenu;
	}

	@Override
	public void updatePanel() {
		panelMenu.updatePanel();
		panelLabel.updatePanel();
	}

	@Override
	protected void initComponentsMenu() {
		ManagementPipelineProtocol pipeline = (ManagementPipelineProtocol) this.getManagement();
		panelMenu = new PanelRNPipelineProtocolMenuAutomaticMenuMenuImpl(pipeline);		
		panelLabel = new PanelRNPipelineProtocolMenuAutomaticMenuLabelImpl(pipeline);		
	}

	@Override
	protected void initLayout() {
		Integer heightMenu = this.getPanelHeight();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelMenu, GroupLayout.DEFAULT_SIZE, panelMenu.getPanelWidth(), Short.MAX_VALUE)
					.addComponent(panelLabel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelMenu, GroupLayout.DEFAULT_SIZE, heightMenu, Short.MAX_VALUE)
				.addComponent(panelLabel, GroupLayout.DEFAULT_SIZE, heightMenu, Short.MAX_VALUE)
		);
		setLayout(groupLayout);
	}

	@Override
	protected void initMethods() {
		// nothing
	}
}
