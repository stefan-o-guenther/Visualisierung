package Rechnernetze.Queueing_And_Loss;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class TimedClass {
	protected Rectangle shape;
	protected double time;
	
	public void setTime(double now)	{
		time = now;
		update();
	}
	
	protected abstract void update();
	
	public abstract void draw(Graphics g);
	
	public static String timeToString(double now) {
		String res = Double.toString(now*1000);
		int dot = res.indexOf('.');
		String inte = res.substring(0,dot);
		return inte + " msec";
	}
}