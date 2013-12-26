package Rechnernetze.Queueing_And_Loss;

import java.awt.Graphics;

import Base.BasePanelModelDraw;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class PanelRNQueueingAndLossModel extends BasePanelModelDraw {

	private IQALManagement qal;
	
	/**
	 * Create the panel.
	 */
	public PanelRNQueueingAndLossModel(IQALManagement iqal) {
		
		JLabel lblRouter = new JLabel("");
		lblRouter.setIcon(new ImageIcon("C:\\Eclipse\\Workspace\\Visualisierung\\img\\router.png"));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(106)
					.addComponent(lblRouter)
					.addContainerGap(124, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(72)
					.addComponent(lblRouter)
					.addContainerGap(79, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		if (iqal == null) {
			iqal = new QALManagement();
		}
		qal = iqal;
	}

	@Override
	protected void doDrawing(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
