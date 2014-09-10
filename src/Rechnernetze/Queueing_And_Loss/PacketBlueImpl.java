/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Queueing_And_Loss;

import java.awt.Color;

public class PacketBlueImpl extends PacketAbstract implements PacketBlue {
	
	public PacketBlueImpl() {
		super(0);
	}
	
	public PacketBlueImpl(Integer position) {
		super(position);
	}
	
	@Override
	protected Color getColoredColor() {
		return Color.BLUE;
	}

	@Override
	public Packet getClone() {
		return new PacketBlueImpl(this.getPosition());
	}	
}
