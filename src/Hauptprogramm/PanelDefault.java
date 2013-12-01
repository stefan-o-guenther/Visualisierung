package Hauptprogramm;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


public class PanelDefault extends JPanel {
    
	private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawString("Stefan Günther", 100, 100);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}