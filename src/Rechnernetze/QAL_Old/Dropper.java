package Rechnernetze.QAL_Old;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Dropper extends Line {
	public Dropper(double propD,Rectangle r){super(propD,r);}
	
	public void draw(Graphics g) {
		for (int i=0;i<packets.getLength();i++) {
			drawPacket(packets.getPacket(i),g);
		}
	}
	
	private void drawPacket(Packet P, Graphics g) {
		double y1=((double)shape.y)+(time-P.emmissionTime)*((double)shape.height)/propDelay;
		double y2=y1-(P.emmissionDelay)*((double)shape.height)/propDelay;
		if (y1>((double)(shape.y+shape.height))) y1=(double)(shape.y+shape.height);
		if (y2<((double)(shape.y))) y2=(double)(shape.y);
		g.setColor(P.color);
		g.fillRect(shape.x,(int)y2,shape.width,(int)(y1-y2));
	}
}