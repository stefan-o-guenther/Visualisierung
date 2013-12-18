package Hauptprogramm;

import java.awt.Graphics;
import java.awt.Graphics2D;

import Base.BasePanelModel;
import Base.EnumSurface;


public class PanelDefaultModel extends BasePanelModel {
    
	protected void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawString("Stefan Günther", 100, 100);
    }

	@Override
	public void updateColor(EnumSurface c) {
		// TODO Auto-generated method stub
		
	}   
}