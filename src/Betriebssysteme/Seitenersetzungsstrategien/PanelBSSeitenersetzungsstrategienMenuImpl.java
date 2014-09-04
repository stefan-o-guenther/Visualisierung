/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Base.EnumVisualizationStatus;
import Base.Labeling;
import Base.MessageBox;
import Base.PanelMenuMenuButtonsAbstract;

public class PanelBSSeitenersetzungsstrategienMenuImpl extends PanelMenuMenuButtonsAbstract {;
	
private static final long serialVersionUID = 1L;

public PanelBSSeitenersetzungsstrategienMenuImpl(ManagementPaging paging) {
		super(paging);
	}
	
	private PanelBSSeitenersetzungsstrategienMenuImpl() {
		super(new ManagementPagingImpl());
	}
	
	private final int maxSumRamDisk = 14;
	private final int maxLengthReference = 24;

	private JLabel lblStrategie;
	private JLabel lblReferenzfolge;
	private JLabel lblRam;
	private JLabel lblDisk;	
	private JLabel lblErrorTitle;	
	private JLabel lblErrorValue;
	private JLabel lblToolTipR;
	private JLabel lblToolTipM;
	private JLabel lblOldStates;
	
	private JTextField tfReferenzfolge;
	private JTextField tfDisk;
	private JTextField tfRam;
	
	private ComboBoxStrategyImpl cbStrategie;
	
	private JButton btnR;
	private JButton btnM;
		
	private JCheckBox chckbxkOldStates;
	
	private JPanel panel;
	
	private ManagementPaging paging;
	private ToolTipManagerPaging tooltip;

