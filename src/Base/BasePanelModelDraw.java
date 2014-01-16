package Base;

import java.awt.Graphics;


public abstract class BasePanelModelDraw extends BasePanelModel {	
	protected abstract void doDrawing(Graphics g);
	protected abstract void updateData();
	
	@Override
	public void paintComponent(Graphics g) {        
        super.paintComponent(g);
        doDrawing(g);
    }
}
