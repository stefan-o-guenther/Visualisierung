/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Congestion_Avoidance;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
//import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Base.EnumVisualizationStatus;
import Base.MessageBox;
import Base.PanelMenuButtonsAbstract;

public class PanelRNCongestionAvoidanceMenuImpl extends PanelMenuButtonsAbstract {
	
	private static final long serialVersionUID = 1L;

	public PanelRNCongestionAvoidanceMenuImpl(ManagementCongestionAvoidance network) {
		super(network);
	}	
	
	private PanelRNCongestionAvoidanceMenuImpl() {
		super(new ManagementCongestionAvoidanceImpl());
		this.initComponentsMenuButtons();
		this.initLayout();
	}
	
	private ButtonGroupNetworkStrategyImpl groupNetworkStrategy;
	private ManagementCongestionAvoidance network;
	private ToolTipManagerCongestionAvoidance tooltip;
	private JTextField tfSSThresh;
	private JTextField tfTimeout;
	private JTextField tfTrippleDuplACK;
	private JCheckBox chckbxTCPReno;
	private JCheckBox chckbxTCPTahoe;
	private JLabel lblSSThresh;
	private JLabel lblSSThreshTCPRenoLabel;
	private JLabel lblSSThreshTCPTahoeLabel;
	//private JButton btnExampleReset;
	//private JButton btnAssumeInputExecute;	
	private JRadioButton rdbtnTimeout;
	private JRadioButton rdbtnTrippleDuplACK;
	private JLabel lblTimeout;
	private JLabel lblTrippleDuplACK;
	private JLabel lblTCPReno;
	private JLabel lblTCPTahoe;
	private JLabel lblSSThreshTCPRenoBar;
	private JLabel lblSSThreshTCPTahoeBar;
	
	/*
	private void init() {
		rdbtnTrippleDuplACK = new JRadioButton("tripple dupl. ACK:");
		rdbtnTimeout = new JRadioButton("timeout:");
		rdbtnTimeout.setSelected(true);
		btnExampleReset = new JButton("zur\u00FCcksetzen");
		btnAssumeExecute = new JButton("n\u00E4chster Schritt");	
	}
	*/	
	
	@Override
	protected void initComponentsMenuButtons() {
		this.network = (ManagementCongestionAvoidance) this.getManagement();
		this.tooltip = (ToolTipManagerCongestionAvoidance) network.getToolTipManager();
		
		ImageIcon imgHelp = super.getImageIconHelp();
		
		groupNetworkStrategy = new ButtonGroupNetworkStrategyImpl(network);		
		rdbtnTimeout = groupNetworkStrategy.getRadioButtonTimout();				
		rdbtnTrippleDuplACK = groupNetworkStrategy.getRadioButtonTrippleDublACK();		
		groupNetworkStrategy.selectRadioButtonTimeout();		
		
		chckbxTCPReno = new JCheckBox("TCP Reno");		
		chckbxTCPTahoe = new JCheckBox("TCP Tahoe");
		
		lblSSThresh = new JLabel("SSThresh");
		lblSSThresh.setIcon(imgHelp);
		lblSSThresh.setToolTipText(tooltip.getToolTipSSThresh());
		
		lblSSThreshTCPRenoLabel = new JLabel("SSThresh (TCPReno)");
		
		tfSSThresh = new JTextField();
		tfSSThresh.setColumns(10);
		
		lblSSThreshTCPTahoeLabel = new JLabel("SSThresh (TCPTahoe)");		
		
		tfTimeout = new JTextField();
		tfTimeout.setColumns(10);
		
		tfTrippleDuplACK = new JTextField();
		tfTrippleDuplACK.setColumns(10);
		
		lblTimeout = new JLabel(" ");
		lblTimeout.setIcon(imgHelp);
		lblTimeout.setToolTipText(tooltip.getToolTipTimeout());
		
		lblTrippleDuplACK = new JLabel(" ");
		lblTrippleDuplACK.setIcon(imgHelp);
		lblTrippleDuplACK.setToolTipText(tooltip.getToolTipTrippleDuplAck());
		
		lblTCPReno = new JLabel("-");
		lblTCPReno.setForeground(Color.BLACK);
		lblTCPReno.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblTCPReno.setIcon(imgHelp);
		lblTCPReno.setToolTipText(tooltip.getToolTipTcpReno());
		
		lblTCPTahoe = new JLabel("-");
		lblTCPTahoe.setIcon(imgHelp);
		lblTCPTahoe.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblTCPTahoe.setForeground(Color.BLUE);
		lblTCPTahoe.setToolTipText(tooltip.getToolTipTcpTahoe());
		
		lblSSThreshTCPRenoBar = new JLabel("-");
		lblSSThreshTCPRenoBar.setForeground(Color.GREEN);
		lblSSThreshTCPRenoBar.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblSSThreshTCPRenoBar.setIcon(imgHelp);
		lblSSThreshTCPRenoBar.setToolTipText(tooltip.getToolTipSSThreshTCPReno());
		
		lblSSThreshTCPTahoeBar = new JLabel("-");
		lblSSThreshTCPTahoeBar.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblSSThreshTCPTahoeBar.setForeground(Color.RED);
		lblSSThreshTCPTahoeBar.setIcon(imgHelp);
		lblSSThreshTCPTahoeBar.setToolTipText(tooltip.getToolTipSSThreshTCPTahoe());
		
		//init();
		
		this.selectTCPReno();
		this.selectTCPTahoe();		
	}
	
