/**
* @author: Stefan Otto G�nther
* @date: 27.01.2014
*/

package Rechnernetze.QAL_Old;

import java.awt.Graphics;

import Base.Management;

public interface ManagementQueueingAndLoss extends Management {

	void launchSim(double emitRate, double processorRate);
	void draw(Graphics g);
	void reset();
}
