/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Congestion_Avoidance;

import java.awt.Color;
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

import Base.PanelMenuAutomaticAbstract;
import Base.PanelAutomaticImpl;

public class PanelRNCongestionAvoidanceMenuImpl extends PanelMenuAutomaticAbstract {
	
	public PanelRNCongestionAvoidanceMenuImpl(ManagementCongestionAvoidance network, ToolTipManagerCongestionAvoidance tooltip) {
		super(network, tooltip);
		this.network = network;
		this.tooltip = tooltip;
		this.initComponents();
		this.initLayout();
		this.updateComponents();
	}	
	
	private ButtonGroupNetworkStrategyImpl groupNetworkStrategy;
	private ManagementCongestionAvoidance network;
	private JTextField tfSsTresh;
	private JTextField tfTimeout;
	private PanelAutomaticImpl panelAutomatic;
	private JRadioButton rdbtnTimeout;
	private JRadioButton rdbtnTrippleDuplACK;
	private JTextField tfTrippleDuplACK;
	
	private JLabel lblTCPTahoe;
	private JLabel lblSsTresh;
	private JButton btnAction1;
	private JButton btnAction2;
	private JLabel lblTimeout;
	private JLabel lblTripple;
	private JLabel lblTCPReno;
	private JCheckBox chckbxTCPReno;
	private JCheckBox chckbxTCPTahoe;

	@Override
	protected void initLayout() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblTCPTahoe, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTCPReno, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(chckbxTCPTahoe, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(chckbxTCPReno, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
						.addComponent(btnAction1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAction2, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(panelAutomatic, GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTCPReno)
						.addComponent(chckbxTCPReno)
						.addComponent(lblSsTresh)
						.addComponent(tfSsTresh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTimeout)
						.addComponent(rdbtnTimeout)
						.addComponent(tfTimeout, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAction1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblTCPTahoe)
							.addComponent(chckbxTCPTahoe)
							.addComponent(lblTripple))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(rdbtnTrippleDuplACK)
							.addComponent(tfTrippleDuplACK, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnAction2)))
					.addContainerGap(237, Short.MAX_VALUE))
				.addComponent(panelAutomatic, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		setLayout(groupLayout);
	}
	
	@Override
	protected void initComponents() {
		groupNetworkStrategy = new ButtonGroupNetworkStrategyImpl(actionStrategy);
		
		rdbtnTimeout = new JRadioButton("timeout");
		//rdbtnTimeout = groupNetworkStrategy.geRadioButtonTimout();
		rdbtnTimeout.setBackground(Color.WHITE);
		
		rdbtnTrippleDuplACK = new JRadioButton("tripple dupl. ACK");
		//rdbtnTrippleDuplACK = groupNetworkStrategy.getRadioButtonTrippleDublACK();
		rdbtnTrippleDuplACK.setBackground(Color.WHITE);
		
		network.setNetworkStrategy(groupNetworkStrategy.getSelectedButton());
		
		lblTCPTahoe = new JLabel(" ");
		lblTCPTahoe.setIcon(new ImageIcon("C:\\Eclipse\\Workspace\\Visualisierung\\resources\\Base\\img\\16x16_help.png"));
		
		lblSsTresh = new JLabel("ssTresh:");
		lblSsTresh.setIcon(new ImageIcon("C:\\Eclipse\\Workspace\\Visualisierung\\resources\\Base\\img\\16x16_help.png"));
		
		tfSsTresh = new JTextField();
		tfSsTresh.setColumns(10);
		
		tfTimeout = new JTextField();
		tfTimeout.setColumns(10);
		
		btnAction2 = new JButton("n\u00E4chster Schritt");
		btnAction2.addActionListener(ActionExecute);
		
		btnAction1 = new JButton("\u00FCbernehmen");
		btnAction1.addActionListener(ActionReset);
		
		panelAutomatic = new PanelAutomaticImpl(network, this, this.getBackground());
		
		tfTrippleDuplACK = new JTextField();
		tfTrippleDuplACK.setColumns(10);
		
		lblTimeout = new JLabel(" ");
		lblTimeout.setIcon(new ImageIcon("C:\\Eclipse\\Workspace\\Visualisierung\\resources\\Base\\img\\16x16_help.png"));
		
		lblTripple = new JLabel(" ");
		lblTripple.setIcon(new ImageIcon("C:\\Eclipse\\Workspace\\Visualisierung\\resources\\Base\\img\\16x16_help.png"));
		
		lblTCPReno = new JLabel(" ");
		lblTCPReno.setIcon(new ImageIcon("C:\\Eclipse\\Workspace\\Visualisierung\\resources\\Base\\img\\16x16_help.png"));
		
		chckbxTCPReno = new JCheckBox("TCP Reno");
		chckbxTCPReno.setBackground(Color.WHITE);
		
		chckbxTCPTahoe = new JCheckBox("TCP Tahoe");
		chckbxTCPTahoe.setBackground(Color.WHITE);		
		
		
	}

	@Override
	public void updateComponents() {
		EnumNetworkStatus status = network.getNetworkStatus();
		switch (status) {
			case START: {
				rdbtnTimeout.setEnabled(true);
				rdbtnTrippleDuplACK.setEnabled(true);
				
				break;
			}
			case RUN: {
				rdbtnTimeout.setEnabled(true);
				rdbtnTrippleDuplACK.setEnabled(true);
				
				break;
			}
			case FINISHED: {
				rdbtnTimeout.setEnabled(false);
				rdbtnTrippleDuplACK.setEnabled(false);
				
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
	public void error() {
		// TODO Auto-generated method stub
		
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
	
	private ActionListener ActionExecute = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			try {
				Integer maxTimeout = new Integer(tfTimeout.getText());
				Integer maxTrippleDuplAcK = new Integer(tfTrippleDuplACK.getText());				
				
				network.setMaxTimeout(maxTimeout);
				network.setMaxTrippleDuplACK(maxTrippleDuplAcK);
				
				network.execute();
			} catch (Exception ex) {
				ex.printStackTrace();
			}			
		}
	};
	
	private ActionListener ActionReset = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			try {
				//network.setNetworkType(cbNetworkType.getType());
				Integer ssTresh = new Integer(tfSsTresh.getText());
				network.setSsTresh(ssTresh);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	};


	@Override
	public void updateMenu() {
		// TODO Auto-generated method stub
		
	}

	
}
