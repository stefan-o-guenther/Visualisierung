/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Queueing_And_Loss;

import java.awt.Color;

import Base.EnumSurface;


public abstract class PacketAbstract implements Packet {

	public PacketAbstract(Integer position) {
		super();
		this.setPosition(position);
	}
	
	private Integer position;
	
	public Integer getPosition() {
		return this.position;
	}
	
	public void setPosition(Integer position) {
		try {
			if (position == null) {
				throw new NullPointerException();
			}
			if (position.intValue() < 0) {
				throw new IllegalArgumentException();
			}
			this.position = position;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public void incPosition() {
		this.position += 2;
	}
	
	protected abstract Color getColoredColor();
	
	@Override
	public Color getColor(EnumSurface surface) {
		try {
			if (surface == null) {
				throw new NullPointerException();
			}
			if (surface == EnumSurface.COLORED) {
				return this.getColoredColor();
			} else {
				return Color.GRAY;
			}
		} catch (Exception ex) {
			throw ex;
		}
	}
}
