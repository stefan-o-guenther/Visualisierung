package Rechnernetze.Pipeline_Protocol;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import Base.PanelMenuAbstract;
import Base.PanelMenuMenuAbstract;

public class PanelRNPipelineProtocolMenuAutomaticMenuBoxImpl extends PanelMenuMenuAbstract {

	public PanelRNPipelineProtocolMenuAutomaticMenuBoxImpl(ManagementPipelineProtocol pipeline, ToolTipManagerPipelineProtocol tooltip) {
		super(pipeline, tooltip);
	}
	
	private PanelRNPipelineProtocolMenuAutomaticMenuBoxImpl() {
		super(new ManagementPipelineProtocolImpl(), new ToolTipManagerPipelineProtocolImpl());		
		this.initComponents();
		this.initLayout();
	}
	
	private PanelMenuMenuAbstract panelMenu;		
	private PanelMenuAbstract panelLabel;
	
	@Override
	public Integer getLengthMenu() {
		Integer length = 150;
		if (panelMenu != null) {
			length += panelMenu.getLengthMenu();
		}
		return length;
	}

	@Override
	public Integer getHeightMenu() {
		Integer heightMenu = 0;
		int h1 = 0;
		if (panelMenu != null) {
			h1 = panelMenu.getHeightMenu();
		}
		int h2 = 0;
		if (panelLabel != null) {
			h2 = panelLabel.getHeightMenu();
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
		ToolTipManagerPipelineProtocol tooltip = (ToolTipManagerPipelineProtocol) this.getToolTipManager();		
		panelMenu = new PanelRNPipelineProtocolMenuAutomaticMenuMenuImpl(pipeline, tooltip);		
		panelLabel = new PanelRNPipelineProtocolMenuAutomaticMenuLabelImpl(pipeline, tooltip);		
	}

	@Override
	protected void initLayout() {
		Integer heightMenu = this.getHeightMenu();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelMenu, GroupLayout.DEFAULT_SIZE, panelMenu.getLengthMenu(), Short.MAX_VALUE)
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
