/**
* @author: Stefan Otto G�nther
* @date: 27.01.2014
*/

package Rechnernetze.Queueing_And_Loss;

import java.awt.Graphics;

import Base.IManagement;

public interface IQALManagement extends IManagement {

	void launchSim(double emitRate, double processorRate);
	void draw(Graphics g);
	void reset();
}
