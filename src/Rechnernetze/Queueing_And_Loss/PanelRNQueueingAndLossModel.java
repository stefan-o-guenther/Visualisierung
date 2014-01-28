/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

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
		super();		
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
	public void updateData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateModel() {
		// TODO Auto-generated method stub
		
	}

}
