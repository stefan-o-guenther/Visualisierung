/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Fairness;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Base.EnumVisualizationStatus;
import Base.Labeling;
import Base.MessageBox;
import Base.PanelMenuAutomaticAbstract;

public class PanelRNTCPFairnessMenuImpl extends PanelMenuAutomaticAbstract {
	
	public PanelRNTCPFairnessMenuImpl(ManagementFairness fairness, ToolTipManagerFairness tooltip) {
		super(fairness, tooltip);		
		this.initPanel();
	}

	private ManagementFairness fairness;
	private ToolTipManagerFairness tooltip;
	
	private JTextField tfConnection1;
	private JTextField tfConnection2;	
	private JTextField tfMaxFlowRate;
	private JLabel lblMaxFlowRate;
	private JLabel lblConnection1;
	private JLabel lblConnection2;
	private JLabel lblModusLabel1;
	private JLabel lblModusLabel2;
	private JLabel lblModusContent1;
	private JLabel lblModusContent2;
	private JLabel lblCwndLabel1;
	private JLabel lblCwndLabel2;
	private JLabel lblDiferenceLabel;
	private JLabel lblCwndContent1;
	private JLabel lblCwndContent2;
	private JLabel lblDifferenceContent;
	private JButton btnAssumeStepStartStop;
	private JButton btnReset;
	
	@Override
	protected void initComponents() {
		this.fairness = (ManagementFairness) this.getManagement();
		this.tooltip = (ToolTipManagerFairness) this.getToolTipManager();
		
		ImageIcon imgHelp = super.getImageIconHelp();		
		panelAutomatic = new PanelRNTCPFairnessAutomaticImpl(fairness);
				
		lblConnection1 = new JLabel("Verbindung 1:");
		lblConnection1.setIcon(imgHelp);
		
		lblConnection2 = new JLabel("Verbindung 2:");
		lblConnection2.setIcon(imgHelp);
		
		tfConnection1 = new JTextField();
		
		tfConnection2 = new JTextField();
		
		lblModusLabel1 = new JLabel("Modus:");
		lblModusLabel1.setIcon(imgHelp);
		
		lblModusLabel2 = new JLabel("Modus:");
		lblModusLabel2.setIcon(imgHelp);
		
		lblModusContent1 = new JLabel("-");
		
		lblModusContent2 = new JLabel("-");		
		
		lblCwndLabel1 = new JLabel("cwnd:");
		lblCwndLabel1.setIcon(imgHelp);
		
		lblCwndLabel2 = new JLabel("cwnd:");
		lblCwndLabel2.setIcon(imgHelp);
		
		lblDiferenceLabel = new JLabel("Differenz:");
		lblDiferenceLabel.setIcon(imgHelp);
		
		lblCwndContent1 = new JLabel("-");
		
		lblCwndContent2 = new JLabel("-");
		
		lblDifferenceContent = new JLabel("0");
		
		btnAssumeStepStartStop = new JButton(Labeling.ASSUME);
		btnAssumeStepStartStop.addActionListener(ActionAssumeStepStartStop);
		
		btnReset = new JButton(Labeling.RESET);
		btnReset.addActionListener(ActionReset);
		
		lblMaxFlowRate = new JLabel("maximale Durchflussleistung:");
		lblMaxFlowRate.setIcon(imgHelp);
		
		tfMaxFlowRate = new JTextField();
	}
	
