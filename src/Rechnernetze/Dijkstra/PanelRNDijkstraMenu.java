package Rechnernetze.Dijkstra;

import Base.BasePanelMenu;
import Base.BasePanelModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

public class PanelRNDijkstraMenu extends BasePanelMenu {

	private IDijkstraManagement dijkstra;
	
	/**
	 * Create the panel.
	 */
	public PanelRNDijkstraMenu(IDijkstraManagement idijkstra, BasePanelModel model) {
		super(model);
		
		JButton btnNextStep = new JButton("n\u00E4chster Schritt");
		
		JButton btnReset = new JButton("zur\u00FCcksetzen");
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
		if (idijkstra == null) {
			idijkstra = new DijkstraManagement();
		}
		dijkstra = idijkstra;
	}

	@Override
	protected void initComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void updateComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initToolTips() {
		// TODO Auto-generated method stub
		
	}
}
