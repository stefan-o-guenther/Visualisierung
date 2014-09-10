/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Queueing_And_Loss;

import java.awt.Color;

public class PacketCyanImpl extends PacketAbstract implements PacketCyan {

	public PacketCyanImpl() {
		super(0);
	}
	
	public PacketCyanImpl(Integer position) {
		super(position);
	}
	
	@Override
	protected Color getColoredColor() {
		return Color.CYAN;
	}

	@Override
	public Packet getClone() {
		return new PacketCyanImpl(this.getPosition());
	}
}
