/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Queueing_And_Loss;

import java.awt.Color;

import Base.EnumSurface;

public interface Packet {

	public Color getColor(EnumSurface surface);
	
	public Integer getPosition();
	public void setPosition(Integer position);
	
	public void incPosition();
	
	public Packet getClone();
}
