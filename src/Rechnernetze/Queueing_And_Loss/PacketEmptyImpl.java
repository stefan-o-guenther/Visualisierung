package Rechnernetze.Queueing_And_Loss;

import java.awt.Color;

import Base.EnumSurface;

public class PacketEmptyImpl implements PacketEmpty {

	@Override
	public Color getColor(EnumSurface surface) {
		return Color.WHITE;
	}

	@Override
	public EnumPacketType getType() {
		return EnumPacketType.EMPTY;
	}
}
