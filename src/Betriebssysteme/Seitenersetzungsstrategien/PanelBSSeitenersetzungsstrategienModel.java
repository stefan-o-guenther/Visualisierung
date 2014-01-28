/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import Base.BasePanelModelDraw;
import Base.EnumSurface;

public class PanelBSSeitenersetzungsstrategienModel extends BasePanelModelDraw {
	
	private final Integer LENGTH_BOX = 35;
	private final Integer WIDTH_LABEL = 80;
	private final Integer X_FIRST = 5;
	private final Integer Y_FIRST = 30;	
	private final Integer GAP = 5;
	
	private Integer maxRam = 3;
	private Integer maxDisk = 3;
	
	private IMemoryManager paging;
	
	private Graphics2D g2d;	
	
	private List<ICacheBox> listCache = new ArrayList<ICacheBox>();
	
	private EnumSurface surface;
		
	public PanelBSSeitenersetzungsstrategienModel(IMemoryManager ipaging) {
		super();
		if (ipaging == null) {
			ipaging = new MemoryManager();
		}
		paging = ipaging;		
	}	
		
	private void labelX(String text, Integer countX, Boolean gapX) {
		Integer x = X_FIRST + WIDTH_LABEL + (LENGTH_BOX*countX);
		if (gapX) {
			x += GAP;
		}
        Integer y = Y_FIRST-30;        
        
        Font font = g2d.getFont();
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font(font.getFontName(), Font.BOLD, 18));        
        g2d.drawString(text, x+13, y+25);
	}	
		
	private void labelY(String text, Integer countY, Boolean gapY) {		
		Integer w = WIDTH_LABEL;
        Integer h = LENGTH_BOX;
        Integer x = X_FIRST;
        Integer y = Y_FIRST+(h*countY);
        if (gapY) {
        	y += GAP;
        }
        Font font = g2d.getFont();
        g2d.setColor(Color.BLACK);
        g2d.drawRect(x, y, w, h);
               
        g2d.setFont(new Font(font.getFontName(), Font.BOLD, 18));        
        g2d.drawString(text, x+10, y+25);
        
        if (paging.useRM()) {
        	g2d.setFont(new Font(font.getFontName(), Font.BOLD, 10));
            g2d.drawString("R", x+w-15, y+12);
            g2d.drawString("M", x+w-15, y+h-3);		
        }        
	}
	
	private void drawEmptyBox(Integer x, Integer y) {
		g2d.setColor(Color.BLACK);
		g2d.drawRect(x, y, LENGTH_BOX, LENGTH_BOX);
	}
	
	private Integer getGap(Boolean gap) {
		if (gap) {
			return GAP;
		} else {
			return 0;
		}
	}
	
	private Integer getX(Integer countX, Boolean gapX) {
		return (X_FIRST + WIDTH_LABEL + (LENGTH_BOX * countX) + (getGap(gapX)));	
	}
	
	private Integer getY(Integer countY, Boolean gapY) {
		return (Y_FIRST + (LENGTH_BOX * countY) + (getGap(gapY)));
	}
	
	private void boxEmpty(Integer countX, Integer countY, Boolean gapX, Boolean gapY) {
		if ((countX != null) && (countY != null) && (gapY != null)) {
			Integer x = getX(countX, gapX);			
	        Integer y = getY(countY, gapY);
			drawEmptyBox(x, y);	
		}
	}
	
	
	private void boxFull(Integer number, Integer r, Integer m, Integer countX, Integer countY, Boolean gapX, Boolean gapY, EnumCache status) {
		if ((number != null) && (r != null) && (m != null) && (countX != null) && (countY != null) && (gapY != null)) {
			Integer x = getX(countX, gapX);			
	        Integer y = getY(countY, gapY);
	        drawEmptyBox(x, y);	
	        
	        String sZ = "";
	        if (number >= 0) {
	        	sZ = number.toString();
	        }
	        String sM = "";
	        if (m >= 0) {
	        	sM = m.toString();
	        }
	        String sR = "";
	        if (r >= 0) {
	        	sR = r.toString();
	        }	        
	        
	        Font font = g2d.getFont();			
			
			// Zahl
	        g2d.setColor(Color.BLACK);
	        g2d.setFont(new Font(font.getFontName(), Font.BOLD, 18));
	        g2d.drawString(sZ, x+13, y+25);
	        
	        
	        
	        // r und m	        
	        if ((!(gapY)) && (paging.useRM())) {
	        	g2d.setColor(Color.BLACK);
	        	g2d.setFont(new Font(font.getFontName(), Font.BOLD, 10));
	        	g2d.drawString(sR, x+4, y+12);
	        	g2d.drawString(sM, x+4, y+LENGTH_BOX-3); 
	        }
		        
	        
	        	                
	        switch (surface) {
		        case COLORED: {
		        	g2d.setColor(Color.RED);
		        	break;
		        }
		        case GRAY: {
		        	g2d.setColor(Color.BLACK);
		        	break;
		        }
		        default: {
		        	break;
		        }
	        }	        
	        switch (status) {
	        	case OVERWRITE: {
	        		g2d.drawOval(x+8, y+8, LENGTH_BOX-15, LENGTH_BOX-15);
	        		break;
	        	}
		        case NEW: {		        	
		        	g2d.drawRect(x+10, y+9, LENGTH_BOX-19, LENGTH_BOX-17);
		        	break;
		        }
		        default: {
		        	break;
		        }
	        }
		}		       
	}	
	
	

	protected void doDrawing(Graphics g) {		
        g2d = (Graphics2D) g;       
        
        updateData();
        
        Font font = g2d.getFont();
        
        g2d.setFont(new Font(font.getFontName(), Font.BOLD, 18)); 
        
        Integer size = listCache.size();        
        
        // RAM
        for (Integer r = 0; r < maxRam; r++) {
        	labelY("RAM", r, false);
        }
        
        // DISK
        for (Integer d = maxRam; d < (maxDisk + maxRam); d++) {
        	labelY("DISK", d, true);        	
        }
        
        // X und Felder
        for (Integer c = 0; c < size; c++) {
        	
        	Boolean gapX = false;
        	if (c >= maxRam) {
        		gapX = true;
        	}
        	
        	// X
        	ICacheBox cb = listCache.get(c);
        	Integer z = cb.getNumber();
        	
        	labelX(z.toString(), c, gapX);
        	
        	// box RAM
        	List<ICache> listRam = cb.getRam();        	
    		for (Integer r = 0; r < maxRam; r++) {
    			if (listRam.size() > r) {
    				ICache v = listRam.get(r);
    				boxFull(v.getNumber(), v.getR(), v.getM(), c, r, gapX, false, v.getStatus());
    			} else {    				
    				boxEmpty(c, r, gapX, false);
    			}
            }       	       	   
            
            // box DISK
        	List<ICache> listDisk = cb.getDisk();        	
    		for (Integer d = 0; d < maxDisk; d++) {
    			if (listDisk.size() > d) {
    				ICache v = listDisk.get(d);
        			boxFull(v.getNumber(), v.getR(), v.getM(), c, d + maxRam, gapX, true, v.getStatus());
    			} else {
    				boxEmpty(c, (d + maxRam), gapX, true);
    			}    			
    		}        	        	
        }
    }

	@Override
	protected void updateData() {
		listCache = paging.getListCache();
		maxRam = paging.getMaxRam();
		maxDisk = paging.getMaxDisk();
		surface = paging.getSurface();
	}

	@Override
	public void updateModel() {
		repaint();
	} 
}
