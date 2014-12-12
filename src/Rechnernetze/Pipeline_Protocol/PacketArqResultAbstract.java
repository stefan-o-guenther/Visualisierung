/**
 * @author:	Stefan Otto Günther
 * @date:	22.10.2014
 */

package Rechnernetze.Pipeline_Protocol;

public abstract class PacketArqResultAbstract extends PacketArqAbstract implements PacketArqResult {

	public PacketArqResultAbstract(Integer number, Integer position) {
		super(number, position);
	}

	@Override
	public void doStep() {
		this.position -= this.step;
	}
}
