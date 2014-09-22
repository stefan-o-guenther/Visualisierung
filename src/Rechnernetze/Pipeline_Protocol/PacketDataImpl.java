/**
 * @author:	Stefan Otto Günther
 * @date:	22.10.2014
 */

package Rechnernetze.Pipeline_Protocol;

public class PacketDataImpl extends PacketAbstract implements PacketData {

	public PacketDataImpl(Integer number, Integer position) {
		super(number, position);
	}

	@Override
	public EnumPacketType getPacketType() {
		return EnumPacketType.DATA;
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
			this.position += value;
		} catch (Exception ex) {
			throw ex;
		}
	}
}
