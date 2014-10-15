/**
 * @author:	Stefan Otto Günther
 * @date:	22.10.2014
 */

package Rechnernetze.Pipeline_Protocol;

public class PacketAckImpl extends PacketResultAbstract implements PacketAck {

	public PacketAckImpl(Integer number, Integer position) {
		super(number, position);
	}

	@Override
	public EnumPacketType getPacketType() {
		return EnumPacketType.ACK;
	}

	@Override
	public Packet getCopy() {
		return new PacketAckImpl(this.number, this.position);
	}
}