	@Override
	public void updatePanelMenuButtons() {		
		lblStrategie.setEnabled(true);
		lblReferenzfolge.setEnabled(true);
		lblRam.setEnabled(true);
		lblDisk.setEnabled(true);
		lblErrorTitle.setEnabled(true);
		lblErrorValue.setEnabled(true);
		lblErrorValue.setText(paging.getErrorCount().toString());		
		Boolean isRmVisible = paging.isRmVisible();
		Boolean isRmEnabled = paging.isRmEnabled();
		Boolean oldStates = paging.isViewOldStatesEnabled();
		chckbxkOldStates.setSelected(oldStates);
		EnumVisualizationStatus status = paging.getStatus();
		switch (status) {
			case START: {
				btnR.setEnabled(false);
				btnR.setVisible(false);
				btnM.setEnabled(false);
				btnM.setVisible(false);
				chckbxkOldStates.setEnabled(false);
				chckbxkOldStates.setVisible(false);
				lblOldStates.setEnabled(false);
				lblOldStates.setVisible(false);				
				lblToolTipR.setEnabled(false);
				lblToolTipR.setVisible(false);
				lblToolTipM.setEnabled(false);
				lblToolTipM.setVisible(false);
				cbStrategie.setEnabled(true);
				tfReferenzfolge.setEnabled(true);
				tfReferenzfolge.setEditable(true);
				tfRam.setEnabled(true);
				tfRam.setEditable(true);
				tfDisk.setEnabled(true);
				tfDisk.setEditable(true);
				break;
			}
			case RUN: {				
				btnR.setEnabled(isRmEnabled);
				btnR.setVisible(isRmVisible);
				btnM.setEnabled(isRmEnabled);				
				btnM.setVisible(isRmVisible);
				chckbxkOldStates.setEnabled(isRmVisible);
				chckbxkOldStates.setVisible(isRmVisible);
				lblOldStates.setEnabled(isRmVisible);
				lblOldStates.setVisible(isRmVisible);
				lblToolTipR.setEnabled(isRmVisible);
				lblToolTipR.setVisible(isRmVisible);
				lblToolTipM.setEnabled(isRmVisible);
				lblToolTipM.setVisible(isRmVisible);
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
				btnR.setEnabled(isRmVisible);
				btnR.setVisible(isRmVisible);
				btnM.setEnabled(isRmVisible);				
				btnM.setVisible(isRmVisible);
				chckbxkOldStates.setEnabled(isRmVisible);
				chckbxkOldStates.setVisible(isRmVisible);
				lblOldStates.setEnabled(isRmVisible);
				lblOldStates.setVisible(isRmVisible);
				lblToolTipR.setEnabled(isRmVisible);
				lblToolTipR.setVisible(isRmVisible);
				lblToolTipM.setEnabled(isRmVisible);
				lblToolTipM.setVisible(isRmVisible);
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
	
	@Override
	protected void initComponentsMenuButtons() {		
		this.paging = (ManagementPaging) this.getManagement();
		this.tooltip = (ToolTipManagerPaging) paging.getToolTipManager();
		
		ImageIcon imgHelp = super.getImageIconHelp();
		
		lblStrategie = new JLabel(Labeling.STRATEGY+":");
		lblStrategie.setIcon(imgHelp);
		lblStrategie.setToolTipText(tooltip.getToolTipStrategy());
		
		lblReferenzfolge = new JLabel(Labeling.REFERENCE+":");
		lblReferenzfolge.setIcon(imgHelp);
		lblReferenzfolge.setToolTipText(tooltip.getToolTipReference());
		
		tfReferenzfolge = new JTextField();
		tfReferenzfolge.setColumns(10);
		
		cbStrategie = new ComboBoxStrategyImpl();
		
		lblRam = new JLabel(Labeling.COUNT_RAM+":");
		lblRam.setIcon(imgHelp);
		lblRam.setToolTipText(tooltip.getToolTipRam());
		
		lblDisk = new JLabel(Labeling.COUNT_DISK+":");
		lblDisk.setIcon(imgHelp);
		lblDisk.setToolTipText(tooltip.getToolTipDisk());
		
		tfDisk = new JTextField();
		tfDisk.setColumns(10);
		
		tfRam = new JTextField();
		tfRam.setColumns(10);
		
		lblErrorTitle = new JLabel(Labeling.COUNT_PAGING+":");		
		lblErrorTitle.setIcon(imgHelp);
		lblErrorTitle.setToolTipText(tooltip.getToolTipPagingError());
		lblErrorValue = new JLabel(" ");
		
		panel = new JPanel();
		panel.setBackground(this.getBackground());
		
		lblToolTipR = new JLabel(" ");
		lblToolTipR.setIcon(imgHelp);
		lblToolTipR.setToolTipText(tooltip.getToolTipR());
		
		btnR = new JButton(Labeling.RESET_R_BITS);		
		
		lblToolTipM = new JLabel(" ");
		lblToolTipM.setIcon(imgHelp);
		lblToolTipM.setToolTipText(tooltip.getToolTipM());
		
		btnM = new JButton(Labeling.SET_M_BIT);		
		
		lblOldStates = new JLabel(" ");
		lblOldStates.setIcon(imgHelp);
		lblOldStates.setToolTipText(tooltip.getToolTipOldStates());
		
		chckbxkOldStates = new JCheckBox(Labeling.OLD_STATES);
		chckbxkOldStates.setBackground(Color.WHITE);	
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
							.addComponent(lblErrorTitle)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblErrorValue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblReferenzfolge)
								.addComponent(lblStrategie))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(tfReferenzfolge, Alignment.LEADING)
								.addComponent(cbStrategie, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblRam, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblDisk, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(tfDisk, 0, 0, Short.MAX_VALUE)
						.addComponent(tfRam, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(this.btnAssumeExecute, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(this.btnExampleReset, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
					.addGap(194))
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStrategie)
						.addComponent(cbStrategie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfRam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRam)
						.addComponent(this.btnExampleReset))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblReferenzfolge)
						.addComponent(tfReferenzfolge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDisk)
						.addComponent(tfDisk, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(this.btnAssumeExecute))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblErrorTitle)
						.addComponent(lblErrorValue))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(176, Short.MAX_VALUE))
		);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblToolTipR)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnR, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblToolTipM)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnM, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblOldStates)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxkOldStates)
					.addContainerGap(230, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblToolTipR)
						.addComponent(btnR)
						.addComponent(btnM)
						.addComponent(lblOldStates)
						.addComponent(chckbxkOldStates)
						.addComponent(lblToolTipM))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);		
	}
	
	@Override
	protected void initMethodsMenuButtons() {
		ActionListener actionResetR = new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				paging.resetRBits();
				updatePanel();
			}
		};

		ActionListener actionSetM = new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				paging.setMBit();
				updatePanel();
			}
		};
		
		ActionListener actionOldStates = new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				paging.setViewOldStatesEnabled(chckbxkOldStates.isSelected());
				updatePanel();
			}
		};
		
		btnR.addActionListener(actionResetR);
		btnM.addActionListener(actionSetM);
		chckbxkOldStates.addActionListener(actionOldStates);
	}
	
	protected void loadExample() {
		tfReferenzfolge.setText("012340156012356");
		tfRam.setText("3");
		tfDisk.setText("4");
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
			MessageBox.showErrorMessage("");
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
			MessageBox.showErrorMessage(Labeling.WRONG_COUNT_RAM);
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
			MessageBox.showErrorMessage(Labeling.WRONG_COUNT_DISK);
			result = null;
		} finally {
			
		}
		return result;
	}		

	@Override
	public Integer getPanelHeight() {
		return 140;
	}

	@Override
	public Integer getPanelWidth() {
		return 660;
	}

	@Override
	protected void assume() {
		List<Integer> listSequence = inputReference();
		Integer ram = inputRAM();
		Integer disk = inputDISK();
		if ((listSequence != null) && (ram != null) && (disk != null)) {
			Integer sum = ram + disk;
			Integer size = listSequence.size();
			Boolean ok = true;
			if (sum > 14) {
				ok = false;
				MessageBox.showErrorMessage("Die Summe aus Anzahl von RAM und DISK is gr\u00f6\u00dfer als " + maxSumRamDisk +"!");
			}
			if (size > maxLengthReference) {
				ok = false;
				MessageBox.showErrorMessage("Die Referenzfolge hat mehr als " + maxLengthReference + " Stellen!");
			}
			if (ram.equals(0)) {
				ok = false;
				MessageBox.showErrorMessage("Die Anzahl des RAM muss mindestens 1 sein!");
			}
			if (ok) {
				paging.setStrategy(cbStrategie.getStrategy(), listSequence, ram, disk);
			}						
		}
	}

	@Override
	protected void clearFields() {
		
	}

	@Override
	protected void executeExtra() {
		
	}
}