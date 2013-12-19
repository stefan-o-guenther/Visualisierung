package Betriebssysteme.Seitenersetzungsstrategien;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import Base.BasePanelModel;
import Base.EnumSurface;

public class PanelBSSeitenersetzungsstrategienModel extends BasePanelModel {
	
	private IPagingManagement paging;
	
	private Graphics2D G2D; // = (Graphics2D) getGraphics();
	//private Font FONT = G2D.getFont();
	
	private Integer HIGHT_BOX = 35;
	private Integer WIDTH_LABEL = 80;
	private Integer X_FIRST = 5;
	private Integer Y_FIRST = 40;
	
	private Integer GAP = 5;
	
	private List<ICacheBox> listCache = new ArrayList<ICacheBox>();
	private Integer maxRam = 3;
	private Integer maxDisk = 3;
	
	public PanelBSSeitenersetzungsstrategienModel(IPagingManagement ipaging) {
		if (ipaging == null) {
			ipaging = new PagingManagement();
		}
		paging = ipaging;
		listCache = paging.getListCache();
		maxRam = paging.getMaxRam();
		maxDisk = paging.getMaxDisk();
	}	
	
	public void drawListSpace(List<ICacheBox> value, Integer r, Integer d) {
		if ((value != null) && (r != null) && (d != null)) {
			listCache = value;
			maxRam = r;
			maxDisk = d;
			Graphics g = getGraphics();
			doDrawing(g);
		}
	}
	
	private void labelX(String text, Integer countX) {
		Integer x = X_FIRST + WIDTH_LABEL + (HIGHT_BOX*countX);
        Integer y = Y_FIRST-30;        
        
        Font font = G2D.getFont();
        G2D.setFont(new Font(font.getFontName(), Font.BOLD, 18));        
        G2D.drawString(text, x+13, y+25);
	}	
	
	
	private void labelY(String text, Integer countY, Boolean gap) {		
		Integer w = WIDTH_LABEL;
        Integer h = HIGHT_BOX;
        Integer x = X_FIRST;
        Integer y = Y_FIRST+(h*countY);
        if (gap) {
        	y += GAP;
        }
        Font font = G2D.getFont();
        G2D.drawRect(x, y, w, h);
               
        G2D.setFont(new Font(font.getFontName(), Font.BOLD, 18));        
        G2D.drawString(text, x+10, y+25);
        
        G2D.setFont(new Font(font.getFontName(), Font.BOLD, 10));
        G2D.drawString("R", x+w-15, y+12);
        G2D.drawString("M", x+w-15, y+h-3);		
	}
	
	
	private void box(Integer z, Integer r, Integer m, Integer countX, Integer countY, Boolean gap) {
		if ((countX != null) && (countY != null) && (gap != null)) {
			Integer x = X_FIRST + WIDTH_LABEL+(HIGHT_BOX*countX);
	        Integer y = Y_FIRST+(HIGHT_BOX*countY);		
	        if (gap) {
	        	y += GAP;
	        }
	        String sZ = "";
	        if ((z != null) && (z >= 0)) {
	        	sZ = z.toString();
	        }
	        String sM = "";
	        if ((m != null) && (m >= 0)) {
	        	sM = m.toString();
	        }
	        String sR = "";
	        if ((r != null) && (r >= 0)) {
	        	sR = r.toString();
	        }
	        
	        
	        Font font = G2D.getFont();
			G2D.drawRect(x, y, HIGHT_BOX, HIGHT_BOX);
			
			// Zahl
	        G2D.setFont(new Font(font.getFontName(), Font.BOLD, 18));
	        G2D.drawString(sZ, x+13, y+25);
	        
	        // r und m
	        G2D.setFont(new Font(font.getFontName(), Font.BOLD, 10));
	        G2D.drawString(sR, x+4, y+12);
	        G2D.drawString(sM, x+4, y+HIGHT_BOX-3); 
		}		       
	}	
	

	protected void doDrawing(Graphics g) {

		repaint();
        G2D = (Graphics2D) g;
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
        	
        	// X
        	ICacheBox cb = listCache.get(c);
        	Integer z = cb.getNumber();
        	labelX(z.toString(), c);
        	
        	// box RAM
        	List<ICache> listRam = cb.getRam();        	
    		for (Integer r = 0; r < maxRam; r++) {
    			if (listRam.size() > r) {
    				ICache v = listRam.get(r);
    				box(v.getItem(), v.getR(), v.getM(), c, r, false);
    			} else {
    				box(null, null, null, c, r, false);
    			}
            }       	       	   
            
            // box DISK
        	List<ICache> listDisk = cb.getDisk();        	
    		for (Integer d = 0; d < maxDisk; d++) {
    			if (listDisk.size() > d) {
    				ICache v = listDisk.get(d);
        			box(v.getItem(), v.getR(), v.getM(), c, d+maxRam, true);
    			} else {
    				box(null, null, null, c, d+maxRam, true);
    			}    			
    		}        	        	
        }  
        
        //g2d.drawString("Java 2D", 50, 50);
        
        //g2d.setColor(Color.BLACK);
    	
    }


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	} 
}
