package Rechnernetze.Pipeline_Protocol;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import Base.Management;
import Base.PanelMenuAbstract;
import Base.ToolTipManager;

public class PanelRNPipelineProtocolMenuPipelineBoxImpl extends PanelMenuAbstract {
	

	public PanelRNPipelineProtocolMenuPipelineBoxImpl(Management management, ToolTipManager tooltip) {
		super(management, tooltip);
		this.initPanel();
	}

	private JPanel panelMenu;	
	private JPanel panelPipeline;
	
	@Override
	public Integer getHeightMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initComponents() {
		panelMenu = new JPanel();
		panelPipeline = new JPanel();
	}

	@Override
	protected void initLayout() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelMenu, GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
				.addComponent(panelPipeline, GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelMenu, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
					.addComponent(panelPipeline, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);
	}
}
