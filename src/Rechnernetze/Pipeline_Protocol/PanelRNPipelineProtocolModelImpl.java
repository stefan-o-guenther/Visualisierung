/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Pipeline_Protocol;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.SwingUtilities;

import Base.Checker;
import Base.ManagementFactory;
import Base.PanelDrawingAbstract;

public class PanelRNPipelineProtocolModelImpl extends PanelDrawingAbstract {

	private static final long serialVersionUID = 1L;

	public PanelRNPipelineProtocolModelImpl() {
		super();
		this.createPanel();
	}
	
	private ManagementAutomaticRepeatRequest pipeline;
	
	protected Map<Rectangle2D, PacketArq> mapRectanglePacket;
	
	
	@Override
	protected void doDrawing() {
		if (pipeline != null) {
			this.mapRectanglePacket.clear();
			
			g2d.setColor(Color.BLACK);
			pipeline.setSize(this.getHeight(), this.getWidth());			
			
			this.drawSender();
			this.drawReceiver();			
			
			this.drawBoxSender();
			this.drawBoxReceiver();
			
			this.drawPackets();
			
			//this.drawPacket(0, minY, Color.BLUE);
			//this.drawPacket(0, maxY, Color.RED);
		}	
	}
	
	private void drawBoxSender() {
		Integer base = pipeline.getWindowSenderBase();
		Integer size = pipeline.getWindowSenderSize();
		if (size.intValue() >= 0) {
			this.drawBox(base, size, true);
		}
	}
	
	private void drawBoxReceiver() {
		Integer base = pipeline.getWindowReceiverBase();
		Integer size = pipeline.getWindowReceiverSize();
		if (size.intValue() >= 0) {
			this.drawBox(base, size, false);
		}
	}
	
	private void drawBox(Integer number, Integer length, Boolean isTop) {
		try {
			Checker.checkIfIntegerNotLessZero(number);
			Checker.checkIfIntegerNotLessZero(length);
			Checker.checkIfNotNull(isTop);
			
			if (length.intValue() > 0) {				
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
		} catch (Exception ex) {
			throw ex;
		}		
	}
	
	private void drawActor(Actor[] arrayActor, Color color, Boolean isSender) {
		Checker.checkIfNotNull(arrayActor);
		Checker.checkIfNotNull(color);
		Checker.checkIfNotNull(isSender);
		int boxH = pipeline.getPacketHeight().intValue();
		int minY = pipeline.getPositionY0().intValue();
		int maxY = pipeline.getPositionYMax().intValue();
		Integer positionBox;
		Integer positionNumber;
		if (isSender) {
			positionBox = minY - boxH;
			positionNumber = positionBox - 10;
		} else {
			positionBox = maxY + boxH;
			positionNumber = positionBox + boxH + 24;
		}
		for (int i = 0; i < arrayActor.length; i++) {
			Actor actor = arrayActor[i];
			Color colorBox = Color.WHITE;
			if (actor.hasReceived()) {
				colorBox = color;
			} else {
				colorBox = Color.WHITE;
			}
			this.drawRectangle(i, positionBox, colorBox);
			Color colorNumber = Color.BLACK;
			int extra = 2;
			if (i < 10) {
				extra = 7;
			}
			g2d.setColor(colorNumber);
			g2d.setFont(new Font(g2d.getFont().getFontName(), Font.BOLD, 16));
			g2d.drawString(i+"", pipeline.XToPositionX(i) + extra, positionNumber);
		}	
	}
	
	private void drawSender() {
		this.drawActor(pipeline.getArraySender(), pipeline.getColorSenderOk(), true);
	}
	
	private void drawReceiver() {
		this.drawActor(pipeline.getArrayReceiver(), pipeline.getColorReceiverOk(), false);
	}
	
	private void drawPackets() {
		List<PacketArq> listPacket = pipeline.getListPacket();
		for (PacketArq packet : listPacket) {
			Color color = Color.WHITE;
			if (packet.getPacketStatus() == EnumPacketStatus.OK) {
				switch (packet.getPacketType()) {
					case DATA: {
						color = pipeline.getColorData();
						break;
					}
					case ACK: {
						color = pipeline.getColorAck();
						break;
					}
					case NAK: {
						color = pipeline.getColorNak();
						break;
					}
					default: {
						color = Color.WHITE;
						break;
					}
				}
			} else {
				color = pipeline.getColorBroken();
			}
			Integer position = packet.getPosition();
			Integer y = pipeline.YToPositionY(position);
			Integer number = packet.getNumber();
			Rectangle2D rect = this.drawRectangle(number, y, color);
			this.mapRectanglePacket.put(rect, packet);
		}
	}	
	
	private Rectangle2D drawRectangle(Integer number, Integer y, Color color) {
		Integer h = pipeline.getPacketHeight();
		Integer w = pipeline.getPacketWidth();
		Integer x = pipeline.XToPositionX(number);
		g2d.setColor(Color.BLACK);
		Rectangle2D rect = new Rectangle2D.Float(x, y, w, h);
		g2d.draw(rect);
		g2d.setColor(color);
		g2d.fillRect(x+1, y+1, w-1, h-1);
		return rect;
	}	

	@Override
	protected void createDrawing() {
		this.pipeline = ManagementFactory.getManagementAutomaticRepeatRequest();
		this.mapRectanglePacket = new HashMap<Rectangle2D, PacketArq>();
		this.addMouseListener(new HitTestAdapter());
	}

	@Override
	public Integer getPanelHeight() {
		return 100;
	}

	@Override
	public Integer getPanelWidth() {
		return 100;
	}
	
	class HitTestAdapter extends MouseAdapter {	
		@Override
		public void mousePressed(MouseEvent e) {
			Boolean left = SwingUtilities.isLeftMouseButton(e);
			Boolean right = SwingUtilities.isRightMouseButton(e);
			Boolean middle = SwingUtilities.isMiddleMouseButton(e);
			
		    int x = e.getX();
		    int y = e.getY();
		    
		    List<Rectangle2D> list = new ArrayList<Rectangle2D>(mapRectanglePacket.keySet());
		    
		    for (Rectangle2D rect : list) {
		    	if (rect.contains(x, y)) {
		    		PacketArq packet = mapRectanglePacket.get(rect);		    		
			    	if (left) {
			    		pipeline.disablePacket(packet);
			    		repaint();
			    	} else if (right) {
			    		pipeline.deletePacket(packet);
			    		repaint();
			    	}	    	
			    	//color = Color.GRAY;
			        //rectAnimator = new RectRunnable();			    	
			    }
		    }		    
		}
	}
}
