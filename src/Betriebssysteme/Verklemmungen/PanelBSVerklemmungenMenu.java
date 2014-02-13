/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Verklemmungen;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Base.BasePanelMenu;

public class PanelBSVerklemmungenMenu extends BasePanelMenu {
	
	public PanelBSVerklemmungenMenu(IDeadlockManagement ideadlock) {
		super();
		if (ideadlock == null) {
			ideadlock = new DeadlockManagement();
		}
		deadlock = ideadlock;
		initComponents();
	}
	
	private JTextField tfE;
	private JTextField tfB;
	private JTextField tfC;
	private JLabel lblE;
	private JButton btnE;
	private JLabel lblB;
	private JLabel lblC;
	private JButton btnAdd;
	private JButton btnReset;
	private JButton btnExecute;
	private JLabel lblExample;
	private JRadioButton rdbtnOwn;
	private JRadioButton rdbtnExample;
	private JComboBox cbExample;
	private JButton btnUse;
	
	private IDeadlockManagement deadlock;
	
	@Override
	protected void initComponents() {
		
		lblE = new JLabel("E =");
		lblE.setIcon(new ImageIcon("C:\\Eclipse\\Workspace\\Visualisierung\\img\\help16x16.png"));
		
		tfE = new JTextField();
		tfE.setColumns(10);
		
		btnE = new JButton("übernehmen");
		
		lblB = new JLabel("B =");
		lblB.setIcon(new ImageIcon("C:\\Eclipse\\Workspace\\Visualisierung\\img\\help16x16.png"));
		
		tfB = new JTextField();
		tfB.setColumns(10);
		
		lblC = new JLabel("C =");
		lblC.setIcon(new ImageIcon("C:\\Eclipse\\Workspace\\Visualisierung\\img\\help16x16.png"));
		
		tfC = new JTextField();
		tfC.setColumns(10);
		
		btnAdd = new JButton("hinzufügen");
		
		btnReset = new JButton("zurücksetzen");
		
		btnExecute = new JButton("ausführen");
		
		lblExample = new JLabel("Beispiel:");
		lblExample.setIcon(new ImageIcon("C:\\Eclipse\\Workspace\\Visualisierung\\img\\help16x16.png"));
		
		rdbtnOwn = new JRadioButton("selber ausprobieren");
		
		rdbtnExample = new JRadioButton("Beispiele verwenden");
		
		cbExample = new JComboBox();
		cbExample.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		
		btnUse = new JButton("verwenden");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnExecute, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblB)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfB, 0, 0, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfE, 0, 0, Short.MAX_VALUE))
						.addComponent(rdbtnOwn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblC)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnE, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnReset, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(tfC, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(28)
							.addComponent(btnUse, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(rdbtnExample, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdd, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblExample)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbExample, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
					.addGap(287))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnOwn)
								.addComponent(rdbtnExample))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblE)
								.addComponent(tfE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblExample)
								.addComponent(btnE)
								.addComponent(cbExample, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblB)
								.addComponent(tfB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAdd))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnExecute)
								.addComponent(btnReset)
								.addComponent(btnUse)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(61)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblC)
								.addComponent(tfC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(458, Short.MAX_VALUE))
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
		return 200;
	}	
}
