/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Queueing_And_Loss;

import java.awt.Color;

public class PacketOrangeImpl extends PacketAbstract implements PacketOrange {

	public PacketOrangeImpl() {
		super(0);
	}

	public PacketOrangeImpl(Integer position) {
		super(position);
	}

	@Override
	protected Color getColoredColor() {
		return Color.ORANGE;
	}

	@Override
	public Packet getClone() {
		return new PacketOrangeImpl(this.getPosition());
	}
}
