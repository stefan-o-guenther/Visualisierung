/**
 * @author:	Stefan Otto Günther
 * @date:	22.10.2014
 */

package Rechnernetze.Pipeline_Protocol;

public class PacketArqNakImpl extends PacketArqResultAbstract implements PacketArqNak {

	public PacketArqNakImpl(Integer number, Integer position) {
		super(number, position);
	}

	@Override
	public EnumPacketType getPacketType() {
		return EnumPacketType.NAK;
	}

	@Override
	public PacketArq getClone() {
		return new PacketArqNakImpl(this.number, this.position);
	}
}
