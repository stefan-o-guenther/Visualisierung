/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Pipeline_Protocol;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.SwingUtilities;

import Base.PanelDrawingAbstract;

public class PanelRNPipelineProtocolModelImpl extends PanelDrawingAbstract {

	private static final long serialVersionUID = 1L;

	public PanelRNPipelineProtocolModelImpl() {
		super();
		this.createPanel();
	}
	
	private ManagementARQ pipeline;
	//private Rectangle2D rect = new Rectangle2D.Float(10, 60, 20, 40);
	
	private Color color = Color.BLACK;
	
	
	@Override
	protected void doDrawing() {
		if (pipeline != null) {
			g2d.setColor(Color.BLACK);
			pipeline.setSize(this.getHeight(), this.getWidth());			
			
			this.drawSender();
			this.drawReceiver();
			
			this.drawBox(2, 5, true);
			this.drawBox(1, 1, false);
			
			this.drawPackets();
			
			//this.drawPacket(0, minY, Color.BLUE);
			//this.drawPacket(0, maxY, Color.RED);
			
			//g2d.draw(rect);
			//g2d.setColor(color);
			//g2d.fill(rect);
		}
		
		
		/*
		Packet packet = pipeline.getPacket();
		if (packet != null) {
			System.out.println("x");
			Rectangle2D rect = new Rectangle2D.Float(10, packet.getPosition(), 10, 10);
			g2d.setColor(Color.BLACK);
			g2d.fill(rect);
		}
		*/		
	}
	
	private void drawSender() {
		Integer boxH = pipeline.getPacketHeight();
		Integer minY = pipeline.getPositionY0();
		List<Boolean> listSender = pipeline.getListSender();
		for (int i = 0; i < listSender.size(); i++) {
			Boolean s = listSender.get(i);
			Color color = Color.WHITE;
			if (s) {
				color = Color.BLACK;
			}
			this.drawPacket(i, minY-boxH, color);
		}
	}
	
	private void drawReceiver() {
		Integer boxH = pipeline.getPacketHeight();
		Integer maxY = pipeline.getPositionYMax();
		List<Boolean> listReceiver = pipeline.getListReceiver();		
		for (int j = 0; j < listReceiver.size(); j++) {
			Boolean r = listReceiver.get(j);
			Color color = Color.WHITE;
			if (r) {
				color = Color.BLACK;
			}
			this.drawPacket(j, maxY+boxH, color);
		}
	}
	
	private void drawPackets() {
		List<Packet> listPacket = pipeline.getListPacket();
		for (Packet packet : listPacket) {
			Color color = Color.WHITE;
			if (packet.isOk()) {
				if (packet.getPacketType() == EnumPacketType.DATA) {
					color = Color.BLUE;
				} else if (packet.getPacketType() == EnumPacketType.ACK) {
					color = Color.RED;
				}
			} else {
				color = Color.GRAY;
			}
			Integer position = packet.getPosition();
			Integer y = pipeline.YToPositionY(position);
			Integer number = packet.getNumber();
			this.drawPacket(number, y, color);
		}
	}	
	
	private void drawBox(Integer number, Integer length, Boolean isTop) {
		Integer minY = pipeline.getPositionY0();
		Integer maxY = pipeline.getPositionYMax();
		Integer boxW = pipeline.getPacketWidth();
		Integer boxH = pipeline.getPacketHeight();
		Integer gap = pipeline.getGapBetweenPackets();
		Integer h = boxH + 10;
		Integer w = ((boxW * length) + ((length - 1) * gap) + 10);
		Integer x = pipeline.XToPositionX(number) - 5;
		Integer y = 0;
		if (isTop) {
			y = minY - boxH - 5;
		} else {
			y = maxY + boxH - 5;
		}
		g2d.setColor(Color.BLACK);
		g2d.drawRect(x, y, w, h);		
	}
	
	private void drawPacket(Integer number, Integer y, Color color) {
		Integer h = pipeline.getPacketHeight();
		Integer w = pipeline.getPacketWidth();
		Integer x = pipeline.XToPositionX(number);
		g2d.setColor(Color.BLACK);
		g2d.drawRect(x, y, w, h);
		g2d.setColor(color);
		g2d.fillRect(x+1, y+1, w-1, h-1);		
	}
	
	

	@Override
	protected void createDrawing() {
		this.pipeline = ManagementARQImpl.getInstance();
		//this.addMouseListener(new HitTestAdapter());
	}

	@Override
	public Integer getPanelHeight() {
		return 100;
	}

	@Override
	public Integer getPanelWidth() {
		return 100;
	}
	
	/*
	class HitTestAdapter extends MouseAdapter {	
		@Override
		public void mousePressed(MouseEvent e) {
			Boolean left = SwingUtilities.isLeftMouseButton(e);
			Boolean right = SwingUtilities.isRightMouseButton(e);
			Boolean middle = SwingUtilities.isMiddleMouseButton(e);
			
		    int count = e.getClickCount();
		    
		    
		    int x = e.getX();
		    int y = e.getY();
		
		    if (rect.contains(x, y)) {
		    	if (left) {
		    		if (count > 1) {
		    			color = Color.CYAN;
		    		} else {
		    			color = Color.BLUE;
		    		}		    		
		    	} else if (right) {
		    		if (count > 1) {
		    			color = Color.ORANGE;
		    		} else {
		    			color = Color.RED;
		    		}
		    	} else if (middle) {
		    		if (count > 1) {
		    			color = Color.MAGENTA;
		    		} else {
		    			color = Color.GREEN;
		    		}
		    	}
		    	
		    	
		    	//color = Color.GRAY;
		        //rectAnimator = new RectRunnable();
		    	
		    }
		    repaint();
		}
	}
	*/
}
