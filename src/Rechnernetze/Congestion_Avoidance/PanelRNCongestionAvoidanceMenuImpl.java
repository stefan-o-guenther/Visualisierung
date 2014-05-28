/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Congestion_Avoidance;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Base.EnumVisualizationStatus;
import Base.Labeling;
import Base.MessageBox;
import Base.PanelMenuAutomaticAbstract;

public class PanelRNCongestionAvoidanceMenuImpl extends PanelMenuAutomaticAbstract {
	
	public PanelRNCongestionAvoidanceMenuImpl(ManagementCongestionAvoidance network, ToolTipManagerCongestionAvoidance tooltip) {
		super(network, tooltip);
		this.initPanel();
	}	
	
	private ButtonGroupNetworkStrategyImpl groupNetworkStrategy;
	private ManagementCongestionAvoidance network;
	private ToolTipManagerCongestionAvoidance tooltip;
	
	private JTextField tfSsTresh;
	private JTextField tfTimeout;
	private JRadioButton rdbtnTimeout;
	private JRadioButton rdbtnTrippleDuplACK;
	private JTextField tfTrippleDuplACK;
	
	private JLabel lblTCPTahoe;
	private JLabel lblSsTresh;
	private JButton btnAssumeStepStartStop;
	private JButton btnReset;
	private JLabel lblTimeout;
	private JLabel lblTripple;
	private JLabel lblTCPReno;
	private JCheckBox chckbxTcpReno;
	private JCheckBox chckbxTcpTahoe;
	
	private JLabel lblSsTreshTahoeBar;
	private JLabel lblSsTreshTahoeLabel;
	private JLabel lblSsTreshRenoBar;
	private JLabel lblSsTreshRenoLabel;
	
	@Override
	protected void initComponents() {
		this.network = (ManagementCongestionAvoidance) this.getManagement();
		this.tooltip = (ToolTipManagerCongestionAvoidance) this.getToolTipManager();
		
		ImageIcon imgHelp = super.getImageIconHelp();
		
		groupNetworkStrategy = new ButtonGroupNetworkStrategyImpl(actionStrategy);
		
		//rdbtnTimeout = new JRadioButton("timeout");
		rdbtnTimeout = groupNetworkStrategy.geRadioButtonTimout();
		rdbtnTimeout.setBackground(this.getBackground());
		
		//rdbtnTrippleDuplACK = new JRadioButton("tripple dupl. ACK");
		rdbtnTrippleDuplACK = groupNetworkStrategy.getRadioButtonTrippleDublACK();
		rdbtnTrippleDuplACK.setBackground(this.getBackground());
		
		network.setNetworkStrategy(groupNetworkStrategy.getSelectedButton());
		
		lblTCPTahoe = new JLabel("-");
		lblTCPTahoe.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblTCPTahoe.setForeground(network.getColorTcpTahoe());
		lblTCPTahoe.setIcon(imgHelp);
		lblTCPTahoe.setToolTipText(this.tooltip.getToolTipTcpTahoe());
		
		chckbxTcpTahoe = new JCheckBox("TCP-Tahoe");
		chckbxTcpTahoe.setBackground(this.getBackground());	
		chckbxTcpTahoe.setSelected(false);
		chckbxTcpTahoe.addActionListener(ActionTcpRenoTcpTahoe);		
		
		lblTCPReno = new JLabel("-");
		lblTCPReno.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblTCPReno.setForeground(network.getColorTcpReno());
		lblTCPReno.setIcon(imgHelp);
		lblTCPReno.setToolTipText(this.tooltip.getToolTipTcpReno());
		
		chckbxTcpReno = new JCheckBox("TCP-Reno");
		chckbxTcpReno.setBackground(this.getBackground());
		chckbxTcpReno.setSelected(false);
		chckbxTcpReno.addActionListener(ActionTcpRenoTcpTahoe);
		
		lblSsTresh = new JLabel("ssTresh:");
		lblSsTresh.setIcon(imgHelp);
		
		tfSsTresh = new JTextField();
		tfSsTresh.setColumns(10);
		
		tfTimeout = new JTextField();
		tfTimeout.setColumns(10);
		
		btnReset = new JButton(Labeling.NEXT_STEP);
		btnReset.addActionListener(ActionReset);
		
		btnAssumeStepStartStop = new JButton(Labeling.ASSUME);
		btnAssumeStepStartStop.addActionListener(ActionAssumeStepStartStop);
		
		panelAutomatic = new PanelRNCongestionAvoidanceAutomaticImpl(network);
		
		tfTrippleDuplACK = new JTextField();
		tfTrippleDuplACK.setColumns(10);
		
		lblTimeout = new JLabel(" ");
		lblTimeout.setIcon(imgHelp);
		
		lblTripple = new JLabel(" ");
		lblTripple.setIcon(imgHelp);
			
		lblSsTreshTahoeBar = new JLabel("-");
		lblSsTreshTahoeBar.setForeground(network.getColorSsTreshTcpTahoe());
		lblSsTreshTahoeBar.setFont(new Font("Tahoma", Font.PLAIN, 33));		
		
		lblSsTreshRenoBar = new JLabel("-");
		lblSsTreshRenoBar.setForeground(network.getColorSsTreshTcpReno());
		lblSsTreshRenoBar.setFont(new Font("Tahoma", Font.PLAIN, 33));
		
		lblSsTreshTahoeLabel = new JLabel("ssTresh (TCP-Tahoe)");
		lblSsTreshRenoLabel = new JLabel("ssTresh (TCP-Reno)");
		
		this.selectTcpRenoTcpTahoe();
	}
	
