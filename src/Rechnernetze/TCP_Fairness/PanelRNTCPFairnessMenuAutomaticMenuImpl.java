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
import Base.PanelMenuAutomaticMenuAbstract;

public class PanelRNTCPFairnessMenuAutomaticMenuImpl extends PanelMenuAutomaticMenuAbstract {
	
	public PanelRNTCPFairnessMenuAutomaticMenuImpl(ManagementFairness fairness, ToolTipManagerFairness tooltip) {
		super(fairness, tooltip);		
		this.initPanel();
	}
	
	// only for Designer
	private PanelRNTCPFairnessMenuAutomaticMenuImpl() {
		super(new ManagementFairnessImpl(), new ToolTipManagerFairnessImpl());
		this.initComponents();
		this.initLayout();
		this.updatePanel();
	}

	private ManagementFairness fairness;
	private ToolTipManagerFairness tooltip;
	
	private JTextField tfConnection1;
	private JTextField tfConnection2;	
	private JLabel lblMaxFlowRateLabel;
	private JLabel lblMaxFlowRateContent;
	private JLabel lblConnection1;
	private JLabel lblConnection2;
	private JLabel lblModusLabel;
	private JLabel lblModusContent;
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
		lblConnection1 = new JLabel("Verbindung 1:");
		lblConnection1.setIcon(imgHelp);
		
		lblConnection2 = new JLabel("Verbindung 2:");
		lblConnection2.setIcon(imgHelp);
		
		tfConnection1 = new JTextField();
		
		tfConnection2 = new JTextField();
		
		lblModusLabel = new JLabel("Modus:");
		lblModusLabel.setIcon(imgHelp);
		
		lblModusContent = new JLabel("-");
		
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
		
		lblMaxFlowRateLabel = new JLabel("maximale Durchflussleistung:");
		lblMaxFlowRateLabel.setIcon(imgHelp);
		
		lblMaxFlowRateContent = new JLabel("0");
	}
	
	@Override
	public void updatePanel() {
		EnumVisualizationStatus status = fairness.getStatus();
		Boolean isStart = (status == EnumVisualizationStatus.START);
		String modus = fairness.getModus();
		Integer c1 = fairness.getConnection1();
		Integer c2 = fairness.getConnection2();
		Integer dif = fairness.getDifference();
		Integer mfr = fairness.getMaxFlowRate();
		
		this.lblModusContent.setText(modus);
		this.lblCwndContent1.setText(c1.toString());
		this.lblCwndContent2.setText(c2.toString());
		this.lblDifferenceContent.setText(dif.toString());
		this.lblMaxFlowRateContent.setText(mfr.toString());
		this.tfConnection1.setEnabled(isStart);
		this.tfConnection1.setEditable(isStart);
		this.tfConnection2.setEnabled(isStart);		
		this.tfConnection2.setEditable(isStart);
		
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
				this.btnAssumeStepStartStop.setText(fairness.getButtonAutomaticText());
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
						.addComponent(lblMaxFlowRateLabel)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblConnection2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblConnection1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(tfConnection1, 0, 0, Short.MAX_VALUE)
								.addComponent(tfConnection2, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblMaxFlowRateContent, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblDiferenceLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblCwndLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblCwndLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblDifferenceContent, GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
						.addComponent(lblCwndContent2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblCwndContent1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnAssumeStepStartStop, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblModusLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblModusContent, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(661, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConnection1)
						.addComponent(tfConnection1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCwndLabel1)
						.addComponent(lblCwndContent1)
						.addComponent(btnAssumeStepStartStop))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConnection2)
						.addComponent(tfConnection2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCwndLabel2)
						.addComponent(lblCwndContent2)
						.addComponent(btnReset))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMaxFlowRateLabel)
						.addComponent(lblMaxFlowRateContent)
						.addComponent(lblDiferenceLabel)
						.addComponent(lblDifferenceContent)
						.addComponent(lblModusLabel)
						.addComponent(lblModusContent))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	@Override
	public Integer getHeightMenu() {
		return 110;
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
				fairness.reset();
			} catch (Exception ex) {
				
			}
			updatePanel();
		}
	};
	
	private ActionListener ActionAssumeStepStartStop = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			try {
				EnumVisualizationStatus status = fairness.getStatus();
				if (status != EnumVisualizationStatus.FINISHED) {
					if (status == EnumVisualizationStatus.START) {
						inputConnection();
					}
					executeManualAutomatic();
				}				
			} catch (Exception ex) {
				
			}
			updatePanel();
		}
	};

	@Override
	public Integer getLengthMenu() {
		return 600;
	}
}
