package Rechnernetze.Queueing_And_Loss.Example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Line extends TimedClass {
	private boolean availableArrivedPacket;
	private Packet arrivedPacket;
	protected PacketFIFO packets;
	protected double propDelay;
	
	public Line(double propD,Rectangle r) {
		packets = new PacketFIFO();
		propDelay = propD;
		shape = r;
		availableArrivedPacket = false;
	}
		
	public void emitPacket(double eT, Color c) {
		packets.add(new Packet(eT,c));
	}
		
	public void draw(Graphics g) {
		for (int i = 0; i < packets.getLength(); i++) {
			drawPacket(packets.getPacket(i),g);
		}
		g.setColor(Color.black);
		g.drawRect(shape.x,shape.y,shape.width,shape.height);
	}
		
	private void drawPacket(Packet P, Graphics g) {
		double dShapeX = (double)(shape.x);
		double dShapeWidth = (double)(shape.width);
		double dShapeXWidth = (double)(shape.x+shape.width);
		double x1= dShapeX + (time - P.emmissionTime) * dShapeWidth / propDelay;
		double x2 = x1 - (P.emmissionDelay) * dShapeWidth / propDelay;		
		if (x1 > dShapeXWidth) {
			x1 = dShapeXWidth;
		}		
		if (x2< dShapeX) {
			x2= dShapeX;
		}
		g.setColor(P.color);
		g.fillRect((int)x2,shape.y,(int)(x1-x2),shape.height);
	}
		
	protected void update()	{
		if (packets.getLength()>0) {
			Packet fP=packets.getFirstPacket();
			if (fP.emmissionTime+fP.emmissionDelay+propDelay<time) {
				packets.rem();
				arrivedPacket=fP;
				availableArrivedPacket=true;
			}
		}
	}
	
	public boolean getAvailableArrivedPacket() {
		return availableArrivedPacket;
	}
	
	public Packet pickArrivedPacket() {
		availableArrivedPacket=false;
		return arrivedPacket;
	}
}