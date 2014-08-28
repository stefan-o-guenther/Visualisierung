package Rechnernetze.Queueing_And_Loss;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import Base.*;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;


public class PanelRNQueueingAndLossMenuAutomaticControlBoxImpl extends PanelMenuControlAbstract {

	public PanelRNQueueingAndLossMenuAutomaticControlBoxImpl(Management management, ToolTipManager tooltip) {
		super(management, tooltip);
	}
	
	private PanelRNQueueingAndLossMenuAutomaticControlBoxImpl() {
		super(new ManagementTestImpl(), new ToolTipManagerTestImpl());	
	}
	
	private PanelMenuControlAbstract panelSpeed;
	private PanelMenuControlAbstract panelProcessing;
	private PanelMenuControlAbstract panelInterval;

	@Override
	public Integer getHeightMenu() {
		return this.panelSpeed.getHeightMenu() + this.panelProcessing.getHeightMenu();
	}

	@Override
	public void updatePanel() {
		this.panelSpeed.updatePanel();
		this.panelProcessing.updatePanel();
		this.panelInterval.updatePanel();
	}

	@Override
	protected void initComponentsMenu() {
		panelSpeed = new PanelRNQueueingAndLossMenuAutomaticControlSpeedImpl(management, tooltip);
		panelProcessing = new PanelRNQueueingAndLossMenuAutomaticControlProcessingImpl(management, tooltip);
		panelInterval = new PanelRNQueueingAndLossMenuAutomaticControlIntervalImpl(management, tooltip);
	}

	@Override
	protected void initMethods() {
		
	}

	@Override
	protected void initLayout() {		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelSpeed, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
				.addComponent(panelProcessing, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
				.addComponent(panelInterval, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelSpeed, GroupLayout.PREFERRED_SIZE, panelSpeed.getHeightMenu(), GroupLayout.PREFERRED_SIZE)
					.addComponent(panelProcessing, GroupLayout.PREFERRED_SIZE, panelProcessing.getHeightMenu(), GroupLayout.PREFERRED_SIZE)
					.addComponent(panelInterval, GroupLayout.DEFAULT_SIZE, panelInterval.getHeightMenu(), Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}
