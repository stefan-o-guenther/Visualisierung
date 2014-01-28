package Rechnernetze.Queueing_And_Loss.Example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Queue extends TimedClass {

	private int maxSize;
	private int size;
	private int receivedCounter;
	private int droppedCounter;
	private PacketFIFO packets;
	private Line inputLine;
	private Dropper dropper;
	
	public Queue(int mS,Line inputL,Dropper defDropper,Rectangle r) {
		shape = r;
		maxSize = mS;
		inputLine = inputL;
		packets = new PacketFIFO();
		dropper = defDropper;
	}
	
	protected void update() {
		//if a packet is at input then add it to the queue
		if (inputLine.getAvailableArrivedPacket()) {
			addPacket(inputLine.pickArrivedPacket());
		}
	}
	
	private void addPacket(Packet P) {
		receivedCounter++;
		//if the queue is full drop packet else queue it
		if (size == maxSize) {
			dropPacket(P);
		} else {
			size++;
			packets.add(P);
		}
	}
	
	private void dropPacket(Packet P) {
		dropper.emitPacket(time,P.color);
		droppedCounter++;
	}
	
	public void draw(Graphics g) {
		for (int i=0;i<maxSize;i++)	{
			int xp=shape.x+shape.width-(i+1)*(shape.width/maxSize);
			int wp=(shape.width/maxSize);
			if (i<(packets.getLength())) {
				g.setColor(packets.getPacket(i).color);
				g.fillRect(xp,shape.y,wp,shape.height);
			}
			g.setColor(Color.black);
			g.drawRect(xp,shape.y,wp,shape.height);
		}
	}
	
	public boolean getAvailableArrivedPacket() {
		return (packets.getLength()>0);
	}
	
	public Packet pickArrivedPacket() {
		size -= 1;
		Packet fP = packets.getFirstPacket();
		packets.rem();
		return fP;
	}
	
	public String getDropStat() {
		return Integer.toString(droppedCounter) + " packets dropped out of " + Integer.toString(receivedCounter);
	}
}

