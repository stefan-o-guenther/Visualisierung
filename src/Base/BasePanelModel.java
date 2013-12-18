package Base;

import java.awt.Graphics;

import javax.swing.JPanel;

public abstract class BasePanelModel extends JPanel {

	protected EnumSurface color = EnumSurface.COLORED;
	
	protected abstract void doDrawing(Graphics g);
	
	public abstract void update();
	
	public void updateColor(EnumSurface c) {
		if (c != null) {
			color = c;
			Graphics g = getGraphics();
			doDrawing(g);
		}
		
	}
	
	@Override
	public void paintComponent(Graphics g) {        
        super.paintComponent(g);
        doDrawing(g);
    }
}
