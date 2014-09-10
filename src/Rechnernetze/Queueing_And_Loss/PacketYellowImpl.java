/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Queueing_And_Loss;

import java.awt.Color;

public class PacketYellowImpl extends PacketAbstract implements PacketYellow {

	public PacketYellowImpl() {
		super(0);
	}

	public PacketYellowImpl(Integer position) {
		super(position);
	}

	@Override
	protected Color getColoredColor() {
		return Color.YELLOW;
	}

	@Override
	public Packet getClone() {
		return new PacketYellowImpl(this.getPosition());
	}	
}
