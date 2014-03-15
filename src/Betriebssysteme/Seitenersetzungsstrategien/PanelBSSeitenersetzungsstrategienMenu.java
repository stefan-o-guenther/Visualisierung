/**
 * @author:	Stefan Otto G�nther
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
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import java.awt.Color;

public class PanelBSSeitenersetzungsstrategienMenu extends BasePanelMenu {;
	
	public PanelBSSeitenersetzungsstrategienMenu(IPaging ipaging) {
		super();
		if (ipaging == null) {
			ipaging = new Paging();
		}
		paging = ipaging;
		initComponents();
		updateComponents();
	}

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
		
	private JCheckBox chckbxkOldStates;
	
	private IPaging paging;

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
		Boolean useRM = paging.useRM();
		Boolean canUseRM = paging.canUseRM();
		Boolean oldStates = paging.canViewOldStates();
		chckbxkOldStates.setSelected(oldStates);
		EnumPagingStatus status = paging.getStatus();
		switch (status) {
			case START: {
				btnR.setEnabled(false);
				btnR.setVisible(false);
				btnM.setEnabled(false);
				btnM.setVisible(false);
				chckbxkOldStates.setEnabled(false);
				chckbxkOldStates.setVisible(false);
				lblToolTipR.setEnabled(false);
				lblToolTipR.setVisible(false);
				lblToolTipM.setEnabled(false);
				lblToolTipM.setVisible(false);
				btnExecute1.setText("Beispiel laden");
				btnExecute2.setText("\u00fcbernehmen");
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
				btnR.setEnabled(canUseRM);
				btnR.setVisible(useRM);
				btnM.setEnabled(canUseRM);				
				btnM.setVisible(useRM);
				chckbxkOldStates.setEnabled(useRM);
				chckbxkOldStates.setVisible(useRM);
				lblToolTipR.setEnabled(useRM);
				lblToolTipR.setVisible(useRM);
				lblToolTipM.setEnabled(useRM);
				lblToolTipM.setVisible(useRM);
				btnExecute1.setText("zur\u00fccksetzen");
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
				btnR.setEnabled(useRM);
				btnR.setVisible(useRM);
				btnM.setEnabled(useRM);				
				btnM.setVisible(useRM);
				chckbxkOldStates.setEnabled(useRM);
				chckbxkOldStates.setVisible(useRM);
				lblToolTipR.setEnabled(useRM);
				lblToolTipR.setVisible(useRM);
				lblToolTipM.setEnabled(useRM);
				lblToolTipM.setVisible(useRM);
				btnExecute1.setText("zur\u00fccksetzen");
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
		ImageIcon imgHelp = getImageIconHelp();
		
		lblStrategie = new JLabel("Strategie:");
		lblStrategie.setIcon(imgHelp);
		lblStrategie.setToolTipText(ToolTipManager.getToolTipStrategy());
		
		lblReferenzfolge = new JLabel("Referenzfolge:");
		lblReferenzfolge.setIcon(imgHelp);
		lblReferenzfolge.setToolTipText(ToolTipManager.getToolTipReference());
		
		tfReferenzfolge = new JTextField();
		tfReferenzfolge.setColumns(10);
		
		cbStrategie = new ComboBoxStrategy();
		
		lblRam = new JLabel("Anzahl RAM:");
		lblRam.setIcon(imgHelp);
		lblRam.setToolTipText(ToolTipManager.getToolTipRam());
		
		lblDisk = new JLabel("Anzahl DISK:");
		lblDisk.setIcon(imgHelp);
		lblDisk.setToolTipText(ToolTipManager.getToolTipDisk());
		
		tfDisk = new JTextField();
		tfDisk.setColumns(10);
		
		tfRam = new JTextField();
		tfRam.setColumns(10);
		
		btnExecute1 = new JButton("Beispiel laden");
		btnExecute1.addActionListener(actionExecute1);
		
		btnExecute2 = new JButton("\u00fcbernehmen");
		btnExecute2.addActionListener(actionExecute2);		
		
		lblErrorTitle = new JLabel("Seitenverdr\u00e4ngungen:");		
		lblErrorTitle.setIcon(imgHelp);
		lblErrorTitle.setToolTipText(ToolTipManager.getToolTipPagingError());
		lblErrorValue = new JLabel(" ");		
		
		chckbxkOldStates = new JCheckBox("alte Zust\u00E4nde anzeigen");
		chckbxkOldStates.setBackground(Color.WHITE);
		chckbxkOldStates.addActionListener(actionOldStates);
		
		lblToolTipR = new JLabel(" ");
		lblToolTipR.setIcon(imgHelp);
		lblToolTipR.setToolTipText(ToolTipManager.getToolTipR());
		
		btnR = new JButton("R-Bits zur\u00fccksetzen");
		btnR.addActionListener(actionResetR);
		
		btnM = new JButton("M-Bit setzen");
		btnM.addActionListener(actionSetM);
		
		lblToolTipM = new JLabel(" ");
		lblToolTipM.setIcon(imgHelp);
		lblToolTipM.setToolTipText(ToolTipManager.getToolTipM());
				
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblToolTipR)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnR, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblReferenzfolge)
								.addComponent(lblStrategie))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(tfReferenzfolge, Alignment.LEADING)
								.addComponent(cbStrategie, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
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
								.addComponent(btnExecute1, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblToolTipM)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnM, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblErrorTitle)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblErrorValue, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addComponent(chckbxkOldStates, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(228, Short.MAX_VALUE))
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
						.addComponent(lblErrorValue))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblReferenzfolge)
						.addComponent(tfReferenzfolge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDisk)
						.addComponent(tfDisk, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExecute2)
						.addComponent(chckbxkOldStates))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblToolTipR)
						.addComponent(btnR)
						.addComponent(lblToolTipM)
						.addComponent(btnM))
					.addContainerGap(271, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
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
			Object[] option = {"schlie\u00dfen"};
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
			}
		} catch (Exception ex) {
			tfReferenzfolge.setText("Keine g\u00fcltige Referenzfolge eingegeben!");
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
			printError("Keine g\u00fcltige RAM-Anzahl eingegeben!");
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
			printError("Keine g\u00fcltige DISK-Anzahl eingebeben!");
			result = null;
		} finally {
			
		}
		return result;
	}	
	
	private ActionListener actionExecute1 = new ActionListener() {
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
	
	private final Integer maxSumRamDisk = 14;
	private final Integer maxLengthReference = 24;
	
	private ActionListener actionExecute2 = new ActionListener() {
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
						if (sum > 14) {
							ok = false;
							printError("Die Summe aus Anzahl von RAM und DISK is gr\u00f6\u00dfer als " + maxSumRamDisk +"!");
						}
						if (size > maxLengthReference) {
							ok = false;
							printError("Die Referenzfolge hat mehr als " + maxLengthReference + " Stellen!");
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
	
	private ActionListener actionResetR = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			paging.resetRBits();
			updateComponents();
		}
	};

	private ActionListener actionSetM = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			paging.setMBit();
			updateComponents();
		}
	};
	
	private ActionListener actionOldStates = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			paging.setViewOldStates(chckbxkOldStates.isSelected());
			updateComponents();
		}
	};

	@Override
	public Integer getHeightMenu() {
		return 100;
	}
}
