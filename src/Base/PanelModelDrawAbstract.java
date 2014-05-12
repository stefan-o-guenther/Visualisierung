/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import java.awt.Graphics;


public abstract class PanelModelDrawAbstract extends PanelModelAbstract implements PanelModelDraw {	
	
	public PanelModelDrawAbstract(Management management, ToolTipManager tooltip) {
		super(management, tooltip);
	}
	
	protected abstract void doDrawing(Graphics g);	
	
	@Override
	public void paintComponent(Graphics g) {        
        super.paintComponent(g);
        doDrawing(g);
    }
	
	@Override
	public void initLayout() {
		// nothing
	}
	
	@Override
	public void updateModel() {
		repaint();
	}
}