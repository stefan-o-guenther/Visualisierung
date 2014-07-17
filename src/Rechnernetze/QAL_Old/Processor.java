package Rechnernetze.QAL_Old;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Processor extends TimedClass {
	private boolean busy;
	private double workLength;
	private double curWorkStart;
	private Line outputLine;
	private Queue inputQueue;
	private Packet curPacket;
	
	public Processor(double wrkLength, Queue inputQ, Line outputL,Rectangle r) {
		workLength = wrkLength;
		inputQueue = inputQ;
		outputLine = outputL;
		shape = r;
		busy = false;
	}
	
	public void setWrkLength(double wrkl) {
		workLength=wrkl;
	}
	
	protected void update()	{ 
		//if there is a packet and the job is done then emit it
		if ((busy)&&(workDone())) {
			outputLine.emitPacket(time, curPacket.color);
			busy = false;
		}
		if ((!(busy))&&(inputQueue.getAvailableArrivedPacket())) {
			busy = true;
			curWorkStart = time;
			curPacket = inputQueue.pickArrivedPacket();
		}
	}
	
	private boolean workDone(){
		return (curWorkStart+workLength<=time);
	}
	
	public void draw(Graphics g) {
		if (busy) {
			g.setColor(curPacket.color);
			g.fillRect(shape.x,shape.y,shape.width,shape.height);
		}
		g.setColor(Color.black);
		g.drawRect(shape.x,shape.y,shape.width,shape.height);
	}
}