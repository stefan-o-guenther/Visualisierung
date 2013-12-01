package Betriebssysteme.Belegungsstrategien;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelBSBelegungsstrategien extends JPanel {

	private IMemoryManagement memory = new MemoryManagement();
	
	private ButtonGroup gruppe = new ButtonGroup();
	
	private JRadioButton rdbtnColored;	
	private JRadioButton rdbtnGray;	
	
	private JLabel lblTitel;
	
	private JLabel lblStrategie;	
	private JComboBox cbStrategie;
	private JButton btnExecute1;
		
	private JLabel lblSpeicher;
	private JTextField tSpeicher;
	private JButton btnExecute2;
	private JCheckBox chcxbxAuto;
	private JLabel lblSpeedTip;
	private JSlider sSpeed;

	private JLabel lblTotalSpaceLabel;
	private JLabel lblTotalSpaceOutput;
	private JLabel lblFreeSpaceLabel;
	private JLabel lblFreeSpaceOutput;
	private JLabel lblUsedSpaceLabel;
	private JLabel lblUsedSpaceOutput;
	private JLabel lblRateLabel;
	private JLabel lblRateOutput;
	private ModelBSBelegungsstrategien panel;
	
	private EnumSurface color = EnumSurface.COLORED;
	
	private AutoThread tAuto = new AutoThread();
	
	private void drawList() {
		List<ISpace> listSpace = memory.getListSpace();
		panel.drawListSpace(listSpace, color);
	}	
	
	private void updateComponents() {
		
		rdbtnColored.setEnabled(true);
    	rdbtnGray.setEnabled(true);	       
    	lblTitel.setEnabled(true);
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
    	
    	Integer total = 0;
    	Integer free = 0;
    	Integer used = 0;
    	List<ISpace> listSpace = memory.getListSpace();
    	for (ISpace space : listSpace) {
    		Integer value = space.getCurrentValue();
    		total += value;
    		EnumSpace type = space.getType();
    		if (type == EnumSpace.EMPTY) {
    			free += value;
    		}
    		if ((type == EnumSpace.FULL) || (type == EnumSpace.USED)) {
    			used += value;
    		}
    	}
    	Double rate = (((double) used) * 100) / ((double) total); 
    	DecimalFormat f = new DecimalFormat("#0.00"); 
    	
    	lblTotalSpaceOutput.setText(total.toString());
    	lblFreeSpaceOutput.setText(free.toString());
    	lblUsedSpaceOutput.setText(used.toString());
    	lblRateOutput.setText(f.format(rate));
    	
    	EnumStatus status = memory.getStatus();
    	
    	if (status == EnumStatus.START) {
    		cbStrategie.setEnabled(true);
        	tSpeicher.setEnabled(false);
        	tSpeicher.setEditable(false);
        	tSpeicher.setText("");
        	btnExecute1.setEnabled(true);
        	btnExecute1.setText("übernehmen");
        	btnExecute2.setEnabled(false);
        	btnExecute2.setText("speichern");
        	chcxbxAuto.setEnabled(false);
        	chcxbxAuto.setSelected(false);
        	sSpeed.setEnabled(false);
    	} else if (status == EnumStatus.INPUT) {
    		cbStrategie.setEnabled(false);
        	tSpeicher.setEnabled(true);
        	tSpeicher.setEditable(true);
        	tSpeicher.setText("");
        	btnExecute1.setEnabled(true);
        	btnExecute1.setText("zurücksetzen");
        	btnExecute2.setEnabled(true);
        	btnExecute2.setText("speichern");
        	chcxbxAuto.setEnabled(false);
        	chcxbxAuto.setSelected(false);
        	sSpeed.setEnabled(false);
    	} else if (status == EnumStatus.SEARCH) {
    		cbStrategie.setEnabled(false);
        	tSpeicher.setEnabled(false);
        	tSpeicher.setEditable(false);
        	btnExecute1.setEnabled(true);
        	btnExecute1.setText("zurücksetzen");
        	btnExecute2.setEnabled(!(memory.isAuto()));
        	btnExecute2.setText("weiter");
        	chcxbxAuto.setEnabled(true);
        	sSpeed.setEnabled(true);
    	} else if (status == EnumStatus.FINISHED) {
    		cbStrategie.setEnabled(false);
        	tSpeicher.setEnabled(false);
        	tSpeicher.setEditable(false);
        	btnExecute1.setEnabled(true);
        	btnExecute1.setText("zurücksetzen");
        	btnExecute2.setEnabled(!(memory.isAuto()));
        	btnExecute2.setText("weiter");
        	chcxbxAuto.setEnabled(false);
        	sSpeed.setEnabled(false);    	
    	}
	}
	
	private void initGui() {
		String sToolTipStrategie = 	
	        	  "<html>"
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
			
	        String sToolTipSpeed = 
	        	  "<html>"
	        	+ "Mit diesem Geschwindigkeitsregeler können Sie einstellen,<br>"
	        	+ "wie schnell der Auto-Durchlauf ausgeführt werden soll.<br>"
	        	+ "Standardmäßig ist die Geschwindigkeit auf 25% eingestellt.<br>"
	        	+ "</html>";
	        
	        String sToolTipSpeicher = "ganze Zahl, die größer als Null ist, eintragen";
			
			String[] strategy = {"First Fit", "Next Fit", "Best Fit", "Worst Fit"};
			
			
			ImageIcon imgHelp = new ImageIcon("img/help16x16.png");
			
			
			rdbtnColored = new JRadioButton("farbig");
			rdbtnColored.setActionCommand("colored");
			rdbtnColored.addActionListener(ActionColor);
			rdbtnGray = new JRadioButton("grau");
			rdbtnGray.setActionCommand("gray");
			rdbtnGray.addActionListener(ActionColor);
			gruppe.add(rdbtnColored);
			gruppe.add(rdbtnGray);
			rdbtnColored.setSelected(true);
			
			lblTitel = new JLabel("Belegungsstrategien");
			lblTitel.setFont(new Font("Tahoma", Font.PLAIN, 36));
			
			lblStrategie = new JLabel("Strategie:");
			lblStrategie.setIcon(imgHelp);
			lblStrategie.setToolTipText(sToolTipStrategie);
			
			lblSpeicher = new JLabel("Speichergröße:");
			lblSpeicher.setIcon(imgHelp);
			lblSpeicher.setToolTipText(sToolTipSpeicher);
			
			cbStrategie = new JComboBox(strategy);
			cbStrategie.setEditable( false );
	        cbStrategie.setSelectedItem("");	
			
			tSpeicher = new JTextField();
			tSpeicher.setColumns(10);
			
			btnExecute1 = new JButton("zurücksetzen");
			btnExecute1.addActionListener(ActionExecute1);
			
			btnExecute2 = new JButton("übernehmen");
			btnExecute2.addActionListener(ActionExecute2);
			
			chcxbxAuto = new JCheckBox("Automatischer Durchlauf");
			
			lblSpeedTip = new JLabel("");
			lblSpeedTip.setIcon(imgHelp);
			lblSpeedTip.setToolTipText(sToolTipSpeed);
			
			sSpeed = new JSlider( 0, 100, 50 );
	    	sSpeed.setPaintTicks( true );
	    	sSpeed.setMinorTickSpacing(10); //Abstände im Feinraster
	    	sSpeed.setMajorTickSpacing(20); //Abstände im Großraster
	    	sSpeed.setSnapToTicks(true);
	    	sSpeed.setPaintLabels(false);
			
			lblTotalSpaceLabel = new JLabel("Gesammter Speicherplatz:");
			
			lblTotalSpaceOutput = new JLabel("?");
			
			lblFreeSpaceLabel = new JLabel("Freier Speicherplatz:");
			
			lblFreeSpaceOutput = new JLabel("?");
			
			lblUsedSpaceLabel = new JLabel("Belegter Speicherplatz:");
			
			lblUsedSpaceOutput = new JLabel("?");
			
			lblRateLabel = new JLabel("Belegter Speicherplatz in %:");
			
			lblRateOutput = new JLabel("?");
			
			panel = new ModelBSBelegungsstrategien(memory.getListSpace());
			
			
			GroupLayout groupLayout = new GroupLayout(this);
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(rdbtnColored, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(rdbtnGray, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblStrategie, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblSpeicher, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(tSpeicher, 0, 0, Short.MAX_VALUE)
											.addComponent(cbStrategie, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(btnExecute2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(btnExecute1, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblSpeedTip)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(chcxbxAuto, GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
											.addComponent(sSpeed, GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)))
									.addComponent(lblTitel, GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addComponent(lblTotalSpaceLabel)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblTotalSpaceOutput))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addComponent(lblRateLabel)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblRateOutput))
							.addGroup(Alignment.LEADING, groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblUsedSpaceLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblUsedSpaceOutput, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblFreeSpaceLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblFreeSpaceOutput))))
						.addContainerGap())
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(6)
								.addComponent(rdbtnColored)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(rdbtnGray))
							.addGroup(groupLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblTitel)))
						.addGap(34)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblStrategie)
							.addComponent(cbStrategie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnExecute1)
							.addComponent(chcxbxAuto)
							.addComponent(lblSpeedTip))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
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
									.addComponent(lblRateOutput)))
							.addComponent(sSpeed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
						.addContainerGap())
			);
			setLayout(groupLayout);
	}
	
	
	/**
	 * Create the panel.
	 */
	public PanelBSBelegungsstrategien() {
		memory = new MemoryManagement();
		initGui();
		updateComponents();
		
	}
	
	ActionListener ActionExecute1 = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			try {
				if (memory.getStatus() == EnumStatus.START) {
					// Strategie festlegen
					int select = cbStrategie.getSelectedIndex();
					switch (select) {
						case 0: 
							memory.setStrategy(EnumStrategy.FIRST_FIT);
							break;
						case 1: 
							memory.setStrategy(EnumStrategy.NEXT_FIT);
							break;
						case 2: 
							memory.setStrategy(EnumStrategy.BEST_FIT);
							break;
						case 3: 
							memory.setStrategy(EnumStrategy.WORST_FIT);
							break;
						default:
							memory.setStrategy(EnumStrategy.NULL);
							break;
					}				
				} else {
					// zurücksetzen
					if (memory.isAuto()) {
						tAuto.interrupt();
						memory.setAuto(false);
					}
					tAuto = new AutoThread();
					memory.reset();
					drawList();
				}
				updateComponents();
			} catch (Exception ex) {
				
			}
		}
	};
	
	
	ActionListener ActionExecute2 = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			try {
				EnumStatus status = memory.getStatus();
				if (status == EnumStatus.INPUT) {
					// Eingabe
					String text = tSpeicher.getText();			
					try {
						Integer space = new Integer(text);
						memory.setNumber(space);	
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "keine ganze Zahl eingebeben", "Achtung", JOptionPane.OK_CANCEL_OPTION);					
					} finally {
						updateComponents();
					}
				} else if ((status == EnumStatus.SEARCH) || (status == EnumStatus.FINISHED)) {
					// Suche
					if (chcxbxAuto.isSelected()) {
						memory.setAuto(true);
						tAuto = new AutoThread();
						tAuto.start();
					} else {
						memory.execute();
						drawList();
						updateComponents();
					}
				}		
				updateComponents();
			} catch (Exception ex) {
				
			}
		}
	};	
	
	ActionListener ActionColor = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			String s = e.getActionCommand();
			if (s == "colored") {
				color = EnumSurface.COLORED;
				drawList();
			} else if (s == "gray") {
				color = EnumSurface.GRAY;
				drawList();
			}
		}
	};
		
	class AutoThread extends Thread {
	    String text;
	  
	    public AutoThread() {
	      
	    }
	  
	    public void run() {
	    	try {
	    		while((memory.getStatus() == EnumStatus.SEARCH) || (memory.getStatus() == EnumStatus.FINISHED)) {
	                memory.execute();
					drawList();
					updateComponents();
                    Thread.sleep(1000);  
	            }
	    		memory.setAuto(false);
	    		interrupt();
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
	    }
	}
	
}
