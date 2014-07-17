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
import Base.PanelMenuAutomaticMenuAbstract;
import java.awt.Color;

public class PanelRNCongestionAvoidanceMenuAutomaticMenuImpl extends PanelMenuAutomaticMenuAbstract {
	
	public PanelRNCongestionAvoidanceMenuAutomaticMenuImpl(ManagementCongestionAvoidance network, ToolTipManagerCongestionAvoidance tooltip) {
		super(network, tooltip);
		this.initPanel();
	}	
	
	private PanelRNCongestionAvoidanceMenuAutomaticMenuImpl() {
		super(new ManagementCongestionAvoidanceImpl(), new ToolTipManagerCongestionAvoidanceImpl());
		this.initComponents();
		this.initLayout();
	}
	
	private ButtonGroupNetworkStrategyImpl groupNetworkStrategy;
	private ManagementCongestionAvoidance network;
	private ToolTipManagerCongestionAvoidance tooltip;
	
	private JLabel lblTCPReno;
	private JCheckBox chckbxTCPReno;
	
	private JLabel lblTCPTahoe;	
	private JCheckBox chckbxTCPTahoe;
	
	private JLabel lblSSThresh;
	private JTextField tfSSThresh;
	
	private JLabel lblTimeout;
	private JRadioButton rdbtnTimeout;
	private JTextField tfTimeout;
	
	private JLabel lblTrippleDuplACK;
	private JRadioButton rdbtnTrippleDuplACK;	
	private JTextField tfTrippleDuplACK;
	
	private JLabel lblSSThreshTCPRenoBar;
	private JLabel lblSSThreshTCPRenoLabel;
	
	private JLabel lblSSThreshTCPTahoeBar;
	private JLabel lblSSThreshTCPTahoeLabel;
	
	private JButton btnAssumeStepStartStop;
	private JButton btnReset;
	private JButton btnLoadExample;	
	
	@Override
	protected void initComponents() {
		this.network = (ManagementCongestionAvoidance) this.getManagement();
		this.tooltip = (ToolTipManagerCongestionAvoidance) this.getToolTipManager();
		
		ImageIcon imgHelp = super.getImageIconHelp();
		
		groupNetworkStrategy = new ButtonGroupNetworkStrategyImpl(actionStrategy);
		
		//rdbtnTimeout = new JRadioButton("timeout:");		
		//rdbtnTrippleDuplACK = new JRadioButton("tripple dupl. ACK:");
		rdbtnTimeout = groupNetworkStrategy.geRadioButtonTimout();
		rdbtnTrippleDuplACK = groupNetworkStrategy.getRadioButtonTrippleDublACK();
		rdbtnTimeout.setSelected(true);
		selectStrategy();
		
		lblTCPReno = new JLabel("-");
		lblTCPReno.setForeground(Color.BLACK);
		lblTCPReno.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblTCPReno.setIcon(imgHelp);
		lblTCPReno.setToolTipText(tooltip.getToolTipTcpReno());
		
		lblTCPTahoe = new JLabel("-");
		lblTCPTahoe.setForeground(Color.BLUE);
		lblTCPTahoe.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblTCPTahoe.setIcon(imgHelp);
		lblTCPTahoe.setToolTipText(tooltip.getToolTipTcpTahoe());
		
		chckbxTCPReno = new JCheckBox("TCP Reno");
		chckbxTCPReno.setSelected(false);
		chckbxTCPReno.addActionListener(ActionTcpReno);
		this.selectTCPReno();		
		
		chckbxTCPTahoe = new JCheckBox("TCP Tahoe");
		chckbxTCPTahoe.setSelected(false);
		chckbxTCPTahoe.addActionListener(ActionTcpTahoe);
		this.selectTCPTahoe();
		
		lblSSThresh = new JLabel("SSThresh:");
		lblSSThresh.setIcon(imgHelp);
		lblSSThresh.setToolTipText(tooltip.getToolTipSSThresh());
		
		tfSSThresh = new JTextField();
		tfSSThresh.setColumns(10);
		tfSSThresh.setText("");
		
		lblTimeout = new JLabel(" ");
		lblTimeout.setIcon(imgHelp);
		lblTimeout.setToolTipText(tooltip.getToolTipTimeout());
		
		lblTrippleDuplACK = new JLabel(" ");
		lblTrippleDuplACK.setIcon(imgHelp);
		lblTrippleDuplACK.setToolTipText(tooltip.getToolTipTrippleDuplAck());
		
		tfTimeout = new JTextField();
		tfTimeout.setColumns(10);
		tfTimeout.setText("");
		
		tfTrippleDuplACK = new JTextField();
		tfTrippleDuplACK.setColumns(10);
		tfTrippleDuplACK.setText("");
		
		lblSSThreshTCPRenoBar = new JLabel("-");
		lblSSThreshTCPRenoBar.setForeground(Color.GREEN);		
		lblSSThreshTCPRenoBar.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblSSThreshTCPRenoBar.setIcon(imgHelp);
		lblSSThreshTCPRenoBar.setToolTipText(tooltip.getToolTipSSThreshTCPReno());
		
		lblSSThreshTCPTahoeBar = new JLabel("-");
		lblSSThreshTCPTahoeBar.setForeground(Color.RED);		
		lblSSThreshTCPTahoeBar.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblSSThreshTCPTahoeBar.setIcon(imgHelp);
		lblSSThreshTCPTahoeBar.setToolTipText(tooltip.getToolTipSSThreshTCPTahoe());
		
		lblSSThreshTCPRenoLabel = new JLabel("SSThresh (TCP Reno)");		
		lblSSThreshTCPTahoeLabel = new JLabel("SSThresh (TCP Tahoe)");
		
		btnAssumeStepStartStop = new JButton(Labeling.ASSUME);	
		btnAssumeStepStartStop.addActionListener(ActionAssumeStepStartStop);
		
		btnReset = new JButton(Labeling.RESET);	
		btnReset.addActionListener(ActionReset);
		
		btnLoadExample = new JButton(Labeling.LOAD_EXAMPLE);
		btnLoadExample.addActionListener(ActionLoadExample);			
	}
	
