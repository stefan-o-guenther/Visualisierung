/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Queueing_And_Loss;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import Base.BasePanelModelDraw;

public class PanelRNQueueingAndLossModel extends BasePanelModelDraw {

	private IQALManagement qal;
	
	/**
	 * Create the panel.
	 */
	public PanelRNQueueingAndLossModel(IQALManagement qal) {
		super(qal);		
		this.qal = qal;
		putModelToManagement();
	}
	
	@Override
	public void doDrawing(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateModel() {
		repaint();
	}
	
	public void paint (Graphics g) {
		update(g); // eliminate flashing : update is overriden
	}
	
	public void update (Graphics g) {
		//work on a offscreen image
		Dimension offDimension = getSize();
		Image offImage = createImage(offDimension.width, offDimension.height);
		Graphics offGraphics = offImage.getGraphics();
		qal.draw(offGraphics);
		g.drawImage(offImage, 0, 0, this);
	}
}
