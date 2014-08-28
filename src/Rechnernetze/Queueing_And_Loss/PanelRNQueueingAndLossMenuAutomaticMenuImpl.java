/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Rechnernetze.Queueing_And_Loss;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import Base.PanelMenuMenuAbstract;

public class PanelRNQueueingAndLossMenuAutomaticMenuImpl extends PanelMenuMenuAbstract {

	public PanelRNQueueingAndLossMenuAutomaticMenuImpl(ManagementQueueingAndLoss qal, ToolTipManagerQueueingAndLoss tooltip) {
		super(qal, tooltip);
	}

	private PanelRNQueueingAndLossMenuAutomaticMenuImpl() {
		super(new ManagementQueueingAndLossImpl(), new ToolTipManagerQueueingAndLossImpl());
		this.initComponents();
		this.initLayout();
	}
	
	private ManagementQueueingAndLoss qal;
	
	private JButton btnStart;
	private JLabel lblTransfersLabel;
	private JLabel lblTransfersContent;
	private JLabel lblLossLabel;
	private JLabel lblLossContent;
	
	@Override
	protected void initComponentsMenu() {
		this.qal = (ManagementQueueingAndLoss) this.getManagement();
		
		btnStart = new JButton("ausf\u00FChren");
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
						.addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTransfersLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblTransfersContent))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblLossLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblLossContent)))
					.addContainerGap(339, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnStart)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTransfersLabel)
						.addComponent(lblTransfersContent))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLossLabel)
						.addComponent(lblLossContent))
					.addGap(226))
		);
		setLayout(groupLayout);
	}
	
	@Override
	protected void initMethods() {
		
		ActionListener actionStart = new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				qal.executeNormal();
			}
				
		};
		
		btnStart.addActionListener(actionStart);		
	}

	@Override
	public void updatePanel() {
		this.lblLossContent.setText(qal.getCountLoss().toString());
		this.lblTransfersContent.setText(qal.getCountTransfered().toString());
	}

	@Override
	public Integer getHeightMenu() {
		return 130;
	}	

	@Override
	public Integer getLengthMenu() {
		return 160;
	}		
}