/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Base.BasePanelMenu;
import Base.BasePanelModel;

public class PanelBSBuddySystemeMenu extends BasePanelMenu {

	public PanelBSBuddySystemeMenu(IBuddyMemoryAllocation ibuddy) {
		super();
		if (ibuddy != null) {
			buddy = ibuddy;
		}
		initComponents();
		updateComponents();
	}

	private IBuddyMemoryAllocation buddy;	
	
	private JTextField tfSpace;
	private JTextField tfProcessName;
	private JTextField tfProcessSize;
	
	private JRadioButton rdbtnProcessStart;	
	private JRadioButton rdbtnProcessStop;	
	
	private JLabel lblSpace;
	private JLabel lblProcessName;
	private JLabel lblProcessSize;
	private JLabel lblExampleTip;	
	private JLabel lblProcessCountLabel;	
	private JLabel lblProcessSpaceLabel;	
	private JLabel lblFreeSpaceLabel;	
	private JLabel lblRestSpaceLable;	
	private JLabel lblProcessCountOutput;
	private JLabel lblProcessSpaceOutput;	
	private JLabel lblFreeSpaceOutput;	
	private JLabel lblRestSpaceOutput;
	
	private JButton btnExecute1;	
	private JButton btnExecute2;	
	private JButton btnExample;
	
	private ButtonGroupProcess groupProcess;	
	
	private String sToolTipSpeichergroesse = "";
	private String sToolTipProzessname = "";
	private String sToolTipProzessgroesse = "";
	private String sToolTipBeispielLaden = "";
	
