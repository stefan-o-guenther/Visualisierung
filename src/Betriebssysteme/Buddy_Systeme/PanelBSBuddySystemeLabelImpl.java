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

import Base.ManagementTestImpl;
import Base.PanelInitAbstract;

public class PanelBSBuddySystemeLabelImpl extends PanelInitAbstract {

	private static final long serialVersionUID = 1L;

	public PanelBSBuddySystemeLabelImpl(ManagementBuddyMemoryAllocation buddy) {
		super(buddy);
	}
	
	private PanelBSBuddySystemeLabelImpl() {
		super(new ManagementTestImpl());
		this.initComponents();
		this.initLayout();
	}
		
	private ManagementBuddyMemoryAllocation buddy;
	private JLabel lblProcessCountLabel;	
	private JLabel lblProcessSpaceLabel;	
	private JLabel lblFreeSpaceLabel;	
	private JLabel lblRestSpaceLable;	
	private JLabel lblProcessCountOutput;
	private JLabel lblProcessSpaceOutput;	
	private JLabel lblFreeSpaceOutput;	
	private JLabel lblRestSpaceOutput;
			
	@Override
	protected void initComponents() {
		buddy = (ManagementBuddyMemoryAllocation) this.getManagement();	
		
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
							.addComponent(lblRestSpaceLable)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblRestSpaceOutput, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblProcessSpaceLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblProcessSpaceOutput, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblProcessCountLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblProcessCountOutput, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblFreeSpaceLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblFreeSpaceOutput, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)))
					.addContainerGap())
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
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
	public Integer getPanelHeight() {
		return 110;
	}

	@Override
	public Integer getPanelWidth() {
		return 200;
	}
}