	@Override
	public void updatePanel() {
		EnumVisualizationStatus status = fairness.getFairnessStatus();
		Boolean isStart = (status == EnumVisualizationStatus.START);
		String modus1 = fairness.getModus1();
		String modus2 = fairness.getModus2();
		Integer c1 = fairness.getConnection1();
		Integer c2 = fairness.getConnection2();
		Integer dif = fairness.getDifference();
		
		this.lblModusContent1.setText(modus1);
		this.lblModusContent2.setText(modus2);
		this.lblCwndContent1.setText(c1.toString());
		this.lblCwndContent2.setText(c2.toString());
		this.lblDifferenceContent.setText(dif.toString());
		this.tfConnection1.setEnabled(isStart);
		this.tfConnection1.setEditable(isStart);
		this.tfConnection2.setEnabled(isStart);		
		this.tfConnection2.setEditable(isStart);		
		this.tfMaxFlowRate.setEnabled(isStart);
		this.tfMaxFlowRate.setEditable(isStart);
		
		switch (status) {
			case START: {
				this.btnReset.setEnabled(true);
				this.btnAssumeStepStartStop.setEnabled(true);
				this.btnAssumeStepStartStop.setText(Labeling.ASSUME);
				break;
			}
			case RUN: {
				this.btnReset.setEnabled(true);
				this.btnAssumeStepStartStop.setEnabled(true);
				this.btnAssumeStepStartStop.setText(Labeling.NEXT_STEP);
				break;
			}
			case FINISHED: {
				this.btnReset.setEnabled(true);
				this.btnAssumeStepStartStop.setEnabled(false);
				this.btnAssumeStepStartStop.setText(Labeling.NEXT_STEP);
				break;
			}
			default: {			
				break;
			}
		
		}
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
							.addComponent(lblMaxFlowRate)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfMaxFlowRate, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblConnection2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblConnection1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(tfConnection1, 0, 0, Short.MAX_VALUE)
								.addComponent(tfConnection2, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblModusLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblModusLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblModusContent2, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblModusContent1, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblCwndLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblCwndLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblDiferenceLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblDifferenceContent, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblCwndContent2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblCwndContent1, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnAssumeStepStartStop, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(panelAutomatic, GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConnection1)
						.addComponent(tfConnection1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblModusLabel1)
						.addComponent(lblModusContent1)
						.addComponent(lblCwndLabel1)
						.addComponent(lblCwndContent1)
						.addComponent(btnAssumeStepStartStop))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConnection2)
						.addComponent(tfConnection2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblModusLabel2)
						.addComponent(btnReset)
						.addComponent(lblModusContent2)
						.addComponent(lblCwndLabel2)
						.addComponent(lblCwndContent2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMaxFlowRate)
						.addComponent(tfMaxFlowRate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDiferenceLabel)
						.addComponent(lblDifferenceContent))
					.addContainerGap(56, Short.MAX_VALUE))
				.addComponent(panelAutomatic, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
		);
		setLayout(groupLayout);
	}

	@Override
	public Integer getHeightMenu() {
		return 110;
	}
	
	private void inputMaxFlowRate() throws Exception {
		try {
			Integer maxFlowRate = new Integer(tfMaxFlowRate.getText());
			fairness.setMaxFlowRate(maxFlowRate);
		} catch (Exception ex) {
			MessageBox.showErrorMessage("falsches Flow Rate!");			
			throw ex;
		}
	}
	
	private void inputConnection() throws Exception {
		try {			
			Integer connection1 = new Integer(tfConnection1.getText());
			Integer connection2 = new Integer(tfConnection2.getText());
			fairness.setConnections(connection1, connection2);
		} catch (Exception ex) {
			MessageBox.showErrorMessage("falsche Verbindungen!");			
			throw ex;
		}
	}
	
	private ActionListener ActionReset = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			try {	
				tfConnection1.setText("");
				tfConnection2.setText("");
				tfMaxFlowRate.setText("");
				fairness.reset();
			} catch (Exception ex) {
				
			}
			updatePanel();
		}
	};
	
	private ActionListener ActionAssumeStepStartStop = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			try {
				EnumVisualizationStatus status = fairness.getFairnessStatus();
				if (status != EnumVisualizationStatus.FINISHED) {
					if (status == EnumVisualizationStatus.START) {
						inputMaxFlowRate();
						inputConnection();
					}
					executeManualAutomatic();
				}				
			} catch (Exception ex) {
				
			}
			updatePanel();
		}
	};
	
}
