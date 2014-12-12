/**
 * @author:	Stefan Otto Günther
 * @date:	22.10.2014
 */

package Rechnernetze.Pipeline_Protocol;

public class PacketArqDataImpl extends PacketArqAbstract implements PacketArqData {

	public PacketArqDataImpl(Integer number, Integer position) {
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
	public PacketArq getClone() {
		return new PacketArqDataImpl(this.number, this.position);
	}
}
