package Rechnernetze.QAL_Old;

import java.awt.Color;
import java.util.Random;


public class Sender {
	private final Color packetsColors[]={Color.blue,Color.red,Color.green,Color.gray,Color.magenta,Color.black,Color.pink};
	private double meanInterval;
	private Line outputLine;
	private double time;
	private double nextEmission;
	private int nextColor;
	private Random randomGenerator;
	
	public Sender(double meanI, Line outputL) {
		meanInterval = meanI;
		outputLine = outputL;
		randomGenerator = new Random();
	}
	
	public void setEmitInterval(double val) {
		meanInterval = val;
	}
	
	public void setTime(double now)	{
		time = now;
		update();
	}
	
	private void update() {
		if (nextEmission < time) {
			outputLine.emitPacket(time,packetsColors[nextColor]);
			nextColor++;
			if (nextColor >= packetsColors.length) {
				nextColor = 0;
			}
			nextEmission = 2 * randomGenerator.nextDouble() * (meanInterval-Packet.emmissionDelay)+Packet.emmissionDelay;
			nextEmission += time;
		}
	}
}
