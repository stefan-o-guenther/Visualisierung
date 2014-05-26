/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class PanelModelDrawAbstract extends PanelModelAbstract {	
	
	public PanelModelDrawAbstract(Management management, ToolTipManager tooltip) {
		super(management, tooltip);
	}
	
	protected abstract void doDrawing();	
	protected Graphics2D g2d;
		
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
	protected void initLayout() {
		// nothing
	}
	
	@Override
	public void updatePanel() {
		repaint();
	}
}