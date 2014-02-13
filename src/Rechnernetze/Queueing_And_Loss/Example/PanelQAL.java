package Rechnernetze.Queueing_And_Loss.Example;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class PanelQAL extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelQAL() {
		
		JLabel lblEmission = new JLabel("Emission rate");
		
		JLabel lblTransmission = new JLabel("Transmission rate");
		
		JComboBox cbEmission = new JComboBox();
		
		JComboBox cbTransmission = new JComboBox();
		
		JButton btnStart = new JButton("Start");
		
		JButton btnReset = new JButton("Reset");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEmission)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cbEmission, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblTransmission)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cbTransmission, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(138, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmission)
						.addComponent(cbEmission, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTransmission)
						.addComponent(cbTransmission, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnStart)
						.addComponent(btnReset))
					.addContainerGap(356, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
