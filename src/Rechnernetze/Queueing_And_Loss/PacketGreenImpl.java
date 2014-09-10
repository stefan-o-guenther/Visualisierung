/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Queueing_And_Loss;

import java.awt.Color;

public class PacketGreenImpl extends PacketAbstract implements PacketGreen {

	public PacketGreenImpl() {
		super(0);
	}
	
	public PacketGreenImpl(Integer position) {
		super(position);
	}

	@Override
	protected Color getColoredColor() {
		return Color.GREEN;
	}

	@Override
	public Packet getClone() {
		return new PacketGreenImpl(this.getPosition());
	}
}