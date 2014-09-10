/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Queueing_And_Loss;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import Base.ManagementTestImpl;
import Base.PanelMenuMenuButtonsAbstract;

public class PanelRNQueueingAndLossMenuImpl extends PanelMenuMenuButtonsAbstract {

	private static final long serialVersionUID = 1L;	

	public PanelRNQueueingAndLossMenuImpl(ManagementQueueingAndLoss qal) {
		super(qal);
	}

	private PanelRNQueueingAndLossMenuImpl() {
		super(new ManagementTestImpl());
		this.initComponentsMenu();
		this.initLayout();
	}
	
	private ManagementQueueingAndLoss qal;
	
	private JLabel lblTransfersLabel;
	private JLabel lblTransfersContent;
	private JLabel lblLossLabel;
	private JLabel lblLossContent;
	
	@Override
	protected void updatePanelMenuButtons() {
		this.lblLossContent.setText(qal.getCountLoss().toString());
		this.lblTransfersContent.setText(qal.getCountTransfered().toString());
	}
	
	@Override
	protected void initComponentsMenuButtons() {
		this.qal = (ManagementQueueingAndLoss) this.getManagement();		
		lblTransfersLabel = new JLabel("\u00DCbertragungen:");		
		lblTransfersContent = new JLabel("00");		
		lblLossLabel = new JLabel("Verlust:");		
		lblLossContent = new JLabel("00");
	}
	
	@Override
	protected void initLayout() {	
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(btnExampleReset, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
							.addComponent(btnAssumeExecute, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTransfersLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblTransfersContent))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblLossLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblLossContent)))
					.addContainerGap(278, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnExampleReset)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAssumeExecute)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTransfersLabel)
						.addComponent(lblTransfersContent))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLossLabel)
						.addComponent(lblLossContent))
					.addGap(197))
		);
		setLayout(groupLayout);
	}
	
	@Override
	public Integer getPanelHeight() {
		return 130;
	}	

	@Override
	public Integer getPanelWidth() {
		return 180;
	}

	@Override
	protected void initMethodsMenuButtons() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void loadExample() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void assume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void clearFields() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void executeExtra() {
		// TODO Auto-generated method stub
		
	}		
}
