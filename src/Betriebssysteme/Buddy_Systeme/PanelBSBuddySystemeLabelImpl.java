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

import Base.Labeling;
import Base.ManagementFactory;
import Base.PanelLayoutAbstract;

public class PanelBSBuddySystemeLabelImpl extends PanelLayoutAbstract {

	private static final long serialVersionUID = 1L;

	public PanelBSBuddySystemeLabelImpl() {
		super();
		this.initializeExtra();
		this.createPanel();
	}
	
	private void initializeExtra() {
		this.createComponents();
		this.createLayout();
	}
	
	private JLabel lblProcessCountLabel;	
	private JLabel lblProcessSpaceLabel;	
	private JLabel lblFreeSpaceLabel;	
	private JLabel lblRestSpaceLable;	
	private JLabel lblProcessCountOutput;
	private JLabel lblProcessSpaceOutput;	
	private JLabel lblFreeSpaceOutput;	
	private JLabel lblRestSpaceOutput;
	private JLabel lblWholeSpaceLabel;
	private JLabel lblWholeSpaceOutput;
			
	@Override
	protected void createComponents() {		
		lblProcessCountLabel = new JLabel("Anzahl der Prozesse:");
		lblProcessSpaceLabel = new JLabel(Labeling.USED_SPACE+":");
		lblFreeSpaceLabel = new JLabel(Labeling.FREE_SPACE+":");
		lblRestSpaceLable = new JLabel("Verschnitt:");
		lblWholeSpaceLabel = new JLabel(Labeling.WHOLE_SPACE+":");
		lblProcessCountOutput = new JLabel("0000");
		lblProcessSpaceOutput = new JLabel("0000");
		lblFreeSpaceOutput = new JLabel("0000");
		lblRestSpaceOutput = new JLabel("0000");		
		lblWholeSpaceOutput = new JLabel("0000");
	}
	
	@Override
	protected void createLayout() {	
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblProcessCountLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblProcessCountOutput, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblWholeSpaceLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblWholeSpaceOutput, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblProcessSpaceLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblProcessSpaceOutput, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblFreeSpaceLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblFreeSpaceOutput, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblRestSpaceLable)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblRestSpaceOutput, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWholeSpaceLabel)
						.addComponent(lblWholeSpaceOutput))
					.addPreferredGap(ComponentPlacement.RELATED)
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
					.addContainerGap(138, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	@Override
	public void updatePanel() {
		ManagementBuddyMemoryAllocation buddy = ManagementFactory.getManagementBuddyMemoryAllocation();
		
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
		
		Integer wholeSpace = buddy.getTotalSpace();
		lblWholeSpaceOutput.setText(wholeSpace.toString());		
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
