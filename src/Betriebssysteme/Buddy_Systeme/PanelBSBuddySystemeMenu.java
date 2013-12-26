package Betriebssysteme.Buddy_Systeme;

import Base.BasePanelMenu;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelBSBuddySystemeMenu extends BasePanelMenu {

	private IBuddyManagement buddy;
	private JTextField tfSpace;
	private JTextField tfProcessName;
	private JTextField tfProcessSize;
	
	/**
	 * Create the panel.
	 */
	public PanelBSBuddySystemeMenu(IBuddyManagement ibuddy) {
		
		JRadioButton rdbtnProcessStart = new JRadioButton("Prozess starten");
		
		JRadioButton rdbtnProcessEnd = new JRadioButton("Prozess beenden");
		
		JLabel lblSpace = new JLabel("Speichergr\u00F6\u00DFe:");
		
		tfSpace = new JTextField();
		tfSpace.setColumns(10);
		
		JButton btnExecute1 = new JButton("zur\u00FCcksetzen");
		
		JLabel lblProcessName = new JLabel("Prozessname:");
		
		tfProcessName = new JTextField();
		tfProcessName.setColumns(10);
		
		JButton btnExecute2 = new JButton("Prozess beenden");
		
		JLabel lblProcessSize = new JLabel("Prozessgr\u00F6\u00DFe:");
		
		tfProcessSize = new JTextField();
		tfProcessSize.setColumns(10);
		
		JButton btnDemo = new JButton("Demo laden");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblProcessName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblSpace, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(tfSpace, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfProcessName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(rdbtnProcessStart))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(lblProcessSize)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tfProcessSize, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnExecute2, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
						.addComponent(rdbtnProcessEnd)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnExecute1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDemo)))
					.addContainerGap(285, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSpace)
						.addComponent(tfSpace, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExecute1)
						.addComponent(btnDemo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnProcessStart)
						.addComponent(rdbtnProcessEnd))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProcessName)
						.addComponent(lblProcessSize)
						.addComponent(tfProcessName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfProcessSize, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExecute2))
					.addContainerGap(219, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		if (ibuddy == null) {
			ibuddy = new BuddyManagement();
		}
		buddy = ibuddy;
		initComponents();
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
