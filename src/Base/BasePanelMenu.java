package Base;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public abstract class BasePanelMenu extends JPanel {

	protected abstract void initComponents();	
	protected abstract void updateComponents();
	protected abstract void initToolTips();
		
	protected ImageIcon IMG_HELP = new ImageIcon("img/16x16_help.png");
	protected ImageIcon IMG_RABBIT = new ImageIcon("img/rabbit.png");
	protected ImageIcon IMG_TURTLE = new ImageIcon("img/turtle.png");
	
	
	@Override
	public void paintComponent(Graphics g) {        
        super.paintComponent(g);
        updateComponents();
    }
    
}