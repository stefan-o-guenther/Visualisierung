/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Queueing_And_Loss;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.List;

import Base.ImageLoader;
import Base.ManagementFactory;
import Base.PanelDrawingAbstract;

public class PanelRNQueueingAndLossModelImpl extends PanelDrawingAbstract {

	private static final long serialVersionUID = 1L;

	public PanelRNQueueingAndLossModelImpl() {
		super();
		this.createPanel();
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
			List<PacketQal> listRouter = qal.getListRouter();
			int size = listRouter.size();
			for (int i = 0; i < maxRouter; i++) {				
				Color color = Color.WHITE;
				if (i < size) {
					PacketQal packet = listRouter.get(i);
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
			List<PacketQal> listInput = qal.getListInput();
			for (PacketQal packet : listInput) {
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
			List<PacketQal> listOutput = qal.getListOutput();
			for (PacketQal packet : listOutput) {
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
			List<PacketQal> listError = qal.getListError();
			for (PacketQal packet : listError) {
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
	protected void createDrawing() {
		this.qal = ManagementFactory.getManagementQueueingAndLoss();
	}

	@Override
	public Integer getPanelHeight() {
		return 100;
	}

	@Override
	public Integer getPanelWidth() {
		return 100;
	}
}
