package Rechnernetze.Queueing_And_Loss.Example;

import java.awt.Color;

public class Packet {
	public static final double emmissionDelay=1E-3;
	public double emmissionTime;
	public Color color;

	public Packet(double eT, Color c) {
		emmissionTime = eT;
		color = c;
	}
}