	@Override
	protected void initLayout() {		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblTCPReno, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblTCPTahoe, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(chckbxTcpReno, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(chckbxTcpTahoe, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(18)
							.addComponent(lblSsTresh)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfSsTresh, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTimeout)
								.addComponent(lblTripple))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(rdbtnTimeout, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(rdbtnTrippleDuplACK, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(tfTimeout, 0, 0, Short.MAX_VALUE)
								.addComponent(tfTrippleDuplACK, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnAssumeStepStartStop, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSsTreshTahoeBar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblSsTreshTahoeLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblSsTreshRenoBar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblSsTreshRenoLabel)))
					.addGap(18)
					.addComponent(panelAutomatic, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTCPTahoe, GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(chckbxTcpTahoe, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
							.addComponent(lblSsTresh)
							.addComponent(tfSsTresh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblTimeout)
							.addComponent(rdbtnTimeout, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(tfTimeout, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnAssumeStepStartStop, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTCPReno, GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(chckbxTcpReno, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
							.addComponent(lblTripple)
							.addComponent(rdbtnTrippleDuplACK)
							.addComponent(tfTrippleDuplACK, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblSsTreshRenoLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblSsTreshTahoeLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblSsTreshRenoBar, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblSsTreshTahoeBar, 0, 0, Short.MAX_VALUE)))
					.addGap(255))
				.addComponent(panelAutomatic, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
		);
		setLayout(groupLayout);
	}

	@Override
	public void updatePanel() {
		this.btnReset.setEnabled(true);
		this.btnReset.setText(Labeling.RESET);		
		
		this.lblTCPTahoe.setForeground(network.getColorTcpTahoe());
		this.lblTCPReno.setForeground(network.getColorTcpReno());		
		this.lblSsTreshTahoeBar.setForeground(network.getColorSsTreshTcpTahoe());
		this.lblSsTreshRenoBar.setForeground(network.getColorSsTreshTcpReno());
		
		EnumVisualizationStatus status = network.getNetworkStatus();
		switch (status) {
			case START: {
				this.chckbxTcpReno.setEnabled(true);
				this.chckbxTcpTahoe.setEnabled(true);
				this.tfSsTresh.setEnabled(true);
				this.tfSsTresh.setEditable(true);
				this.rdbtnTimeout.setEnabled(true);
				this.rdbtnTrippleDuplACK.setEnabled(true);
				this.tfTimeout.setEnabled(true);
				this.tfTimeout.setEditable(true);
				this.tfTrippleDuplACK.setEnabled(true);	
				this.tfTrippleDuplACK.setEditable(true);
				this.btnAssumeStepStartStop.setEnabled(true);
				this.btnAssumeStepStartStop.setText(Labeling.ASSUME);				
				this.panelAutomatic.setAutomaticEnabled(false);				
				break;
			}
			case RUN: {
				this.chckbxTcpReno.setEnabled(false);
				this.chckbxTcpTahoe.setEnabled(false);
				this.tfSsTresh.setEnabled(false);
				this.tfSsTresh.setEditable(false);
				this.rdbtnTimeout.setEnabled(true);
				this.rdbtnTrippleDuplACK.setEnabled(true);
				Boolean notRunning = !(network.isAutomaticRunning());
				this.tfTimeout.setEnabled(notRunning);
				this.tfTimeout.setEditable(notRunning);
				this.tfTrippleDuplACK.setEnabled(notRunning);	
				this.tfTrippleDuplACK.setEditable(notRunning);
				this.btnAssumeStepStartStop.setEnabled(true);
				this.btnAssumeStepStartStop.setText(Labeling.RESET);
				this.btnAssumeStepStartStop.setText(network.getButtonAutomaticText());
				this.panelAutomatic.setAutomaticEnabled(true);				
				break;
			}
			case FINISHED: {
				this.chckbxTcpReno.setEnabled(false);
				this.chckbxTcpTahoe.setEnabled(false);
				this.tfSsTresh.setEnabled(false);
				this.tfSsTresh.setEditable(false);
				this.rdbtnTimeout.setEnabled(false);
				this.rdbtnTrippleDuplACK.setEnabled(false);
				this.tfTimeout.setEnabled(false);
				this.tfTimeout.setEditable(false);
				this.tfTrippleDuplACK.setEnabled(false);	
				this.tfTrippleDuplACK.setEditable(false);
				this.btnAssumeStepStartStop.setEnabled(false);
				this.btnAssumeStepStartStop.setText(Labeling.NEXT_STEP);	
				this.panelAutomatic.setAutomaticEnabled(false);				
				break;
			}
			default: {
				break;
			}
		}
	}

	@Override
	public Integer getHeightMenu() {
		return 100;
	}

	private void inputSsTresh() throws Exception {
		try {
			Integer ssTresh = new Integer(tfSsTresh.getText());
			if (ssTresh > network.getMaxCwnd()) {
				throw new Exception();
			}
			network.setSsTresh(ssTresh);
		} catch (Exception ex) {
			MessageBox.showErrorMessage("kein richtiges ssTresh eingegeben!");			
			throw ex;
		}
	}
	
	private void inputTimeout() throws Exception {
		try {
			Integer maxTimeout = new Integer(tfTimeout.getText());
			if (maxTimeout > network.getMaxCwnd()) {
				throw new Exception();
			}
			network.setTimeout(maxTimeout);
		} catch (Exception ex) {
			MessageBox.showErrorMessage("kein richtiges timout eingebeben!");			
			throw ex;
		}
	}
	
	private void inputTrippleDuplAck() throws Exception {
		try {
			Integer maxTrippleDuplACK = new Integer(tfTrippleDuplACK.getText());
			if (maxTrippleDuplACK > network.getMaxCwnd()) {
				throw new Exception();
			}
			network.setTrippleDuplACK(maxTrippleDuplACK);
		} catch (Exception ex) {
			MessageBox.showErrorMessage("kein richtiges tripple dupl. ACK eingebeben!");			
			throw ex;
		}
	}
	
	private void checkCheckboxes() throws Exception {		
		Boolean reno = this.chckbxTcpReno.isSelected();
		Boolean tahoe = this.chckbxTcpTahoe.isSelected();
		if ((reno == false) && (tahoe == false)) {
			MessageBox.showErrorMessage("kein Typ ausgewählt!");
			throw new Exception("nichts ausgewählt");
		}			
	}
	
	private ActionListener actionStrategy = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			try {
				network.setNetworkStrategy(groupNetworkStrategy.getSelectedButton());
			} catch (Exception ex) {
				ex.printStackTrace();
			}			
		}
	};
	