	@Override
	protected void initComponents() {
		initToolTips();
		
		ImageIcon imgHelp = this.getImageIconHelp();		
		
		lblSpace = new JLabel("Speichergröße:");	
		lblSpace.setIcon(imgHelp);
		lblSpace.setToolTipText(sToolTipSpeichergroesse);
		lblProcessName = new JLabel("Prozessname:");	
		lblProcessName.setIcon(imgHelp);
		lblProcessName.setToolTipText(sToolTipProzessname);
		lblProcessSize = new JLabel("Prozessgröße:");
		lblProcessSize.setIcon(imgHelp);
		lblProcessSize.setToolTipText(sToolTipProzessgroesse);
		lblExampleTip = new JLabel(" ");
		lblExampleTip.setIcon(imgHelp);
		lblExampleTip.setToolTipText(sToolTipBeispielLaden);
		
		groupProcess = new ButtonGroupProcess("Prozess starten", "Prozess beenden", actionProcess);	
		rdbtnProcessStart = groupProcess.geRadioButtonStart();
		rdbtnProcessStop = groupProcess.getRadioButtonStop();
				
		btnExecute1 = new JButton("zurücksetzen");
		btnExecute1.addActionListener(actionExecute1);
		btnExecute2 = new JButton("Prozess beenden");
		btnExecute2.addActionListener(actionExecute2);
		btnExample = new JButton("Beispiel laden");
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
		
		JPanel panel = new JPanel();
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblProcessName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblSpace, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(tfProcessName, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfSpace, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)))
						.addComponent(rdbtnProcessStart, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(rdbtnProcessStop, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblProcessSize)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfProcessSize, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnExecute1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnExample, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblExampleTip))
						.addComponent(btnExecute2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(98, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSpace)
								.addComponent(btnExecute1)
								.addComponent(tfSpace, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnExample)
								.addComponent(lblExampleTip))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblProcessName)
								.addComponent(lblProcessSize)
								.addComponent(tfProcessName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfProcessSize, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnExecute2))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnProcessStart)
								.addComponent(rdbtnProcessStop))))
					.addContainerGap(394, Short.MAX_VALUE))
		);
		
		lblProcessCountLabel = new JLabel("Anzahl der Prozesse:");
		lblProcessSpaceLabel = new JLabel("Belegter Speicherplatz:");
		lblFreeSpaceLabel = new JLabel("Freier Speicherplatz:");
		lblRestSpaceLable = new JLabel("Verschnitt:");
		lblProcessCountOutput = new JLabel("");
		lblProcessSpaceOutput = new JLabel("");
		lblFreeSpaceOutput = new JLabel("");
		lblRestSpaceOutput = new JLabel("");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblProcessCountLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblProcessCountOutput))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblProcessSpaceLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblProcessSpaceOutput))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblFreeSpaceLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblFreeSpaceOutput))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblRestSpaceLable)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblRestSpaceOutput)))
					.addContainerGap(47, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProcessCountLabel)
						.addComponent(lblProcessCountOutput))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProcessSpaceLabel)
						.addComponent(lblProcessSpaceOutput))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFreeSpaceLabel)
						.addComponent(lblFreeSpaceOutput))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRestSpaceLable)
						.addComponent(lblRestSpaceOutput))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
	}

	@Override
	protected void updateComponents() {
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
					btnExecute1.setText("übernehmen");
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
					btnExecute1.setText("zurücksetzen");
					btnExecute2.setEnabled(true);	
					btnExample.setEnabled(false);					
					break;
				}
				default: {
					break;
				}
			}					
		}
		DecimalFormat decimalFormat = new DecimalFormat("#0.00");
		
		Integer processCount = buddy.getProcessCount();
		lblProcessCountOutput.setText(processCount.toString());
		
		Integer processSpace = buddy.getProcessSpace();
		Double processRate = buddy.getProcessRate();				
		lblProcessSpaceOutput.setText(processSpace + " (" + decimalFormat.format(processRate) + "%)");
		
		Integer freeSpace = buddy.getFreeSpace();
		Double freeRate = buddy.getFreeRate();		
		lblFreeSpaceOutput.setText(freeSpace + " (" + decimalFormat.format(freeRate) + "%)");
		
		Integer restSpace = buddy.getRestSpace();
		Double restRate = buddy.getRestRate();
		lblRestSpaceOutput.setText(restSpace + " (" + decimalFormat.format(restRate) + "%)");
	}

	@Override
	protected void initToolTips() {
		sToolTipSpeichergroesse = ""
			+ "<html>"
			+ "Da der BuddySystem-Algorithmus immer mit Blöcken der Länge 2<sup>k</sup> arbeitet,<br/>"
			+ "wird jede Eingabe auf die nächst höherliegende 2er-Potzenzzahl gerundet.<br/>"
			+ "</<html>";
		sToolTipProzessname = ""
			+ "<html>"
			+ "Jeder Prozess hat einen inividuellen Namen."
			+ "</<html>";
		sToolTipProzessgroesse = ""
			+ "<html>"
			+ "Die Größe des Prozesses darf nicht größer sein als der größte freie Speicherbereich.<br/>"
			+ "</<html>";
		sToolTipBeispielLaden = ""
			+ "<html>"
			+ "Ein Bespielszenario, bei dem verschiedene Prozesse gestartet und gestoppt werden, wird geladen.<br/>"
			+ "</<html>";
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
			tfSpace.setText("");
			//noInput();
		} finally {
			
		}
		return process;
	}

	ActionListener actionExecute1 = new ActionListener() {
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
			updateComponents();
		}
	};
	
	ActionListener actionExecute2 = new ActionListener() {
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
								if (processSize != null) {
									buddy.startProcess(processName, processSize);								
								}
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
			updateComponents();
		}
	};
	
	ActionListener actionDemo = new ActionListener() {
		public void actionPerformed (ActionEvent e) {			
			tfSpace.setText("1024");
			buddy.setTotalSpace(1024);				
			buddy.startProcess("a", 400);			
			buddy.startProcess("b", 200);			
			buddy.startProcess("c", 100);
			buddy.startProcess("d", 50);
			buddy.stopProcess("b");			
			buddy.stopProcess("c");						
			buddy.stopProcess("a");
			buddy.startProcess("e", 50);
			buddy.stopProcess("d");
			buddy.stopProcess("e");
			updateComponents();
		}
	};
	
	private ActionListener actionProcess = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			updateComponents();
		}	
	};

	@Override
	public Integer getHeightMenu() {
		return 110;
	}
}
