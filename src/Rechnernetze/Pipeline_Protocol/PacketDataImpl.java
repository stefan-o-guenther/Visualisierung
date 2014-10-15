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
	public void doStep() {
		this.position += this.step;
	}

	@Override
	public Packet getCopy() {
		return new PacketDataImpl(this.number, this.position);
	}
}
