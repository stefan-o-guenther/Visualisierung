/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Queueing_And_Loss;

import java.awt.Color;
import java.awt.image.BufferedImage;

import Base.ImageLoader;
import Base.PanelModelDrawAbstract;

public class PanelRNQueueingAndLossModelImpl extends PanelModelDrawAbstract {

	public PanelRNQueueingAndLossModelImpl(ManagementQueueingAndLoss qal, ToolTipManagerQueueingAndLoss tooltip) {
		super(qal, tooltip);		
		this.initPanel();	
	}
	
	private ManagementQueueingAndLoss qal;
	
	private BufferedImage getRouterImage() throws Exception {
		return ImageLoader.getBufferedImageRouter2();
	}
	
	private void drawRouter() {		
		try {
			int x = 20;
			int y = 20;
			g2d.drawImage(getRouterImage(), x, y, null);
			g2d.setColor(Color.BLACK);
			g2d.drawRect(x+10, y+30, 20, 20);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	protected void doDrawing() {
		drawRouter();
		
	}

	@Override
	protected void initComponents() {
		this.qal = (ManagementQueueingAndLoss) this.getManagement();
	}
}
