/**
 * @author:	Stefan Otto Günther
 * @date:	22.10.2014
 */

package Rechnernetze.Pipeline_Protocol;

public class PacketNakImpl extends PacketResultAbstract implements PacketNak {

	public PacketNakImpl(Integer number, Integer position) {
		super(number, position);
	}

	@Override
	public EnumPacketType getPacketType() {
		return EnumPacketType.NAK;
	}

	@Override
	public Packet getCopy() {
		return new PacketNakImpl(this.number, this.position);
	}
}
