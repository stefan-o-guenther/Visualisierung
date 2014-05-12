/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import Base.PanelMenuAutomaticAbstract;
import Base.PanelAutomaticImpl;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelRNDijkstraAlgorithmMenuImpl extends PanelMenuAutomaticAbstract {

	public PanelRNDijkstraAlgorithmMenuImpl(ManagementDijkstraAlgorithm dijkstra, ToolTipManagerDijkstraAlgorithm tooltip) {
		super(dijkstra, tooltip);
		this.dijkstra = dijkstra;
		initComponents();
		initLayout();
		updateComponents();
	}

	private ManagementDijkstraAlgorithm dijkstra;
	
	private JButton btnNextStep;
	private JButton btnReset;
	private PanelAutomaticImpl panelAutomatic;
	
	@Override
	protected void initComponents() {
		btnNextStep = new JButton("n\u00e4chster Schritt");
		btnNextStep.addActionListener(ActionExecute);		
		btnReset = new JButton("zur\u00fccksetzen");
		btnReset.addActionListener(ActionReset);
		
		panelAutomatic = new PanelAutomaticImpl(dijkstra, this, this.getBackground());		
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
	public void updateComponents() {
		Boolean notFinished = (dijkstra.getStatus() != EnumDijkstraStatus.FINISHED);
		panelAutomatic.setAutomaticEnabled(notFinished);				
		btnNextStep.setEnabled(notFinished);		
		btnReset.setEnabled(true);
		if (dijkstra.isAutomaticRunning()) {
			btnNextStep.setText("stop");
    	} else {
    		btnNextStep.setText("n\u00e4chster Schritt");
    	}
	}

	ActionListener ActionExecute = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			if (dijkstra.isAutomaticChecked()) {
				panelAutomatic.switchAutomatic();
			} else {
				dijkstra.execute();
			}			
			updateComponents();
		}
	};

	ActionListener ActionReset = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			dijkstra.reset();
			updateComponents();
		}
	};

	@Override
	public Integer getHeightMenu() {
		return 70;
	}

	@Override
	public void updateMenu() {
		updateComponents();
	}

	@Override
	public void error() {
		// nothing
	}
}
