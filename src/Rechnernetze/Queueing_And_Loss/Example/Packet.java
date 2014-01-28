package Rechnernetze.Queueing_And_Loss.Example;

import java.awt.Color;

public class Packet {

	static final double emmissionDelay=1E-3;
	double emmissionTime;
	Color color;

	public Packet(double eT, Color c) {
		emmissionTime = eT;
		color = c;
	}
}

