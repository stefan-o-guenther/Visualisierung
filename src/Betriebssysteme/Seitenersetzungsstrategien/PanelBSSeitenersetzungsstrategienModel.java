/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import Base.BasePanelModelDraw;

public class PanelBSSeitenersetzungsstrategienModel extends BasePanelModelDraw {
	
	public PanelBSSeitenersetzungsstrategienModel(IMemoryManager ipaging) {
		super();
		if (ipaging == null) {
			ipaging = new MemoryManager();
		}
		paging = ipaging;
		paging.setPanelModel(this);
		updateModel();
	}	
		
	private final Integer HEIGHT_BOX = 35;
	private final Integer WIDTH_BOX = 50;
	private final Integer WIDTH_LABEL = 80;
	private final Integer X_FIRST = 5;
	private final Integer Y_FIRST = 0;	
	private final Integer GAP = 5;
	private final Integer X_NUMBER = 19;
	private final Integer Y_NUMBER = 25;
	
	private IMemoryManager paging;
	
	private Graphics2D g2d;		
	
	private void labelNames(String text, Integer countY, Boolean gapY) {		
		Integer w = WIDTH_LABEL;
        Integer h = HEIGHT_BOX;
        Integer x = X_FIRST;
        Integer y = getY(countY, gapY);
        Font font = g2d.getFont();
        g2d.setColor(Color.BLACK);
        g2d.drawRect(x, y, w, h);
               
        g2d.setFont(new Font(font.getFontName(), Font.BOLD, 18));        
        g2d.drawString(text, x+10, y+Y_NUMBER);
        
        if (paging.useRM()) {
        	g2d.setFont(new Font(font.getFontName(), Font.BOLD, 10));
            g2d.drawString("R", x+w-15, y+12);
            g2d.drawString("M", x+w-15, y+h-3);		
        }        
	}
	
	private void drawBox(Integer countX, Integer countY, Boolean gapX, Boolean gapY) {
		if ((countX != null) && (countY != null) && (gapY != null)) {
			Integer x = getX(countX, gapX);			
	        Integer y = getY(countY, gapY);
	        g2d.setColor(Color.BLACK);
			g2d.drawRect(x, y, WIDTH_BOX, HEIGHT_BOX);
		}		
	}
	
	private Integer getX(Integer countX, Boolean gapX) {
		return (X_FIRST + WIDTH_LABEL + (WIDTH_BOX * countX) + (getGap(gapX)));	
	}
	
	private Integer getY(Integer countY, Boolean gapY) {
		return (Y_FIRST + (HEIGHT_BOX * countY) + (getGap(gapY)));
	}	
	
	private void printRM(ICache cache, Integer countX, Integer countY, Boolean gapX, Boolean gapY) {		
		if ((!(gapY)) && (paging.useRM())) {
			Integer x = getX(countX, gapX);			
	        Integer y = getY(countY, gapY);
	        String sR = cache.getR().toString();
	        if (cache.isRChanged()) {
	        	sR += Character.toString('\u21D0') + cache.getRPrevious().toString();
	        }
			String sM = cache.getM().toString();
	        if (cache.isMChanged()) {
	        	sM += Character.toString('\u21D0') + cache.getMPreviousM().toString();
	        }
        	g2d.setColor(Color.BLACK);
        	g2d.setFont(new Font(g2d.getFont().getFontName(), Font.BOLD, 10));
        	g2d.drawString(sR, x+4, y+12);
        	g2d.drawString(sM, x+4, y+HEIGHT_BOX-3); 
        }        
	}
	
	private Integer getGap(Boolean gap) {
		if (gap) {
			return GAP;
		} else {
			return 0;
		}
	}
	
	private Integer getXNumber(Integer x) {
		return x + WIDTH_BOX - X_NUMBER;
	}
	
	private void printNumber(Integer number, Integer countX, Integer countY, Boolean gapX, Boolean gapY) {
		Integer x = getX(countX, gapX);			
        Integer y = getY(countY, gapY);		
		String sNumber = "";
		if (number >= 0) {
			sNumber = number.toString();
		}
		g2d.setColor(Color.BLACK);
        g2d.setFont(new Font(g2d.getFont().getFontName(), Font.BOLD, 18));
        g2d.drawString(sNumber, getXNumber(x), y+Y_NUMBER);
	}
	
	private void printRectOval(ICache cache, Integer countX, Integer countY, Boolean gapX, Boolean gapY) {
		Integer x = getX(countX, gapX);			
        Integer y = getY(countY, gapY);
        x = getXNumber(x);
		g2d.setColor(paging.getColor());
		EnumCache status = cache.getStatus();	        
        if (status == EnumCache.OVERWRITE) {
        	g2d.drawOval(x-5, y+8, 20, 20);
        } else if (status == EnumCache.NEW) {
        	g2d.drawRect(x-4, y+9, 17, 18);
        }	        
	}
	
	protected void doDrawing(Graphics g) {		
		g2d = (Graphics2D) g;		
		g2d.setFont(new Font(g2d.getFont().getFontName(), Font.BOLD, 18)); 
		
		List<ICacheBox> listCacheBox = paging.getListCache();		 
		Integer maxRam = paging.getMaxRam();
		Integer maxDisk = paging.getMaxDisk();		
		
		Integer sizeX = listCacheBox.size();
		Integer sizeY = maxRam + maxDisk + 1;
		
		for (Integer indexX = 0; indexX < sizeX; indexX++) {
			Boolean gapX = (indexX >= maxRam);
			ICacheBox cacheBox = listCacheBox.get(indexX);
			List<ICache> listRam = cacheBox.getRam();
			List<ICache> listDisk = cacheBox.getDisk();  
			for (Integer indexY = 0; indexY < sizeY; indexY++) {
				if (indexY > 0) {
					// Beschriftung auf Y-Achse
					if (indexY <= maxRam) {
						labelNames("RAM", indexY, false);
					} else {
						labelNames("DISK", indexY, true);   
					}
					
					Boolean gapY = (indexY > maxRam);
					drawBox(indexX, indexY, gapX, gapY);
					
					// Felder					
					ICache cache = null;
					if (indexY <= maxRam) {
						// RAM
						Integer indexRam = indexY - 1;
						if (indexRam < listRam.size() ) {
							cache = listRam.get(indexRam);
							printRectOval(cache, indexX, indexY, gapX, gapY);
							printRM(cache, indexX, indexY, gapX, gapY);
						}						
					} else {
						// DISK
						Integer indexDisk = indexY - maxRam - 1;
						if (indexDisk < listDisk.size() ) {
							cache = listDisk.get(indexDisk);
						}						
					}
					if (cache != null) {
						printNumber(cache.getNumber(), indexX, indexY, gapX, gapY);
					}					
				} else {
					// Beschriftung auf X-Achse
					Integer number = cacheBox.getNumber();					
					printNumber(number, indexX, 0, gapX, false);
				}
			}
		}
    }	

	@Override
	public void updateModel() {
		repaint();
	} 
}