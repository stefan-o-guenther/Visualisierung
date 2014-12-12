/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Queueing_And_Loss;

import java.awt.Color;

public class PacketQalPinkImpl extends PacketQalAbstract implements PacketQalPink {

	public PacketQalPinkImpl() {
		super(0);
	}

	public PacketQalPinkImpl(Integer position) {
		super(position);
	}

	@Override
	protected Color getColoredColor() {
		return Color.PINK;
	}

	@Override
	public PacketQal getClone() {
		return new PacketQalPinkImpl(this.getPosition());
	}	
}
