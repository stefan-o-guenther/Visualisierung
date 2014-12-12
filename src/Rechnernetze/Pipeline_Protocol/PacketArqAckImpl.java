/**
 * @author:	Stefan Otto Günther
 * @date:	22.10.2014
 */

package Rechnernetze.Pipeline_Protocol;

public class PacketArqAckImpl extends PacketArqResultAbstract implements PacketArqAck {

	public PacketArqAckImpl(Integer number, Integer position) {
		super(number, position);
	}

	@Override
	public EnumPacketType getPacketType() {
		return EnumPacketType.ACK;
	}

	@Override
	public PacketArq getClone() {
		return new PacketArqAckImpl(this.number, this.position);
	}
}
