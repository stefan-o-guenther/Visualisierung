/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Queueing_And_Loss;

import java.awt.Color;

public class PacketRedImpl extends PacketAbstract implements PacketRed {

	public PacketRedImpl() {
		super(0);
	}

	public PacketRedImpl(Integer position) {
		super(position);
	}

	@Override
	protected Color getColoredColor() {
		return Color.RED;
	}

	@Override
	public Packet getClone() {
		return new PacketRedImpl(this.getPosition());
	}	
}
