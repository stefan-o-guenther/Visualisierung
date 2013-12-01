package Betriebssysteme.Belegungsstrategien;



import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;



public class ModelBSBelegungsstrategien extends JPanel {
    
	
	private List<ISpace> listSpace = new ArrayList<ISpace>();
	private EnumSurface color = EnumSurface.COLORED;
	private final Integer MAX_WIDTH = 1000;
	
	
	public ModelBSBelegungsstrategien(List<ISpace> value) {
		if (value != null) {
			listSpace = value;
		} else {
			listSpace = new ArrayList<ISpace>();
		}
	}
	
	
	public void drawListSpace(List<ISpace> valueL, EnumSurface valueC) {
		if ((valueL != null) && (valueC != null)) {
			listSpace = valueL;
			color = valueC;
			Graphics g = getGraphics();
			doDrawing(g);
		}
	}
	
	
	
    private void doDrawing(Graphics g) {
    	try {
    		repaint();
        	
        	Graphics2D g2d = (Graphics2D) g;
    		
    		g2d.setColor(Color.BLACK);

            RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

            g2d.setRenderingHints(rh);
            
            BasicStroke bs2 = new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
            g2d.setStroke(bs2);       
            
            Integer xPoint = 0;
            Integer yPoint = 0;
            Integer xRect = xPoint + 0;
            Integer yRect = yPoint + 30;
            Integer xValue = 0;
            Integer yValue = 0;
            Integer yNV = 0;
            Integer yRV = 0;
            Integer width = 0;
            Integer height = 100;
            Integer times = 0;        
            
            Integer sum = 0;
            for (ISpace space : listSpace) {
            	sum += space.getCurrentValue();
            }        
            times = MAX_WIDTH / sum;
            
            if (listSpace != null) {
            	for (ISpace space : listSpace) {        	
                	Integer value = space.getCurrentValue();
                	width = value * times;
                	xValue = xRect + (width / 2) - 3;
                	yValue = yRect + 50;
                	yNV = yRect - 5;
                	yRV = yRect + height + 15;
                	
                	// new number
                	Integer nv = space.getNewValue();
                	if (nv != null) {
                		if (space.isActivated() && color == EnumSurface.COLORED) {
                    		g2d.setColor(Color.RED);
                    	} else {
                    		g2d.setColor(Color.BLACK);
                    	}
                		g2d.drawString((Integer.toString(nv)), xValue, yNV);
                	}       	
                	
                	// rectangle border
                	g2d.setColor(Color.BLACK);
                	g2d.drawRect(xRect, yRect, width, height);	// x y width height
                	
                	// rectangle filled
                	switch (color) {
        	        	case COLORED:
        	        		switch (space.getType()) {
        			        	case EMPTY:
        			        		g2d.setColor(Color.WHITE);
        			        		break;
        			        	case USED:
        			        		g2d.setColor(Color.CYAN);
        			        		break;
        			        	case FULL:
        			        		g2d.setColor(Color.BLACK);
        			        		break;
        			        	default:
        			        		break;        	
        		        	}
        	        		break;
        	        	case GRAY:
        	        		switch (space.getType()) {
        			        	case EMPTY:
        			        		g2d.setColor(Color.WHITE);
        			        		break;
        			        	case USED:
        			        		g2d.setColor(Color.LIGHT_GRAY);
        			        		break;
        			        	case FULL:
        			        		g2d.setColor(Color.BLACK);
        			        		break;
        			        	default:
        			        		break;        	
        		        	}
        	        		break;
                	}
                	        	
                	g2d.fillRect(xRect+1, yRect+1, width-1, height-1);
                	
                	if (space.isActivated() && color == EnumSurface.COLORED) {
                		g2d.setColor(Color.RED);
                	} else {
                		g2d.setColor(Color.BLACK);
                	}       	
                    g2d.drawString((Integer.toString(value)), xValue, yValue);
                    
                    // rest number
                	Integer rv = space.getRestValue();
                	if (rv != null) {
                		if (space.isActivated() && color == EnumSurface.COLORED) {
                    		g2d.setColor(Color.RED);
                    	} else {
                    		g2d.setColor(Color.BLACK);
                    	}
                		g2d.drawString((Integer.toString(rv)), xValue, yRV);
                	}            
                    
                    
                    xRect += width;
                }
            }
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}        
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        doDrawing(g);
    }    
}

