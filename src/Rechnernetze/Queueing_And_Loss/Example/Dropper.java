package Rechnernetze.Queueing_And_Loss.Example;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Dropper extends Line {
	
	public Dropper(double propD,Rectangle r) {
		super(propD,r);
	}

	public void draw(Graphics g) {
		for (int i = 0; i < packets.getLength(); i++) {
			drawPacket(packets.getPacket(i),g);
		}
	}

	private void drawPacket(Packet P, Graphics g) {
		double doubleShapeY = (double)(shape.y);
		double doubleShapeHeight = (double)(shape.height);
		double y1 = doubleShapeY + (time - P.emmissionTime) * doubleShapeHeight / propDelay;
		double y2 = y1 - (P.emmissionDelay) * doubleShapeHeight / propDelay;
		
		if (y1 > doubleShapeHeight) {
			y1 = doubleShapeHeight;
		}		
		if (y2 < doubleShapeY) {
			y2 = doubleShapeY;
		}
		g.setColor(P.color);
		g.fillRect(shape.x, (int)y2, shape.width, (int)(y1 - y2));
	}
}

