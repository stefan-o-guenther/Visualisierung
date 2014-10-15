/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class PanelDrawingAbstract extends PanelAbstract {	
	
	private static final long serialVersionUID = 1L;
	
	public PanelDrawingAbstract() {
		super();
	}	
	
	protected Graphics2D g2d;
	protected abstract void doDrawing();
	protected abstract void createDrawing();
	
	@Override
	protected void createPanel() {
		this.createDrawing();
		this.updatePanel();
	}
	
	@Override
	public void paintComponent(Graphics g) {        
		try {
			if (g == null) {
				throw new NullPointerException();
			}
			super.paintComponent(g);
	        g2d = (Graphics2D) g;
	        doDrawing();
		} catch (Exception ex) {
			throw ex;
		}        
    }
	
	@Override
	public void updatePanel() {
		repaint();
	}
}