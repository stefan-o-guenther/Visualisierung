/**
 * @author:	Stefan Otto Günther
 * @date:	13.02.2014
 */

package Rechnernetze.Queueing_And_Loss;

import java.awt.Graphics;

import Base.IManagement;

public interface ISimTimer extends IManagement, Runnable {

	void launchSim(double emitRate, double processorRate);
	void run();
	void draw(Graphics g);
}
