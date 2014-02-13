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
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Base.BasePanelMenu;
import Base.ImageLoader;

public class PanelBSBelegungsstrategienMenu extends BasePanelMenu {

	public PanelBSBelegungsstrategienMenu(IMemoryManagement imemory) {
		super();
		if (imemory == null) {
			imemory = new MemoryManagement();
		}
		memory = imemory;
		initComponents();
		updateComponents();
	}
	
	private static final long serialVersionUID = 1L;
	private String sToolTipStrategie = "";
	private String sToolTipSpeed = "";
	private String sToolTipSpeicher = "";
		
	private IMemoryManagement memory;
		
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
	private JLabel lblRabbit;
	private JLabel lblTurtle;
	private JLabel lblSpeedTip;
	
	private JButton btnExecute1;
	private JButton btnExecute2;
	
	private ComboBoxStrategy cbStrategie;
	
	private JTextField tSpeicher;
	
	private JCheckBox chcxbxAuto;
	
	private JSlider sSpeed;
	
	private AutoThread tAuto; //= new AutoThread();
	private Boolean isAutomaticChecked = false;
	private Boolean isAutomaticRunning = false;	
	private Integer speed = 0;
	
	private void noInput() {
		Object[] option = {"schließen"};
		JOptionPane.showOptionDialog(null,
				"Keine ganze Zahl eingebeben!",
			    "Fehler",
			    JOptionPane.ERROR_MESSAGE,
			    JOptionPane.ERROR_MESSAGE,
			    null,
			    option,
			    option[0]);
	}
	
	
	private void foundSpace(Boolean value) {
		if (!(value)) {
			Object[] option = {"schließen"};
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
	
	private void setSpeed() {		
		speed = 2500 - (sSpeed.getValue() * 20);
	}
	
	private void startAutomatic() {
		if ((!(isAutomaticRunning)) && (isAutomaticChecked)) {
			isAutomaticRunning = true;
			tAuto = new AutoThread();
			tAuto.start();
		}
	}

	private void stopAutomatic() {
		if (isAutomaticRunning) {
			isAutomaticRunning = false;
			isAutomaticChecked = false;
		}
	}
	
	protected void initToolTips() {
		sToolTipStrategie = ""
			+ "<html>"
	    	+ "<h3>First-Fit:</h3>"
	    	+ "Wähle den ersten Speicherblock, der ausreichend<br>"
	    	+ "groß ist.<br>"
	    	+ "<br>"
	    	+ "<h3>Next-Fit:</h3>"
	    	+ "Dasselbe Prinzip wie bei First-Fit, nur wird hier<br>"
	    	+ "die Suche nicht wieder von vorn begonnen,<br>"
	    	+ "sondern beim letzten Treffer fortgesetzt.<br>"
	    	+ "<br>"
	    	+ "<h3>Best-Fit:</h3>"
	    	+ "Es wird der Speicherblock gewählt, bei dem am<br>"
	    	+ "wenigsten Rest bzw. Verschnitt übrig bleibt.<br>"
	    	+ "<br>"
	    	+ "<h3>Worst-Fit:</h3>"
	    	+ "Genau das Gegenteil von Best-Fit. Es wird der<br>"
	    	+ "Speicherblock gewählt, bei dem am meisten Rest<br>"
	    	+ "bzw. Verschnitt übrig bleibt.<br><br>"
	    	+ "</html>";
			
		sToolTipSpeed = ""
			+ "<html>"
        	+ "Mit diesem Geschwindigkeitsregeler können Sie einstellen,<br>"
        	+ "wie schnell der Auto-Durchlauf ausgeführt werden soll.<br>"
        	+ "Standardmäßig ist die Geschwindigkeit auf 50% eingestellt.<br>"
        	+ "</html>";
	        
	    sToolTipSpeicher = "ganze Zahl, die größer als Null ist, eintragen";
	}
	
	@Override
	protected void updateComponents() {
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
    	lblSpeedTip.setEnabled(true);
    	    	
    	
    	
    	EnumMemoryStatus status = memory.getStatus();    	
    	switch (status) {
	    	case START: {
	    		cbStrategie.setEnabled(true);
	        	tSpeicher.setEnabled(false);
	        	tSpeicher.setEditable(false);
	        	tSpeicher.setText("");
	        	btnExecute1.setEnabled(true);
	        	btnExecute1.setText("übernehmen");
	        	btnExecute2.setEnabled(false);
	        	btnExecute2.setText("speichern");
	        	chcxbxAuto.setEnabled(false);
	        	isAutomaticChecked = false;
	    		break;
	    	}
	    	case INPUT: {
	    		cbStrategie.setEnabled(false);
	        	tSpeicher.setEnabled(true);
	        	tSpeicher.setEditable(true);
	        	btnExecute1.setEnabled(true);
	        	btnExecute1.setText("zurücksetzen");
	        	btnExecute2.setEnabled(true);
	        	btnExecute2.setText("speichern");
	        	chcxbxAuto.setEnabled(false);
	        	isAutomaticChecked = false;
	    		break;
	    	}
	    	case SEARCH:
	    	case CHOOSE: {
	    		cbStrategie.setEnabled(false);
	        	tSpeicher.setEnabled(false);
	        	tSpeicher.setEditable(false);
	        	btnExecute1.setEnabled(true);
	        	btnExecute1.setText("zurücksetzen");
	        	btnExecute2.setEnabled(true);
	        	if (isAutomaticRunning) {
	        		btnExecute2.setText("stop");
	        	} else {
	        		btnExecute2.setText("weiter");
	        	}        	
	        	chcxbxAuto.setEnabled(true);   
	    		break;
	    	}
	    	case FINISHED: {
	    		cbStrategie.setEnabled(false);
	        	tSpeicher.setEnabled(false);
	        	tSpeicher.setEditable(false);
	        	tSpeicher.setText("");
	        	btnExecute1.setEnabled(true);
	        	btnExecute1.setText("zurücksetzen");
	        	btnExecute2.setEnabled(!(isAutomaticChecked));
	        	btnExecute2.setText("weiter");
	        	chcxbxAuto.setEnabled(false);  
	    	}
	    	default: {
	    		break;
	    	}
    	}    	
    	chcxbxAuto.setSelected(isAutomaticChecked);
    	lblTotalSpaceOutput.setText(memory.getTotalSpace().toString());
    	lblFreeSpaceOutput.setText(memory.getFreeSpace().toString());
    	lblUsedSpaceOutput.setText(memory.getUsedSpace().toString());
    	DecimalFormat decimalFormat = new DecimalFormat("#0.00"); 
    	lblRateOutput.setText(decimalFormat.format(memory.getUsedRate()));
    	sSpeed.setEnabled(isAutomaticChecked);
	}	
	
	@Override
	protected void initComponents() {		
		initToolTips();
		
		ImageIcon imgHelp = super.getImageIconHelp();
		ImageIcon imgRabbit = ImageLoader.getImageIconRabbit();
		ImageIcon imgTurtle = ImageLoader.getImageIconTurtle();		
		
		lblStrategie = new JLabel("Strategie:");
		lblStrategie.setIcon(imgHelp);
		lblStrategie.setToolTipText(sToolTipStrategie);
		
		lblSpeicher = new JLabel("Speicher:");
		lblSpeicher.setIcon(imgHelp);
		lblSpeicher.setToolTipText(sToolTipSpeicher);
		
		cbStrategie = new ComboBoxStrategy();
		cbStrategie.setEditable( false );
        cbStrategie.setSelectedItem("");	
		
		tSpeicher = new JTextField();
		tSpeicher.setColumns(10);
		tSpeicher.setText("");
		
		btnExecute1 = new JButton("zurücksetzen");
		btnExecute1.addActionListener(ActionExecute1);
					
		btnExecute2 = new JButton("übernehmen");
		btnExecute2.addActionListener(ActionExecute2);
		
		chcxbxAuto = new JCheckBox("Automatischer Durchlauf");
		chcxbxAuto.addActionListener(ActionAuto);
		chcxbxAuto.setSelected(isAutomaticChecked);
		
		lblSpeedTip = new JLabel(" ");
		lblSpeedTip.setIcon(imgHelp);
		lblSpeedTip.setToolTipText(sToolTipSpeed);
		
		sSpeed = new JSlider( 0, 100, 50 );
    	sSpeed.setPaintTicks( true );
    	sSpeed.setMinorTickSpacing(10); //Abstände im Feinraster
    	sSpeed.setMajorTickSpacing(20); //Abstände im Großraster
    	sSpeed.setSnapToTicks(true);
    	sSpeed.setPaintLabels(false);
    	sSpeed.addChangeListener(ChangeSpeed);
    	
    	setSpeed();
		
		lblTotalSpaceLabel = new JLabel("Gesammter Speicherplatz:");		
		lblTotalSpaceOutput = new JLabel("");		
		lblFreeSpaceLabel = new JLabel("Freier Speicherplatz:");		
		lblFreeSpaceOutput = new JLabel("");		
		lblUsedSpaceLabel = new JLabel("Belegter Speicherplatz:");		
		lblUsedSpaceOutput = new JLabel("");		
		lblRateLabel = new JLabel("Belegter Speicherplatz in %:");		
		lblRateOutput = new JLabel("");		
		lblTurtle = new JLabel(" ");
		lblTurtle.setIcon(imgTurtle);		
		lblRabbit = new JLabel(" ");
		lblRabbit.setIcon(imgRabbit);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblUsedSpaceLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblUsedSpaceOutput, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
							.addGap(786))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblFreeSpaceLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblFreeSpaceOutput)
							.addContainerGap(874, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
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
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(7)
									.addComponent(lblTurtle))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(lblSpeedTip)
									.addGap(4)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(sSpeed, GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
										.addComponent(chcxbxAuto))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblRabbit)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblStrategie)
							.addComponent(cbStrategie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnExecute1))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(chcxbxAuto)
							.addComponent(lblSpeedTip)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblTurtle)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSpeicher)
								.addComponent(tSpeicher, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnExecute2))
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(sSpeed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblRabbit))))
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
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}	
		
	private ActionListener ActionExecute1 = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			try {
				if (memory.getStatus() == EnumMemoryStatus.START) {
					// Strategie festlegen
					memory.setStrategy(cbStrategie.getStrategy());		
				} else {
					// zurücksetzen
					stopAutomatic();;
					memory.reset();
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
			memory.setNumber(space);	
		} catch (Exception ex) {
			tSpeicher.setText("");
			noInput();
		} finally {
			
		}
		updateComponents();
	}
	
	private void automatic() {
		if (isAutomaticRunning) {
			stopAutomatic();
		} else {
			startAutomatic();
		}
		updateComponents();
	}
	
	private void search() {
		// Suche
		if (isAutomaticChecked) {
			automatic();
		} else {
			foundSpace(memory.execute());
		}
		updateComponents();
	}	
	
	private ActionListener ActionExecute2 = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			try {
				EnumMemoryStatus status = memory.getStatus();
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
	
	private ActionListener ActionAuto = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			isAutomaticChecked = chcxbxAuto.isSelected();
			updateComponents();
		}
	};
	
	private ChangeListener ChangeSpeed = new ChangeListener() {
		public void stateChanged(ChangeEvent arg0) {
			setSpeed();
			updateComponents();
		}
	};
	
	public class AutoThread extends Thread {
	    String text;
	  
	    public AutoThread() {
	      
	    }
	  
	    public void run() {
	    	try {
	    		while(isAutomaticRunning && isAutomaticChecked && ((memory.getStatus() == EnumMemoryStatus.SEARCH) || (memory.getStatus() == EnumMemoryStatus.CHOOSE) || (memory.getStatus() == EnumMemoryStatus.FINISHED))) {
	                foundSpace(memory.execute());
	                updateComponents();
                    Thread.sleep(speed);
	            }
	    		isAutomaticChecked = false;
	    		isAutomaticRunning = false;
            } catch (InterruptedException e) {
            	System.out.println("Thread abgebrochen");
            }
	    	updateComponents();
	    }
	}
	
	@Override
	public Integer getHeightMenu() {
		return 160;
	}	
}
