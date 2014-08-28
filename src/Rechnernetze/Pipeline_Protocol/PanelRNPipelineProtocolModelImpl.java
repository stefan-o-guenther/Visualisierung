/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Pipeline_Protocol;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import Base.PanelModelDrawAbstract;

public class PanelRNPipelineProtocolModelImpl extends PanelModelDrawAbstract {

	public PanelRNPipelineProtocolModelImpl(ManagementPipelineProtocol pipeline, ToolTipManagerPipelineProtocol tooltip) {
		super(pipeline, tooltip);
	}
	
	private ManagementPipelineProtocol pipeline;
	private Integer gap = 10;
	private Rectangle2D rect = new Rectangle2D.Float(10, 60, 20, 40);
	
	private Color color = Color.BLACK;
	
	
	@Override
	protected void doDrawing() {
		if (pipeline != null) {
			g2d.setColor(Color.BLACK);
			pipeline.setSize(this.getHeight(), this.getWidth());
			
			Integer boxH = 40;
			Integer boxW = 20;
			Integer minX = 10;
			Integer minY = 10;
			Integer maxY = this.getHeight() - 10 - boxH;
			
			
			Integer count = pipeline.getCount();
			for (Integer i = 0; i < count; i++) {
				g2d.drawRect(minX+(i*(boxW+gap)), minY, boxW, boxH);
			}
			for (Integer i = 0; i < count; i++) {
				g2d.drawRect(minX+(i*(boxW+gap)), maxY, boxW, boxH);
			}
			g2d.drawRect(minX-5, minY-5, ((boxW * 5) + (4 * gap) + 10), 50);
			g2d.drawRect(minX-5, maxY-5, 30, 50);
			
			
			//g2d.draw(rect);
			g2d.setColor(color);
			g2d.fill(rect);
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

	@Override
	protected void initComponents() {
		this.pipeline = (ManagementPipelineProtocol) this.getManagement();
		this.addMouseListener(new HitTestAdapter());
	}
	
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
}
