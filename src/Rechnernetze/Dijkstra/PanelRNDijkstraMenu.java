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

import Base.BasePanelMenuAutomatic;
import Base.PanelAutomatic;

public class PanelRNDijkstraMenu extends BasePanelMenuAutomatic {

	public PanelRNDijkstraMenu(IDijkstraAlgorithm idijkstra) {
		super();
		if (idijkstra == null) {
			idijkstra = new DijkstraAlgorithm();
		}		
		dijkstra = idijkstra;
		initComponents();
		updateComponents();
	}

	private IDijkstraAlgorithm dijkstra;
	
	private JButton btnNextStep;
	private JButton btnReset;
	private PanelAutomatic panelAutomatic;
	
	@Override
	protected void initComponents() {
		btnNextStep = new JButton("n\u00e4chster Schritt");
		btnNextStep.addActionListener(ActionExecute);		
		btnReset = new JButton("zur\u00fccksetzen");
		btnReset.addActionListener(ActionReset);
		
		panelAutomatic = new PanelAutomatic(dijkstra, this, this.getBackground());
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNextStep, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(panelAutomatic, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNextStep)
						.addComponent(btnReset))
					.addContainerGap(88, Short.MAX_VALUE))
				.addComponent(panelAutomatic, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
		);
		setLayout(groupLayout);		
	}

	@Override
	protected void updateComponents() {
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
		return 100;
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
