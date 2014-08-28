/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.RenderingHints;
import java.util.List;

import Base.PanelModelDrawAbstract;

public class PanelBSBelegungsstrategienModelImpl extends PanelModelDrawAbstract {
	
	public PanelBSBelegungsstrategienModelImpl(ManagementFragmentation fragmentation, ToolTipManagerFragmentation tooltip) {
		super(fragmentation, tooltip);
	}
	
	@Override
	protected void initComponents() {
		this.fragmentation = (ManagementFragmentation) this.getManagement();
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
	
	private Integer widthMaximum = 1000;	
	private Dimension dim;
	
	private ManagementFragmentation fragmentation;
	
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
		
	private Integer getMultiply() {
		Integer sum = 0;
		List<Space> listSpace = fragmentation.getListSpace();
        for (Space space : listSpace) {
        	sum += space.getCurrentValue();
        }
        return widthMaximum / sum;
	}
	
	private void calculateValues(Space space) {
		try {
			if (space == null) {
				throw new NullPointerException();
			}
			Integer currentValue = space.getCurrentValue();
			width = currentValue * getMultiply();
			xValue = xRect + (width / 2) - 3;
			yValue = yRect + 50;
			yNV = yRect - 5;
			yRV = yRect + height + 15;
		} catch (Exception ex) {
			throw ex;
		}		
	}
	
	@Override
	protected void doDrawing() {
		try {			         	
    		initComponents();
    		
    		dim = this.getSize();    		
    		widthMaximum = dim.width;
    		
    		g2d.setColor(Color.BLACK);
    		
            RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHints(rh);
            
            BasicStroke bs2 = new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
            g2d.setStroke(bs2);                
            
            List<Space> listSpace = fragmentation.getListSpace();
            if (listSpace != null) {
            	for (Space space : listSpace) {        	
    				calculateValues(space);
    				
    				Color fontColor = space.getColorFont(fragmentation.getSurface());
    				    				
    				if (space.getType() == EnumSpace.EMPTY) {
    					SpaceEmpty spaceE = (SpaceEmpty) space;
    					// new number
    					if (spaceE.isNewValue()) {
        					Integer newValue = spaceE.getNewValue();
        					g2d.setColor(fontColor);
        					g2d.drawString((Integer.toString(newValue)), xValue, yNV);
        				}
    					// rest number
    					String rest = "";
    					if (spaceE.isRestValue()) {
    						Integer restValue = spaceE.getRestValue();
    						if (restValue >= 0) {
    							rest = restValue.toString();
    						} else {
    							rest = "-";
    						}
    					}    				   				
    					g2d.setColor(fontColor);				
    					g2d.drawString(rest, xValue, yRV);   					
    				}   				
    				
    				// rectangle border
    				g2d.setColor(Color.BLACK);
    				g2d.drawRect(xRect, yRect, width, height);	// x y width height
    				
    				g2d.setColor(space.getColorBox(fragmentation.getSurface()));
    				        	
    				g2d.fillRect(xRect+1, yRect+1, width-1, height-1);				
    				
    				if (space.getType() != EnumSpace.FULL) {
    					Integer currentValue = space.getCurrentValue();
    					g2d.setColor(fontColor);
    					g2d.drawString((Integer.toString(currentValue)), xValue, yValue);
    				}
    				xRect += width;
        		}
            }                		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    }
}