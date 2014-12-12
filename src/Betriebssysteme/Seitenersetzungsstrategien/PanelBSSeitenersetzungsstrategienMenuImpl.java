/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

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
import Base.ManagementFactory;
import Base.MessageBox;
import Base.PanelMenuButtonsAbstract;

public class PanelBSSeitenersetzungsstrategienMenuImpl extends PanelMenuButtonsAbstract {;
	
private static final long serialVersionUID = 1L;

	public PanelBSSeitenersetzungsstrategienMenuImpl() {
		super(ManagementFactory.getManagementPaging());
		//this.initializeExtra();
		this.createPanel();
	}
	
	private void initializeExtra() {
		this.initButtons();
		this.createMenuComponentsExtra();
		this.createLayout();
	}	
	
	private void initButtons() {
		this.btnAssumeSaveExecute = new JButton("assume");
		this.btnExampleReset = new JButton("reset");
	}
	
	private final int maxSumRamDisk = 14;
	private final int maxLengthReference = 24;

	private JLabel lblStrategie;
	private JLabel lblReferenzfolge;
	private JLabel lblRam;
	private JLabel lblDisk;	
	
	private JTextField tfReferenzfolge;
	private JTextField tfDisk;
	private JTextField tfRam;
	
	private ComboBoxStrategyImpl cbStrategie;
	
	//private JButton btnAssumeSaveExecute;
	//private JButton btnExampleReset;
	
	private ManagementPaging paging;
	private ToolTipManagerPaging tooltip;
	
	@Override
	public void updatePanelExtra() {		
		lblStrategie.setEnabled(true);
		lblReferenzfolge.setEnabled(true);
		lblRam.setEnabled(true);
		lblDisk.setEnabled(true);
		EnumVisualizationStatus status = paging.getStatus();
		switch (status) {
			case START: {
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
	protected void createMenuComponentsExtra() {		
		this.paging = ManagementFactory.getManagementPaging();
		this.tooltip = ToolTipManagerPagingImpl.getInstance();
		
		ImageIcon imgHelp = super.getImageIconHelp();		
		
		lblStrategie = new JLabel(Labeling.STRATEGY+":");
		lblStrategie.setIcon(imgHelp);
		lblStrategie.setToolTipText(tooltip.getToolTipStrategy());
		
		lblReferenzfolge = new JLabel(LabelingPaging.REFERENCE+":");
		lblReferenzfolge.setIcon(imgHelp);
		lblReferenzfolge.setToolTipText(tooltip.getToolTipReference());
		
		tfReferenzfolge = new JTextField();
		tfReferenzfolge.setColumns(10);
		
		cbStrategie = new ComboBoxStrategyImpl();
		
		lblRam = new JLabel(LabelingPaging.COUNT_RAM+":");
		lblRam.setIcon(imgHelp);
		lblRam.setToolTipText(tooltip.getToolTipRam());
		
		lblDisk = new JLabel(LabelingPaging.COUNT_DISK+":");
		lblDisk.setIcon(imgHelp);
		lblDisk.setToolTipText(tooltip.getToolTipDisk());
		
		tfDisk = new JTextField();
		tfDisk.setColumns(10);
		
		tfRam = new JTextField();
		tfRam.setColumns(10);			
	}
	
	@Override
	protected void createLayout() {		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblStrategie, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblReferenzfolge, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(tfReferenzfolge)
						.addComponent(cbStrategie, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblRam, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblDisk, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(tfDisk, 0, 0, Short.MAX_VALUE)
						.addComponent(tfRam, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnAssumeSaveExecute, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnExampleReset, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
					.addContainerGap(219, Short.MAX_VALUE))
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
						.addComponent(btnExampleReset))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblReferenzfolge)
						.addComponent(tfReferenzfolge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDisk)
						.addComponent(btnAssumeSaveExecute)
						.addComponent(tfDisk, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(268, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	@Override
	protected void createMenuMethodsExtra() {
		
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
			MessageBox.showErrorMessage(LabelingPaging.WRONG_COUNT_RAM);
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
			MessageBox.showErrorMessage(LabelingPaging.WRONG_COUNT_DISK);
			result = null;
		} finally {
			
		}
		return result;
	}		

	@Override
	public Integer getPanelHeight() {
		return 75;
	}

	@Override
	public Integer getPanelWidth() {
		return 630;
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
				paging.assume(cbStrategie.getStrategy(), listSequence, ram, disk);
			}						
		}
	}

	@Override
	protected void clearFields() {
		
	}

	@Override
	protected void executeExtra() {
		
	}

	@Override
	protected Boolean hasExample() {
		return true;
	}

	@Override
	protected void input() {
		
	}
}