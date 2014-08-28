/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Rechnernetze.QAL_Old;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.LayoutStyle.ComponentPlacement;

import Base.PanelMenuAbstract;

public class PanelRNQueueingAndLossMenuImpl extends PanelMenuAbstract {

	public PanelRNQueueingAndLossMenuImpl(ManagementQueueingAndLoss qal, ToolTipManagerQueueingAndLoss tooltip) {
		super(qal, tooltip);
	}

	private ManagementQueueingAndLoss qal;
	
	private JButton btnStart;
	private JButton btnReset;
	private JLabel lblTransferRate;
	private JLabel lblProcessingTime;
	private JLabel lblArrivalRate;
	private JSlider sliderProcessingTime;
	private JSlider sliderArrivalRate;
	private ComboBoxTransferRateImpl cbTransferRate;
	private ComboBoxProcessingTimeImpl cbProcessingTime;
	
	@Override
	protected void initComponentsMenu() {
		this.qal = (ManagementQueueingAndLoss) this.getManagement();
		
		btnStart = new JButton("ausf\u00FChren");		
		btnReset = new JButton("zur\u00FCcksetzen");		
		
		lblTransferRate = new JLabel("\u00DCbertragungsrate Eingang:");
		lblTransferRate.setIcon(new ImageIcon("C:\\Eclipse\\Workspace\\Visualisierung\\img\\16x16_help.png"));
		
		lblProcessingTime = new JLabel("Verarbeitungszeit:");
		lblProcessingTime.setIcon(new ImageIcon("C:\\Eclipse\\Workspace\\Visualisierung\\img\\16x16_help.png"));
		
		lblArrivalRate = new JLabel("Ankunftsrate (Paketabstand):");
		lblArrivalRate.setIcon(new ImageIcon("C:\\Eclipse\\Workspace\\Visualisierung\\img\\16x16_help.png"));
		
		sliderProcessingTime = new JSlider();
		sliderProcessingTime.setPaintTicks(true);
		
		sliderArrivalRate = new JSlider();
		sliderArrivalRate.setPaintTicks(true);
		
		cbTransferRate = new ComboBoxTransferRateImpl();
		
		cbProcessingTime = new ComboBoxProcessingTimeImpl();		
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
							.addComponent(lblProcessingTime)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblTransferRate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblArrivalRate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(sliderArrivalRate, 0, 0, Short.MAX_VALUE)
												.addComponent(sliderProcessingTime, 0, 0, Short.MAX_VALUE))
											.addGap(16))
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(cbTransferRate, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(cbProcessingTime, Alignment.LEADING, 0, 123, Short.MAX_VALUE))
											.addGap(14)))))
							.addGap(320))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnStart)
						.addComponent(btnReset))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTransferRate)
						.addComponent(cbTransferRate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addComponent(sliderProcessingTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblProcessingTime)
								.addComponent(cbProcessingTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblArrivalRate)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(sliderArrivalRate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(155))
		);
		setLayout(groupLayout);
	}

	@Override
	public void updatePanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getHeightMenu() {
		return 130;
	}	

	@Override
	protected void initMethods() {
		ActionListener actionStart = new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				cbTransferRate.setEnabled(false);
				cbProcessingTime.setEnabled(false);
				btnStart.setEnabled(false);
				btnReset.setEnabled(true);
				qal.launchSim(cbTransferRate.getVal(), cbProcessingTime.getVal());
			}
				
		};
		
		ActionListener actionReset = new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				cbTransferRate.setEnabled(true);
				cbProcessingTime.setEnabled(true);
				btnStart.setEnabled(true);
				btnReset.setEnabled(true);
				qal.reset();
			}
		};
		
		btnStart.addActionListener(actionStart);
		btnReset.addActionListener(actionReset);		
	}
}