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
	
	private IMemoryManager paging;
	
	private Graphics2D G2D; // = (Graphics2D) getGraphics();
	//private Font FONT = G2D.getFont();
	
	private Integer LENGTH_BOX;
	private Integer WIDTH_LABEL;
	private Integer X_FIRST;
	private Integer Y_FIRST;	
	private Integer GAP;
	
	private List<ICacheBox> listCache = new ArrayList<ICacheBox>();
	private Integer maxRam = 3;
	private Integer maxDisk = 3;
	private EnumSurface surface;
	
	public PanelBSSeitenersetzungsstrategienModel(IMemoryManager ipaging) {
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
        
        Font font = G2D.getFont();
        G2D.setColor(Color.BLACK);
        G2D.setFont(new Font(font.getFontName(), Font.BOLD, 18));        
        G2D.drawString(text, x+13, y+25);
	}	
		
	private void labelY(String text, Integer countY, Boolean gapY) {		
		Integer w = WIDTH_LABEL;
        Integer h = LENGTH_BOX;
        Integer x = X_FIRST;
        Integer y = Y_FIRST+(h*countY);
        if (gapY) {
        	y += GAP;
        }
        Font font = G2D.getFont();
        G2D.setColor(Color.BLACK);
        G2D.drawRect(x, y, w, h);
               
        G2D.setFont(new Font(font.getFontName(), Font.BOLD, 18));        
        G2D.drawString(text, x+10, y+25);
        
        G2D.setFont(new Font(font.getFontName(), Font.BOLD, 10));
        G2D.drawString("R", x+w-15, y+12);
        G2D.drawString("M", x+w-15, y+h-3);		
	}
	
	private void drawEmptyBox(Integer x, Integer y) {
		G2D.setColor(Color.BLACK);
		G2D.drawRect(x, y, LENGTH_BOX, LENGTH_BOX);
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
	        
	        Font font = G2D.getFont();			
			
			// Zahl
	        G2D.setColor(Color.BLACK);
	        G2D.setFont(new Font(font.getFontName(), Font.BOLD, 18));
	        G2D.drawString(sZ, x+13, y+25);
	        
	        
	        
	        // r und m
	       
	        	
		        
	        if ((!(gapY)) && (paging.useRM())) {
	        	G2D.setColor(Color.BLACK);
	        	G2D.setFont(new Font(font.getFontName(), Font.BOLD, 10));
	        	G2D.drawString(sR, x+4, y+12);
	        	G2D.drawString(sM, x+4, y+LENGTH_BOX-3); 
	        }
		        
	        
	        	                
	        switch (surface) {
		        case COLORED: {
		        	G2D.setColor(Color.RED);
		        	break;
		        }
		        case GRAY: {
		        	G2D.setColor(Color.BLACK);
		        	break;
		        }
		        default: {
		        	break;
		        }
	        }	        
	        switch (status) {
	        	case OVERWRITE: {
	        		G2D.drawOval(x+8, y+8, LENGTH_BOX-15, LENGTH_BOX-15);
	        		break;
	        	}
		        case NEW: {		        	
		        	G2D.drawRect(x+10, y+9, LENGTH_BOX-19, LENGTH_BOX-17);
		        	break;
		        }
		        default: {
		        	break;
		        }
	        }
		}		       
	}	
	
	private void initValues() {
		LENGTH_BOX = 35;
		WIDTH_LABEL = 80;
		X_FIRST = 5;
		Y_FIRST = 30;
		GAP = 5;
	}	

	protected void doDrawing(Graphics g) {

		repaint();
        G2D = (Graphics2D) g;
        
        initValues();
        update();
        
        Font font = G2D.getFont();
        
        //g2d.setFont(g2d.getFont().deriveFont(18f));
        G2D.setFont(new Font(font.getFontName(), Font.BOLD, 18)); 
        
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
        
        //g2d.drawString("Java 2D", 50, 50);
        
        //g2d.setColor(Color.BLACK);
    	
    }


	@Override
	protected void update() {
		listCache = paging.getListCache();
		maxRam = paging.getMaxRam();
		maxDisk = paging.getMaxDisk();
		surface = paging.getSurface();
	} 
}
