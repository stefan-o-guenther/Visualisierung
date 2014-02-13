/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

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
		super();
		if (imain == null) {
			imain = new DefaultManagement();
		}
		main = imain;
		main.setPanelModel(this);
		updateModel();
	}
	
	@Override
	public void updateModel() {
		// TODO Auto-generated method stub
		
	}   
}