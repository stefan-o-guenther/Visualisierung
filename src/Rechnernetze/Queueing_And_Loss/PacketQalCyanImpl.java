/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Queueing_And_Loss;

import java.awt.Color;

public class PacketQalCyanImpl extends PacketQalAbstract implements PacketQalCyan {

	public PacketQalCyanImpl() {
		super(0);
	}
	
	public PacketQalCyanImpl(Integer position) {
		super(position);
	}
	
	@Override
	protected Color getColoredColor() {
		return Color.CYAN;
	}

	@Override
	public PacketQal getClone() {
		return new PacketQalCyanImpl(this.getPosition());
	}
}
