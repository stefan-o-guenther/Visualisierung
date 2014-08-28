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
	}
	
	private ManagementQueueingAndLoss qal;
	private Integer x = 300;
	private Integer y = 20;
	
	private BufferedImage getRouterImage() throws Exception {
		return ImageLoader.getBufferedImageRouter2();
	}
	
	private void drawRouter() {		
		try {
			g2d.drawImage(getRouterImage(), x, y, null);			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void drawRect(int x, int y, Color color) {
		g2d.setColor(Color.BLACK);
		g2d.drawRect(x, y, 30, 30);
		g2d.setColor(color);
		g2d.fillRect(x+1, y+1, 29, 29);
	}
	
	@Override
	protected void doDrawing() {
		drawRouter();
		int z = qal.getMaxRouter();
		int yp = 120;
		for (int i = 0; i < z; i++) {
			drawRect(x+14+(i*30), y+yp, Color.WHITE);
		}
	}

	@Override
	protected void initComponents() {
		this.qal = (ManagementQueueingAndLoss) this.getManagement();
	}
}
