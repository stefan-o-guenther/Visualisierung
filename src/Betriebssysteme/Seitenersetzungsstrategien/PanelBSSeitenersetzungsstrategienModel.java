package Betriebssysteme.Seitenersetzungsstrategien;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import Base.BasePanelModel;
import Base.EnumSurface;

public class PanelBSSeitenersetzungsstrategienModel extends BasePanelModel {
	
	public PanelBSSeitenersetzungsstrategienModel() {
	}
	
	
	public void drawListSpace(List<ICacheBox> value, Integer r, Integer d) {
		if ((value != null) && (r != null) && (d != null)) {
			listCache = value;
			maxR = r;
			maxD = d;
			Graphics g = getGraphics();
			doDrawing(g);
		}
	}
	
	private Graphics2D G2D; // = (Graphics2D) getGraphics();
	//private Font FONT = G2D.getFont();
	
	private Integer HIGHT_BOX = 35;
	private Integer WIDTH_LABEL = 80;
	private Integer X_FIRST = 5;
	private Integer Y_FIRST = 40;
	
	private Integer GAP = 5;
	
	private List<ICacheBox> listCache = new ArrayList<ICacheBox>();
	private Integer maxR = 3;
	private Integer maxD = 3;
	
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
	
	
	private void box(String text, String r, String m, Integer countX, Integer countY, Boolean gap) {
		Integer x = X_FIRST + WIDTH_LABEL+(HIGHT_BOX*countX);
        Integer y = Y_FIRST+(HIGHT_BOX*countY);		
        if (gap) {
        	y += GAP;
        }
        Font font = G2D.getFont();
		G2D.drawRect(x, y, HIGHT_BOX, HIGHT_BOX);
		
        G2D.setFont(new Font(font.getFontName(), Font.BOLD, 18));
        G2D.drawString(text, x+13, y+25);
        
        G2D.setFont(new Font(font.getFontName(), Font.BOLD, 10));
        G2D.drawString(r, x+4, y+12);
        G2D.drawString(m, x+4, y+HIGHT_BOX-3);        
	}	
	

	protected void doDrawing(Graphics g) {
		
		Integer anzRam = maxR;
		Integer anzDisk = maxD;;

		repaint();
        G2D = (Graphics2D) g;
        Font font = G2D.getFont();
        
        //g2d.setFont(g2d.getFont().deriveFont(18f));
        G2D.setFont(new Font(font.getFontName(), Font.BOLD, 18)); 
        
        // RAM
        for (Integer r = 0; r < anzRam; r++) {
        	labelY("RAM", r, false);
        }
        
        // DISK
        for (Integer d = anzRam; d < (anzDisk + anzRam); d++) {
        	labelY("DISK", d, true);        	
        }
        
        // X
        for (Integer x = 0; x < 16; x++) {
        	//ICacheBox cb = listCache.get(x);
        	//Integer y = cb.getNumber();
        	//labelX(y.toString(), x);
        	labelX("0", x);
        }        
        
        for (Integer c = 0; c < 16; c++) {
        	
        	// box RAM
        	//ICacheBox cb = listCache.get(c);
        	//List<ICache> listRam = cb.getRam();
        	//List<ICache> listDisk = cb.getDisk();
        	
        	for (Integer r = 0; r < 3; r++) {
        		//ICache v = listRam.get(r);
        		box("0", "0", "1", c, r, false);
            }            
            
            // box DISK
        	for (Integer d = 3; d < (3 + 3); d++) {
        		//ICache v = listDisk.get(d);
        		box("0", "0", "1", c, d, true);        	
            }	
        }  
        
        //g2d.drawString("Java 2D", 50, 50);
        
        //g2d.setColor(Color.BLACK);
    	
    } 
}
