/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Hauptprogramm;

import java.awt.Graphics;
import java.awt.Graphics2D;

import Base.BasePanelModelDraw;


public class PanelDefaultModel extends BasePanelModelDraw {

	public PanelDefaultModel(IDefaultManagement main) {
		super(main);
		this.main = main;
		putModelToManagement();
		updateModel();
	}
	
	private IDefaultManagement main;
	
	public void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawString("Stefan Günther", 100, 100);
    }
	
	@Override
	public void updateModel() {
		// TODO Auto-generated method stub
		
	}   
}