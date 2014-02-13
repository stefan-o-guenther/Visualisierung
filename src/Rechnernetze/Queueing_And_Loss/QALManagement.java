/**
* @author: Stefan Otto Günther
* @date: 27.01.2014
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

public class QALManagement extends BaseManagement implements IQALManagement {
	private double time;
	private double tic;
	private Line line1;
	private Sender sender1;
	private Dropper dropper1;
	private Queue queue1;
	private Line line2;
	private Processor proc1;
	//private JPanel target;
	private TimerThread timerThread;
	
	

	public QALManagement(double tick) {
		super();
		tic = tick;
		init();
	}
	
	private void init() {
		line1 = new Line(1E-2, new Rectangle(10,60,200,10));
		sender1 = new Sender(1E-3,line1);
		dropper1 = new Dropper(.6E-2, new Rectangle(200,70,10,60));
		queue1 = new Queue(10, line1,dropper1, new Rectangle(210,40,100,50));
		line2 = new Line(1E-2, new Rectangle(340,60,200,10));
		proc1 = new Processor(2E-3, queue1, line2, new Rectangle(310,50,30,30));
		time = 0;
		runThread = false;
	}

	public void launchSim(double emitRate, double processorRate) {
		sender1.setEmitInterval(emitRate);
		proc1.setWrkLength(processorRate);
		runThread = true;
		timerThread = new TimerThread();
		timerThread.start();
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

	@Override
	public void reset() {
		init();
		panelModel.updateModel();
	}
	
	private Boolean runThread = false;
	
	public class TimerThread extends Thread {
	    String text;
	  
	    public TimerThread() {
	    	super();
	    }
	  
	    public void run() {
	    	try {
	    		while (runThread) {
					dropper1.setTime(time);
					sender1.setTime(time);
					line1.setTime(time);
					queue1.setTime(time);
					proc1.setTime(time);
					line2.setTime(time);
					if (panelModel != null) {
						panelModel.updateModel();
					}
					time += tic;					
					sleep(50);					
				}	    		
		    } catch (InterruptedException e) {
	        	System.out.println("Thread abgebrochen");
	        }
	    }
	}
}