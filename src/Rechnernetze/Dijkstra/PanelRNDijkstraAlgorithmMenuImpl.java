/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import Base.Labeling;
import Base.PanelMenuAutomaticAbstract;
import Base.PanelAutomaticAbstract;

import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelRNDijkstraAlgorithmMenuImpl extends PanelMenuAutomaticAbstract {

	public PanelRNDijkstraAlgorithmMenuImpl(ManagementDijkstraAlgorithm dijkstra, ToolTipManagerDijkstraAlgorithm tooltip) {
		super(dijkstra, tooltip);
		this.initPanel();
	}

	private ManagementDijkstraAlgorithm dijkstra;
	
	private JButton btnNextStep;
	private JButton btnReset;
	private PanelAutomaticAbstract panelAutomatic;
	
	@Override
	protected void initComponents() {
		this.dijkstra = (ManagementDijkstraAlgorithm) this.getManagement();
		
		btnNextStep = new JButton(Labeling.NEXT_STEP);
		btnNextStep.addActionListener(ActionExecute);		
		btnReset = new JButton(Labeling.RESET);
		btnReset.addActionListener(ActionReset);
		
		panelAutomatic = new PanelRNDijkstraAlgorithmAutomaticImpl(dijkstra);		
	}

	@Override
	protected void initLayout() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNextStep, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelAutomatic, GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNextStep)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnReset)
					.addContainerGap(59, Short.MAX_VALUE))
				.addComponent(panelAutomatic, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
		);
		setLayout(groupLayout);		
	}

	@Override
	public void updatePanel() {
		Boolean notFinished = (dijkstra.getStatus() != EnumDijkstraStatus.FINISHED);
		panelAutomatic.setAutomaticEnabled(notFinished);				
		btnNextStep.setEnabled(notFinished);		
		btnReset.setEnabled(true);
		btnNextStep.setText(dijkstra.getButtonAutomaticText());
	}

	ActionListener ActionExecute = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			executeManualAutomatic();
			//updatePanel();
		}
	};

	ActionListener ActionReset = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			dijkstra.reset();
			updatePanel();
		}
	};

	@Override
	public Integer getHeightMenu() {
		return 70;
	}
}
