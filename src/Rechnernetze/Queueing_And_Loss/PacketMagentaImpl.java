/**
 * @author:	Stefan Otto G�nther
 * @date:	09.09.2014
 */

package Rechnernetze.Queueing_And_Loss;

import java.awt.Color;

public class PacketMagentaImpl extends PacketAbstract implements PacketMagenta {

	public PacketMagentaImpl() {
		super(0);
	}
	
	public PacketMagentaImpl(Integer position) {
		super(position);
	}

	@Override
	protected Color getColoredColor() {
		return Color.MAGENTA;
	}

	@Override
	public Packet getClone() {
		return new PacketMagentaImpl(this.getPosition());
	}
}
