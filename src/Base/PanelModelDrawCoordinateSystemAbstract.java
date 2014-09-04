/**
 * @author:	Stefan Otto Günther
 * @date:	01.06.2014
 */

package Base;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Polygon;

public abstract class PanelModelDrawCoordinateSystemAbstract extends PanelModelDrawAbstract {

	private static final long serialVersionUID = 1L;
	
	public PanelModelDrawCoordinateSystemAbstract(ManagementCoordinateSystem management) {
		super(management);		
	}
	
	// coordinate system
	protected void printCoordinateSystem(String xName, String yName) {
		try {			
			if ((xName == null) || (yName == null)) {
				throw new NullPointerException();
			}
			this.printAxisX(xName);
			this.printAxisY(yName);
		} catch (Exception ex) {
			throw ex;
		}	
	}
	
	protected void printAxisX(String name) {
		try {
			if (name == null) {
				throw new NullPointerException();
			}
			ManagementCoordinateSystem coordinate = (ManagementCoordinateSystem) this.getManagement();
			
			BasicStroke bs = new BasicStroke(3, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
			g2d.setStroke(bs);	
			g2d.setColor(Color.BLACK);
			
			Integer x0 = coordinate.getPositionX0();
			Integer y0 = coordinate.getPositionY0();
			Integer xMax = coordinate.getPositionXMax();
			Integer arrow = coordinate.getArrowLength();
			
			// Beschriftung von X-Achse
			Font font = g2d.getFont();
			g2d.setFont(new Font(font.getFontName(), Font.BOLD, font.getSize()+2));
			
			EnumCoordinateSystem position = coordinate.getPosition();
			switch (position) {
				case BOTTOM: {
					g2d.drawString(name, x0 + 350, y0 + 40);
					break;
				}
				case RIGHT: {
					g2d.drawString(name, xMax + 10, y0 + 5);
					break;
				}
				default: {
					break;
				}
			}				
			g2d.setFont(font);
			
			// Linie von X-Achse
			g2d.drawLine(x0, y0, xMax, y0);		// X-Achse
			
			// Pfeil bei X-Achse
			Integer d = arrow / 2;
			Polygon p = new Polygon(new int[] {xMax, xMax-arrow, xMax-arrow}, new int[] {y0, y0-d, y0+d}, 3 );	
			g2d.drawPolygon(p);
	     	g2d.fillPolygon(p);
	     	
	     	// Striche und Nummerierung bei X-Achse
	     	for (Integer i = 1; i <= coordinate.getXMax(); i++) {
	     		int j = i.intValue();
	     		int r = j % coordinate.getIntervalX();
	     		if (r == 0) {
	     			Integer xpos = coordinate.XToPositionX(i);	     		
		     		g2d.drawLine(xpos, y0-5, xpos, y0+5);
		     		String s = i.toString();
		     		int max = coordinate.getXMax().intValue();
		     		if (max > 9) {
		     			if (max > 99) {
		     				if (j < 100) {
		     					s = "0" + s;
		     					if (j < 10) {
		     						s = "0" + s;
		     					}
		     				}
		     			} else {
		     				if (j < 10) {
		     					s = "0" + s;
		     				}
		     			}
		     		}
		     		g2d.drawString(s, xpos-5, y0+22);
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
			ManagementCoordinateSystem coordinate = (ManagementCoordinateSystem) this.getManagement();
			
			BasicStroke bs = new BasicStroke(3, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
			g2d.setStroke(bs);	
			g2d.setColor(Color.BLACK);
			
			Integer x0 = coordinate.getPositionX0();
			Integer y0 = coordinate.getPositionY0();
			Integer yMax = coordinate.getPositionYMax();
			Integer arrow = coordinate.getArrowLength();
			
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
	     	for (Integer i = 1; i <= coordinate.getYMax(); i++) {
	     		int j = i.intValue();
	     		int r = j % coordinate.getIntervalY();
	     		if (r == 0) {
	     			Integer ypos = coordinate.YToPositionY(i);
		     		g2d.drawLine(x0-5, ypos, x0+5, ypos);
		     		String s = i.toString();
		     		int max = coordinate.getXMax().intValue();
		     		if (max > 9) {
		     			if (max > 99) {
		     				if (j < 100) {
		     					s = "0" + s;
		     					if (j < 10) {
		     						s = "0" + s;
		     					}
		     				}
		     			} else {
		     				if (j < 10) {
		     					s = "0" + s;
		     				}
		     			}
		     		}
		     		g2d.drawString(s, x0-30, ypos+5);	    
	     		}		     		 		
	     	}	
			
		} catch (Exception ex) {
			throw ex;
		}
	}
}