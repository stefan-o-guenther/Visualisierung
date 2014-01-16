package Betriebssysteme.Seitenersetzungsstrategien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Base.BasePanelMenu;
import Base.BasePanelModel;

public class PanelBSSeitenersetzungsstrategienMenu extends BasePanelMenu {;
	
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
	
	private JComboBox cbStrategie;
	
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
		lblToolTipR.setEnabled(true);
		lblToolTipM.setEnabled(true);
		btnExecute1.setEnabled(true);
				
		EnumPagingStatus status = paging.getStatus();
		//System.out.println(status.toString());
		switch (status) {
			case START: {
				btnR.setEnabled(false);
				btnM.setEnabled(false);
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
				Boolean urm = paging.useRM();
				btnR.setEnabled(urm);
				btnM.setEnabled(urm);
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
				Boolean urm = paging.useRM();
				btnR.setEnabled(urm);
				btnM.setEnabled(urm);
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
				
		lblStrategie = new JLabel("Strategie:");
		lblStrategie.setIcon(IMG_HELP);
		lblStrategie.setToolTipText(sToolTipStrategie);
		
		lblReferenzfolge = new JLabel("Referenzfolge:");
		lblReferenzfolge.setIcon(IMG_HELP);
		lblReferenzfolge.setToolTipText(sToolTipReferenzfolge);
		
		tfReferenzfolge = new JTextField();
		tfReferenzfolge.setColumns(10);
		
		cbStrategie = new JComboBox();
		cbStrategie.setModel(new DefaultComboBoxModel(new String[] {"Optimale Strategie", "FIFO", "FIFO - Second Chance", "LRU", "NFU / LFU", "NRU / RNU - FIFO", "NRU / RNU - FIFO Second Chance"}));
		
		lblRam = new JLabel("Anzahl RAM:");
		lblRam.setIcon(IMG_HELP);
		lblRam.setToolTipText(sToolTipRam);
		
		lblDisk = new JLabel("Anzahl DISK:");
		lblDisk.setIcon(IMG_HELP);
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
		lblToolTipR.setIcon(IMG_HELP);
		lblToolTipR.setToolTipText(sToolTipR);
		
		lblToolTipM = new JLabel(" ");
		lblToolTipM.setIcon(IMG_HELP);
		lblToolTipM.setToolTipText(sToolTipM);
		
		lblErrorTitle = new JLabel("Seitenfehler:");		
		lblErrorTitle.setIcon(IMG_HELP);
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
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblToolTipR)
						.addComponent(lblToolTipM))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnM, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnR, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(lblErrorTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblErrorValue)
					.addContainerGap(34, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblStrategie)
							.addComponent(cbStrategie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblRam)
							.addComponent(tfRam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnExecute1))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnR)
							.addComponent(lblToolTipR)
							.addComponent(lblErrorTitle)
							.addComponent(lblErrorValue)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblReferenzfolge)
						.addComponent(tfReferenzfolge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDisk)
						.addComponent(tfDisk, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExecute2)
						.addComponent(btnM)
						.addComponent(lblToolTipM))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}
	
	/**
	 * Create the panel.
	 * @param panelModel 
	 */
	public PanelBSSeitenersetzungsstrategienMenu(IMemoryManager ipaging, BasePanelModel model) {
		super(model);
		if (ipaging == null) {
			ipaging = new MemoryManager();
		}
		paging = ipaging;
		initComponents();
		updateView();
	}	
	
	@Override
	protected void initToolTips() {	
		sToolTipStrategie = 	
	        	  "<html>"
		    	+ "<h3>:</h3>"
		    	+ "<br>"
		    	+ "<br>"
		    	+ "<br>"
		    	+ "<h3>:</h3>"
		    	+ "<br>"
		    	+ "<br>"		    	
		    	+ "<br>"
		    	+ "<br>"
		    	+ "</html>";	
		
		sToolTipReferenzfolge = 	
	        	  "<html>"
		    	+ "<h3>:</h3>"
		    	+ "<br>"
		    	+ "<br>"
		    	+ "<br>"
		    	+ "<h3>:</h3>"
		    	+ "<br>"
		    	+ "<br>"		    	
		    	+ "<br>"
		    	+ "<br>"
		    	+ "</html>";
		
		sToolTipRam =
			  	  "<html>"
			  	+ "<h3>:</h3>"
			  	+ "<br>"
			  	+ "<br>"
			  	+ "<br>"
			  	+ "<h3>:</h3>"
			  	+ "<br>"
			  	+ "<br>"		    	
			  	+ "<br>"
			  	+ "<br>"
			  	+ "</html>";
		
		sToolTipDisk =
			  	  "<html>"
			  	+ "<h3>:</h3>"
			  	+ "<br>"
			  	+ "<br>"
			  	+ "<br>"
			  	+ "<h3>:</h3>"
			  	+ "<br>"
			  	+ "<br>"		    	
			  	+ "<br>"
			  	+ "<br>"
			  	+ "</html>";
		
		sToolTipSeitenfehler =
			  	  "<html>"
			  	+ "<h3>:</h3>"
			  	+ "<br>"
			  	+ "<br>"
			  	+ "<br>"
			  	+ "<h3>:</h3>"
			  	+ "<br>"
			  	+ "<br>"		    	
			  	+ "<br>"
			  	+ "<br>"
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
	
	private EnumPagingStrategy getStrategy() {
		EnumPagingStrategy result = null;
		/* {
		 * "Optimale Strategie", 
		 * "FIFO", 
		 * "FIFO - Second Chance", 
		 * "LRU", 
		 * "NFU / LFU", 
		 * "NRU / RNU - FIFO", 
		 * "NRU / RNU - FIFO Second Chance"
		 * } */
		int select = cbStrategie.getSelectedIndex();
		switch (select) {
			case 0: 
				result = EnumPagingStrategy.OPTIMAL;
				break;
			case 1: 
				result = EnumPagingStrategy.FIFO;
				break;
			case 2: 
				result = EnumPagingStrategy.FIFO_SECOND_CHANCE;
				break;
			case 3: 
				result = EnumPagingStrategy.LRU;
				break;
			case 4: 
				result = EnumPagingStrategy.NFU_LFU;
				break;
			case 5: 
				result = EnumPagingStrategy.NRU_RNU;
				break;
			case 6: 
				result = EnumPagingStrategy.NRU_RNU_SECOND_CHANCE;
				break;
			default:
				result = EnumPagingStrategy.NULL;
				break;
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
			updateView();
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
						if (size > 26) {
							ok = false;
							printError("Die Referenzfolge hat mehr als 26 Stellen!");
						}
						if (ram.equals(0)) {
							ok = false;
							printError("Die Anzahl des RAM muss mindestens 1 sein!");
						}
						if (ok) {
							paging.setStrategy(getStrategy(), listSequence, ram, disk);
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
			updateView();
		}
	};
	
	ActionListener ActionResetR = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			paging.resetRBits();
			updateView();
		}
	};

	ActionListener ActionSetM = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			paging.setMBit();
			updateView();
		}
	};
}
