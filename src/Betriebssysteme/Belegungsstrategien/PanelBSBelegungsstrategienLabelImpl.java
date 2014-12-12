package Betriebssysteme.Belegungsstrategien;

import java.text.DecimalFormat;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import Base.Labeling;
import Base.ManagementFactory;
import Base.PanelLayoutAbstract;

public class PanelBSBelegungsstrategienLabelImpl extends PanelLayoutAbstract {

	private static final long serialVersionUID = 1L;

	public PanelBSBelegungsstrategienLabelImpl() {
		super();
		//this.initializeExtra();
		this.createPanel();
	}
	
	private void initializeExtra() {
		this.createComponents();
		this.createLayout();
	}

	private JLabel lblTotalSpaceLabel;
	private JLabel lblTotalSpaceOutput;
	private JLabel lblFreeSpaceLabel;
	private JLabel lblFreeSpaceOutput;
	private JLabel lblUsedSpaceLabel;
	private JLabel lblUsedSpaceOutput;
	

	@Override
	protected void createComponents() {		
		lblTotalSpaceLabel = new JLabel(Labeling.WHOLE_SPACE+":");		
		lblTotalSpaceOutput = new JLabel("");		
		lblFreeSpaceLabel = new JLabel(Labeling.FREE_SPACE+":");		
		lblFreeSpaceOutput = new JLabel("");		
		lblUsedSpaceLabel = new JLabel(Labeling.USED_SPACE+":");		
		lblUsedSpaceOutput = new JLabel("");
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
							.addComponent(lblTotalSpaceLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblTotalSpaceOutput))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblFreeSpaceLabel)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblFreeSpaceOutput, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addComponent(lblUsedSpaceLabel)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblUsedSpaceOutput))))
					.addContainerGap(408, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTotalSpaceLabel)
						.addComponent(lblTotalSpaceOutput))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFreeSpaceLabel)
						.addComponent(lblFreeSpaceOutput))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsedSpaceLabel)
						.addComponent(lblUsedSpaceOutput))
					.addContainerGap(343, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	@Override
	public void updatePanel() {
		ManagementFragmentation fragmentation = ManagementFactory.getManagementFragmentation();
		
		DecimalFormat decimalFormat = new DecimalFormat("#0.00");
		
		Integer totalSpace = fragmentation.getTotalSpace();
		Integer freeSpace = fragmentation.getFreeSpace();
		Integer usedSpace = fragmentation.getUsedSpace();
		
		String freeSpaceRate = decimalFormat.format(fragmentation.getFreeSpaceRate());
		String usedSpaceRate = decimalFormat.format(fragmentation.getUsedSpaceRate());
		
		lblTotalSpaceOutput.setText(totalSpace.toString());
    	lblFreeSpaceOutput.setText(freeSpace.toString() + " (" + freeSpaceRate + "%)");
    	lblUsedSpaceOutput.setText(usedSpace.toString() + " (" + usedSpaceRate + "%)");
	}

	@Override
	public Integer getPanelHeight() {
		return 70;
	}

	@Override
	public Integer getPanelWidth() {
		return 200;
	}
}
