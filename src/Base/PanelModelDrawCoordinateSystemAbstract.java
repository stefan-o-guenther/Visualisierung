package Base;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Polygon;

public abstract class PanelModelDrawCoordinateSystemAbstract extends PanelModelDrawAbstract {

	public PanelModelDrawCoordinateSystemAbstract(ManagementCoordinateSystem management, ToolTipManager tooltip) {
		super(management, tooltip);
		cs = management.getCoordinateSystem();
	}
	
	protected CoordinateSystem cs;
	
	// coordinate system
	protected void printCoordinateSystem(String nameX, String nameY) {
		try {			
			if ((nameX == null) || (nameY == null)) {
				throw new NullPointerException();
			}
			this.printAxisX(nameX);
			this.printAxisY(nameY);
		} catch (Exception ex) {
			throw ex;
		}	
	}
	
	protected void printAxisX(String name) {
		try {
			if (name == null) {
				throw new NullPointerException();
			}
			if (cs != null) {
				BasicStroke bs = new BasicStroke(3, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
				g2d.setStroke(bs);	
				g2d.setColor(Color.BLACK);
				
				Integer x0 = cs.getPositionX0();
				Integer y0 = cs.getPositionY0();
				Integer xMax = cs.getPositionXMax();
				Integer arrow = cs.getArrowLength();
				
				// Beschriftung von X-Achse
				Font font = g2d.getFont();
				g2d.setFont(new Font(font.getFontName(), Font.BOLD, font.getSize()+2));
				g2d.drawString(name, x0 + 350, y0 + 40);
				g2d.setFont(font);
				
				// Linie von X-Achse
				g2d.drawLine(x0, y0, xMax, y0);		// X-Achse
				
				// Pfeil bei X-Achse
				Integer d = arrow / 2;
				Polygon p = new Polygon(new int[] {xMax, xMax-arrow, xMax-arrow}, new int[] {y0, y0-d, y0+d}, 3 );	
				g2d.drawPolygon(p);
		     	g2d.fillPolygon(p);
		     	
		     	// Striche und Nummerierung bei X-Achse
		     	for (Integer i = 1; i <= cs.getXMax(); i++) {
		     		Integer r = i % cs.getInterval();
		     		if (r.equals(0)) {
		     			Integer j = cs.XToPositionX(i);	     		
			     		g2d.drawLine(j, y0-5, j, y0+5);
			     		String s = i.toString();
			     		if (i < 10) {
			     			s = "0" + s;
			     		}
			     		g2d.drawString(s, j-5, y0+22);
		     		}		     		
		     	}
			}
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	protected void printAxisY(String name) {
		try {
			if (name == null) {
				throw new NullPointerException();
			}
			if (cs != null) {
				BasicStroke bs = new BasicStroke(3, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
				g2d.setStroke(bs);	
				g2d.setColor(Color.BLACK);
				
				Integer x0 = cs.getPositionX0();
				Integer y0 = cs.getPositionY0();
				Integer yMax = cs.getPositionYMax();
				Integer arrow = cs.getArrowLength();
				
				// Beschriftung
				Font font = g2d.getFont();
				g2d.setFont(new Font(font.getFontName(), Font.BOLD, font.getSize()+2));
				g2d.drawString(name, x0 - 25, yMax - 10);
				g2d.setFont(font);
				
				// Achse
				g2d.drawLine(x0, y0, x0, yMax);	// Y-Achse
				
				// Pfeil bei Y-Achse
				Integer d = arrow / 2;
				Polygon p = new Polygon(new int[] {x0, x0-d, x0+d}, new int[] {yMax, yMax+arrow, yMax+arrow}, 3 );	
				g2d.drawPolygon(p);
		     	g2d.fillPolygon(p);
		     	
		     	// Striche und Nummerierung bei Y-Achse
		     	for (Integer i = 1; i <= cs.getYMax(); i++) {
		     		Integer r = i % cs.getInterval();
		     		if (r.equals(0)) {
		     			Integer j = cs.YToPositionY(i);
			     		g2d.drawLine(x0-5, j, x0+5, j);
			     		String s = i.toString();
			     		if (i < 10) {
			     			s = "0" + s;
			     		}
			     		g2d.drawString(s, x0-25, j+5);	    
		     		}		     		 		
		     	}	
			}
		} catch (Exception ex) {
			throw ex;
		}
	}
}