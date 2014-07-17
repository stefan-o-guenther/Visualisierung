/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.QAL_Old;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import Base.PanelModelDrawAbstract;

public class PanelRNQueueingAndLossModelImpl extends PanelModelDrawAbstract {

	public PanelRNQueueingAndLossModelImpl(ManagementQueueingAndLoss qal, ToolTipManagerQueueingAndLoss tooltip) {
		super(qal, tooltip);		
		this.initPanel();	
	}
	
	private ManagementQueueingAndLoss qal;
	
	@Override
	protected void doDrawing() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initComponents() {
		this.qal = (ManagementQueueingAndLoss) this.getManagement();
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
