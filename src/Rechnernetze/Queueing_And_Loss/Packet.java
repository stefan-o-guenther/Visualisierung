package Rechnernetze.Queueing_And_Loss;

import java.awt.Color;

import Base.EnumSurface;

public interface Packet {

	Color getColor(EnumSurface surface);
	
	Integer getPosition();
	void setPosition(Integer position);
}
