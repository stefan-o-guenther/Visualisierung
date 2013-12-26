package Base;

import java.awt.Graphics;

public abstract class BasePanelModelDraw extends BasePanelModel {

	protected abstract void doDrawing(Graphics g);
	protected abstract void update();
	
	@Override
	public void paintComponent(Graphics g) {        
        super.paintComponent(g);
        doDrawing(g);
    }
	
}
