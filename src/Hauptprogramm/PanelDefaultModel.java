package Hauptprogramm;

import java.awt.Graphics;
import java.awt.Graphics2D;

import Base.BasePanelModelDraw;


public class PanelDefaultModel extends BasePanelModelDraw {

	private IDefaultManagement main;
	
	protected void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawString("Stefan Günther", 100, 100);
    }

	public PanelDefaultModel(IDefaultManagement imain) {
		if (imain == null) {
			imain = new DefaultManagement();
		}
		main = imain;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}   
}