/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Queueing_And_Loss;

import java.awt.Color;

public class PacketQalBlueImpl extends PacketQalAbstract implements PacketQalBlue {
	
	public PacketQalBlueImpl() {
		super(0);
	}
	
	public PacketQalBlueImpl(Integer position) {
		super(position);
	}
	
	@Override
	protected Color getColoredColor() {
		return Color.BLUE;
	}

	@Override
	public PacketQal getClone() {
		return new PacketQalBlueImpl(this.getPosition());
	}	
}
