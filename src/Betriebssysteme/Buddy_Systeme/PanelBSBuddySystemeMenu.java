package Betriebssysteme.Buddy_Systeme;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Base.BasePanelMenu;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

public class PanelBSBuddySystemeMenu extends BasePanelMenu {

	private IBuddyMemoryAllocation buddy;	
	
	private JTextField tfSpace;
	private JTextField tfProcessName;
	private JTextField tfProcessSize;
	
	private JRadioButton rdbtnProcessStart;	
	private JRadioButton rdbtnProcessEnd;	
	
	private JLabel lblSpace;
	private JLabel lblProcessName;
	private JLabel lblProcessSize;
	private JLabel lblDemoTip;
	
	private JButton btnExecute1;	
	private JButton btnExecute2;	
	private JButton btnDemo;
	
	private ButtonGroup groupBuddy = new ButtonGroup();
	
	
	/**
	 * Create the panel.
	 */
	public PanelBSBuddySystemeMenu(IBuddyMemoryAllocation ibuddy) {		
		if (ibuddy == null) {
			ibuddy = new BuddyMemoryAllocation();
		}
		buddy = ibuddy;
		initComponents();
	}

	@Override
	protected void initComponents() {
		lblSpace = new JLabel("Speichergröße:");	
		lblSpace.setIcon(new ImageIcon("C:\\Eclipse\\Workspace\\Visualisierung\\img\\16x16_help.png"));
		lblProcessName = new JLabel("Prozessname:");	
		lblProcessName.setIcon(new ImageIcon("C:\\Eclipse\\Workspace\\Visualisierung\\img\\16x16_help.png"));
		lblProcessSize = new JLabel("Prozessgröße:");
		lblProcessSize.setIcon(new ImageIcon("C:\\Eclipse\\Workspace\\Visualisierung\\img\\16x16_help.png"));
		lblDemoTip = new JLabel(" ");
		lblDemoTip.setIcon(new ImageIcon("C:\\Eclipse\\Workspace\\Visualisierung\\img\\16x16_help.png"));		
		
		rdbtnProcessStart = new JRadioButton("Prozess starten");		
		rdbtnProcessEnd = new JRadioButton("Prozess beenden");	
		groupBuddy.add(rdbtnProcessStart);
		groupBuddy.add(rdbtnProcessEnd);
		rdbtnProcessStart.setSelected(true);					
		
		btnExecute1 = new JButton("zurücksetzen");
		btnExecute1.addActionListener(ActionExecute1);
		btnExecute2 = new JButton("Prozess beenden");
		btnExecute2.addActionListener(ActionExecute2);
		btnDemo = new JButton("Demo laden");
		btnDemo.addActionListener(ActionDemo);
		
		tfSpace = new JTextField();
		tfSpace.setColumns(10);
		tfSpace.setText("");
		tfProcessName = new JTextField();
		tfProcessName.setColumns(10);
		tfProcessName.setText("");
		tfProcessSize = new JTextField();
		tfProcessSize.setColumns(10);
		tfProcessSize.setText("");	
		
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
						.addComponent(rdbtnProcessEnd)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(21)
									.addComponent(lblProcessSize)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(tfProcessSize, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnExecute1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblDemoTip)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnDemo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(btnExecute2, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(308, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSpace)
						.addComponent(tfSpace, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExecute1)
						.addComponent(btnDemo)
						.addComponent(lblDemoTip))
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
					.addContainerGap(216, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	@Override
	protected void updateComponents() {
		
		lblSpace.setEnabled(true);
		lblProcessName.setEnabled(true);
		lblProcessSize.setEnabled(true);
		lblDemoTip.setEnabled(true);	
		btnExecute1.setEnabled(true);
		
		if (rdbtnProcessStart.isSelected()) {
			btnExecute2.setText("Prozess starten");			
		} else {
			btnExecute2.setText("Prozess beenden");
		}
		
		if (buddy != null) {
			EnumBuddyMemoryAllocation status = buddy.getStatus();			
			switch (status) {
				case START: {					
					tfSpace.setEnabled(true);
					tfSpace.setEditable(true);
					tfProcessName.setEnabled(false);
					tfProcessName.setEditable(false);
					tfProcessSize.setEnabled(false);
					tfProcessSize.setEditable(false);
					rdbtnProcessStart.setEnabled(false);	
					rdbtnProcessEnd.setEnabled(false);
					btnExecute1.setText("übernehmen");
					btnExecute2.setEnabled(false);
					btnDemo.setEnabled(true);		
					break;					
				}
				case EXECUTE: {					
					tfSpace.setEnabled(false);
					tfSpace.setEditable(false);
					tfProcessName.setEnabled(true);
					tfProcessName.setEditable(true);
					tfProcessSize.setEnabled(rdbtnProcessStart.isSelected());
					tfProcessSize.setEditable(rdbtnProcessStart.isSelected());
					rdbtnProcessStart.setEnabled(true);	
					rdbtnProcessEnd.setEnabled(true);
					btnExecute1.setText("zurücksetzen");
					btnExecute2.setEnabled(true);	
					btnDemo.setEnabled(false);					
					break;
				}
				default: {
					break;
				}
			}
					
		}		
	}

	@Override
	protected void initToolTips() {
		// TODO Auto-generated method stub
		
	}
	
	private void inputTotalSpace() {
		// Eingabe
		String text = tfSpace.getText();			
		try {
			Integer space = new Integer(text);
			Integer x = BuddyHelper.getPotence(space);
			Integer y = (int) Math.pow(2, x);
			tfSpace.setText(y.toString());
			buddy.setTotalSpace(y);	
		} catch (Exception ex) {
			tfSpace.setText("");
			//noInput();
		} finally {
			
		}
	}
	
	private Integer inputProcessSize() {
		// Eingabe
		Integer process = null;
		String text = tfProcessSize.getText();			
		try {
			process = new Integer(text);
		} catch (Exception ex) {
			tfSpace.setText("");
			//noInput();
		} finally {
			
		}
		return process;
	}
	
	ActionListener ActionExecute1 = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			EnumBuddyMemoryAllocation status = buddy.getStatus();
			switch (status) {
				case START: {
					inputTotalSpace();
					break;
				}
				case EXECUTE: {
					buddy.reset();
					break;
				}
				default: {
					break;
				}
			}
		}
	};
	
	ActionListener ActionExecute2 = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			EnumBuddyMemoryAllocation status = buddy.getStatus();
			switch (status) {
				case START: {					
					break;
				}
				case EXECUTE: {
					String processName = tfProcessName.getText();
					if (processName != null) {
						if (rdbtnProcessStart.isSelected()) {
							Integer processSize = inputProcessSize();
							if (processSize != null) {
								buddy.startProcess(processName, processSize);
								
							}
						} else {
							buddy.stopProcess(processName);
						}
						tfProcessName.setText("");
						tfProcessSize.setText("");
					}					
					break;
				}
				default: {
					break;
				}
			}
		}
	};
	
	ActionListener ActionDemo = new ActionListener() {
		public void actionPerformed (ActionEvent e) {			
			buddy.setTotalSpace(1024);		
			buddy.startProcess("a", 100);			
			buddy.startProcess("b", 200);			
			buddy.startProcess("c", 250);			
			buddy.startProcess("d", 250);			
			buddy.stopProcess("b");			
			buddy.stopProcess("c");			
			buddy.startProcess("f", 60);			
			buddy.stopProcess("a");			
			buddy.stopProcess("f");			
			buddy.stopProcess("d");			
		}
	};
}
