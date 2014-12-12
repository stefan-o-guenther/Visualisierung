/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Queueing_And_Loss;

import java.awt.Color;

public class PacketQalMagentaImpl extends PacketQalAbstract implements PacketQalMagenta {

	public PacketQalMagentaImpl() {
		super(0);
	}
	
	public PacketQalMagentaImpl(Integer position) {
		super(position);
	}

	@Override
	protected Color getColoredColor() {
		return Color.MAGENTA;
	}

	@Override
	public PacketQal getClone() {
		return new PacketQalMagentaImpl(this.getPosition());
	}
}
