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
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Base.PanelMenuAutomaticAbstract;
import Base.PanelAutomaticImpl;

public class PanelRNCongestionAvoidanceMenu2Impl extends PanelMenuAutomaticAbstract {
	
	public PanelRNCongestionAvoidanceMenu2Impl(ManagementCongestionAvoidance network, ToolTipManagerCongestionAvoidance tooltip) {
		super(network, tooltip);
		this.network = network;
		this.tooltip = tooltip;
		this.initComponents();
		this.initLayout();
		this.updateComponents();
	}	
	
	private ButtonGroupNetworkStrategyImpl groupNetworkStrategy;
	private ComboBoxNetworkTypeImpl cbNetworkType;
	private ManagementCongestionAvoidance network;
	private JTextField tfSsTresh;
	private JTextField tfTimeout;
	private PanelAutomaticImpl panelAutomatic;
	private JRadioButton rdbtnTimeout;
	private JRadioButton rdbtnTrippleDuplACK;
	private JTextField tfTrippleDuplACK;
	
	private JLabel lblType;
	private JLabel lblSsTresh;
	
	private JButton btnAction1;
	private JButton btnAction2;
	
	private JLabel lblTripple;
	private JLabel lblTimeout;	

	@Override
	protected void initComponents() {
		groupNetworkStrategy = new ButtonGroupNetworkStrategyImpl(actionStrategy);
		
		//rdbtnTimeout = new JRadioButton("timeout");
		rdbtnTimeout = groupNetworkStrategy.geRadioButtonTimout();
		rdbtnTimeout.setBackground(Color.WHITE);
		
		//rdbtnTrippleDuplACK = new JRadioButton("tripple dupl. ACK");
		rdbtnTrippleDuplACK = groupNetworkStrategy.getRadioButtonTrippleDublACK();
		rdbtnTrippleDuplACK.setBackground(Color.WHITE);
		
		network.setNetworkStrategy(groupNetworkStrategy.getSelectedButton());
		
		lblType = new JLabel("Typ:");
		lblType.setIcon(new ImageIcon("C:\\Eclipse\\Workspace\\Visualisierung\\resources\\Base\\img\\16x16_help.png"));
		
		cbNetworkType = new ComboBoxNetworkTypeImpl();
		cbNetworkType.setBackground(Color.WHITE);
		cbNetworkType.setEditable( false );
		cbNetworkType.setSelectedItem("");	
		
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
	}
	
	@Override
	protected void initLayout() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnAction1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAction2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
					.addGap(158)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblType, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblSsTresh, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(tfSsTresh, 0, 0, Short.MAX_VALUE)
						.addComponent(cbNetworkType, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTimeout)
						.addComponent(lblTripple))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(tfTrippleDuplACK, 0, 0, Short.MAX_VALUE)
						.addComponent(tfTimeout, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(panelAutomatic, GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAction1)
						.addComponent(lblType)
						.addComponent(cbNetworkType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTimeout)
						.addComponent(tfTimeout, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAction2)
						.addComponent(lblSsTresh)
						.addComponent(tfSsTresh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTripple)
						.addComponent(tfTrippleDuplACK, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(246, Short.MAX_VALUE))
				.addComponent(panelAutomatic, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
		);
		setLayout(groupLayout);
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
				network.setNetworkType(cbNetworkType.getType());
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
