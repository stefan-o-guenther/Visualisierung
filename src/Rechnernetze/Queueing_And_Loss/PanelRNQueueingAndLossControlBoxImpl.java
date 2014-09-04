package Rechnernetze.Queueing_And_Loss;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import Base.Management;
import Base.ManagementTestImpl;
import Base.PanelMenuControlAbstract;


public class PanelRNQueueingAndLossControlBoxImpl extends PanelMenuControlAbstract {

	private static final long serialVersionUID = 1L;

	public PanelRNQueueingAndLossControlBoxImpl(Management management) {
		super(management);
	}
	
	private PanelRNQueueingAndLossControlBoxImpl() {
		super(new ManagementTestImpl());	
	}
	
	private PanelMenuControlAbstract panelSpeed;
	private PanelMenuControlAbstract panelProcessing;
	private PanelMenuControlAbstract panelInterval;

	@Override
	public void updatePanel() {
		this.panelSpeed.updatePanel();
		this.panelProcessing.updatePanel();
		this.panelInterval.updatePanel();
	}

	@Override
	protected void initComponentsMenu() {
		panelSpeed = new PanelRNQueueingAndLossControlSpeedImpl(management);
		panelProcessing = new PanelRNQueueingAndLossControlProcessingImpl(management);
		panelInterval = new PanelRNQueueingAndLossControlIntervalImpl(management);
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
					.addComponent(panelSpeed, GroupLayout.PREFERRED_SIZE, panelSpeed.getPanelHeight(), GroupLayout.PREFERRED_SIZE)
					.addComponent(panelProcessing, GroupLayout.PREFERRED_SIZE, panelProcessing.getPanelHeight(), GroupLayout.PREFERRED_SIZE)
					.addComponent(panelInterval, GroupLayout.DEFAULT_SIZE, panelInterval.getPanelHeight(), Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}
