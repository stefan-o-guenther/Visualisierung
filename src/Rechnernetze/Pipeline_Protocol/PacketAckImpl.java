/**
 * @author:	Stefan Otto Günther
 * @date:	22.10.2014
 */

package Rechnernetze.Pipeline_Protocol;

public class PacketAckImpl extends PacketAbstract implements PacketAck {

	public PacketAckImpl(Integer number, Integer position) {
		super(number, position);
	}

	@Override
	public EnumPacketType getPacketType() {
		return EnumPacketType.ACK;
	}

	@Override
	public void doStep(Integer value) {
		try {
			if (value == null) {
				throw new NullPointerException();
			}
			if (value.intValue() <= 0) {
				throw new IllegalArgumentException();
			}
			this.position -= value;
		} catch (Exception ex) {
			throw ex;
		}
	}
}
