package Betriebssysteme.Seitenersetzungsstrategien;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class PanelBSSeitenersetzungsstrategien extends JPanel {
	private JTextField tReferenzfolge;

	/**
	 * Create the panel.
	 */
	public PanelBSSeitenersetzungsstrategien() {
		
		JLabel lblTitel = new JLabel("Seitenersetzungsstrategien");
		lblTitel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		
		JRadioButton rdbtnColored = new JRadioButton("farbig");
		
		JRadioButton rdbtnGray = new JRadioButton("grau");
		
		JLabel lblStrategie = new JLabel("Strategie:");
		lblStrategie.setIcon(new ImageIcon("C:\\Eclipse\\Workspace\\Visualisierung\\img\\help16x16.png"));
		
		JLabel lblReferenzfolge = new JLabel("Referenzfolge:");
		lblReferenzfolge.setIcon(new ImageIcon("C:\\Eclipse\\Workspace\\Visualisierung\\img\\help16x16.png"));
		
		JComboBox cbStrategie = new JComboBox();
		cbStrategie.setModel(new DefaultComboBoxModel(new String[] {"Optimale Strategie", "FIFO", "FIFO - Second Chance", "NRU / RNU - FIFO", "NRU / RNU - FIFO - Second Chance"}));
		
		tReferenzfolge = new JTextField();
		tReferenzfolge.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblReferenzfolge)
						.addComponent(lblStrategie, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
						.addComponent(rdbtnColored)
						.addComponent(rdbtnGray))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTitel)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(tReferenzfolge, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
								.addComponent(cbStrategie, 0, 359, Short.MAX_VALUE))
							.addGap(530))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTitel)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(rdbtnColored)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnGray)))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbStrategie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStrategie))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblReferenzfolge)
						.addComponent(tReferenzfolge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(460, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
