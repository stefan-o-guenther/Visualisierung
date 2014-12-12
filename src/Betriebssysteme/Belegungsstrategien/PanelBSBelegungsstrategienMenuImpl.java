/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

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

public class PanelBSBelegungsstrategienMenuImpl extends PanelMenuButtonsAbstract {

	private static final long serialVersionUID = 1L;
	
	public PanelBSBelegungsstrategienMenuImpl() {
		super(ManagementFactory.getManagementFragmentation());
		//this.initializeExtra();
		this.createPanel();
	}
	
	private void initializeExtra() {
		this.btnAssumeSaveExecute = new JButton(this.getBtnExecuteText());
		this.btnExampleReset = new JButton(this.getBtnExampleText());
		this.createMenuComponentsExtra();
		this.createLayout();
	}
	
	private ManagementFragmentation fragmentation;
	private ToolTipManagerFragmentation tooltip;
	
	private JLabel lblStrategy;
	private JLabel lblSpace;
	private JLabel lblGeneralStorage;
	
	private ComboBoxStrategy cbStrategy;
	
	private JTextField tfSpace;
	private JTextField tfGeneralStorage;
	
	//private JButton btnExampleReset;
	//private JButton btnAssumeSaveExecute;
	
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
	protected void updatePanelExtra() {
    	lblStrategy.setEnabled(true);
    	lblSpace.setEnabled(true);
    	
    	EnumVisualizationStatus status = fragmentation.getStatus();    	
    	switch (status) {
	    	case START: {
	    		tfGeneralStorage.setEnabled(true);
	    		tfGeneralStorage.setEditable(true);
	    		cbStrategy.setEnabled(true);
	        	tfSpace.setEnabled(false);
	        	tfSpace.setEditable(false);
	        	tfSpace.setText("");      	
	        	break;
	    	}
	    	case INPUT: {
	    		tfGeneralStorage.setEnabled(false);
	    		tfGeneralStorage.setEditable(false);
	    		cbStrategy.setEnabled(false);
	        	tfSpace.setEnabled(true);
	        	tfSpace.setEditable(true);
	        	break;
	    	}
	    	case RUN: {
	    		tfGeneralStorage.setEnabled(false);
	    		tfGeneralStorage.setEditable(false);
	    		cbStrategy.setEnabled(false);
	        	tfSpace.setEnabled(false);
	        	tfSpace.setEditable(false);
	        	break;
	    	}
	    	case NEXT: {
	    		tfGeneralStorage.setEnabled(false);
	    		tfGeneralStorage.setEditable(false);
	    		cbStrategy.setEnabled(false);
	        	tfSpace.setEnabled(false);
	        	tfSpace.setEditable(false);
	        	tfSpace.setText("");
	        	break;
	    	}
	    	case FINISHED: {
	    		tfGeneralStorage.setEnabled(false);
	    		tfGeneralStorage.setEditable(false);
	    		cbStrategy.setEnabled(false);
	        	tfSpace.setEnabled(false);
	        	tfSpace.setEditable(false);
	        	tfSpace.setText("");
	        	break;
	    	}
	    	default: {
	    		break;
	    	}
    	}
	}	
	
	@Override
	protected void createMenuComponentsExtra() {
		fragmentation = ManagementFactory.getManagementFragmentation();
		tooltip = ToolTipManagerFragmentationImpl.getInstance();
		
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
	}	
	
	@Override
	protected void createLayout() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSpace, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblGeneralStorage, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblStrategy))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(cbStrategy, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfSpace)
						.addComponent(tfGeneralStorage))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnAssumeSaveExecute, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnExampleReset, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
					.addContainerGap(227, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGeneralStorage, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfGeneralStorage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExampleReset))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStrategy, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbStrategy, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAssumeSaveExecute))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSpace, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfSpace, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(208, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	@Override
	protected void createMenuMethodsExtra() {
		
	}
	
	@Override
	public Integer getPanelHeight() {
		return 100;
	}	

	@Override
	public Integer getPanelWidth() {
		return 470;
	}

	@Override
	protected void loadExample() {
		try {
			tfGeneralStorage.setText("10,4,20,18,7,9,12,15");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	protected void input() {
		try {
			String text = tfSpace.getText();
			Integer space = new Integer(text);
			fragmentation.inputNumber(space);	
		} catch (Exception ex) {
			tfSpace.setText("");
			MessageBox.showErrorMessage("Keine ganze Zahl eingebeben!");
		}
	}
	
	@Override
	protected void assume() {
		List<Integer> listGeneralStorage = getGeneralStorage();
		if ((listGeneralStorage != null) && (listGeneralStorage.size() > 0)) {						
			// Strategie festlegen
			fragmentation.assume(cbStrategy.getStrategy(), getGeneralStorage());
		}
	}

	@Override
	protected void clearFields() {
		// this.tfGeneralStorage.setText("");
		this.tfSpace.setText("");
	}

	@Override
	protected void executeExtra() {
		
	}

	@Override
	protected Boolean hasExample() {
		return true;
	}
	
	protected String getBtnExampleText() {
		return "Fragmentierung laden";
	}
}
