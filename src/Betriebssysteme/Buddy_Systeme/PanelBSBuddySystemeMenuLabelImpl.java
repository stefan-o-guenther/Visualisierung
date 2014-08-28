/**
 * @author:	Stefan Otto Günther
 * @date:	01.07.2014
 */

package Betriebssysteme.Buddy_Systeme;

import java.text.DecimalFormat;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelBSBuddySystemeMenuLabelImpl extends PanelBSBuddySystemeMenuAbstract {

	public PanelBSBuddySystemeMenuLabelImpl(ManagementBuddyMemoryAllocation buddy, ToolTipManagerBuddyMemoryAllocation tooltip) {
		super(buddy, tooltip);
	}
	
	private PanelBSBuddySystemeMenuLabelImpl() {
		super(new ManagementBuddyMemoryAllocationImpl(), new ToolTipManagerBuddyMemoryAllocationImpl());
		this.initComponents();
		this.initLayout();
	}
		
	private ManagementBuddyMemoryAllocation buddy;
	private ToolTipManagerBuddyMemoryAllocation tooltip;
	private JLabel lblProcessCountLabel;	
	private JLabel lblProcessSpaceLabel;	
	private JLabel lblFreeSpaceLabel;	
	private JLabel lblRestSpaceLable;	
	private JLabel lblProcessCountOutput;
	private JLabel lblProcessSpaceOutput;	
	private JLabel lblFreeSpaceOutput;	
	private JLabel lblRestSpaceOutput;
	
	private ButtonGroupProcessImpl groupProcess;
	
	@Override
	protected void initComponentsMenu() {
		buddy = (ManagementBuddyMemoryAllocation) this.getManagement();
		tooltip = (ToolTipManagerBuddyMemoryAllocation) this.getToolTipManager();
		
		//ImageIcon imgHelp = this.getImageIconHelp();
		
		lblProcessCountLabel = new JLabel("Anzahl der Prozesse:");
		lblProcessSpaceLabel = new JLabel("Belegter Speicherplatz:");
		lblFreeSpaceLabel = new JLabel("Freier Speicherplatz:");
		lblRestSpaceLable = new JLabel("Verschnitt:");
		lblProcessCountOutput = new JLabel("0000");
		lblProcessSpaceOutput = new JLabel("0000");
		lblFreeSpaceOutput = new JLabel("0000");
		lblRestSpaceOutput = new JLabel("0000");
	}
	
	@Override
	protected void initLayout() {		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblProcessSpaceLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(lblRestSpaceLable)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblRestSpaceOutput)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblProcessSpaceOutput))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblProcessCountLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblProcessCountOutput))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblFreeSpaceLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblFreeSpaceOutput)))
					.addGap(29))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProcessCountLabel)
						.addComponent(lblProcessCountOutput))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProcessSpaceLabel)
						.addComponent(lblProcessSpaceOutput))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFreeSpaceLabel)
						.addComponent(lblFreeSpaceOutput))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRestSpaceLable)
						.addComponent(lblRestSpaceOutput))
					.addContainerGap(306, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	@Override
	public void updatePanel() {		
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
	public Integer getHeightMenu() {
		return 110;
	}

	@Override
	protected void initMethods() {
		// nothing
	}
}
