/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra_Algorithmus.Version_A;

import javax.swing.JButton;

import Base.EnumVisualizationStatus;
import Base.Labeling;
import Base.PanelMenuButtonsAbstract;
import Rechnernetze.Dijkstra_Algorithmus.ManagementDijkstraAlgorithm;
import Rechnernetze.Dijkstra_Algorithmus.ManagementDijkstraAlgorithmImpl;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelRNDijkstraAlgorithmMenuImpl extends PanelMenuButtonsAbstract {

	private static final long serialVersionUID = 1L;

	public PanelRNDijkstraAlgorithmMenuImpl() {
		super(ManagementDijkstraAlgorithmImpl.getInstance());	
		//this.initializeExtra();
		this.createPanel();		
	}
	
	private void initializeExtra() {
		this.initializeButtons();
		this.createMenuComponentsExtra();
		this.createLayout();
	}
	
	private void initializeButtons() {
		this.btnExampleReset = new JButton(Labeling.LOAD_EXAMPLE);
		this.btnAssumeSaveExecute = new JButton(Labeling.ASSUME);		
	}
	
	// private JButton btnExampleReset;
	// private JButton btnAssumeSaveExecute;
	
	private ManagementDijkstraAlgorithm dijkstra;
	
	
	@Override
	protected void createMenuComponentsExtra() {
		dijkstra = ManagementDijkstraAlgorithmImpl.getInstance();
	}

	@Override
	protected void createMenuMethodsExtra() {
		
	}
	
	@Override
	protected void createLayout() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnAssumeSaveExecute, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnExampleReset, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
					.addContainerGap(318, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnExampleReset)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAssumeSaveExecute)
					.addContainerGap(237, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	@Override
	protected void updatePanelExtra() {
		EnumVisualizationStatus status = dijkstra.getStatus();
		if (status == EnumVisualizationStatus.START) {
			this.assume();
		}		
	}

	@Override
	protected void loadExample() {
		
	}

	@Override
	protected void assume() {
		dijkstra.assume("U", "Z");
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
		return 70;
	}
	
	@Override
	public Integer getPanelWidth() {
		return 150;
	}
}
