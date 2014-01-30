/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;

import Base.BasePanelModelDraw;
import Base.EnumSurface;

public class PanelBSBelegungsstrategienModel extends BasePanelModelDraw {
	
	public PanelBSBelegungsstrategienModel(IMemoryManagement imemory) {
		super();
		if (imemory == null) {
			imemory = new MemoryManagement();
		}
		memory = imemory;
	}
	
	private Integer widthMaximum = 1000;	
	private Dimension dim;
	
	private IMemoryManagement memory;
	
	private Graphics2D g2d;
	
	private Integer xPoint;
	private Integer yPoint;
	private Integer xRect;
	private Integer yRect;
	private Integer xValue;
	private Integer yValue;
	private Integer yNV;
	private Integer yRV;
	private Integer width;
	private Integer height;
	
	private List<ISpace> listSpace;
	private EnumSurface surface;
	
	private void initValues() {
		xPoint = 0;
		yPoint = 0;
		xRect = xPoint + 5;
		yRect = yPoint + 30;
		xValue = 0;
		yValue = 0;
		yNV = 0;
		yRV = 0;
		width = 0;
		height = 100;		       
	}
	
	private Integer getMultiply() {
		Integer sum = 0;  
        for (ISpace space : listSpace) {
        	sum += space.getCurrentValue();
        }
        return widthMaximum / sum;
	}
	
	private Color getBoxColor(ISpace space) {		
		return memory.getColor(space.getType());
	}
	
	private void calculateValues(ISpace space) {
		Integer currentValue = space.getCurrentValue();
		width = currentValue * getMultiply();
		xValue = xRect + (width / 2) - 3;
		yValue = yRect + 50;
		yNV = yRect - 5;
		yRV = yRect + height + 15;
	}
	
	private Color getFontColor(ISpace space) {
		Color color = Color.BLACK;
		if (space.isActivated() && surface == EnumSurface.COLORED) {
			color = Color.RED;
		}
		return color;
	}	
	
	@Override
	protected void updateData() {
		listSpace = memory.getListSpace();            
        surface = memory.getSurface();         
	}
		
	protected void doDrawing(Graphics g) {
		try {			         	
    		g2d = (Graphics2D) g;		
    		
    		initValues();
    		
    		dim = this.getSize();    		
    		widthMaximum = dim.width;
    		
    		g2d.setColor(Color.BLACK);
    		
            RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHints(rh);
            
            BasicStroke bs2 = new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
            g2d.setStroke(bs2);                
            
            for (ISpace space : listSpace) {        	
				calculateValues(space);
				
				Color fontColor = getFontColor(space);
				
				// new number
				Integer newValue = space.getNewValue();
				if (newValue != null) {					
					g2d.setColor(fontColor);
					g2d.drawString((Integer.toString(newValue)), xValue, yNV);					
				}
				
				// rectangle border
				g2d.setColor(Color.BLACK);
				g2d.drawRect(xRect, yRect, width, height);	// x y width height
				
				g2d.setColor(getBoxColor(space));
				        	
				g2d.fillRect(xRect+1, yRect+1, width-1, height-1);				
				
				if (space.getType() != EnumSpace.FULL) {
					Integer currentValue = space.getCurrentValue();
					g2d.setColor(fontColor);
					g2d.drawString((Integer.toString(currentValue)), xValue, yValue);
				}                    
			    
			    // rest number
				Integer restValue = space.getRestValue();
				if (restValue != null) {
					g2d.setColor(fontColor);
					String rest = "";
					if (restValue >= 0) {
						rest = restValue.toString();
					} else {
						rest = "-";
					}
					g2d.drawString(rest, xValue, yRV);
				}
				xRect += width;
    		}    		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    }

	@Override
	public void updateModel() {		
		updateData();
		repaint();
	}
}

