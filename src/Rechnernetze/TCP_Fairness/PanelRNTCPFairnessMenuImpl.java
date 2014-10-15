/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.TCP_Fairness;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Base.EnumVisualizationStatus;
import Base.MessageBox;
import Base.PanelMenuButtonsAbstract;

public class PanelRNTCPFairnessMenuImpl extends PanelMenuButtonsAbstract {
	
	private static final long serialVersionUID = 1L;
	
	public PanelRNTCPFairnessMenuImpl() {
		super(ManagementFairnessImpl.getInstance());
		//this.initializeExtra();
		this.createPanel();
	}

	private void initializeExtra() {
		this.createMenuComponentsExtra();
		this.createLayout();
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
	private JLabel lblDifferenceLabel;
	private JLabel lblCwndContent1;
	private JLabel lblCwndContent2;
	private JLabel lblDifferenceContent;	
	
	@Override
	protected void createMenuComponentsExtra() {
		this.fairness = ManagementFairnessImpl.getInstance();
		this.tooltip = ToolTipManagerFairnessImpl.getInstance();
		
		ImageIcon imgHelp = super.getImageIconHelp();		
		lblConnection1 = new JLabel("Verbindung 1 cwnd Startwert:");
		lblConnection1.setIcon(imgHelp);
		lblConnection1.setToolTipText(tooltip.getToolTipConnection1());
		
		lblConnection2 = new JLabel("Verbindung 2 cwnd Startwert:");
		lblConnection2.setIcon(imgHelp);
		lblConnection2.setToolTipText(tooltip.getToolTipConnection2());
		
		tfConnection1 = new JTextField();
		
		tfConnection2 = new JTextField();
		
		lblModusLabel = new JLabel("Modus:");
		lblModusLabel.setIcon(imgHelp);
		lblModusLabel.setToolTipText(tooltip.getToolTipModus());
		
		lblModusContent = new JLabel("-");
		
		lblCwndLabel1 = new JLabel("aktueller Wert:");
		//lblCwndLabel1.setIcon(imgHelp);
		//lblCwndLabel1.setToolTipText(tooltip.getToolTipCwnd1());
		
		lblCwndLabel2 = new JLabel("aktueller Wert:");
		//lblCwndLabel2.setIcon(imgHelp);
		//lblCwndLabel2.setToolTipText(tooltip.getToolTipCwnd2());
		
		lblDifferenceLabel = new JLabel("Differenz:");
		lblDifferenceLabel.setIcon(imgHelp);
		lblDifferenceLabel.setToolTipText(tooltip.getToolTipDifference());
		
		lblCwndContent1 = new JLabel("-");
		
		lblCwndContent2 = new JLabel("-");
		
		lblDifferenceContent = new JLabel("0");
		
		lblMaxFlowRateLabel = new JLabel("maximale Durchflussleistung:");
		lblMaxFlowRateLabel.setIcon(imgHelp);
		lblMaxFlowRateLabel.setToolTipText(tooltip.getToolTipMaxFlowRate());
		
		lblMaxFlowRateContent = new JLabel("0");
	}
	
	@Override
	public void updatePanelExtra() {
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
	}	
	
	@Override
	protected void createLayout() {		
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
						.addComponent(lblDifferenceLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblCwndLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblCwndLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblDifferenceContent, GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
						.addComponent(lblCwndContent2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblCwndContent1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(this.btnAssumeSaveExecute, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(this.btnExampleReset, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
						.addComponent(this.btnAssumeSaveExecute))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConnection2)
						.addComponent(tfConnection2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCwndLabel2)
						.addComponent(lblCwndContent2)
						.addComponent(this.btnExampleReset))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMaxFlowRateLabel)
						.addComponent(lblMaxFlowRateContent)
						.addComponent(lblDifferenceLabel)
						.addComponent(lblDifferenceContent)
						.addComponent(lblModusLabel)
						.addComponent(lblModusContent))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	@Override
	protected void createMenuMethodsExtra() {
		
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

	@Override
	public Integer getPanelHeight() {
		return 110;
	}
	
	@Override
	public Integer getPanelWidth() {
		return 600;
	}

	@Override
	protected void loadExample() {
		tfConnection1.setText("28");
		tfConnection2.setText("4");
	}

	@Override
	protected void assume() {
		try {
			inputConnection();
			fairness.executeNormal();
		} catch (Exception e) {
			
		}		
	}

	@Override
	protected void clearFields() {
		tfConnection1.setText("");
		tfConnection2.setText("");
	}

	@Override
	protected void executeExtra() {
		// nothing
	}

	@Override
	protected Boolean hasExample() {
		return true;
	}

	@Override
	protected void input() {
		
	}
}
