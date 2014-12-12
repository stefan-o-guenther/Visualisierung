/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import Base.ManagementFactory;
import Base.PanelDrawingAbstract;

public class PanelBSSeitenersetzungsstrategienModelImpl extends PanelDrawingAbstract {
	
	private static final long serialVersionUID = 1L;

	public PanelBSSeitenersetzungsstrategienModelImpl() {
		super();
		this.createPanel();
	}
	
	private final int HEIGHT_BOX = 35;
	private final int WIDTH_BOX = 35;
	private final int WIDTH_LABEL = 80;
	private final int X_FIRST = 5;
	private final int Y_FIRST = 0;	
	private final int GAP = 5;
	private final int X_NUMBER = 19;
	private final int Y_NUMBER = 25;
		
	private ManagementPaging paging;
	
	@Override
	public void createDrawing() {
		this.paging = ManagementFactory.getManagementPaging();
	}
	
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
		    
		if (paging.isRmVisible()) {
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
	
	private void printRM(Cache cache, Integer countX, Integer countY, Boolean gapX, Boolean gapY) {		
		if ((!(gapY)) && (paging.isRmVisible())) {
			Integer x = getX(countX, gapX);			
			Integer y = getY(countY, gapY);
			String r = "";
			String m = "";
			
			
			if (paging.isViewOldStatesEnabled()) {
				List<Integer> listRPrevious = cache.getRPrevious();
				List<Integer> listMPrevious = cache.getMPrevious();
				Integer sizeRPrevious = listRPrevious.size();
				Integer sizeMPrevious = listMPrevious.size();
				for (Integer rp : listRPrevious) {
					r += rp.toString();	        		
				}
				for (Integer mp : listMPrevious) {
					m += mp.toString();	        		
				}
				g2d.setColor(paging.getColor());
				g2d.setFont(new Font(g2d.getFont().getFontName(), Font.BOLD, 15));
				
				Integer size = sizeRPrevious;
				if (size < sizeMPrevious) {
					size = sizeMPrevious;
				}
				
				for (Integer i = 0; i < size; i++) {
					Integer xSlash = x+4+(i*6);
					if (i < sizeRPrevious) {
						g2d.drawString("/", xSlash, y+14);
					}
					if (i < sizeMPrevious) {
						g2d.drawString("/", xSlash, y+HEIGHT_BOX-1);
					}
				}
			}
			r += cache.getR();
			m += cache.getM();
		
			g2d.setColor(Color.BLACK);
			g2d.setFont(new Font(g2d.getFont().getFontName(), Font.BOLD, 10));
			g2d.drawString(r, x+4, y+12);
			g2d.drawString(m, x+4, y+HEIGHT_BOX-3);
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
	
	private void printNumber(Integer number, Integer countX, Integer countY, Boolean gapX, Boolean gapY, Color color) {
		Integer x = getX(countX, gapX);			
		Integer y = getY(countY, gapY);		
		String sNumber = "";
		if (number >= 0) {
			sNumber = number.toString();
		}
		g2d.setColor(color);
		g2d.setFont(new Font(g2d.getFont().getFontName(), Font.BOLD, 18));
		g2d.drawString(sNumber, getXNumber(x), y+Y_NUMBER);
	}
	
	private void printRectOval(Cache cache, Integer countX, Integer countY, Boolean gapX, Boolean gapY) {
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
	
	@Override
	protected void doDrawing() {		
		g2d.setFont(new Font(g2d.getFont().getFontName(), Font.BOLD, 18)); 
		
		List<CacheBox> listCacheBox = paging.getListCache();		 
		Integer maxRam = paging.getMaxRam();
		Integer maxDisk = paging.getMaxDisk();		
		
		Integer sizeX = listCacheBox.size();
		Integer sizeY = maxRam + maxDisk + 1;
		
		for (Integer indexX = 0; indexX < sizeX; indexX++) {
			Boolean gapX = (indexX >= maxRam);
			CacheBox cacheBox = listCacheBox.get(indexX);
			List<Cache> listRam = cacheBox.getRam();
			List<Cache> listDisk = cacheBox.getDisk();  
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
					Cache cache = null;
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
						printNumber(cache.getNumber(), indexX, indexY, gapX, gapY, Color.BLACK);
					}					
				} else {
					// Beschriftung auf X-Achse
					Integer number = cacheBox.getNumber();
					Color color = Color.BLACK;
					if (cacheBox.isActivated()) {
						color = paging.getColor();
					}
					printNumber(number, indexX, 0, gapX, false, color);
				}
			}
		}
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