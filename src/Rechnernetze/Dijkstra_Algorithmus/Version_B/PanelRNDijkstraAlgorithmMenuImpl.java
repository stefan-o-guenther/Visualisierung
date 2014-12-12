/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra_Algorithmus.Version_B;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Base.EnumVisualizationStatus;
import Base.Labeling;
import Base.ManagementFactory;
import Base.PanelMenuButtonsAbstract;
import Rechnernetze.Dijkstra_Algorithmus.ManagementDijkstraAlgorithm;
import Rechnernetze.Dijkstra_Algorithmus.ToolTipManagerDijkstraAlgorithm;
import Rechnernetze.Dijkstra_Algorithmus.ToolTipManagerDijkstraAlgorithmImpl;

public class PanelRNDijkstraAlgorithmMenuImpl extends PanelMenuButtonsAbstract {

	private static final long serialVersionUID = 1L;

	public PanelRNDijkstraAlgorithmMenuImpl() {
		super(ManagementFactory.getManagementDijkstraAlgorithm());		
		//this.initializeExra();
		this.createPanel();
	}
	
	private void initializeExra() {
		this.initButtons();
		this.createMenuComponentsExtra();
		this.createLayout();
	}
	
	private void initButtons() {
		this.btnExampleReset = new JButton(Labeling.LOAD_EXAMPLE);
		this.btnAssumeSaveExecute = new JButton(Labeling.ASSUME);		
	}
	
	//private JButton btnExampleReset;
	//private JButton btnAssumeSaveExecute;
	
	private JLabel lblStart;
	private JLabel lblTarget;
	private ComboBoxNodeNames cbStart;
	private ComboBoxNodeNames cbTarget;
	
	private ManagementDijkstraAlgorithm dijkstra;
	private ToolTipManagerDijkstraAlgorithm tooltip;
	private JTextField textField;
	
	@Override
	protected void createMenuComponentsExtra() {
		dijkstra = ManagementFactory.getManagementDijkstraAlgorithm();
		tooltip = ToolTipManagerDijkstraAlgorithmImpl.getInstance();
		
		ImageIcon imgHelp = super.getImageIconHelp();
		
		lblStart = new JLabel("Start:");
		lblStart.setIcon(imgHelp);
		lblStart.setToolTipText(tooltip.getToolTipStart());
		
		lblTarget = new JLabel("Ziel:");
		lblTarget.setIcon(imgHelp);
		lblTarget.setToolTipText(tooltip.getToolTipTarget());
		
		cbStart = new ComboBoxNodeNames();		
		cbStart.setSelectedIndex(0);
		cbTarget = new ComboBoxNodeNames();	
		cbTarget.setSelectedIndex(5);
	}

	@Override
	protected void createMenuMethodsExtra() {
		
	}
	
	@Override
	protected void createLayout() {
		
		JLabel lblEdge = new JLabel("Achse:");
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		
		JButton btnChangeWeight = new JButton("\u00E4ndern");
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnExampleReset, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblStart)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cbStart, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnAssumeSaveExecute, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(86)
											.addComponent(textField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnChangeWeight, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblTarget, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(cbTarget, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblEdge)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))
					.addGap(270))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnExampleReset)
						.addComponent(lblStart)
						.addComponent(cbStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAssumeSaveExecute)
						.addComponent(lblTarget)
						.addComponent(cbTarget, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEdge)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnChangeWeight)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(208, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	@Override
	protected void updatePanelExtra() {
		EnumVisualizationStatus status = dijkstra.getStatus();
		Boolean enabled = (status == EnumVisualizationStatus.START);
		this.cbStart.setEnabled(enabled);
		this.cbTarget.setEnabled(enabled);
	}

	@Override
	protected void loadExample() {
		
	}

	@Override
	protected void assume() {
		String nameStart = cbStart.getNodeName();
		String nameTarget = cbTarget.getNodeName();
		dijkstra.assume(nameStart, nameTarget);		
	}

	@Override
	protected void input() {
		
	}

	@Override
	protected void clearFields() {
		
	}

	@Override
	protected void executeExtra() {
		
	}

	@Override
	protected Boolean hasExample() {
		return false;
	}

	@Override
	public Integer getPanelHeight() {
		return 80;
	}
	
	@Override
	public Integer getPanelWidth() {
		return 270;
	}
}
