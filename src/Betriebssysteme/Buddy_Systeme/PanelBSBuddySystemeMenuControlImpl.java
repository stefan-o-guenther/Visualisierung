/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Base.Labeling;

public class PanelBSBuddySystemeMenuControlImpl extends PanelBSBuddySystemeMenuAbstract {

	public PanelBSBuddySystemeMenuControlImpl(ManagerBuddyMemoryAllocation buddy, ToolTipManagerBuddyMemoryAllocation tooltip) {
		super(buddy, tooltip);
		this.initPanel();
	}

	private PanelBSBuddySystemeMenuControlImpl() {
		super(new ManagerBuddyMemoryAllocationImpl(), new ToolTipManagerBuddyMemoryAllocationImpl());
		this.initComponents();
		this.initLayout();
	}
	
	private ManagerBuddyMemoryAllocation buddy;
	private ToolTipManagerBuddyMemoryAllocation tooltip;
	
	private JTextField tfSpace;
	private JTextField tfProcessName;
	private JTextField tfProcessSize;
	
	private JRadioButton rdbtnProcessStart;	
	private JRadioButton rdbtnProcessStop;	
	
	private JLabel lblSpace;
	private JLabel lblProcessName;
	private JLabel lblProcessSize;
	private JLabel lblExampleTip;	
	
	private JButton btnExecute1;	
	private JButton btnExecute2;	
	private JButton btnExample;
	
	private ButtonGroupProcessImpl groupProcess;
	
	@Override
	protected void initComponents() {
		buddy = (ManagerBuddyMemoryAllocation) this.getManagement();
		tooltip = (ToolTipManagerBuddyMemoryAllocation) this.getToolTipManager();
		
		ImageIcon imgHelp = this.getImageIconHelp();		
		
		lblSpace = new JLabel(Labeling.SIZE_SPACE + ":");	
		lblSpace.setIcon(imgHelp);
		lblSpace.setToolTipText(tooltip.getToolTipSpaceSize());
		lblProcessName = new JLabel("Prozessname:");	
		lblProcessName.setIcon(imgHelp);
		lblProcessName.setToolTipText(tooltip.getToolTipProcessName());
		lblProcessSize = new JLabel(Labeling.SIZE_PROCESS + ":");
		lblProcessSize.setIcon(imgHelp);
		lblProcessSize.setToolTipText(tooltip.getToolTipProcessSize());
		lblExampleTip = new JLabel(" ");
		lblExampleTip.setIcon(imgHelp);
		lblExampleTip.setToolTipText(tooltip.getToolTipLoadExample());
		
		groupProcess = new ButtonGroupProcessImpl(actionProcess);	
		rdbtnProcessStart = groupProcess.getRadioButtonStart();
		rdbtnProcessStop = groupProcess.getRadioButtonStop();
		//rdbtnProcessStart = new JRadioButton("starten");
		//rdbtnProcessStop = new JRadioButton("stoppen");
				
		btnExecute1 = new JButton(Labeling.RESET);
		btnExecute1.addActionListener(actionExecute1);
		btnExecute2 = new JButton("Prozess beenden");
		btnExecute2.addActionListener(actionExecute2);
		btnExample = new JButton(Labeling.LOAD_EXAMPLE);
		btnExample.addActionListener(actionDemo);
		
		tfSpace = new JTextField();
		tfSpace.setColumns(10);
		tfSpace.setText("");
		tfProcessName = new JTextField();
		tfProcessName.setColumns(10);
		tfProcessName.setText("");
		tfProcessSize = new JTextField();
		tfProcessSize.setColumns(10);
		tfProcessSize.setText("");
	}
	
	@Override
	protected void initLayout() {		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblProcessName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblSpace, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(tfProcessName, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfSpace, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)))
						.addComponent(rdbtnProcessStart, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(rdbtnProcessStop, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblProcessSize)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfProcessSize, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnExecute1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(lblExampleTip)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnExecute2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnExample, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
					.addGap(314))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSpace)
						.addComponent(btnExecute1)
						.addComponent(lblExampleTip)
						.addComponent(btnExample)
						.addComponent(tfSpace, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProcessSize)
						.addComponent(tfProcessSize, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExecute2)
						.addComponent(lblProcessName)
						.addComponent(tfProcessName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnProcessStart)
						.addComponent(rdbtnProcessStop))
					.addContainerGap(209, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	@Override
	public void updatePanel() {
		lblSpace.setEnabled(true);
		lblProcessName.setEnabled(true);
		lblProcessSize.setEnabled(true);
		lblExampleTip.setEnabled(true);	
		btnExecute1.setEnabled(true);
		
		btnExecute2.setText(groupProcess.getSelectedButtonString());
		
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
					rdbtnProcessStop.setEnabled(false);
					btnExecute1.setText(Labeling.ASSUME);
					btnExecute2.setEnabled(false);
					btnExample.setEnabled(true);		
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
					rdbtnProcessStop.setEnabled(true);
					btnExecute1.setText(Labeling.RESET);
					btnExecute2.setEnabled(true);	
					btnExample.setEnabled(false);					
					break;
				}
				default: {
					break;
				}
			}					
		}
	}
		
	private void inputTotalSpace() {
		// Eingabe
		String text = tfSpace.getText();			
		try {
			Integer space = new Integer(text);
			if (space < 1024) {
				space = 1024;
			} else	if (space > 4096) {
				space = 4096;			
			} else {
				Integer x = BuddyHelper.getPotence(space);
				space = (int) Math.pow(2, x);				
			}			
			tfSpace.setText(space.toString());
			buddy.setTotalSpace(space);
			Integer limit = space / 512;
			buddy.limitOutput(limit);
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
			
		} finally {
			
		}
		return process;
	}

	private ActionListener actionExecute1 = new ActionListener() {
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
	
	private ActionListener actionExecute2 = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			EnumBuddyMemoryAllocation status = buddy.getStatus();
			switch (status) {
				case START: {					
					break;
				}
				case EXECUTE: {
					String processName = tfProcessName.getText();
					if (processName != null) {
						EnumProcess radioButton = groupProcess.getSelectedButtonEnum();
						switch(radioButton) {
							case PROCESS_START: {
								Integer processSize = inputProcessSize();
								buddy.startProcess(processName, processSize);							
								break;
							}
							case PROCESS_STOP: {
								buddy.stopProcess(processName);
								break;
							}
							default: {
								break;
							}
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
	
	private ActionListener actionDemo = new ActionListener() {
		public void actionPerformed (ActionEvent e) {			
			tfSpace.setText("1024");
			buddy.setTotalSpace(1024);				
			buddy.startProcess("a", 400);			
			buddy.startProcess("b", 200);
			buddy.startProcess("c", 70);
			buddy.stopProcess("c");
			buddy.startProcess("d", 100);
			buddy.startProcess("e", 50);
			buddy.stopProcess("b");			
			buddy.stopProcess("d");						
			buddy.stopProcess("a");
			buddy.startProcess("f", 50);
			buddy.stopProcess("e");
			buddy.stopProcess("f");
			//updatePanel();
		}
	};
	
	private ActionListener actionProcess = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			updatePanel();
		}	
	};

	@Override
	public Integer getHeightMenu() {
		return 110;
	}
}
