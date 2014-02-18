/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Base.BasePanelMenu;

public class PanelBSSeitenersetzungsstrategienMenu extends BasePanelMenu {;
	
	public PanelBSSeitenersetzungsstrategienMenu(IMemoryManager ipaging) {
		super();
		if (ipaging == null) {
			ipaging = new MemoryManager();
		}
		paging = ipaging;
		initComponents();
		updateComponents();
	}	

	private String sToolTipStrategie = "";
	private String sToolTipReferenzfolge = "";
	private String sToolTipRam = "";
	private String sToolTipDisk = "";
	private String sToolTipR = "";
	private String sToolTipM = "";
	private String sToolTipSeitenfehler = "";
	
	private JLabel lblStrategie;
	private JLabel lblReferenzfolge;
	private JLabel lblRam;
	private JLabel lblDisk;	
	private JLabel lblErrorTitle;	
	private JLabel lblErrorValue;
	private JLabel lblToolTipR;
	private JLabel lblToolTipM;
	
	private JTextField tfReferenzfolge;
	private JTextField tfDisk;
	private JTextField tfRam;
	
	private ComboBoxStrategy cbStrategie;
	
	private JButton btnExecute2;
	private JButton btnExecute1;
	private JButton btnR;
	private JButton btnM;
		
	
	private IMemoryManager paging;
	
	//private JPanel panel;	

	//@Override
	protected void updateComponents() {		
		lblStrategie.setEnabled(true);
		lblReferenzfolge.setEnabled(true);
		lblRam.setEnabled(true);
		lblDisk.setEnabled(true);
		lblErrorTitle.setEnabled(true);
		lblErrorValue.setEnabled(true);
		lblErrorValue.setText(paging.getErrorCount().toString());		
		btnExecute1.setEnabled(true);
		Boolean urm = paging.useRM();
		EnumPagingStatus status = paging.getStatus();
		switch (status) {
			case START: {
				btnR.setEnabled(false);
				btnR.setVisible(false);
				btnM.setEnabled(false);
				btnM.setVisible(false);
				lblToolTipR.setEnabled(false);
				lblToolTipR.setVisible(false);
				lblToolTipM.setEnabled(false);
				lblToolTipM.setVisible(false);
				btnExecute1.setText("Beispiel laden");
				btnExecute2.setText("übernehmen");
				btnExecute2.setEnabled(true);
				cbStrategie.setEnabled(true);
				tfReferenzfolge.setEnabled(true);
				tfReferenzfolge.setEditable(true);
				tfRam.setEnabled(true);
				tfRam.setEditable(true);
				tfDisk.setEnabled(true);
				tfDisk.setEditable(true);
				break;
			}
			case SEARCH: {
				
				btnR.setEnabled(urm);
				btnR.setVisible(urm);
				btnM.setEnabled(urm);				
				btnM.setVisible(urm);
				lblToolTipR.setEnabled(urm);
				lblToolTipR.setVisible(urm);
				lblToolTipM.setEnabled(urm);
				lblToolTipM.setVisible(urm);
				btnExecute1.setText("zurücksetzen");
				btnExecute2.setText("weiter");
				btnExecute2.setEnabled(true);
				cbStrategie.setEnabled(false);
				tfReferenzfolge.setEnabled(false);
				tfReferenzfolge.setEditable(false);
				tfRam.setEnabled(false);
				tfRam.setEditable(false);
				tfDisk.setEnabled(false);
				tfDisk.setEditable(false);
				break;
			}
			case FINISHED: {
				btnR.setEnabled(urm);
				btnR.setVisible(urm);
				btnM.setEnabled(urm);				
				btnM.setVisible(urm);
				lblToolTipR.setEnabled(urm);
				lblToolTipR.setVisible(urm);
				lblToolTipM.setEnabled(urm);
				lblToolTipM.setVisible(urm);
				btnExecute1.setText("zurücksetzen");
				btnExecute2.setText("weiter");
				btnExecute2.setEnabled(false);
				cbStrategie.setEnabled(false);
				tfReferenzfolge.setEnabled(false);
				tfReferenzfolge.setEditable(false);
				tfRam.setEnabled(false);
				tfRam.setEditable(false);
				tfDisk.setEnabled(false);
				tfDisk.setEditable(false);
				break;
			}
			default: {
				break;
			}
		}		
	}
	