	private void inputMaxTimeoutMaxTrippleDuplAck() throws Exception {
		try {
			this.inputTimeout();
			this.inputTrippleDuplAck();
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	private ActionListener ActionReset = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			try {	
				network.reset();
			} catch (Exception ex) {
				
			}
			updatePanel();
		}
	};
	
	private ActionListener ActionAssumeStepStartStop = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			try {
				EnumVisualizationStatus status = network.getNetworkStatus();
				if (status != EnumVisualizationStatus.FINISHED) {
					if (status == EnumVisualizationStatus.START) {
						checkCheckboxes();
						inputSsTresh();
					}
					inputMaxTimeoutMaxTrippleDuplAck();
					executeManualAutomatic();
				}				
			} catch (Exception ex) {
				
			}
			updatePanel();
		}
	};
	
	private void selectTcpRenoTcpTahoe() {
		Boolean isTcpRenoSelected = chckbxTcpReno.isSelected();
		Boolean isTcpTahoeSelected = chckbxTcpTahoe.isSelected();
		network.setTcpReno(isTcpRenoSelected);
		network.setTcpTahoe(isTcpTahoeSelected);
	}
	
	private ActionListener ActionTcpRenoTcpTahoe = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			try {
				selectTcpRenoTcpTahoe();
			} catch (Exception ex) {
				ex.printStackTrace();
			}			
		}
	};	
	
}
