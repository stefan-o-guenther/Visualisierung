/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Base.EnumVisualizationStatus;
import Base.Labeling;
import Base.MessageBox;
import Base.PanelMenuAbstract;

public class PanelBSBelegungsstrategienMenuImpl extends PanelMenuAbstract {

	private static final long serialVersionUID = 1L;
	
	public PanelBSBelegungsstrategienMenuImpl(ManagementFragmentation fragmentation) {
		super(fragmentation);
	}
	
	private PanelBSBelegungsstrategienMenuImpl() {
		super(new ManagementFragmentationImpl());
		this.initComponents();
		this.initLayout();
	}
	
	private ManagementFragmentation fragmentation;
	private ToolTipManagerFragmentation tooltip;
	
	private JLabel lblStrategy;
	private JLabel lblSpace;
	private JLabel lblTotalSpaceLabel;
	private JLabel lblTotalSpaceOutput;
	private JLabel lblFreeSpaceLabel;
	private JLabel lblFreeSpaceOutput;
	private JLabel lblUsedSpaceLabel;
	private JLabel lblUsedSpaceOutput;
	private JLabel lblRateLabel;
	private JLabel lblRateOutput;
	private JLabel lblGeneralStorage;
	
	private JButton btnAssumeReset;
	private JButton btnSaveStepStartStop;
	private JButton btnExample;
	
	private ComboBoxStrategy cbStrategy;
	
	private JTextField tfSpace;
	private JTextField tfGeneralStorage;
	
	private void inputNumber() {
		try {
			String text = tfSpace.getText();
			Integer space = new Integer(text);
			fragmentation.inputNumber(space);	
		} catch (Exception ex) {
			tfSpace.setText("");
			MessageBox.showErrorMessage("Keine ganze Zahl eingebeben!");
		}
	}
	
	private List<Integer> getGeneralStorage() {
		List<Integer> listGeneralStorage = new ArrayList<Integer>();
		try {			
			String storage = tfGeneralStorage.getText();
			String[] arrayStorage = storage.split(",");
			for (String s : arrayStorage) {
				Integer space = new Integer(s);
				listGeneralStorage.add(space);
			}			
		} catch (Exception ex) {
			MessageBox.showErrorMessage("Hauptspeicher ist falsch");
		}	
		return listGeneralStorage;
	}
	
	@Override
	public void updatePanel() {
		lblTotalSpaceLabel.setEnabled(true);
    	lblTotalSpaceOutput.setEnabled(true);
    	lblFreeSpaceLabel.setEnabled(true);
    	lblFreeSpaceOutput.setEnabled(true);
    	lblUsedSpaceLabel.setEnabled(true);
    	lblUsedSpaceOutput.setEnabled(true);
    	lblRateLabel.setEnabled(true);
    	lblRateOutput.setEnabled(true);
    	lblStrategy.setEnabled(true);
    	lblSpace.setEnabled(true);
    	
    	EnumVisualizationStatus status = fragmentation.getStatus();    	
    	switch (status) {
	    	case START: {
	    		tfGeneralStorage.setEnabled(true);
	    		tfGeneralStorage.setEditable(true);
	    		btnExample.setEnabled(true);
	    		cbStrategy.setEnabled(true);
	        	tfSpace.setEnabled(false);
	        	tfSpace.setEditable(false);
	        	tfSpace.setText("");
	        	btnAssumeReset.setEnabled(true);
	        	btnAssumeReset.setText(Labeling.ASSUME);
	        	btnSaveStepStartStop.setEnabled(false);
	        	btnSaveStepStartStop.setText(Labeling.SAVE);	        	
	        	break;
	    	}
	    	case INPUT: {
	    		tfGeneralStorage.setEnabled(false);
	    		tfGeneralStorage.setEditable(false);
	    		btnExample.setEnabled(false);
	    		cbStrategy.setEnabled(false);
	        	tfSpace.setEnabled(true);
	        	tfSpace.setEditable(true);
	        	btnAssumeReset.setEnabled(true);
	        	btnAssumeReset.setText(Labeling.RESET);
	        	btnSaveStepStartStop.setEnabled(true);
	        	btnSaveStepStartStop.setText(Labeling.SAVE);
	        	break;
	    	}
	    	case RUN: {
	    		tfGeneralStorage.setEnabled(false);
	    		tfGeneralStorage.setEditable(false);
	    		btnExample.setEnabled(false);
	    		cbStrategy.setEnabled(false);
	        	tfSpace.setEnabled(false);
	        	tfSpace.setEditable(false);
	        	btnAssumeReset.setEnabled(true);
	        	btnAssumeReset.setText(Labeling.RESET);
	        	btnSaveStepStartStop.setEnabled(true);
	        	btnSaveStepStartStop.setText(fragmentation.getButtonAutomaticText());
	        	break;
	    	}
	    	case NEXT: {
	    		tfGeneralStorage.setEnabled(false);
	    		tfGeneralStorage.setEditable(false);
	    		btnExample.setEnabled(false);
	    		cbStrategy.setEnabled(false);
	        	tfSpace.setEnabled(false);
	        	tfSpace.setEditable(false);
	        	tfSpace.setText("");
	        	btnAssumeReset.setEnabled(true);
	        	btnAssumeReset.setText(Labeling.RESET);
	        	btnSaveStepStartStop.setEnabled(true);
	        	btnSaveStepStartStop.setText(Labeling.NEXT_STEP);
	        	break;
	    	}
	    	case FINISHED: {
	    		tfGeneralStorage.setEnabled(false);
	    		tfGeneralStorage.setEditable(false);
	    		btnExample.setEnabled(false);
	    		cbStrategy.setEnabled(false);
	        	tfSpace.setEnabled(false);
	        	tfSpace.setEditable(false);
	        	tfSpace.setText("");
	        	btnAssumeReset.setEnabled(true);
	        	btnAssumeReset.setText(Labeling.RESET);
	        	btnSaveStepStartStop.setEnabled(false);
	        	btnSaveStepStartStop.setText(Labeling.NEXT_STEP);
	        	break;
	    	}
	    	default: {
	    		break;
	    	}
    	}
    	lblTotalSpaceOutput.setText(fragmentation.getTotalSpace().toString());
    	lblFreeSpaceOutput.setText(fragmentation.getFreeSpace().toString());
    	lblUsedSpaceOutput.setText(fragmentation.getUsedSpace().toString());
    	DecimalFormat decimalFormat = new DecimalFormat("#0.00");
    	lblRateOutput.setText(decimalFormat.format(fragmentation.getUsedRate()));
	}	
	