	@Override
	protected void initLayout() {		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTCPTahoe)
								.addComponent(lblTCPReno))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxTCPReno, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
								.addComponent(chckbxTCPTahoe, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnAssumeSaveExecute, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSSThreshTCPRenoBar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblSSThreshTCPRenoLabel, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSSThresh)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfSSThresh, 0, 0, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSSThreshTCPTahoeBar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblSSThreshTCPTahoeLabel)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTimeout)
								.addComponent(lblTrippleDuplACK))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(rdbtnTimeout, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(rdbtnTrippleDuplACK, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(tfTrippleDuplACK, 0, 0, Short.MAX_VALUE)
								.addComponent(tfTimeout, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)))
						.addComponent(btnExampleReset, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(698))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblTCPTahoe, 0, 0, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(chckbxTCPTahoe, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(tfTimeout, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblSSThresh, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(tfSSThresh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblTimeout, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addComponent(rdbtnTimeout)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfTrippleDuplACK, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTrippleDuplACK, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
								.addComponent(rdbtnTrippleDuplACK, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblSSThreshTCPTahoeLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblSSThreshTCPTahoeBar, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(lblTCPReno, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(chckbxTCPReno, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 4, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblSSThreshTCPRenoBar, 0, 0, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblSSThreshTCPRenoLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnExampleReset, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(btnAssumeSaveExecute, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
	


	@Override
	protected void initMethodsMenuButtons() {	
		
		ActionListener ActionTcpReno = new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				try {
					selectTCPReno();
				} catch (Exception ex) {
					ex.printStackTrace();
				}			
			}
		};
		
		ActionListener ActionTcpTahoe = new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				try {
					selectTCPTahoe();
				} catch (Exception ex) {
					ex.printStackTrace();
				}			
			}
		};
		
		this.chckbxTCPReno.addActionListener(ActionTcpReno);
		this.chckbxTCPTahoe.addActionListener(ActionTcpTahoe);
	}

	@Override
	public void updatePanelMenuButtons() {
		
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
				break;
			}
			default: {
				break;
			}
		}
	}

	@Override
	public Integer getPanelHeight() {
		return 120;
	}	

	@Override
	public Integer getPanelWidth() {
		return 550;
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
	
	private void inputMaxTimeoutMaxTrippleDuplAck() throws Exception {
		try {
			this.inputTimeout();
			this.inputTrippleDuplAck();
		} catch (Exception ex) {
			throw ex;
		}
	}	
	
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

	@Override
	protected void loadExample() {
		chckbxTCPReno.setSelected(true);
		selectTCPReno();
		chckbxTCPTahoe.setSelected(true);
		selectTCPTahoe();				
		tfSSThresh.setText("8");
		tfTimeout.setText("12");
		tfTrippleDuplACK.setText("12");
		groupNetworkStrategy.selectRadioButtonTrippleDublACK();
	}

	@Override
	protected void assume() {
		try {
			checkCheckboxes();
			inputSsTresh();		
			inputMaxTimeoutMaxTrippleDuplAck();
			network.executeNormal();
		} catch (Exception e) {
			
		}		
	}

	@Override
	protected void clearFields() {
		
	}

	@Override
	protected void executeExtra() {
		try {
			inputMaxTimeoutMaxTrippleDuplAck();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	protected Boolean hasExample() {
		return true;
	}

	@Override
	protected void input() {
		
	}
}
