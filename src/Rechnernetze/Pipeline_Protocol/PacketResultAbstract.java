/**
 * @author:	Stefan Otto Günther
 * @date:	22.10.2014
 */

package Rechnernetze.Pipeline_Protocol;

public abstract class PacketResultAbstract extends PacketAbstract implements PacketResult {

	public PacketResultAbstract(Integer number, Integer position) {
		super(number, position);
	}

	@Override
	public void doStep() {
		this.position -= this.step;
	}
}
