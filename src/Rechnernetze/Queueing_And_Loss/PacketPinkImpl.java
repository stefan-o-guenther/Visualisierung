/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Queueing_And_Loss;

import java.awt.Color;

public class PacketPinkImpl extends PacketAbstract implements PacketPink {

	public PacketPinkImpl() {
		super(0);
	}

	public PacketPinkImpl(Integer position) {
		super(position);
	}

	@Override
	protected Color getColoredColor() {
		return Color.PINK;
	}

	@Override
	public Packet getClone() {
		return new PacketPinkImpl(this.getPosition());
	}	
}
