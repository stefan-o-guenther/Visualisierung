/**
 * @author:	Stefan Otto Günther
 * @date:	13.02.2014
 */

package Rechnernetze.Queueing_And_Loss;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

import Base.BaseManagement;
import Rechnernetze.Queueing_And_Loss.Example.Dropper;
import Rechnernetze.Queueing_And_Loss.Example.Line;
import Rechnernetze.Queueing_And_Loss.Example.Processor;
import Rechnernetze.Queueing_And_Loss.Example.Queue;
import Rechnernetze.Queueing_And_Loss.Example.Sender;
import Rechnernetze.Queueing_And_Loss.Example.TimedClass;

public class SimTimer extends BaseManagement implements ISimTimer {
	private double time;
	private double tic;
	private Line line1;
	private Sender sender1;
	private Dropper dropper1;
	private Queue queue1;
	private Line line2;
	private Processor proc1;
	private JPanel target;
	private Thread timerThread;

	public SimTimer(double tick, double length, JPanel tgt) {
		line1 = new Line(1E-2, new Rectangle(10,60,200,10));
		sender1 = new Sender(1E-3,line1);
		dropper1 = new Dropper(.6E-2, new Rectangle(200,70,10,60));
		queue1 = new Queue(10, line1,dropper1, new Rectangle(210,40,100,50));
		line2 = new Line(1E-2, new Rectangle(340,60,200,10));
		proc1 = new Processor(2E-3, queue1, line2, new Rectangle(310,50,30,30));
		target = tgt;
		time = 0;
		tic = tick;
		timerThread = new Thread(this);
	}

	public void launchSim(double emitRate, double processorRate) {
		sender1.setEmitInterval(emitRate);
		proc1.setWrkLength(processorRate);
		timerThread.start();
	}

	public void run() {
		while (true) {
			dropper1.setTime(time);
			sender1.setTime(time);
			line1.setTime(time);
			queue1.setTime(time);
			proc1.setTime(time);
			line2.setTime(time);
			if (panelModel != null) {
				//panelModel.repaint();
			}
			target.repaint();
			time += tic;
			try {
				timerThread.sleep(50);
			} catch (Exception e) { 
		
			}
		}
	}

	public void draw(Graphics g) {
		dropper1.draw(g);
		line1.draw(g);
		line2.draw(g);
		queue1.draw(g);
		proc1.draw(g);
		g.drawString(TimedClass.timeToString(time),10,110);
		g.drawString(queue1.getDropStat(),10,125);
	}
}