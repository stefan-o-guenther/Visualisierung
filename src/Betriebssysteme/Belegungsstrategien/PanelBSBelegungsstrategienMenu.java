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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Base.BasePanelMenuAutomatic;
import Base.PanelAutomatic;

public class PanelBSBelegungsstrategienMenu extends BasePanelMenuAutomatic {

	public PanelBSBelegungsstrategienMenu(IFragmentation fragmentation) {
		super(fragmentation);
		this.fragmentation = fragmentation;
		initComponents();
		updateComponents();
	}
	
	private static final long serialVersionUID = 1L;
	
	private IFragmentation fragmentation;
	
	private PanelAutomatic panelAutomatic;
		
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
	
	protected void noInput() {
		Object[] option = {"schlie\u00dfen"};
		JOptionPane.showOptionDialog(null,
				"Keine ganze Zahl eingebeben!",
			    "Fehler",
			    JOptionPane.ERROR_MESSAGE,
			    JOptionPane.ERROR_MESSAGE,
			    null,
			    option,
			    option[0]);
	}
	
	
	protected void foundSpace(Boolean value) {
		if (!(value)) {
			error();
		}
	}
	
	@Override
	public void updateComponents() {
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
	        	btnExecute1.setText("\u00fcbernehmen");
	        	btnExecute2.setEnabled(false);
	        	btnExecute2.setText("speichern");
	        	fragmentation.setAutomaticChecked(false);
	        	panelAutomatic.setAutomaticEnabled(false);
	    		break;
	    	}
	    	case INPUT: {
	    		cbStrategie.setEnabled(false);
	        	tSpeicher.setEnabled(true);
	        	tSpeicher.setEditable(true);
	        	btnExecute1.setEnabled(true);
	        	btnExecute1.setText("zur\u00fccksetzen");
	        	btnExecute2.setEnabled(true);
	        	btnExecute2.setText("speichern");
	        	fragmentation.setAutomaticChecked(false);
	        	panelAutomatic.setAutomaticEnabled(false);
	    		break;
	    	}
	    	case SEARCH:
	    	case CHOOSE: {
	    		cbStrategie.setEnabled(false);
	        	tSpeicher.setEnabled(false);
	        	tSpeicher.setEditable(false);
	        	btnExecute1.setEnabled(true);
	        	btnExecute1.setText("zur\u00fccksetzen");
	        	btnExecute2.setEnabled(true);
	        	if (fragmentation.isAutomaticRunning()) {
	        		btnExecute2.setText("stop");
	        	} else {
	        		btnExecute2.setText("weiter");
	        	}
	        	panelAutomatic.setAutomaticEnabled(true);
	        	break;
	    	}
	    	case FINISHED: {
	    		cbStrategie.setEnabled(false);
	        	tSpeicher.setEnabled(false);
	        	tSpeicher.setEditable(false);
	        	tSpeicher.setText("");
	        	btnExecute1.setEnabled(true);
	        	btnExecute1.setText("zur\u00fccksetzen");
	        	btnExecute2.setEnabled(!(fragmentation.isAutomaticChecked()));
	        	btnExecute2.setText("weiter");
	        	panelAutomatic.setAutomaticEnabled(false);
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
	public void initComponents() {		
		ImageIcon imgHelp = super.getImageIconHelp();
		
		lblStrategie = new JLabel("Strategie:");
		lblStrategie.setIcon(imgHelp);
		lblStrategie.setToolTipText(ToolTipManager.getToolTipStratgy());
		
		lblSpeicher = new JLabel("Speicher:");
		lblSpeicher.setIcon(imgHelp);
		lblSpeicher.setToolTipText(ToolTipManager.getToolTipSpeicher());
		
		cbStrategie = new ComboBoxStrategy();
		cbStrategie.setEditable( false );
        cbStrategie.setSelectedItem("");	
		
		tSpeicher = new JTextField();
		tSpeicher.setColumns(10);
		tSpeicher.setText("");
		
		btnExecute1 = new JButton("zur\u00fccksetzen");
		btnExecute1.addActionListener(ActionExecute1);
					
		btnExecute2 = new JButton("\u00fcbernehmen");
		btnExecute2.addActionListener(ActionExecute2);
    	
    	lblTotalSpaceLabel = new JLabel("Gesammter Speicherplatz:");		
		lblTotalSpaceOutput = new JLabel("");		
		lblFreeSpaceLabel = new JLabel("Freier Speicherplatz:");		
		lblFreeSpaceOutput = new JLabel("");		
		lblUsedSpaceLabel = new JLabel("Belegter Speicherplatz:");		
		lblUsedSpaceOutput = new JLabel("");		
		lblRateLabel = new JLabel("Belegter Speicherplatz in %:");		
		lblRateOutput = new JLabel("");
		
		panelAutomatic = new PanelAutomatic(fragmentation, this, this.getBackground());
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
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
										.addComponent(cbStrategie, 0, 106, Short.MAX_VALUE))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnExecute2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnExecute1, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTotalSpaceLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblTotalSpaceOutput)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelAutomatic, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
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
					.addContainerGap(12, Short.MAX_VALUE))
				.addComponent(panelAutomatic, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
		);
		setLayout(groupLayout);
	}	
	
	@Override
	public Integer getHeightMenu() {
		return 160;
	}
		
	private ActionListener ActionExecute1 = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			try {
				if (fragmentation.getStatus() == EnumMemoryStatus.START) {
					// Strategie festlegen
					fragmentation.setStrategy(cbStrategie.getStrategy());		
				} else {
					// zurücksetzen
					panelAutomatic.stopAutomatic();
					fragmentation.reset();
					tSpeicher.setText("");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			updateComponents();
		}
	};
	
	private void input() {
		// Eingabe
		String text = tSpeicher.getText();			
		try {
			Integer space = new Integer(text);
			fragmentation.setNumber(space);	
		} catch (Exception ex) {
			tSpeicher.setText("");
			noInput();
		} finally {
			
		}
		updateComponents();
	}
	
	private void search() {
		// Suche
		if (fragmentation.isAutomaticChecked()) {
			panelAutomatic.switchAutomatic();
		} else {
			foundSpace(fragmentation.execute());
		}
		updateComponents();
	}	
	
	private ActionListener ActionExecute2 = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			try {
				EnumMemoryStatus status = fragmentation.getStatus();
				switch (status) {
					case INPUT: {
						input();
						break;
					}
					case SEARCH:
					case CHOOSE:
					case FINISHED: {
						search();
						break;
					}
					default: {
						break;
					}
				}				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			updateComponents();
		}
	};	
	
	@Override
	public void updateMenu() {
		updateComponents();
	}

	@Override
	public void error() {
		Object[] option = {"schlie\u00dfen"};
		JOptionPane.showOptionDialog(null,
				"Keinen passenden freien Speicher gefunden!",
			    "Fehler",
			    JOptionPane.ERROR_MESSAGE,
			    JOptionPane.ERROR_MESSAGE,
			    null,
			    option,
			    option[0]);
	}
}
