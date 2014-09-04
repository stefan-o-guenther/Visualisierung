/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Rechnernetze.Queueing_And_Loss;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.List;

import Base.ImageLoader;
import Base.PanelModelDrawAbstract;

public class PanelRNQueueingAndLossModelImpl extends PanelModelDrawAbstract {

	private static final long serialVersionUID = 1L;

	public PanelRNQueueingAndLossModelImpl(ManagementQueueingAndLoss qal) {
		super(qal);
	}
	
	private ManagementQueueingAndLoss qal;
	private Integer x = 300;
	private Integer y = 20;
	
	private BufferedImage getRouterImage() throws Exception {
		return ImageLoader.getBufferedImageRouter2();
	}
	
	private int packetWidth = 27;
	
	private void drawRect(int x, int y, Color color) {
		g2d.setColor(Color.BLACK);
		g2d.drawRect(x, y, packetWidth, packetWidth);
		g2d.setColor(color);
		g2d.fillRect(x+1, y+1, packetWidth-1, packetWidth-1);
	}
	
	private void drawRouter() {		
		try {
			g2d.drawImage(getRouterImage(), x, y, null);
			int maxRouter = qal.getMaxRouter();
			List<Packet> listRouter = qal.getListRouter();
			int size = listRouter.size();
			for (int i = 0; i < maxRouter; i++) {				
				Color color = Color.WHITE;
				if (i < size) {
					Packet packet = listRouter.get(i);
					color = packet.getColor(qal.getSurface());
				}
				int xp = x + 15 + ((maxRouter-1-i) * packetWidth);
				int yp = y + 120;
				drawRect(xp, yp, color);
			}			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void drawInput() {
		try {
			List<Packet> listInput = qal.getListInput();
			for (Packet packet : listInput) {
				int xp = x - 222 + packet.getPosition();
				int yp = y + 120;
				Color color = packet.getColor(qal.getSurface());
				drawRect(xp, yp, color);
			}
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	private void drawOutput() {
		try {
			List<Packet> listOutput = qal.getListOutput();
			for (Packet packet : listOutput) {
				int xp = x + 294 + packet.getPosition();
				int yp = y + 120;
				Color color = packet.getColor(qal.getSurface());
				drawRect(xp, yp, color);
			}
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	private void drawError() {
		try {
			List<Packet> listError = qal.getListError();
			for (Packet packet : listError) {
				int xp = x - 22;
				int yp = y + 120 + packet.getPosition();
				Color color = packet.getColor(qal.getSurface());
				drawRect(xp, yp, color);
			}
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@Override
	protected void doDrawing() {
		drawRouter();
		drawInput();
		drawOutput();
		drawError();
	}

	@Override
	protected void initComponents() {
		this.qal = (ManagementQueueingAndLoss) this.getManagement();
	}
}
