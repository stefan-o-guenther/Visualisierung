/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Base.Labeling;
import Base.MessageBox;
import Base.PanelMenuAutomaticMenuAbstract;

public class PanelBSBelegungsstrategienMenuAutomaticMenuImpl extends PanelMenuAutomaticMenuAbstract {

	public PanelBSBelegungsstrategienMenuAutomaticMenuImpl(ManagementFragmentation fragmentation, ToolTipManagerFragmentation tooltip) {
		super(fragmentation, tooltip);
		this.initPanel();
	}
	
	private PanelBSBelegungsstrategienMenuAutomaticMenuImpl() {
		super(new ManagementFragmentationImpl(), new ToolTipManagerFragmentationImpl());
		this.initComponents();
		this.initLayout();
	}
	
	private static final long serialVersionUID = 1L;
	
	private ManagementFragmentation fragmentation;
	private ToolTipManagerFragmentation tooltip;
	
	private JLabel lblStrategie;
	private JLabel lblSpeicher;
	private JLabel lblTotalSpaceLabel;
	private JLabel lblTotalSpaceOutput;
	private JLabel lblFreeSpaceLabel;
	private JLabel lblFreeSpaceOutput;
	private JLabel lblUsedSpaceLabel;
	private JLabel lblUsedSpaceOutput;
	private JLabel lblRateLabel;
	private JLabel lblRateOutput;
	
	private JButton btnExecute1;
	private JButton btnExecute2;
	
	private ComboBoxStrategy cbStrategie;
	
	private JTextField tSpeicher;
	
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
    	lblStrategie.setEnabled(true);
    	lblSpeicher.setEnabled(true);
    	
    	EnumMemoryStatus status = fragmentation.getStatus();    	
    	switch (status) {
	    	case START: {
	    		cbStrategie.setEnabled(true);
	        	tSpeicher.setEnabled(false);
	        	tSpeicher.setEditable(false);
	        	tSpeicher.setText("");
	        	btnExecute1.setEnabled(true);
	        	btnExecute1.setText(Labeling.ASSUME);
	        	btnExecute2.setEnabled(false);
	        	btnExecute2.setText(Labeling.SAVE);
	        	fragmentation.setAutomaticChecked(false);
	    		break;
	    	}
	    	case INPUT: {
	    		cbStrategie.setEnabled(false);
	        	tSpeicher.setEnabled(true);
	        	tSpeicher.setEditable(true);
	        	btnExecute1.setEnabled(true);
	        	btnExecute1.setText(Labeling.RESET);
	        	btnExecute2.setEnabled(true);
	        	btnExecute2.setText(Labeling.SAVE);
	        	fragmentation.setAutomaticChecked(false);
	    		break;
	    	}
	    	case SEARCH:
	    	case CHOOSE: {
	    		cbStrategie.setEnabled(false);
	        	tSpeicher.setEnabled(false);
	        	tSpeicher.setEditable(false);
	        	btnExecute1.setEnabled(true);
	        	btnExecute1.setText(Labeling.RESET);
	        	btnExecute2.setEnabled(true);
	        	btnExecute2.setText(fragmentation.getButtonAutomaticText());
	        	break;
	    	}
	    	case FINISHED: {
	    		cbStrategie.setEnabled(false);
	        	tSpeicher.setEnabled(false);
	        	tSpeicher.setEditable(false);
	        	tSpeicher.setText("");
	        	btnExecute1.setEnabled(true);
	        	btnExecute1.setText(Labeling.RESET);
	        	btnExecute2.setEnabled(!(fragmentation.isAutomaticChecked()));
	        	btnExecute2.setText(Labeling.NEXT_STEP);
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
	protected void initComponents() {
		this.fragmentation = (ManagementFragmentation) getManagement();
		this.tooltip = (ToolTipManagerFragmentation) getToolTipManager();
		
		ImageIcon imgHelp = super.getImageIconHelp();
		
		lblStrategie = new JLabel(Labeling.STRATEGY+":");
		lblStrategie.setIcon(imgHelp);
		lblStrategie.setToolTipText(tooltip.getToolTipStratgy());
		
		lblSpeicher = new JLabel(Labeling.SPACE+":");
		lblSpeicher.setIcon(imgHelp);
		lblSpeicher.setToolTipText(tooltip.getToolTipSpeicher());
		
		cbStrategie = new ComboBoxStrategy();
		cbStrategie.setEditable( false );
        cbStrategie.setSelectedItem("");	
		
		tSpeicher = new JTextField();
		tSpeicher.setColumns(10);
		tSpeicher.setText("");
		
		btnExecute1 = new JButton(Labeling.RESET);
		btnExecute1.addActionListener(ActionExecute1);
					
		btnExecute2 = new JButton(Labeling.ASSUME);
		btnExecute2.addActionListener(ActionExecute2);
    	
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
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblUsedSpaceLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblUsedSpaceOutput))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblFreeSpaceLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblFreeSpaceOutput))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblRateLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblRateOutput))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblSpeicher)
										.addComponent(lblStrategie))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(tSpeicher)
										.addComponent(cbStrategie, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnExecute2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnExecute1, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)))
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
						.addComponent(lblStrategie)
						.addComponent(cbStrategie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExecute1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSpeicher)
						.addComponent(tSpeicher, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExecute2))
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
					.addContainerGap(157, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	@Override
	public Integer getHeightMenu() {
		return 160;
	}	

	@Override
	public Integer getLengthMenu() {
		return 420;
	}
	
	private ActionListener ActionExecute1 = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			try {
				if (fragmentation.getStatus() == EnumMemoryStatus.START) {
					// Strategie festlegen
					fragmentation.setStrategy(cbStrategie.getStrategy());		
				} else {
					// zurücksetzen
					fragmentation.stopAutomatic();
					fragmentation.reset();
					tSpeicher.setText("");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	};
	
	private void inputNumber() {
		try {
			String text = tSpeicher.getText();
			Integer space = new Integer(text);
			fragmentation.inputNumber(space);	
		} catch (Exception ex) {
			tSpeicher.setText("");
			MessageBox.showErrorMessage("Keine ganze Zahl eingebeben!");
		}
	}
	
	private ActionListener ActionExecute2 = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			try {
				EnumMemoryStatus status = fragmentation.getStatus();
				switch (status) {
					case INPUT: {
						inputNumber();
						break;
					}
					case SEARCH:
					case CHOOSE:
					case FINISHED: {
						if (!(executeManualAutomatic())) {
							fragmentation.showErrorMessage();
						}
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
}