	@Override
	protected void initLayout() {		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAssumeStepStartStop, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblTCPTahoe, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblTCPReno, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(chckbxTCPTahoe, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(chckbxTCPReno, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
							.addGap(18)
							.addComponent(lblSSThresh)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfSSThresh, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblTrippleDuplACK)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rdbtnTrippleDuplACK))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblTimeout)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rdbtnTimeout, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(tfTrippleDuplACK, 0, 0, Short.MAX_VALUE)
								.addComponent(tfTimeout, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)))
						.addComponent(btnLoadExample, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSSThreshTCPRenoBar)
						.addComponent(lblSSThreshTCPTahoeBar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSSThreshTCPRenoLabel)
						.addComponent(lblSSThreshTCPTahoeLabel))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblSSThreshTCPRenoLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTCPReno, GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(chckbxTCPReno, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblSSThresh, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(tfSSThresh, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblTimeout, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(rdbtnTimeout, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(tfTimeout, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblSSThreshTCPRenoBar, 0, 0, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblSSThreshTCPTahoeLabel, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
						.addComponent(lblTCPTahoe, GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
						.addComponent(chckbxTCPTahoe, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
						.addComponent(rdbtnTrippleDuplACK, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
						.addComponent(tfTrippleDuplACK, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
						.addComponent(lblSSThreshTCPTahoeBar, 0, 0, Short.MAX_VALUE)
						.addComponent(lblTrippleDuplACK, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAssumeStepStartStop)
						.addComponent(btnReset)
						.addComponent(btnLoadExample))
					.addGap(210))
		);
		setLayout(groupLayout);
	}

	@Override
	public void updatePanel() {
		this.btnReset.setEnabled(true);
		this.btnReset.setText(Labeling.RESET);		
		
		this.lblTCPTahoe.setForeground(network.getColorTcpTahoe());
		this.lblTCPReno.setForeground(network.getColorTcpReno());		
		this.lblSSThreshTCPTahoeBar.setForeground(network.getColorSsTreshTcpTahoe());
		this.lblSSThreshTCPRenoBar.setForeground(network.getColorSsTreshTcpReno());
		
		EnumVisualizationStatus status = network.getStatus();
		switch (status) {
			case START: {
				this.chckbxTCPReno.setEnabled(true);
				this.chckbxTCPTahoe.setEnabled(true);
				this.tfSSThresh.setEnabled(true);
				this.tfSSThresh.setEditable(true);
				this.rdbtnTimeout.setEnabled(true);
				this.rdbtnTrippleDuplACK.setEnabled(true);
				this.tfTimeout.setEnabled(true);
				this.tfTimeout.setEditable(true);
				this.tfTrippleDuplACK.setEnabled(true);	
				this.tfTrippleDuplACK.setEditable(true);
				this.btnAssumeStepStartStop.setEnabled(true);
				this.btnAssumeStepStartStop.setText(Labeling.ASSUME);
				this.btnLoadExample.setEnabled(true);
				break;
			}
			case RUN: {
				this.chckbxTCPReno.setEnabled(false);
				this.chckbxTCPTahoe.setEnabled(false);
				this.tfSSThresh.setEnabled(false);
				this.tfSSThresh.setEditable(false);
				this.rdbtnTimeout.setEnabled(true);
				this.rdbtnTrippleDuplACK.setEnabled(true);
				Boolean notRunning = !(network.isAutomaticRunning());
				this.tfTimeout.setEnabled(notRunning);
				this.tfTimeout.setEditable(notRunning);
				this.tfTrippleDuplACK.setEnabled(notRunning);	
				this.tfTrippleDuplACK.setEditable(notRunning);
				this.btnAssumeStepStartStop.setEnabled(true);
				this.btnAssumeStepStartStop.setText(Labeling.NEXT_STEP);
				this.btnAssumeStepStartStop.setText(network.getButtonAutomaticText());
				this.btnLoadExample.setEnabled(false);
				break;
			}
			case FINISHED: {
				this.chckbxTCPReno.setEnabled(false);
				this.chckbxTCPTahoe.setEnabled(false);
				this.tfSSThresh.setEnabled(false);
				this.tfSSThresh.setEditable(false);
				this.rdbtnTimeout.setEnabled(false);
				this.rdbtnTrippleDuplACK.setEnabled(false);
				this.tfTimeout.setEnabled(false);
				this.tfTimeout.setEditable(false);
				this.tfTrippleDuplACK.setEnabled(false);	
				this.tfTrippleDuplACK.setEditable(false);
				this.btnAssumeStepStartStop.setEnabled(false);
				this.btnAssumeStepStartStop.setText(Labeling.NEXT_STEP);
				this.btnLoadExample.setEnabled(false);
				break;
			}
			default: {
				break;
			}
		}
	}

	@Override
	public Integer getHeightMenu() {
		return 110;
	}	

	@Override
	public Integer getLengthMenu() {
		return 690;
	}		

	private void inputSsTresh() throws Exception {
		try {
			Integer ssTresh = new Integer(tfSSThresh.getText());
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
		Boolean reno = this.chckbxTCPReno.isSelected();
		Boolean tahoe = this.chckbxTCPTahoe.isSelected();
		if ((reno == false) && (tahoe == false)) {
			MessageBox.showErrorMessage("kein Typ ausgewählt!");
			throw new Exception("nichts ausgewählt");
		}			
	}
	
	private void selectStrategy() {
		try {
			network.setNetworkStrategy(groupNetworkStrategy.getSelectedButton());
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	private ActionListener actionStrategy = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			try {
				selectStrategy();
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
				throw ex;
			}
			updatePanel();
		}
	};
	
	private ActionListener ActionAssumeStepStartStop = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			try {
				EnumVisualizationStatus status = network.getStatus();
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
	
	private ActionListener ActionLoadExample = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			try {	
				chckbxTCPReno.setSelected(true);
				selectTCPReno();
				chckbxTCPTahoe.setSelected(true);
				selectTCPTahoe();				
				tfSSThresh.setText("8");
				tfTimeout.setText("12");
				tfTrippleDuplACK.setText("12");
				rdbtnTrippleDuplACK.setSelected(true);	
				selectStrategy();
			} catch (Exception ex) {
				
			}
			updatePanel();
		}
	};
	
	private void selectTCPReno() {
		try {
			Boolean isSelected = this.chckbxTCPReno.isSelected();
			network.setTcpReno(isSelected);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	private void selectTCPTahoe() {
		try {
			Boolean isSelected = this.chckbxTCPTahoe.isSelected();
			network.setTcpTahoe(isSelected);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	private ActionListener ActionTcpReno = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			try {
				selectTCPReno();
			} catch (Exception ex) {
				ex.printStackTrace();
			}			
		}
	};
	
	private ActionListener ActionTcpTahoe = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			try {
				selectTCPTahoe();
			} catch (Exception ex) {
				ex.printStackTrace();
			}			
		}
	};
}
