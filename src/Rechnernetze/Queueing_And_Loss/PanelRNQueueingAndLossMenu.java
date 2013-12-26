package Rechnernetze.Queueing_And_Loss;

import Base.BasePanelMenu;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.ImageIcon;

public class PanelRNQueueingAndLossMenu extends BasePanelMenu {

	private IQALManagement qal;
	
	/**
	 * Create the panel.
	 */
	public PanelRNQueueingAndLossMenu(IQALManagement iqal) {
		
		JButton btnStart = new JButton("ausf\u00FChren");
		
		JButton btnReset = new JButton("zur\u00FCcksetzen");
		
		JLabel lblTransferRate = new JLabel("\u00DCbertragungsrate Eingang:");
		lblTransferRate.setIcon(new ImageIcon("C:\\Eclipse\\Workspace\\Visualisierung\\img\\16x16_help.png"));
		
		JLabel lblProcessingTime = new JLabel("Verarbeitungszeit:");
		lblProcessingTime.setIcon(new ImageIcon("C:\\Eclipse\\Workspace\\Visualisierung\\img\\16x16_help.png"));
		
		JLabel lblArrivalRate = new JLabel("Ankunftsrate (Paketabstand):");
		lblArrivalRate.setIcon(new ImageIcon("C:\\Eclipse\\Workspace\\Visualisierung\\img\\16x16_help.png"));
		
		JSlider sliderProcessingTime = new JSlider();
		sliderProcessingTime.setPaintTicks(true);
		
		JSlider sliderTransferRate = new JSlider();
		sliderTransferRate.setPaintTicks(true);
		sliderTransferRate.setPaintLabels(true);
		
		JSlider sliderArrivalRate = new JSlider();
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
		if (iqal == null) {
			iqal = new QALManagement();
		}
		qal = iqal;
	}

	@Override
	protected void initComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void updateComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initToolTips() {
		// TODO Auto-generated method stub
		
	}
}
