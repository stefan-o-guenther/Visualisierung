/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Base.EnumVisualizationStatus;
import Base.Labeling;
import Base.MessageBox;
import Base.PanelMenuButtonsAbstract;

public class PanelBSBuddySystemeMenuImpl extends PanelMenuButtonsAbstract {

	private static final long serialVersionUID = 1L;

	public PanelBSBuddySystemeMenuImpl(ManagementBuddyMemoryAllocation buddy) {
		super(buddy);
	}

	private PanelBSBuddySystemeMenuImpl() {
		super(new ManagementBuddyMemoryAllocationImpl());
		this.initButtons();
		this.initComponentsMenuButtons();
		this.rdbtnProcessStart = new JRadioButton("start");
		this.rdbtnProcessStop = new JRadioButton("stop");
		this.initLayout();
	}
	
	private void initButtons() {
		this.btnAssumeSaveExecute = new JButton(this.getBtnExecuteText());
		this.btnExampleReset = new JButton(this.getBtnExampleText());
	}
	
	private ManagementBuddyMemoryAllocation buddy;
	private ToolTipManagerBuddyMemoryAllocation tooltip;
	
	private JTextField tfSpace;
	private JTextField tfProcessName;
	private JTextField tfProcessSize;
	
	private JRadioButton rdbtnProcessStart;
	private JRadioButton rdbtnProcessStop;
	
	private JLabel lblSpace;
	private JLabel lblProcessName;
	private JLabel lblProcessSize;
	
	//private JButton btnAssumeSaveExecute;	
	//private JButton btnExampleReset;
	
	private ButtonGroupProcessImpl groupProcess;
	
	@Override
	protected void initComponentsMenuButtons() {
		buddy = (ManagementBuddyMemoryAllocation) this.getManagement();
		tooltip = (ToolTipManagerBuddyMemoryAllocation) buddy.getToolTipManager();
		
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
		
		groupProcess = new ButtonGroupProcessImpl(buddy);	
		rdbtnProcessStart = groupProcess.getRadioButtonStart();
		rdbtnProcessStop = groupProcess.getRadioButtonStop();	
		
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
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnAssumeSaveExecute, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblProcessName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblSpace, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(tfProcessName, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
										.addComponent(tfSpace, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)))
								.addComponent(rdbtnProcessStart, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(btnExampleReset, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblProcessSize)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(tfProcessSize, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)))
								.addComponent(rdbtnProcessStop, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(329, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSpace)
						.addComponent(tfSpace, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExampleReset))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProcessSize)
						.addComponent(tfProcessSize, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblProcessName)
						.addComponent(tfProcessName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnProcessStart)
						.addComponent(rdbtnProcessStop))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAssumeSaveExecute)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	@Override
	public void updatePanelMenuButtons() {		
		lblSpace.setEnabled(true);
		lblProcessName.setEnabled(true);
		lblProcessSize.setEnabled(true);
		
		if (buddy != null) {
			EnumVisualizationStatus status = buddy.getStatus();			
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
					break;					
				}
				case RUN: {					
					tfSpace.setEnabled(false);
					tfSpace.setEditable(false);
					tfProcessName.setEnabled(true);
					tfProcessName.setEditable(true);
					tfProcessSize.setEnabled(rdbtnProcessStart.isSelected());
					tfProcessSize.setEditable(rdbtnProcessStart.isSelected());
					rdbtnProcessStart.setEnabled(true);	
					rdbtnProcessStop.setEnabled(true);									
					break;
				}
				default: {
					break;
				}
			}					
		}
	}

	@Override
	protected void initMethodsMenuButtons() {
		
	}	
	
	private void executeTotalSpaceReset() {
		EnumVisualizationStatus status = buddy.getStatus();
		switch (status) {
			case START: {
				inputTotalSpace();
				break;
			}
			case RUN: {
				buddy.reset();
				break;
			}
			default: {
				break;
			}
		}
	}	
	
	private void automaticStartProcess(String name, Integer size) {
		try {
			if ((name == null) || (size == null)) {
				throw new NullPointerException();
			}
			if ((name.length() == 0) || (size.intValue() < 0)) {
				throw new IllegalArgumentException();
			}
			if (buddy.getStatus() == EnumVisualizationStatus.RUN) {
				this.groupProcess.selectRadioButtonStart();
				this.tfProcessName.setText(name);
				this.tfProcessSize.setText(size.toString());
				this.execute();
			}
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	private void automaticStopProcess(String name) {
		try {			
			if (name == null) {
				throw new NullPointerException();
			}
			if (name.length() == 0) {
				throw new IllegalArgumentException();
			}
			if (buddy.getStatus() == EnumVisualizationStatus.RUN) {
				this.groupProcess.selectRadioButtonStop();
				this.tfProcessName.setText(name);
				this.execute();
			}
			
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	private void automaticTotalSpace(Integer size) {
		try {
			if (size == null) {
				throw new NullPointerException();
			}
			if (size.intValue() < 0) {
				throw new IllegalArgumentException();
			}
			if (buddy.getStatus() == EnumVisualizationStatus.START) {
				this.tfSpace.setText(size.toString());
				this.executeTotalSpaceReset();
			}
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	private Integer inputProcessSize() {
		// Eingabe					
		try {
			Integer process = null;
			String text = tfProcessSize.getText();
			if (text.length() == 0) {
				throw new IllegalArgumentException();
			}
			process = new Integer(text);
			return process;
		} catch (Exception ex) {
			throw ex;
		}	
	}
	
	@Override
	protected void executeExtra() {
		try {
			String processName = tfProcessName.getText();
			if (processName.length() == 0) {
				throw new IllegalArgumentException();
			}
			buddy.setProcessName(processName);
			if (buddy.getProcessOperation() == EnumProcess.PROCESS_START) {
				Integer processSize = inputProcessSize();
				buddy.setProcessSize(processSize);
			}
			clearFields();
		} catch (Exception ex) {
			MessageBox.showErrorMessage("falsche Eingabe");
		}		
	}

	@Override
	public Integer getPanelHeight() {
		return 140;
	}

	@Override
	public Integer getPanelWidth() {
		return 360;
	}
	
	@Override
	protected String getBtnExecuteText() {
		return groupProcess.getSelectedButtonString();
	}

	@Override
	protected void loadExample() {
		automaticTotalSpace(1024);			
		automaticStartProcess("a", 400);			
		automaticStartProcess("b", 200);
		automaticStartProcess("c", 70);
		automaticStopProcess("c");
		automaticStartProcess("d", 100);
		automaticStartProcess("e", 50);
		automaticStopProcess("b");			
		automaticStopProcess("d");						
		automaticStopProcess("a");
		automaticStartProcess("f", 50);
		automaticStopProcess("e");
		automaticStopProcess("f");
		groupProcess.selectRadioButtonStart();
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

	@Override
	protected void assume() {
		inputTotalSpace();
	}

	@Override
	protected void input() {
		
	}

	@Override
	protected void clearFields() {
		tfProcessName.setText("");
		tfProcessSize.setText("");
	}

	@Override
	protected Boolean hasExample() {
		return true;
	}
}
