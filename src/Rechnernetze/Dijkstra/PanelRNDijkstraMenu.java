/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Rechnernetze.Dijkstra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Base.BasePanelMenu;
import Base.BasePanelModel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

public class PanelRNDijkstraMenu extends BasePanelMenu {

	private IDijkstraAlgorithm dijkstra;
	
	private JButton btnNextStep;
	private JButton btnReset;
	
	/**
	 * Create the panel.
	 */
	public PanelRNDijkstraMenu(IDijkstraAlgorithm idijkstra, BasePanelModel model) {
		super(model);
		if (idijkstra == null) {
			idijkstra = new DijkstraAlgorithm();
		}		
		dijkstra = idijkstra;
		initComponents();
		updateView();
	}

	@Override
	protected void initComponents() {
		btnNextStep = new JButton("n\u00E4chster Schritt");
		btnNextStep.addActionListener(ActionExecute);		
		btnReset = new JButton("zur\u00FCcksetzen");
		btnReset.addActionListener(ActionReset);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNextStep, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(182, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNextStep)
						.addComponent(btnReset))
					.addContainerGap(266, Short.MAX_VALUE))
		);
		setLayout(groupLayout);		
	}

	@Override
	protected void updateComponents() {		
		EnumDijkstraStatus status = dijkstra.getStatus();
		btnNextStep.setEnabled((status != EnumDijkstraStatus.FINISHED));
		btnReset.setEnabled(true);
	}

	@Override
	protected void initToolTips() {
		// TODO Auto-generated method stub
		
	}
	
	ActionListener ActionExecute = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			dijkstra.execute();
			updateView();
		}
	};

	ActionListener ActionReset = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			dijkstra.reset();
			updateView();
		}
	};
}
