/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Queueing_And_Loss;

import java.awt.Color;

public class PacketQalOrangeImpl extends PacketQalAbstract implements PacketQalOrange {

	public PacketQalOrangeImpl() {
		super(0);
	}

	public PacketQalOrangeImpl(Integer position) {
		super(position);
	}

	@Override
	protected Color getColoredColor() {
		return Color.ORANGE;
	}

	@Override
	public PacketQal getClone() {
		return new PacketQalOrangeImpl(this.getPosition());
	}
}
