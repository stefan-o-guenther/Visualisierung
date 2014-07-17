package Rechnernetze.Queueing_And_Loss;

import java.awt.Color;

import Base.EnumSurface;

public class PacketBlueImpl extends PacketAbstract implements PacketBlue {

	public PacketBlueImpl() {
		super();
	}
	
	@Override
	public Color getColor(EnumSurface surface) {
		try {
			if (surface == null) {
				throw new NullPointerException();
			}
			if (surface == EnumSurface.COLORED) {
				return Color.BLUE;
			} else {
				return Color.GRAY;
			}
		} catch (Exception ex) {
			throw ex;
		}
	}

}
