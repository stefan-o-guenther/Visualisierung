package Rechnernetze.Dijkstra;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import Base.BasePanelModelDraw;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelRNDijkstraModel extends BasePanelModelDraw {

	private IDijkstraManagement dijkstra;
	
	/**
	 * Create the panel.
	 */
	public PanelRNDijkstraModel(IDijkstraManagement idijkstra) {
		if (idijkstra == null) {
			idijkstra = new DijkstraManagement();
		}
		dijkstra = idijkstra;
	}

	@Override
	protected void doDrawing(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("img/70px-Router.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//g2d.drawImage(img, 10 , 10, null);
		
		
        //g2d.setColor(Color.blue);
        //g2d.drawLine(5, 5, 50, 50);
		
		int startx = 300;
		int starty = 120;
		int p1x = 320;
		int p1y = 20;
		int p2x = 350;
		int p2y = 40;
		int endx = 400;
		int endy = 120;
		
		Point2D point;
		Rectangle2D.Double rectCubicP2 = new Rectangle2D.Double(5, 5, 20, 20);

		//g2d.draw(rectCubicP2);
		
		
		g2d.setColor(Color.BLACK);
		CubicCurve2D.Double cubicCurve = 
			new CubicCurve2D.Double(
				startx,starty,p1x,p1y,p2x,p2y,endx,endy);
		g2d.draw(cubicCurve);
		
	}

	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateModel() {
		// TODO Auto-generated method stub
		
	}
}