	@Override
	protected void initComponentsMenu() {
		this.fragmentation = (ManagementFragmentation) getManagement();
		this.tooltip = (ToolTipManagerFragmentation) fragmentation.getToolTipManager();
		
		ImageIcon imgHelp = super.getImageIconHelp();
		
		lblStrategy = new JLabel(Labeling.STRATEGY+":");
		lblStrategy.setIcon(imgHelp);
		lblStrategy.setToolTipText(tooltip.getToolTipStratgy());
		
		lblSpace = new JLabel(Labeling.SPACE+":");
		lblSpace.setIcon(imgHelp);
		lblSpace.setToolTipText(tooltip.getToolTipSpeicher());
		
		lblGeneralStorage = new JLabel("Fragmentierung:");
		lblGeneralStorage.setIcon(imgHelp);
		lblGeneralStorage.setToolTipText(tooltip.getToolTipHauptspeicher());
				
		cbStrategy = new ComboBoxStrategy();
		cbStrategy.setEditable( false );
        cbStrategy.setSelectedItem("");	
		
		tfSpace = new JTextField();
		tfSpace.setColumns(10);
		tfSpace.setText("");
		
		tfGeneralStorage = new JTextField();
		tfGeneralStorage.setColumns(10);
		tfGeneralStorage.setText("");
		
		btnAssumeReset = new JButton(Labeling.RESET);		
					
		btnSaveStepStartStop = new JButton(Labeling.ASSUME);		
		
		btnExample = new JButton("Fragmentierung laden");
		
    	
    	lblTotalSpaceLabel = new JLabel(Labeling.WHOLE_SPACE+":");		
		lblTotalSpaceOutput = new JLabel("");		
		lblFreeSpaceLabel = new JLabel(Labeling.FREE_SPACE+":");		
		lblFreeSpaceOutput = new JLabel("");		
		lblUsedSpaceLabel = new JLabel(Labeling.USED_SPACE+":");		
		lblUsedSpaceOutput = new JLabel("");		
		lblRateLabel = new JLabel(Labeling.RATE+":");		
		lblRateOutput = new JLabel("");
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
							.addComponent(lblUsedSpaceLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblUsedSpaceOutput))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblFreeSpaceLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblFreeSpaceOutput))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblRateLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblRateOutput))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblSpace, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblGeneralStorage, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblStrategy))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(cbStrategy, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(tfSpace)
											.addComponent(tfGeneralStorage)))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSaveStepStartStop, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
								.addComponent(btnAssumeReset, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
								.addComponent(btnExample, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTotalSpaceLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblTotalSpaceOutput)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGeneralStorage, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfGeneralStorage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExample))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStrategy, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbStrategy, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAssumeReset))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSpace, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfSpace, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSaveStepStartStop, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
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
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRateLabel)
						.addComponent(lblRateOutput))
					.addContainerGap(128, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	@Override
	protected void initMethods() {
		ActionListener ActionSaveStartStop = new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				try {
					EnumVisualizationStatus status = fragmentation.getStatus();
					switch (status) {
						case INPUT: {
							inputNumber();
							break;
						}
						case RUN:
						case NEXT: {
							fragmentation.executeNormal();
							break;
						}
						default: {
							break;
						}
					}				
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		};		
		
		ActionListener ActionExample = new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				try {
					tfGeneralStorage.setText("10,4,20,18,7,9,12,15");				
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		};
		
		ActionListener ActionAssumeReset = new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				try {
					if (fragmentation.getStatus() == EnumVisualizationStatus.START) {
						List<Integer> listGeneralStorage = getGeneralStorage();
						if ((listGeneralStorage != null) && (listGeneralStorage.size() > 0)) {						
							// Strategie festlegen
							fragmentation.assume(cbStrategy.getStrategy(), getGeneralStorage());
						}						
					} else {
						// zurücksetzen
						fragmentation.reset();
						tfSpace.setText("");
					}
				} catch (Exception ex) {
					// nothing
				}
			}
		};
		
		btnAssumeReset.addActionListener(ActionAssumeReset);
		btnSaveStepStartStop.addActionListener(ActionSaveStartStop);
		btnExample.addActionListener(ActionExample);
	}
	
	@Override
	public Integer getPanelHeight() {
		return 200;
	}	

	@Override
	public Integer getPanelWidth() {
		return 460;
	}	
}