	//@Override
	protected void initComponents() {		
		initToolTips();
		
		ImageIcon imgHelp = getImageIconHelp();
		
		lblStrategie = new JLabel("Strategie:");
		lblStrategie.setIcon(imgHelp);
		lblStrategie.setToolTipText(sToolTipStrategie);
		
		lblReferenzfolge = new JLabel("Referenzfolge:");
		lblReferenzfolge.setIcon(imgHelp);
		lblReferenzfolge.setToolTipText(sToolTipReferenzfolge);
		
		tfReferenzfolge = new JTextField();
		tfReferenzfolge.setColumns(10);
		
		cbStrategie = new ComboBoxStrategy();
		
		lblRam = new JLabel("Anzahl RAM:");
		lblRam.setIcon(imgHelp);
		lblRam.setToolTipText(sToolTipRam);
		
		lblDisk = new JLabel("Anzahl DISK:");
		lblDisk.setIcon(imgHelp);
		lblDisk.setToolTipText(sToolTipDisk);
		
		tfDisk = new JTextField();
		tfDisk.setColumns(10);
		
		tfRam = new JTextField();
		tfRam.setColumns(10);
		
		btnExecute1 = new JButton("Beispiel laden");
		btnExecute1.addActionListener(ActionExecute1);
		
		btnExecute2 = new JButton("übernehmen");
		btnExecute2.addActionListener(ActionExecute2);		
		
		btnR = new JButton("R-Bits zurücksetzen");
		btnR.addActionListener(ActionResetR);
		
		btnM = new JButton("M-Bit setzen");
		btnM.addActionListener(ActionSetM);
		
		lblToolTipR = new JLabel(" ");
		lblToolTipR.setIcon(imgHelp);
		lblToolTipR.setToolTipText(sToolTipR);
		
		lblToolTipM = new JLabel(" ");
		lblToolTipM.setIcon(imgHelp);
		lblToolTipM.setToolTipText(sToolTipM);
		
		lblErrorTitle = new JLabel("Seitenverdrängungen:");		
		lblErrorTitle.setIcon(imgHelp);
		lblErrorTitle.setToolTipText(sToolTipSeitenfehler);
		lblErrorValue = new JLabel(" ");		
				
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblReferenzfolge)
						.addComponent(lblStrategie))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(tfReferenzfolge)
						.addComponent(cbStrategie, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblDisk, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblRam, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(tfDisk, 0, 0, Short.MAX_VALUE)
						.addComponent(tfRam, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnExecute2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnExecute1, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(lblErrorTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblErrorValue, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblToolTipM)
						.addComponent(lblToolTipR))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnM, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnR, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStrategie)
						.addComponent(cbStrategie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRam)
						.addComponent(tfRam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExecute1)
						.addComponent(lblErrorTitle)
						.addComponent(lblErrorValue)
						.addComponent(lblToolTipR)
						.addComponent(btnR))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblReferenzfolge)
						.addComponent(tfReferenzfolge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDisk)
						.addComponent(tfDisk, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExecute2)
						.addComponent(lblToolTipM)
						.addComponent(btnM))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}
	
	@Override
	protected void initToolTips() {	
		sToolTipStrategie = ""
			+ "<html>"
	    	+ "<strong>Optimale Strategie:</strong><br/>"
	    	+ "<p>"
	    	+ "Das beste wäre, wenn die Seitenersetzung immer die zukünfigen<br/>"
	    	+ "Seitenzugriffe aller Prozesse berücksichtigen könnte, weil dann<br/>"
	    	+ "wenige Seitenfehler auftreten würden. Ein optimaler Algorithmus würde<br/>"
	    	+ "die Seitenrahmen für eine Ersetzung auswählen, die am spätesten von allen<br/>"
	    	+ "belegten Seitenrahmen wieder benötigt würden.<br/>"
	    	+ "</p>"
	    	+ "<br/>"
	    	+ "<strong>FIFO</strong><br/>"
	    	+ "<p>"
	    	+ "Bei <i>FIFO</i> (First In First Out) wird die zuerst eingespeicherte Seite ersetzt.<br/>"
	    	+ "</p>"
	    	+ "<br/>"
	    	+ "<strong>FIFO - Second Chance</strong><br/>"
	    	+ "<p>"
	    	+ "Der <i>Second-Chance-Algorithmus</i> ist eine Verbesserung von <i>FIFO</i> dahingehend,<br/>"
	    	+ "dass nochmals referenzierte Seiten im Hauptspeicher wie neu eingelagerte Seiten behandelt werden.<br/>"
	    	+ "</p>"
	    	+ "<br/>"
	    	+ "<strong>NRU</strong><br/>"
	    	+ "<p>"
	    	+ "Seiten werden über R- und M-Bits priorisiert. Seiten mit kleinster Priorität werden als erstes ersetzt.<br/>"
	    	+ "Die Prioritätenreihenfolge von niedrig nach hoch ist: R/M = 0/0, 0/1, 1/0, 1/1.<br/>"
	    	+ "</p>"
	    	+ "</html>";	
		
		sToolTipReferenzfolge = ""
			+ "<html>"
	    	+ "<span>"
	    	+ "Die Eingabelänge der Referenzfolge ist für diese Animation auf 26 Seiten beschränkt.<br/>"
	    	+ "Seiten werden durch einzelne Ziffern (0-9) identifiziert.<br/>"
	    	+ "Die Referenzfolge ist die Reihenfolge der Seitenzugriffe bzw. gibt an,<br/>"
	    	+ "auf welche Seiten als nächstes zugegriffen wird.<br/>"
	    	+ "</span>"
	    	+ "</html>";
		
		sToolTipRam = ""
			+ "<html>"
		  	+ "Anzahl RAM-Seiten"
		  	+ "</html>";
		
		sToolTipDisk = ""
			+ "<html>"
		  	+ "Anzahl Disk-Seiten"
		  	+ "</html>";
		
		sToolTipSeitenfehler = ""
			+ "<html>"
		  	+ "wie oft wurde im RAM eine Seite durch eine andere Seite ersetzt"
		  	+ "</html>";
		
		sToolTipR = ""
			+ "<html>"
		  	+ "für gewöhlich setzt der Pageout-Dämon das R-Bit in<br/>"
		  	+ "regelmäßigen Abständen zurück.<br/>"
		  	+ "</html>";
		sToolTipM = ""
			+ "<html>"
		  	+ "Seite wurde geschrieben/verändert"
		  	+ "</html>";
	}
	
	private void loadExample() {
		// 012340156012356
		// paging.reset();
		// List<Integer> listSequence = Arrays.asList(0,1,2,3,4,0,1,5,6,0,1,2,3,5,6);
		// paging.setStrategy(EnumPagingStrategy.FIFO_SECOND_CHANCE, listSequence, 3, 4);
		tfReferenzfolge.setText("012340156012356");
		tfRam.setText("3");
		tfDisk.setText("4");
	}
	
	private void printError(String error) {
		if (error != null) {
			Object[] option = {"schließen"};
			JOptionPane.showOptionDialog(null,
					error,
				    "Fehler",
				    JOptionPane.ERROR_MESSAGE,
				    JOptionPane.ERROR_MESSAGE,
				    null,
				    option,
				    option[0]);
		}		
	}
			
	private List<Integer> inputReference() {
		String text = tfReferenzfolge.getText();
		List<Integer> result = null;
		try {
			result = new ArrayList<Integer>();
			for (Integer i = 0; i < text.length(); i++) {
				char c = text.charAt(i);
				if (Character.isDigit(c)) {
					Integer x = Character.getNumericValue(c);
					result.add(x);
				} else {
					throw new Exception();
				}				
				//Integer x = Character.digit(c,10); 				
			}
		} catch (Exception ex) {
			tfReferenzfolge.setText("Keine gültige Referenzfolge eingegeben!");
			printError("");
			result = null;
		} finally {
			
		}
		return result;
	}
	
	private Integer inputRAM() {
		String text = tfRam.getText();
		Integer result = null;
		try {
			result = new Integer(text);
			if (result < 1) {
				throw new Exception();
			}
		} catch (Exception ex) {
			tfRam.setText("");
			printError("Keine gültige RAM-Anzahl eingegeben!");
			result = null;
		} finally {
			
		}
		return result;
	}
	
	private Integer inputDISK() {
		String text = tfDisk.getText();
		Integer result = null;		
		try {
			result = new Integer(text);
			if (result < 0) {
				throw new Exception();
			}
		} catch (Exception ex) {
			tfDisk.setText("");
			printError("Keine gültige DISK-Anzahl eingebeben!");
			result = null;
		} finally {
			
		}
		return result;
	}	
	
	ActionListener ActionExecute1 = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			switch (paging.getStatus()) {
				case START: {
					loadExample();
					break;
				}
				case SEARCH:
				case FINISHED: {				
					paging.reset();
					break;
				}
				default: {						
					break;
				}
			}
			updateComponents();
		}
	};
	
	ActionListener ActionExecute2 = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			switch (paging.getStatus()) {
				case START: {				
					List<Integer> listSequence = inputReference();
					Integer ram = inputRAM();
					Integer disk = inputDISK();
					if ((listSequence != null) && (ram != null) && (disk != null)) {
						Integer sum = ram + disk;
						Integer size = listSequence.size();
						Boolean ok = true;
						if (sum > 16) {
							ok = false;
							printError("Die Summe aus Anzahl von RAM und DISK is größer als 16!");
						}
						if (size > 18) {
							ok = false;
							printError("Die Referenzfolge hat mehr als 18 Stellen!");
						}
						if (ram.equals(0)) {
							ok = false;
							printError("Die Anzahl des RAM muss mindestens 1 sein!");
						}
						if (ok) {
							paging.setStrategy(cbStrategie.getStrategy(), listSequence, ram, disk);
						}						
					}
					break;
				}
				case SEARCH: {				
					paging.execute();
					break;
				}
				case FINISHED: {				
					paging.execute();
					break;
				}
				default: {				
					
					break;
				}
			}
			// Starten und Weiter
			updateComponents();
		}
	};
	
	ActionListener ActionResetR = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			paging.resetRBits();
			updateComponents();
		}
	};

	ActionListener ActionSetM = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			paging.setMBit();
			updateComponents();
		}
	};

	@Override
	public Integer getHeightMenu() {
		return 70;
	}
}
