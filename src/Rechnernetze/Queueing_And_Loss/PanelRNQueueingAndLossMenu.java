/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Queueing_And_Loss;

import Base.BasePanelMenu;
import Base.BasePanelModel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.ImageIcon;

public class PanelRNQueueingAndLossMenu extends BasePanelMenu {

	public PanelRNQueueingAndLossMenu(IQALManagement iqal, PanelRNQueueingAndLossModel model) {
		super(model);		
		if (iqal == null) {
			iqal = new QALManagement();
		}
		qal = iqal;
		initComponents();
	}

	private IQALManagement qal;
	
	private JButton btnStart;
	private JButton btnReset;
	private JLabel lblTransferRate;
	private JLabel lblProcessingTime;
	private JLabel lblArrivalRate;
	private JSlider sliderProcessingTime;
	private JSlider sliderTransferRate;
	private JSlider sliderArrivalRate;
	
	@Override
	protected void initComponents() {
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
		
		sliderTransferRate = new JSlider();
		sliderTransferRate.setPaintTicks(true);
		sliderTransferRate.setPaintLabels(true);
		
		sliderArrivalRate = new JSlider();
		sliderArrivalRate.setPaintTicks(true);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblArrivalRate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblTransferRate, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
								.addComponent(lblProcessingTime, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(sliderArrivalRate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(sliderProcessingTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(sliderTransferRate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(796))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnStart)
						.addComponent(btnReset))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTransferRate)
						.addComponent(sliderTransferRate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblProcessingTime)
						.addComponent(sliderProcessingTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblArrivalRate)
						.addComponent(sliderArrivalRate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(179))
		);
		setLayout(groupLayout);
	}

	@Override
	protected void updateComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initToolTips() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getHeightMenu() {
		return 130;
	}
}
