/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Queueing_And_Loss;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import Base.Labeling;
import Base.ManagementFactory;
import Base.PanelMenuButtonsAbstract;

public class PanelRNQueueingAndLossMenuImpl extends PanelMenuButtonsAbstract {

	private static final long serialVersionUID = 1L;	

	public PanelRNQueueingAndLossMenuImpl() {
		super(ManagementFactory.getManagementQueueingAndLoss());
		//this.initializeExtra();
		this.createPanel();
	}
	
	private void initializeExtra() {
		this.createMenuComponents();
		this.initializeButtons();
		this.createLayout();
	}
	
	private void initializeButtons() {
		this.btnAssumeSaveExecute = new JButton(Labeling.ASSUME);
		this.btnExampleReset = new JButton(Labeling.LOAD_EXAMPLE);
	}
	
	private ManagementQueueingAndLoss qal;
	
	//private JButton btnAssumeSaveExecute;
	//private JButton btnExampleReset;
	
	private JLabel lblTransfersLabel;
	private JLabel lblTransfersContent;
	private JLabel lblLossLabel;
	private JLabel lblLossContent;
	
	@Override
	protected void updatePanelExtra() {
		this.lblLossContent.setText(qal.getCountLoss().toString());
		this.lblTransfersContent.setText(qal.getCountTransfered().toString());
	}
	
	@Override
	protected void createMenuComponentsExtra() {
		this.qal = ManagementFactory.getManagementQueueingAndLoss();	
		lblTransfersLabel = new JLabel("\u00DCbertragungen:");		
		lblTransfersContent = new JLabel("00");		
		lblLossLabel = new JLabel("Verlust:");		
		lblLossContent = new JLabel("00");
	}
	
	@Override
	protected void createLayout() {	
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(btnExampleReset, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
							.addComponent(btnAssumeSaveExecute, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
					.addComponent(btnAssumeSaveExecute)
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
	protected void createMenuMethodsExtra() {
		
	}

	@Override
	protected void loadExample() {
		
	}

	@Override
	protected void assume() {
		
	}

	@Override
	protected void clearFields() {
		
	}

	@Override
	protected void executeExtra() {
		
	}

	@Override
	protected Boolean hasExample() {
		return false;
	}

	@Override
	protected void input() {
		
	}		
}
